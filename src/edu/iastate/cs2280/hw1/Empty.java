package edu.iastate.cs2280.hw1;

public class Empty extends TownCell {

	public Empty(Town p, int r, int c) {
		super(p, r, c);
	}
	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		int unpopulated = nCensus[OUTAGE] + nCensus[EMPTY];
		if (unpopulated <= 1) {
			return new Reseller(tNew, row, col);
		}
		return new Casual(tNew, row, col);
	}

}
