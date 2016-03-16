package il.ac.hit.weatherapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.JSONException;

import il.ac.hit.weatherapp.main.controller.WeatherController;
import il.ac.hit.weatherapp.main.gui.GUI;
import il.ac.hit.weatherapp.main.service.WeatherDataService;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, JSONException, UnsupportedEncodingException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GUI view = new GUI();
				WeatherDataService wd = new WeatherDataService();
				WeatherController wcontrol = new WeatherController(wd, view);
				view.addObserver(wcontrol);
				wd.addObserver(wcontrol);
				try {
					view.CreateAndShowGUI();
					
				} catch (JSONException | IOException e) {
					e.printStackTrace();
				}				
			}
		});
	}
}
