package il.ac.hit.weatherapp.main.model;

/**
 * class Location contains information on the location of the user is interested in
 * 
 * @author Lena
 *
 */

public class Location {
	
	private long id;
	private String city;
	private String country;
	
	public Location() {
		super();
	}
	
	public Location(long id, String city, String country) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
}
