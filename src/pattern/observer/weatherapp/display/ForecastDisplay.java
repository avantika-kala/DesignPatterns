package pattern.observer.weatherapp.display;

import pattern.observer.weatherapp.Observer;
import pattern.observer.weatherapp.WeatherData;

public class ForecastDisplay implements Observer {

	WeatherData weatherData;
	private float temperature;
	private float humidity;
	private float pressure;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		System.out.println(estimateWeather());
	}

	public String estimateWeather() {
		if (this.temperature > 25 && this.humidity > 60) {
			return "Hot and humid";
		} else if (this.temperature < 15 && this.humidity > 60) {
			return "Foggy or misty";
		} else if (this.temperature < 20 && this.pressure < 1012) {
			return "Stormy or rainy";
		} else if (this.temperature > 25 && this.pressure > 1012) {
			return "Improving weather";
		} else {
			return "Unknown weather condition";
		}
	}

}
