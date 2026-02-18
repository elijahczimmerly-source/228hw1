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
		if (nCensus[RESELLER] > 0) {
			return new Outage(tNew, row, col);
		}
		else if (nCensus[STREAMER] > 0) {
			return new Streamer(tNew, row, col);
		}
		else {
			return this;
		}
	}

}
