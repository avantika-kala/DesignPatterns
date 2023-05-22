package pattern.observer.weatherapp.display;

import pattern.observer.weatherapp.Observer;
import pattern.observer.weatherapp.Subject;

public class CurrentConditionsDisplay implements Observer, Display {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void removeObserver() {
		weatherData.removeObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");

	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();

	}

}
