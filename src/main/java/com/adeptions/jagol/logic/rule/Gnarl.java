package com.adeptions.jagol.logic.rule;

import com.adeptions.jagol.logic.ICell;

public class Gnarl extends AbstractPredefinedRule implements IChangeAliveRule {
	public static final String LABEL = "Gnarl";
	public static final String RULE = "B1/S1";

	@Override
	public boolean evaluate(ICell cell) {
		int adjacentsAlive = IChangeAliveRule.countAdjacentsAlive(cell);
		boolean changes;
		if (cell.isAlive()) {
			changes = adjacentsAlive != 1;
		} else {
			changes = adjacentsAlive == 1;
		}
		return changes;
	}

	@Override
	public String getAlivesSurviveString() {
		return "1";
	}

	@Override
	public String getDeadsBornString() {
		return "1";
	}

	@Override
	public String getRleString() {
		return RULE;
	}

	@Override
	public String getType() {
		return LABEL;
	}
}
