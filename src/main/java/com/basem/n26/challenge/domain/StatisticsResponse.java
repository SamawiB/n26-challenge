package com.basem.n26.challenge.domain;

public class StatisticsResponse {

	private Double sum;
	private Double avg;
	private Double max;
	private Double min;
	private Double count;

	private StatisticsResponse(Builder builder) {
		super();
		this.sum = builder.sum;
		this.avg = builder.avg;
		this.max = builder.max;
		this.min = builder.min;
		this.count = builder.count;
	}

	public Double getSum() {
		return sum;
	}

	public Double getAvg() {
		return avg;
	}

	public Double getMax() {
		return max;
	}

	public Double getMin() {
		return min;
	}

	public Double getCount() {
		return count;
	}

	public static class Builder {
		private Double sum = 0d;
		private Double avg = 0d;
		private Double max = 0d;
		private Double min = 0d;
		private Double count = 0d;

		public Builder sum(double sum) {
			this.sum = sum;
			return this;
		}

		public Builder avg(double avg) {
			this.avg = avg;
			return this;
		}

		public Builder max(double max) {
			this.max = max;
			return this;
		}

		public Builder min(double min) {
			this.min = min;
			return this;
		}

		public Builder count(double count) {
			this.count = count;
			return this;
		}

		public StatisticsResponse build() {
			return new StatisticsResponse(this);
		}
	}
}
