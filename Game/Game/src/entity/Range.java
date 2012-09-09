package entity;

public class Range {

	private int range;
	private RangeType rangeType;

	public enum RangeType {
		Cross, Circle
	}

	public Range() {

	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public RangeType getRangeType() {
		return rangeType;
	}

	public void setRangeType(RangeType rangeType) {
		this.rangeType = rangeType;
	}
}
