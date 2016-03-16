package il.ac.hit.weatherapp.main.service;

/**
 * class AbstractWeatherData helps in reading weather information
 * 
 * @author Lena
 *
 */

public abstract class AbstractWeatherData {
	
	protected static final String JSON_DATE_TIME = "dt";
	protected static final String JSON_MAIN      = "main";
	protected static final String JSON_WIND      = "wind";
	protected static final String JSON_RAIN      = "rain";
	protected static final String JSON_SNOW      = "snow";
	protected static final String JSON_CLOUDS      = "clouds";
	protected static final String JSON_DESCRIPTION = "weather.description";
	
	static abstract public class Main {
		protected static final String JSON_TEMP     = "temp";
		protected static final String JSON_TEMP_MIN = "temp_min";
		protected static final String JSON_TEMP_MAX = "temp_max";
		protected static final String JSON_HUMIDITY = "humidity";
		protected static final String JSON_PRESSURE = "pressure";
	}
	
	static abstract public class Wind {
		protected static final String JSON_SPEED   = "speed";
		protected static final String JSON_DEG     = "deg";
	}
	
	static abstract public class Sys {
		protected static final String JSON_SUNRISE   = "sunrise";
		protected static final String JSON_SUNSET    = "sunset";
	}
}
