package il.ac.hit.weatherapp.main.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

public class WeatherIcon {
	
	public static final String  REF_WICONS= "/sources/Icons/";
	public static final String  REF_WICONS_END = ".png";
	public static final String  REF_MAIN= "./files/BG.png";
	
	public static Image getIcon(String name) {
		if(name.isEmpty() || name == null){
			return null;
		}
		String url = new String(REF_WICONS + name + REF_WICONS_END);
		System.out.println(url.toString());
		
		URL imageURL = WeatherIcon.class.getResource(url);
		
		if(imageURL == null){
			System.out.println("inage url is null");
			return null;
		}
		
		
		return Toolkit.getDefaultToolkit().createImage(imageURL);
	}
	
	public static Image getFon(){
		
		URL imageURL = WeatherIcon.class.getResource(REF_MAIN);
		
		
		if(imageURL == null){
			Logger.getLogger("imageUrl is null");
			return null;
		}
		System.out.println(WeatherIcon.class.getResource(imageURL.toString()));
		Logger.getLogger(WeatherIcon.class.getName());
		
		return Toolkit.getDefaultToolkit().createImage(imageURL);
	}
	
	public static ImageIcon getImageIcon(String name) throws MalformedURLException{
		Image image = getIcon(name);
		
		if(image == null){
			Logger.getLogger("image is null");
			return null;
		}
		return new ImageIcon(image);			
	}
	
	public static ImageIcon getMainIcon(){
		Image image = getFon();
		if(image == null){
			return null;
		}
		return new ImageIcon(image);			
	}

	public static ImageIcon setWeatherIcon(String name) {
		ImageIcon imic = new ImageIcon(REF_WICONS + name + REF_WICONS_END);
		
		return imic;			
	}
}
