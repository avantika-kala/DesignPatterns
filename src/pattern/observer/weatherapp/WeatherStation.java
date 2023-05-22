package pattern.observer.weatherapp;

import pattern.observer.weatherapp.display.CurrentConditionsDisplay;
import pattern.observer.weatherapp.display.ForecastDisplay;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay ccd1 = new CurrentConditionsDisplay(weatherData);
		ForecastDisplay fd = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(10, 90, 29.2f);

	}

}
