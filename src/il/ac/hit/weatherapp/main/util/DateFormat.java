package il.ac.hit.weatherapp.main.util;

import java.util.Date;

/**
 * Formating date and time
 * @author Lena
 *
 */

public class DateFormat {
	
	public static String sunFormat(Date date){
		
		String time = date.toString();
		String temp = time.substring(10, 16);

		return temp;		
	}
	
	public static String dateTimeFormat(Date date){
		
		String time = date.toString();
		String temp = time.substring(0, 16);

		return temp;		
	}

}
