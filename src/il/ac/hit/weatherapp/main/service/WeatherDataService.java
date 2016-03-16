package il.ac.hit.weatherapp.main.service;

import java.io.UnsupportedEncodingException;
import java.util.Observable;

import org.json.JSONException;

import il.ac.hit.weatherapp.main.model.Location;
import il.ac.hit.weatherapp.main.model.WeatherData;
import il.ac.hit.weatherapp.main.model.WeatherServiceException;
import il.ac.hit.weatherapp.main.util.JsonGetterWeather;
import il.ac.hit.weatherapp.main.util.WeatherJSonParser;

/**
 * class WeatherDataService extends Observable implements IWeatherDataService;
 * class WeatherDataService implement the Singleton Pattern;
 * 
 * Implementation of function getWeatherData;
 * 
 * @author Lena
 *
 */
public class WeatherDataService extends Observable implements IWeatherDataService{
	
	public static WeatherDataService instance;
	
	public static WeatherDataService getInstance() {
		
		if (instance == null) {
			
			instance = new WeatherDataService();
		}
		return instance;
	}

	/**
	 * @see IWeatherDataService
	 */
	@Override
	public WeatherData getWeatherData(Location location) throws WeatherServiceException {
		
		//System.out.println(location.toString());
		String url;
		WeatherData data = new WeatherData();
		try {
			if(location.getCountry()!=null) {
				
				url = OpenWeatherMap.stringCurrentWeatherByCityNameAndCountry(location.getCity(), location.getCountry());
				System.out.println(url.toString());
				
				System.out.println("trying to get data");
				data = WeatherJSonParser.getWeatherData(JsonGetterWeather.GetJSON(url));
			}
			
			else{
				url = OpenWeatherMap.stringToGetCurrentWeatherByCityName(location.getCity());
				System.out.println(url.toString());
				
				System.out.println("trying to get data");
				data = WeatherJSonParser.getWeatherData(JsonGetterWeather.GetJSON(url));
			}
			
			
		} catch (UnsupportedEncodingException e1) {
			System.err.println("encoding exception");
			e1.printStackTrace();
		}
		catch(JSONException ex){
			System.err.println("json exception");
			ex.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(data);	
		
		return data;
	}
}
