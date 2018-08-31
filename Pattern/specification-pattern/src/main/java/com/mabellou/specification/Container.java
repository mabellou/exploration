package com.mabellou.specification;

public class Container {
	private Integer temperatureMax;
	private Integer temperatureMin;
	private boolean isSanitaryForFood;

	public Container() {
	}

	public Container(Integer temperatureMax, Integer temperatureMin,
					 boolean isSanitaryForFood) {
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;
		this.isSanitaryForFood = isSanitaryForFood;
	}

	public Integer getTemperatureMax() {
		return temperatureMax;
	}

	public Integer getTemperatureMin() {
		return temperatureMin;
	}

	public boolean isSanitaryForFood() {
		return isSanitaryForFood;
	}

	public static Builder builder(){
		return new Builder();
	}

	public static class Builder {
		private Integer temperatureMax;
		private Integer temperatureMin;
		private boolean isSanitaryForFood;

		public Builder temperatureMax(Integer temperatureMax){
			this.temperatureMax = temperatureMax;
			return this;
		}

		public Builder temperatureMin(Integer temperatureMin){
			this.temperatureMin = temperatureMin;
			return this;
		}

		public Builder isSanitaryForFood(boolean isSanitaryForFood){
			this.isSanitaryForFood = isSanitaryForFood;
			return this;
		}

		public Container build(){
			return new Container(temperatureMax,
					temperatureMin,
					isSanitaryForFood);
		}
	}
}
