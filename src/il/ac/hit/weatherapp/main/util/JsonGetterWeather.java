package il.ac.hit.weatherapp.main.util;

import java.io.*;

/**
 * Class JsonGetterWeather 
 * for getting JSon with details of weather
 * 
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JsonGetterWeather {
	/*
	public static long GetCityId(String city, String country) throws JSONException, FileNotFoundException {
		
		long cityId = 0;
		String temp;
		Scanner input = new Scanner(new File("/WeatherApp/files/city.list.json"));
		while(input.hasNextLine()){
			JSONObject jObj = new JSONObject(input.nextLine().toString());
			temp = jObj.getString("name");
			if((temp.toLowerCase()).equals(city.toLowerCase())){
				cityId = jObj.getLong("_id");
			}
		}
			
		input.close();
		if(cityId == 0)
			cityId = 294751;
		return cityId;
	}
	*/
	
	public static String GetJSON(String url){
		URL nUrl;		
		String json = new String();
		
		try {
			nUrl = new URL(url);
			Scanner scan = new Scanner(nUrl.openStream());		    
			while (scan.hasNext())
			   json += scan.nextLine();
			
			scan.close();
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
}
