package com.adeptions.jagol.logic.rule;

import com.adeptions.jagol.logic.ICell;

public class Vote45 extends AbstractPredefinedRule implements IChangeAliveRule {
	public static final String LABEL = "Vote 4/5";
	public static final String RULE = "B4678/S35678";

	@Override
	public boolean evaluate(ICell cell) {
		int adjacentsAlive = IChangeAliveRule.countAdjacentsAlive(cell);
		boolean changes;
		if (cell.isAlive()) {
			changes = !(adjacentsAlive == 3 || adjacentsAlive == 5 || adjacentsAlive == 6 || adjacentsAlive == 7 || adjacentsAlive == 8);
		} else {
			changes = (adjacentsAlive == 4 || adjacentsAlive == 6 || adjacentsAlive == 7 || adjacentsAlive == 8);
		}
		return changes;
	}

	@Override
	public String getAlivesSurviveString() {
		return "3,5,6,7,8";
	}

	@Override
	public String getDeadsBornString() {
		return "4,6,7,8";
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
