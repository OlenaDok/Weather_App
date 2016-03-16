package il.ac.hit.weatherapp.main.service;

/**
 * class OpenWeatherMap builds a link for more information
 */

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class OpenWeatherMap {
	
	private static final String URL_API = "http://api.openweathermap.org/data/2.5/";
    private static final String URL_CURRENT = "weather?";

    private static final String PARAM_CITY_NAME = "q=";
    private static final String PARAM_CITY_ID = "id=";
    //private static final String PARAM_MODE = "mode=";
    private static final String PARAM_UNITS = "units=";
    private static final String PARAM_APPID = "appId=";
   // private static final String PARAM_LANG = "lang=";
    
    //private static final String MODE = "json";
    private static final String ENCODING = "UTF-8";
    private static final String UNITS = "metric";
    //private static final String LANG = "en";
    private static final String APPID = "09436d0b2b54f4d8724b3e0203b9e0e3";

	/**
	 * Building the link to get information
	 * 
	 * @param cityName
	 * @return (string )link with specified name of city
	 * @throws UnsupportedEncodingException
	 */
	 public static String stringToGetCurrentWeatherByCityName(String cityName) throws UnsupportedEncodingException {
         return new StringBuilder()
                 .append(URL_API).append(URL_CURRENT)
                 .append(PARAM_CITY_NAME).append(URLEncoder.encode(cityName, ENCODING)).append("&")
                // .append(PARAM_MODE).append(MODE).append("&")
                 .append(PARAM_UNITS).append(UNITS).append("&")
               //  .append(PARAM_LANG).append(LANG).append("&")
                 .append(PARAM_APPID).append(APPID)
                 .toString();
     }
	 
	 /**
	  * Building the link to get information
	  * 
	  * @param cityCode
	  * @return (string )link with specified code of city
	  */
	 public static String stringCurrentWeatherByCityCode(long cityCode) {
         return new StringBuilder()
                 .append(URL_API).append(URL_CURRENT)
                 .append(PARAM_CITY_ID).append(Long.toString(cityCode)).append("&")
                 //.append(PARAM_MODE).append(MODE).append("&")
                .append(PARAM_UNITS).append(UNITS).append("&")
             //    .append(PARAM_LANG).append(LANG).append("&")
                 .append(PARAM_APPID).append(APPID)
                 .toString();
     }
	 
	 /**
	  * Building the link to get information
	  * 
	  * @param cityname
	  * @param country
	  * @return (string )link with specified name of city and country
	  * @throws UnsupportedEncodingException
	  */
	 
	 public static String stringCurrentWeatherByCityNameAndCountry(String cityname, String country) throws UnsupportedEncodingException {
         return new StringBuilder()
                 .append(URL_API).append(URL_CURRENT)
                 .append(PARAM_CITY_NAME).append(URLEncoder.encode(cityname, ENCODING)).append(",")
                 .append(country)              
                 .append("&")
                 //.append(PARAM_MODE).append(MODE).append("&")
                .append(PARAM_UNITS).append(UNITS).append("&")
             //    .append(PARAM_LANG).append(LANG).append("&")
                 .append(PARAM_APPID).append(APPID)
                 .toString();
     }

}
