package com.adeptions.jagol.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.adeptions.jagol.logic.BoardWrappingMode;
import com.adeptions.jagol.logic.rule.IChangeAliveRule;
import com.adeptions.jagol.logic.rule.StandardConways;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;

public class GameConfig {
	private int columns = 60;
	private int rows = 60;
	private BoardWrappingMode wrappingMode = BoardWrappingMode.NONE;
	private boolean deadCellEdges = false;
	private double generationDelay = 100d;
	private double randomizationDensity = 30d;
	private IChangeAliveRule changeAliveRule = new StandardConways();
	private int cellSize = 6;
	private int cellSpace = 1;
	private Color cellActiveColor = Color.DODGERBLUE;
	private Color cellInactiveColor = Color.WHITE;
	private Color cellGridColor = Color.LIGHTGRAY;
	private Color boardBorderColor = Color.BLACK;
	private boolean cellsAge;
	private int maximumCellAge = 16;

	GameConfig() {
	}

	/**
	 * For testing only
	 * @return a new instance of GameConfig
	 */
	public static GameConfig create() {
		return new GameConfig();
	}

	/**
	 * Attempts to load config from [user home dir]/.jagol/config.json
	 * If the file isn't found - creates a new, default game config
	 * @return the loaded game config
	 */
	public static GameConfig load() {
		GameConfig result = null;
		try {
			File userConfigFile = getUserConfigFile();
			if (userConfigFile.exists() && !userConfigFile.isDirectory()) {
				result = loadFromFile(userConfigFile);
			}
		} catch (Exception e) {
			// swallow any loading exceptions silently - just return default config
		}
		if (result == null) {
			result = new GameConfig();
		}
		// now add auto save on app shutdown...
		final GameConfig saveConfig = result;
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			save(saveConfig);
		}));
		return result;
	}

	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCellSize() {
		return cellSize;
	}
	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}

	@JsonProperty("gridLineThickness")
	public int getCellSpace() {
		return cellSpace;
	}
	@JsonProperty("gridLineThickness")
	public void setCellSpace(int cellSpace) {
		this.cellSpace = cellSpace;
	}

	public Color getCellActiveColor() {
		return cellActiveColor;
	}
	public void setCellActiveColor(Color cellActiveColor) {
		this.cellActiveColor = cellActiveColor;
	}

	public Color getCellInactiveColor() {
		return cellInactiveColor;
	}
	public void setCellInactiveColor(Color cellInactiveColor) {
		this.cellInactiveColor = cellInactiveColor;
	}

	public Color getCellGridColor() {
		return cellGridColor;
	}
	public void setCellGridColor(Color cellGridColor) {
		this.cellGridColor = cellGridColor;
	}

	public Color getBoardBorderColor() {
		return boardBorderColor;
	}
	public void setBoardBorderColor(Color boardBorderColor) {
		this.boardBorderColor = boardBorderColor;
	}

	public BoardWrappingMode getWrappingMode() {
		return wrappingMode;
	}
	public void setWrappingMode(BoardWrappingMode wrappingMode) {
		this.wrappingMode = wrappingMode;
	}

	public boolean isDeadCellEdges() {
		return deadCellEdges;
	}
	public void setDeadCellEdges(boolean deadCellEdges) {
		this.deadCellEdges = deadCellEdges;
	}

	public double getGenerationDelay() {
		return generationDelay;
	}
	public void setGenerationDelay(double generationDelay) {
		this.generationDelay = generationDelay;
	}

	public double getRandomizationDensity() {
		return randomizationDensity;
	}
	public void setRandomizationDensity(double randomizationDensity) {
		this.randomizationDensity = randomizationDensity;
	}

	public IChangeAliveRule getChangeAliveRule() {
		return changeAliveRule;
	}
	public void setChangeAliveRule(IChangeAliveRule changeAliveRule) {
		this.changeAliveRule = changeAliveRule;
	}

	public boolean getCellsAge() {
		return cellsAge;
	}
	public void setCellsAge(boolean cellsAge) {
		this.cellsAge = cellsAge;
	}

	public int getMaximumCellAge() {
		return maximumCellAge;
	}
	public void setMaximumCellAge(int maximumCellAge) {
		this.maximumCellAge = maximumCellAge;
	}

	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(this);
		return result;
	}

	private static GameConfig loadFromFile(File configFile) throws IOException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			GameConfigLoadSaveWrapper wrapper = mapper.readValue(configFile, GameConfigLoadSaveWrapper.class);
			return wrapper.getActualConfig();
		} catch (Exception e) {
			return null;
		}
	}

	private static void save(GameConfig config) {
		try {
			File userConfigDir = getUserConfigDirectory();
			userConfigDir.mkdirs();
			File userConfigFile = getUserConfigFile();
			if (userConfigFile != null) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
				writer.writeValue(userConfigFile, new GameConfigLoadSaveWrapper(config));
			}
		} catch (Exception e) {
			// handle exceptions on saving silently
		}
	}

	private static File getUserConfigFile() {
		File result = null;
		File userConfigDir = getUserConfigDirectory();
		if (userConfigDir.exists() && userConfigDir.isDirectory()) {
			result = new File(userConfigDir, "config.json");
		}
		return result;
	}

	private static File getUserConfigDirectory() {
		String userHome = System.getenv("HOMEPATH");
		if (userHome == null || userHome.isEmpty()) {
			userHome = System.getProperty("user.home");
		}
		return new File(userHome + File.separator + ".jagol");
	}

	public static String colorToHtml(Color color) {
		Double r = color.getRed() * 255d;
		Double g = color.getGreen() * 255d;
		Double b = color.getBlue() * 255d;
		return String.format("#%02x%02x%02x", r.intValue(), g.intValue(), b.intValue());
	}

	public static Color colorFromHtml(String htmlColor, Color defaultValue) {
		Color result = defaultValue;
		if (htmlColor != null && !htmlColor.isEmpty() && htmlColor.startsWith("#")) {
			Integer r,g,b;
			try {
				if (htmlColor.length() == 7) {
					r = Integer.valueOf(htmlColor.substring(1, 3), 16);
					g = Integer.valueOf(htmlColor.substring(3, 5), 16);
					b = Integer.valueOf(htmlColor.substring(5, 7), 16);
					result = new Color(r.doubleValue() / 255d, g.doubleValue() / 255d, b.doubleValue() / 255d, 1.0d);
				} else if (htmlColor.length() == 4) {
					r = Integer.valueOf(htmlColor.substring(1, 2) + htmlColor.substring(1, 2), 16);
					g = Integer.valueOf(htmlColor.substring(2, 3) + htmlColor.substring(2, 3), 16);
					b = Integer.valueOf(htmlColor.substring(3, 4) + htmlColor.substring(3, 4), 16);
					result = new Color(r.doubleValue() / 255d, g.doubleValue() / 255d, b.doubleValue() / 255d, 1.0d);
				}
			} catch (NumberFormatException nfe) {
				// just ignore and return the default value
			}
		}
		return result;
	}
}
