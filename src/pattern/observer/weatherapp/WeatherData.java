package pattern.observer.weatherapp;

import java.util.ArrayList;

public class WeatherData implements Subject {

	ArrayList<Observer> observerList;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observerList = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observerList.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		if (observerList.contains(o)) {
			observerList.remove(o);
		}

	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerList.size(); i++) {
			observerList.get(i).update(temperature, humidity, pressure);
		}
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	private void measurementsChanged() {
		this.notifyObservers();
	}

}
