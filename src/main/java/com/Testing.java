package com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Testing {

	public static void main(String[] args) {
		 
		/*
		 * DateTime localTime = DateTime.parse("01/01/1970 00:00:00"); DateTime
		 * inceptionDateTime = DateTime.parse("01/01/1970 00:00:00");
		 * 
		 * TimeSpan departureTimeSpan = departureDateTime - inceptionDateTime; double
		 * departureTimeSeconds = departureTimeSpan.TotalSeconds;
		 * 
		 * return departureTimeSeconds.ToString().Split('.')[0];
		 */
		java.util.Date date=new Date();
	  //  System.out.println(date.getTime());
	    
		//System.out.println(java.time.Instant.now().getEpochSecond());
		
		//Date date1 =new Date("October 11, 2019 10:50:00");   "25 mins"
		//Date date1 =new Date("October 20, 2019 5:50:00");  //24 min
		//Date date1 =new Date("October 20, 2019 20:50:00");  //"18 mins",
		//Date date1 =new Date("October 20, 2019 02:50:00");   //20 min
		Date date1 =new Date("October 20, 2019 02:00:00");   //19 min
		//now "26 mins" at 5:03
		System.out.println((date1.getTime())/1000);
	//	System.out.println( (new Date().getTime())/1000);
	    
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date dater = new Date();  
		    System.out.println(formatter.format(dater));
	    
	    
	  ///  https://maps.googleapis.com/maps/api/directions/json?origin=airoli&destination=mulund&key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk&departure_time=1570625004&mode=driving
	    	
	    	
	    
	}
	
}
