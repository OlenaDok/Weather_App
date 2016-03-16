package il.ac.hit.weatherapp.main.util;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import il.ac.hit.weatherapp.main.model.WeatherData;

/**
 * class is responsible for creating an WeatherData object
 * @author Lena
 *
 */
public class WeatherJSonParser {
	
public static WeatherData getWeatherData(String json) throws JSONException {
		
		System.out.println(json.toString());
		WeatherData weatherData = new WeatherData();

		JSONObject jObj = new JSONObject(json);
		
		JSONObject sysObj = getObject("sys", jObj);
		
		long ss_secs = sysObj.optLong("sunrise", Long.MIN_VALUE);
        if (ss_secs != Long.MIN_VALUE) {
        	weatherData.setSunrise(new Date(ss_secs * 1000));
        } else {
        	weatherData.setSunrise(null);
        }
        
        long sr_secs = sysObj.optLong("sunset", Long.MIN_VALUE);
        if (sr_secs != Long.MIN_VALUE) {
        	weatherData.setSunset(new Date(sr_secs * 1000));
        } else {
        	weatherData.setSunset(null);
        }
        
		String country = getString("country", sysObj);
		
		JSONArray jArr = jObj.getJSONArray("weather");

		JSONObject JSONWeather = jArr.getJSONObject(0);
		weatherData.setConditionId(getInt("id", JSONWeather));
		weatherData.setWeatherParameters(getString("main", JSONWeather));
		weatherData.setDescription(getString("description", JSONWeather));
		weatherData.setIconId(getString("icon", JSONWeather));
		
		 long dt_secs = jObj.optLong("dt", Long.MIN_VALUE);
	        if (dt_secs != Long.MIN_VALUE) {
	        	weatherData.setDatetime(new Date(dt_secs * 1000));
	        } else {
	        	weatherData.setDatetime(null);
	        }
		
		JSONObject mainObj = getObject("main", jObj);
		weatherData.setHumidity(getInt("humidity", mainObj));
		weatherData.setPressure(getInt("pressure", mainObj));
		
		if(mainObj.has("temp_max"))
			weatherData.setTempMax(getFloat("temp_max", mainObj));
		else weatherData.setTempMax(0);
		
		if(mainObj.has("temp_min"))
			weatherData.setTempMin(getFloat("temp_min", mainObj));
		else weatherData.setTempMin(0);
		
		weatherData.setTemp(getFloat("temp", mainObj));
		
		String city = getString("name", jObj);
		
		JSONObject wObj = getObject("wind", jObj);
		weatherData.setSpeed(getFloat("speed", wObj));
		if(wObj.has("deg"))
			weatherData.setDeg(getFloat("deg", wObj));
		else 
			weatherData.setDeg(0);

		JSONObject cObj = getObject("clouds", jObj);
		weatherData.setCloudiness(getInt("all", cObj));
		
		weatherData.setLocationJson(new String(city + ", " + country));
		
		return weatherData;
	}
	
	
	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
		JSONObject subObj = jObj.getJSONObject(tagName);
		return subObj;
	}
	
	private static String getString(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getString(tagName);
	}

	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
		return (float) jObj.getDouble(tagName);
	}
	
	private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getInt(tagName);
	}

}
