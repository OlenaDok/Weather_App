package il.ac.hit.weatherapp.main.model;

public class WeatherServiceException extends Exception {
	
	/**
	 * Class WeatherServiceException 
	 */
	private static final long serialVersionUID = 1L;

	WeatherServiceException(String msg) {
		super(msg);
	}
	
	WeatherServiceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
