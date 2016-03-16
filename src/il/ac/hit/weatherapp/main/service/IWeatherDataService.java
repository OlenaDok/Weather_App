package il.ac.hit.weatherapp.main.service;

import il.ac.hit.weatherapp.main.model.*;

public interface IWeatherDataService {

	/**
	 * Return the Weather Data object
	 * detailed information about the weather in accordance with the specified location
	 * 
	 * @param location
	 * @return object WeatherData 
	 * @throws WeatherServiceException
	 */
	public WeatherData getWeatherData(Location location)
			throws WeatherServiceException;
	
}
