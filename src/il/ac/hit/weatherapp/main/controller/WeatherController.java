package il.ac.hit.weatherapp.main.controller;

import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;

import il.ac.hit.weatherapp.main.gui.GUI;
import il.ac.hit.weatherapp.main.model.Location;
import il.ac.hit.weatherapp.main.model.WeatherServiceException;
import il.ac.hit.weatherapp.main.service.WeatherDataService;

public class WeatherController implements Observer {
	
	WeatherDataService _service;
	GUI _gui;

	public WeatherController(WeatherDataService service, GUI gui){
		this._service = service;
		this._gui = gui;
	}

	@Override
	public void update(Observable obs, Object obj) {

		if(obs.getClass().equals(WeatherDataService.class)) {
			
				System.out.println("update(Observable service, Object obj)");
				try {
					this._gui.UppdateWeatherData();
				} catch (MalformedURLException | WeatherServiceException e) {
					e.printStackTrace();
				};
		}
		
		if(obs.getClass().equals(GUI.class)){
			
			System.out.println("update(Observable gui, Object obj)");
			try {
				this._gui.setWd(WeatherDataService.getInstance().getWeatherData((Location)obj));
			} catch (WeatherServiceException e) {
				
				e.printStackTrace();
			}
		}
	}
}
