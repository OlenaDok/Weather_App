package il.ac.hit.weatherapp.main.model;

import java.util.Date;

/**
 * class WeatherData contains information about the weather
 * 
 * @author Lena
 *
 */

public class WeatherData {
	
	private int conditionId;
	private String description;
	private String iconId;
	private String weatherParameters;
	
	private float temp;	
	private int pressure;
	private int humidity;
	private float tempMin;
	private float tempMax;
	
	private float speed;
	private float deg;
	
	private int cloudiness;
	
	private Date sunset;
	private Date sunrise;
	
	private Date datetime;
	
	private String locationJson;
	
	public WeatherData() {
		super();
	}

	/**
	 * @return the conditionId
	 */
	public int getConditionId() {
		return conditionId;
	}

	/**
	 * @param conditionId the conditionId to set
	 */
	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the iconId
	 */
	public String getIconId() {
		return iconId;
	}

	/**
	 * @param iconId the iconId to set
	 */
	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	/**
	 * @return the weatherParameters
	 */
	public String getWeatherParameters() {
		return weatherParameters;
	}

	/**
	 * @param weatherParameters the weatherParameters to set
	 */
	public void setWeatherParameters(String weatherParameters) {
		this.weatherParameters = weatherParameters;
	}

	/**
	 * @return the temp
	 */
	public float getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(float temp) {
		this.temp = temp;
	}

	/**
	 * @return the pressure
	 */
	public int getPressure() {
		return pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the tempMin
	 */
	public float getTempMin() {
		return tempMin;
	}

	/**
	 * @param tempMin the tempMin to set
	 */
	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}

	/**
	 * @return the tempMax
	 */
	public float getTempMax() {
		return tempMax;
	}

	/**
	 * @param tempMax the tempMax to set
	 */
	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the deg
	 */
	public float getDeg() {
		return deg;
	}

	/**
	 * @param deg the deg to set
	 */
	public void setDeg(float deg) {
		this.deg = deg;
	}

	/**
	 * @return the cloudiness
	 */
	public int getCloudiness() {
		return cloudiness;
	}

	/**
	 * @param cloudiness the cloudiness to set
	 */
	public void setCloudiness(int cloudiness) {
		this.cloudiness = cloudiness;
	}

	/**
	 * @return the sunset
	 */
	public Date getSunset() {
		return sunset;
	}

	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	/**
	 * @return the sunrise
	 */
	public Date getSunrise() {
		return sunrise;
	}

	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the locationJson
	 */
	public String getLocationJson() {
		return locationJson;
	}

	/**
	 * @param locationJson the locationJson to set
	 */
	public void setLocationJson(String locationJson) {
		this.locationJson = locationJson;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeatherData [conditionId=" + conditionId + ", description=" + description + ", iconId=" + iconId
				+ ", weatherParameters=" + weatherParameters + ", temp=" + temp + ", pressure=" + pressure
				+ ", humidity=" + humidity + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", speed=" + speed
				+ ", deg=" + deg + ", cloudiness=" + cloudiness + ", sunset=" + sunset + ", sunrise=" + sunrise
				+ ", datetime=" + datetime + ", locationJson=" + locationJson + "]";
	}

	
}