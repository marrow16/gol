package com.adeptions.jagol.logic.rule;

import com.adeptions.jagol.logic.ICell;

public class StandardConways extends AbstractPredefinedRule implements IChangeAliveRule {
	public static final String LABEL = "Standard";
	public static final String RULE = "B3/S23";

	@Override
	public boolean evaluate(ICell cell) {
		int adjacentsAlive = IChangeAliveRule.countAdjacentsAlive(cell);
		boolean changes = false;
		if (cell.isAlive()) {
			if (adjacentsAlive < 2 || adjacentsAlive > 3) {
				changes = true;
			}
		} else if (adjacentsAlive == 3) {
			changes = true;
		}
		return changes;
	}

	@Override
	public String getAlivesSurviveString() {
		return "2,3";
	}

	@Override
	public String getDeadsBornString() {
		return "3";
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
