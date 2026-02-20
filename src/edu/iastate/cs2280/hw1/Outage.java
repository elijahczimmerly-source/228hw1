package edu.iastate.cs2280.hw1;

/**
 * @author Elijah Zimmerly
 */
public class Outage extends TownCell {

	public Outage(Town p, int r, int c) {
		super(p, r, c);
	}
	@Override
	public State who() {
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		return new Empty(tNew, row, col);
	}

}
