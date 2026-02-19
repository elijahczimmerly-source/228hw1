package edu.iastate.cs2280.hw1;

public class Reseller extends TownCell {

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
	}
	@Override
	public State who() {
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		if (nCensus[CASUAL] <= 3) {
			return new Empty(tNew, row, col);
		}
		if (nCensus[EMPTY] >= 3) {
			return new Empty(tNew, row, col);
		}
		if (nCensus[CASUAL] >= 5) {
			return new Streamer(tNew, row, col);
		}
		return new Reseller(tNew, row, col);
	}

}
