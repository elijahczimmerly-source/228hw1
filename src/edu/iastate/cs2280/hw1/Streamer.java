package edu.iastate.cs2280.hw1;

public class Streamer extends TownCell {

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
	}
	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		if (nCensus[RESELLER] > 0) {
			return new Outage(tNew, row, col);
		}
		else if (nCensus[OUTAGE] > 0) {
			return new Empty(tNew, row, col);
		}
		else {
			return this;
		}
	}

}
