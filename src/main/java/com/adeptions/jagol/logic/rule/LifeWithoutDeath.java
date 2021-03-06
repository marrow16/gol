package com.adeptions.jagol.logic.rule;

import com.adeptions.jagol.logic.ICell;

public class LifeWithoutDeath extends AbstractPredefinedRule implements IChangeAliveRule {
	public static final String LABEL = "Life without death";
	public static final String RULE = "B3/S012345678";

	@Override
	public boolean evaluate(ICell cell) {
		int adjacentsAlive = IChangeAliveRule.countAdjacentsAlive(cell);
		boolean changes = false;
		if (!cell.isAlive()) {
			changes = adjacentsAlive == 3;
		}
		return changes;
	}

	@Override
	public String getAlivesSurviveString() {
		return "0,1,2,3,4,5,6,7,8";
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
