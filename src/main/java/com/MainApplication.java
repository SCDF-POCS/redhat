package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.util.URIUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SpringBootApplication
public class MainApplication{

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		/*
		 * try { getCordinates("Airoli,sector3","India"); // getValue(); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * catch (ParserConfigurationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SAXException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
	   }
	

	//@Configuration
	public class DBConfig{

	       @Bean
	       public DataSource dataSource(){
	          DriverManagerDataSource dataSource = new DriverManagerDataSource();
	          dataSource.setDriverClassName("org.postgresql.Driver");
	          dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
	          dataSource.setUsername( "postgres" );
	          dataSource.setPassword( "root" );
	          return dataSource;
	       }

	}
	
	

	private void getValue() {
		try {
	        URL url = new URL(
	                "http://maps.googleapis.com/maps/api/geocode/json?address="
	                        + URIUtil.encodeQuery("Sayaji Hotel, Near balewadi stadium, pune") + "&sensor=true");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        }
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	        String output = "", full = "";
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	            full += output;
	        }
	        
	        System.out.println(full + "   full");

			/*
			 * PincodeVerify gson = new Gson().fromJson(full, PincodeVerify.class);
			 * HttpResponse response = new IsPincodeSupportedResponse(new
			 * PincodeVerifyConcrete( gson.getResults().get(0).getFormatted_address(),
			 * gson.getResults().get(0).getGeometry().getLocation().getLat(),
			 * gson.getResults().get(0).getGeometry().getLocation().getLng())) ; try {
			 * String address = response.getAddress(); Double latitude =
			 * response.getLatitude(), longitude = response.getLongitude(); if (address ==
			 * null || address.length() <= 0) { // log.error("Address is null"); } } catch
			 * (NullPointerException e) { //
			 * log.error("Address, latitude on longitude is null"); }
			 */
	        conn.disconnect();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	
	   
	   public static String getCordinates(String address,String county) throws IOException, ParserConfigurationException, SAXException{
		    String thisLine;

		    address = address.replace(",", "+");
		    address = address.replace(" ", "+");
		    county = county.replace(" ", "");

		    String fullAddress = address+"+"+county;
		    System.out.println(fullAddress);

		    System.out.println(URIUtil.encodeQuery("Sayaji Hotel, Near balewadi stadium, pune"));
		   
		    
		    String source = URIUtil.encodeQuery("Atos-Syntel  Building No. 4 Mindspace Airoli Navi Mumbai");
		    String dest =URIUtil.encodeQuery("Rabale Station Rd Sundarvan Society Rabale Navi Mumbai");
		   // origin=Disneyland&destination=Universal+Studios+Hollywood
		    		
		    	System.out.println(source);
		    	System.out.println(dest);
		    
		    URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=19.1593979,72.9879501&radius=800&types=school&key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk");
	      
		   
		    //******************final
		    //

		    System.out.println(url);
		    
		    //https://maps.googleapis.com/maps/api/directions/json?origin=airoli&destination=mulund&key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk&departure_time=now&mode=driving
		    
		    // https://maps.googleapis.com/maps/api/directions/json?origin=mumbai&destination=agra&key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk
		    
		   // URL urls = new URL("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk&address=Sayaji%20Hotel,%20Near%20balewadi%20stadium,%20pune&sensor=true&output=xml");
		    
		    //URL url = new URL("http://maps.google.com/maps/geo?q="+fullAddress+"&output=xml&key=AIzaSyC5hL4s6HuMGwUZ9P9BxHGn5WtboUtGUpo");
		   // URL urls = new URL("https://www.google.com/maps/embed/v1/place?key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk&q=Eiffel+Tower,Paris+France");
		    System.out.println("yrm   l    " +url);

		    BufferedReader theHTML = new BufferedReader(new InputStreamReader(url.openStream()));

		    FileWriter fstream = new FileWriter("url.txt");
		    BufferedWriter out = new BufferedWriter(fstream);
		    while ((thisLine = theHTML.readLine()) != null)
		        out.write(thisLine);
		    out.close();

		   // File file = new File("url.txt");
		 
		    try(BufferedReader br = new BufferedReader(new FileReader("url.txt"))) {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		        	System.out.println(line);
		        	if(line.contains("name"))
		        	System.out.println("******************" +line);
		          //  sb.append(line);
		            //sb.append(System.lineSeparator());
		            line = br.readLine();
		        }
		        String everything = sb.toString();
		    }
		    
		/*
		 * DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 * DocumentBuilder db = dbf.newDocumentBuilder(); Document doc = db.parse(file);
		 * doc.getDocumentElement().normalize(); NodeList nl =
		 * doc.getElementsByTagName("code"); Element n = (Element)nl.item(0); String st
		 * = n.getFirstChild().getNodeValue();
		 * 
		 * if (st.equals("200")) { NodeList n2 =
		 * doc.getElementsByTagName("coordinates"); Element nn = (Element)n2.item(0);
		 * String st1 = nn.getFirstChild().getNodeValue();
		 * 
		 * 
		 * return st1; } else { return null; }
		 */
return "Hello";

		}

	   
	   public static String getCordinatesss(String address,String county) throws IOException, ParserConfigurationException, SAXException{
		    String thisLine;

		    address = address.replace(",", "+");
		    address = address.replace(" ", "+");
		    county = county.replace(" ", "");

		    String fullAddress = address+"+"+county;
		    System.out.println(fullAddress);

		    //URL url = new URL("http://maps.google.com/maps/geo?q="+fullAddress+"&output=xml&key=AIzaSyC5hL4s6HuMGwUZ9P9BxHGn5WtboUtGUpo");
		    URL url = new URL("https://www.google.com/maps/embed/v1/place" + 
		    		"?key=AIzaSyCInknKpnR2nuTw-Xgn9fvpI5Tc9hSFZSk" + 
		    		"&q=Eiffel+Tower,Paris+France&sensor=true");
		    

		    BufferedReader theHTML = new BufferedReader(new InputStreamReader(url.openStream()));

		    FileWriter fstream = new FileWriter("url.xml");
		    BufferedWriter out = new BufferedWriter(fstream);
		    while ((thisLine = theHTML.readLine()) != null)
		        out.write(thisLine);
		    out.close();

		    File file = new File("url.xml");
		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    DocumentBuilder db = dbf.newDocumentBuilder();
		    Document doc = db.parse(file);
		    doc.getDocumentElement().normalize();
		    NodeList nl = doc.getElementsByTagName("code");
		    Element n = (Element)nl.item(0);
		    String st = n.getFirstChild().getNodeValue();

		    if (st.equals("200"))
		    {
		        NodeList n2 = doc.getElementsByTagName("coordinates");
		        Element nn = (Element)n2.item(0);
		        String st1 = nn.getFirstChild().getNodeValue();


		        return st1;
		    }
		    else
		    {
		        return null;
		    }


		}

	   
	   
	}

	
	

