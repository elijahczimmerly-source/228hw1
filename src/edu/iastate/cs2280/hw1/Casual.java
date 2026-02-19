package edu.iastate.cs2280.hw1;

public class Casual extends TownCell {
	
	public Casual(Town p, int r, int c) {
		super(p, r, c);
	}
	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		int unpopulated = nCensus[OUTAGE] + nCensus[EMPTY];
		if (unpopulated <= 1) {
			return new Reseller(tNew, row, col);
		}
		if (nCensus[RESELLER] > 0) {
			return new Outage(tNew, row, col);
		}
		if (nCensus[STREAMER] > 0) {
			return new Streamer(tNew, row, col);
		}
		if (nCensus[CASUAL] >= 5) {
			return new Streamer(tNew, row, col);
		}
		return new Casual(tNew, row, col);
		
	}

}
