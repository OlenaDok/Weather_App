package il.ac.hit.weatherapp.main.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Logger;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

import org.json.JSONException;

import il.ac.hit.weatherapp.main.model.Location;
import il.ac.hit.weatherapp.main.model.WeatherData;
import il.ac.hit.weatherapp.main.model.WeatherServiceException;
import il.ac.hit.weatherapp.main.service.WeatherDataService;
import il.ac.hit.weatherapp.main.util.DateFormat;
import il.ac.hit.weatherapp.main.util.WeatherIcon;
import il.ac.hit.weatherapp.main.util.WindDirection;

/**
 * Client Interface
 * 
 * @author Lena
 *
 */

public class GUI extends Observable{
	
	private static final Color myColor = new Color(204, 204, 255);
	private static final String fontName = "Serif";
	
	private static final String TITLE = "Weather Service";
	private static final String SUB_TITLE = "Weather in your city";
	//private static final String Clock_Label = "the time is now ";
	private static final String GET_LABEL = "Get at: ";
	private static final String[] TABLE_SET = {"Wind", "Cloudiness",
								"Pressure", "Humidity", "Sunrise", "Sunset"};
	
	private WeatherData _wd;
	
	private JFrame 		frame;
	private JPanel 		mainPanel, upperPanel, centerPanel, lowerPanel;
	private JTextField	tfCityResearch, tfCountryResearch;
	private JButton 	btnResearch;
	private JLabel 		locationLabel;
	private JLabel 		temperLabal, descriptionLabel;
	private JLabel 		img;	
	private JTable 		table;
	private JLabel 		clockLabel, getAtLabel, dateLabel;
	
	private ButtonsListener btnListner; 
	private TFListner tfListner;
	static Logger  		logger;
	
	public void CreateAndShowGUI() throws JSONException, IOException{
		
		InitComponents();
	}
	
	private void InitComponents() throws JSONException, IOException{

		frame = new JFrame(TITLE);
		frame.setSize(350, 550);
		frame.setResizable(false);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createTitledBorder(SUB_TITLE));
		//mainPanel.setForeground(new Color(0, 150, 255));
		mainPanel.setOpaque(true);
		/*the upper panel*/
		upperPanel = new JPanel();
		JPanel subPanl = new JPanel();
		upperPanel.setPreferredSize(new Dimension(330, 150));
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS));
		upperPanel.setBackground(myColor);
		
		tfCityResearch = new JTextField(13);
		tfCityResearch.setBorder(BorderFactory.createTitledBorder("City"));
		tfListner = new TFListner();
		tfCityResearch.addActionListener(tfListner);
		tfCountryResearch = new JTextField(13);
		tfCountryResearch.setBorder(BorderFactory.createTitledBorder("Country"));
		tfCountryResearch.setEnabled(true);
		
		btnResearch = new JButton("Find");
		btnResearch.setPreferredSize(new Dimension(110,25));
		btnListner = new ButtonsListener();
		btnResearch.addActionListener(btnListner);
		
		subPanl.add(tfCityResearch);
		subPanl.add(tfCountryResearch);
		subPanl.add(btnResearch);
		subPanl.setBackground(new Color(204, 204, 255));
		subPanl.setOpaque(false);
		
		locationLabel = new JLabel();
		locationLabel.setFont(new Font(fontName, Font.ITALIC, 27));
		temperLabal = new JLabel();
		temperLabal.setFont(new Font(fontName, Font.ITALIC, 30));
		descriptionLabel = new JLabel();
		descriptionLabel.setFont(new Font(fontName, Font.ITALIC, 20));
		
		
		
		upperPanel.add(subPanl);
		upperPanel.add(locationLabel);
		upperPanel.add(temperLabal);
		//upperPanel.add(descriptionLabel);
		
		/*the center panel*/
		centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(350, 265));
		centerPanel.setOpaque(false);
		
	//	centerPanel.setEnabled(false);
		
		JPanel subPanIMG = new JPanel();
		subPanIMG.setLayout(new BorderLayout());
		
		
		img = new JLabel();
		img.setSize(new Dimension(120, 120));
		img.setOpaque(false);
		
		centerPanel.add(img, subPanIMG);
		centerPanel.add(descriptionLabel, subPanIMG);
		//subPanIMG.setSize(new Dimension(240, 240));

		table = new JTable(6, 2);
		SetValueAtTable(TABLE_SET, 0);
		
		table.setRowHeight(30);
		table.setPreferredSize(new Dimension(320, 198));
		
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font(fontName, Font.ITALIC, 13));
		table.setShowGrid(false);
		table.setCellSelectionEnabled(false);
		table.setOpaque(false);
		table.setBackground(myColor);
		JPanel subPanTBL = new JPanel();
		
		subPanTBL.add(table);
		subPanTBL.setOpaque(false);
		
		centerPanel.add(subPanIMG);
		centerPanel.add(subPanTBL);
		centerPanel.setOpaque(false);
		//centerPanel.add(table);
		
		/*the lower panel*/
		lowerPanel = new JPanel();
		lowerPanel.setPreferredSize(new Dimension(350, 73));
	//	lowerPanel.setBackground(Color.LIGHT_GRAY);
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
		lowerPanel.setOpaque(false);
		JPanel lowSubPanl = new JPanel();
		lowSubPanl.setOpaque(false);
		
		clockLabel = new JLabel();
		clockLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		getAtLabel = new JLabel(GET_LABEL);
		getAtLabel.setFont(new Font("Courier New", Font.BOLD, 14));
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		lowSubPanl.add(getAtLabel);
		lowSubPanl.add(dateLabel);
		
		lowerPanel.add(lowSubPanl);
		lowerPanel.add(clockLabel);
		lowerPanel.setOpaque(false);
		
		/*adding components to the main panel*/
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(upperPanel);
		mainPanel.add(centerPanel);
		mainPanel.add(lowerPanel);
		
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		setDefaultUI();
		
	}
		
	public String[] GetParametrs(WeatherData wd){
			/*WeatherData data*/
			String[] list = new String[6];
						
			list[0] = new String(wd.getSpeed() + " m/s, " + WindDirection.convertDegree2Direction(wd.getDeg()));
			list[1] = wd.getDescription();
			list[2] = new String(wd.getPressure() + " hpa"); 
			list[3] = new String(wd.getHumidity() + " %");
			list[4] = DateFormat.sunFormat(wd.getSunrise());
			list[5] = DateFormat.sunFormat(wd.getSunset());
			
			return list;			
		}
	
	private void SetValueAtTable(String[] list, int col){
		for(int i=0; i<6; i++){
			table.setValueAt(list[i], i, col);
		}
	}
	
	private boolean isLegalCharInput(String input){
		
		Pattern pattern = Pattern.compile("^[0-9]+");
		boolean isLegal = false;
		
		Matcher m = pattern.matcher(input);
		isLegal = !m.matches(); 
		
	    return  isLegal;
	}
	
	private void cleanStringFromUser (String userInput){
		
		userInput.replaceAll(" ", "");
	}
	
	private void SetTemperature(WeatherData wd){
		String text = String.valueOf(wd.getTemp());
		temperLabal.setText(new String(text + "  °"));
		descriptionLabel.setText(wd.getWeatherParameters());
	}
	
	private void SetIcon(WeatherData wd) throws MalformedURLException{
		Icon icon = WeatherIcon.getImageIcon(wd.getIconId());
		System.out.println("wd.getIconId " + wd.getIconId());
		
		Dimension size = new Dimension(100, 80);
		img.setIcon(icon);
		img.setSize(size);
		img.setPreferredSize(size);
		img.setMinimumSize(size);
		img.setMaximumSize(size);
				
	}
	
	private void setDefaultUI() throws JSONException, IOException{
		
    	Location loc = new Location();
    	loc.setCity("Holon");
    	loc.setCountry("IL");
    	
         	String location = loc.getCity() + ", " + loc.getCountry();
         	//userCleanLocation = ToCleanInput(userInputLocation);
         	//tfCityResearch.setText(userInputLocation);
         	
         	try{
         		
             	locationLabel.setText(location);
             	
         		_wd = WeatherDataService.getInstance().getWeatherData(loc);
         		SetValueAtTable(GetParametrs(_wd), 1);	
         		SetTemperature(_wd);
         		SetIcon(_wd);
         		SetTime(_wd);
         	}catch (WeatherServiceException e) {
         		e.printStackTrace();
         	}
	}

	private void SetTime(WeatherData wd){
		Date dt = wd.getDatetime();
		dateLabel.setText(DateFormat.dateTimeFormat(dt));
	}
	
	public void UppdateWeatherData() throws WeatherServiceException, MalformedURLException{
		
	//_wd = WeatherDataService.getInstance().getWeatherData(loc);
	//	locationLabel.setText(_wd.getLocationJson());
		locationLabel.setText(_wd.getLocationJson());
		SetValueAtTable(GetParametrs(_wd), 1);
		SetTemperature(_wd);
		SetIcon(_wd);
		SetTime(_wd);
		tfCityResearch.setText("");
		tfCountryResearch.setText("");
	}
	
	public WeatherData getWD() {
		return _wd;
	}
	
	public void setWd(WeatherData wd){
		this._wd = wd;
	}
	
	private class TFListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tfCityResearch){
				if(!(tfCityResearch.getText().equals(""))){
				tfCountryResearch.setEnabled(true);
				}
			}
		}
	}
	
	private class ButtonsListener implements ActionListener {
		
        @Override
        public void actionPerformed(ActionEvent event){
        	
        	//logger.getLevel().toString();
        	String userInputLocation = "";
        	Location loc;
        	
            if(event.getSource() == btnResearch)
            {
                    //logger.info(" User click the button *FIND*");
            	System.out.println("User click the button *FIND*");

                try
                {
                    if(tfCityResearch.getText().equals("") || isLegalCharInput(tfCityResearch.getText()) == false)
                    {
                    	JOptionPane.showMessageDialog(frame, "Oppss...Your input is not correct");
                    	setDefaultUI();
                    	System.out.println("equal, or 123");
                    }
                    else
                    {
                    	if(!tfCityResearch.getText().equals("") && tfCountryResearch.getText().equals("")){
                    		
                    		//notifyObservers();
                    		
                    		userInputLocation = tfCityResearch.getText();
                    		cleanStringFromUser(userInputLocation);
                    		loc = new Location();
                    		loc.setCity(userInputLocation);
                    		
                    		System.out.println(loc.toString());
                    		
                    		setChanged();
                    		notifyObservers(loc);
                    		
                    		UppdateWeatherData();
                    		
                    	}
                    	if(!tfCityResearch.getText().equals("") && !tfCountryResearch.getText().equals("")){
                    		
                    		//notifyObservers();
                    		
                    		userInputLocation = tfCityResearch.getText();
                    		cleanStringFromUser(userInputLocation);
                    		loc = new Location();
                    		loc.setCity(userInputLocation);
                    		userInputLocation = tfCountryResearch.getText();
                    		cleanStringFromUser(userInputLocation);
                    		loc.setCity(userInputLocation);
                    		
                    		setChanged();
                    		notifyObservers(loc);
                    		
                    		System.out.println(_wd.toString());
                    		
                    		UppdateWeatherData();
                    	}
                    }
                }catch (MalformedURLException e) {

                	e.printStackTrace();
                	
				} catch (Exception e) {
					
					e.printStackTrace();
				}
            }
        }
	}
}
