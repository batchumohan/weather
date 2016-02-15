package com.twc.SmokeTestCases;

import io.appium.java_client.MobileElement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import atu.testng.reports.ATUReports;

import com.twc.General.Swipe;
import com.twc.General.app_Kill_Relaunch;
import com.twc.driver.Driver;
import com.twc.driver.PropertyFile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SmokeTest_AD_C333174_FactualCall extends Driver {

	@SuppressWarnings({ "unchecked", "unused", "deprecation", "resource" })
	public void Factual_Test() throws Exception{
				
		//Read data from Property file if required
	    Driver.property();
		PropertyFile.property();

		System.out.println("Verification of Factual Call Test_Case Started");
		
		String adbPath = properties.getProperty("adbPath");
		String[] str ={"/bin/bash", "-c", adbPath+" shell setprop log.tag.TwcAd DEBUG"};
		Process p = Runtime.getRuntime().exec(str);
		
		System.out.println("Debug command is done");
	
		String[] str1 ={"/bin/bash", "-c", adbPath+ " -d logcat -v time >> "+properties.getProperty("LogFilePath")};
		Process p1 = Runtime.getRuntime().exec(str1);
		System.out.println("Writing App logs to LogFile");
			
		ATUReports.add("Launch the app",false);
		
		try {
//		//Wait for 10 sec for element presence
		WebDriverWait wait = new WebDriverWait(Ad, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/temperature")));
		
		//Temperature  Element
		MobileElement tempElement = (MobileElement) Ad.findElementById("com.weather.Weather:id/temperature");
		System.out.println("Temperature : "+tempElement.getText());
		
		ATUReports.add("Scroll to Feed-1 Ad", false);
		Swipe.swipe();
		Swipe.swipe();
		}catch(Exception e){
			//System.out.println("Exception message :: "+e);			
		}
		
		Thread.sleep(2000);
	
//		MobileElement AdEle =(MobileElement) Ad.findElementById("com.weather.Weather:id/ad_view_holder");
		MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.view.View[2]/android.widget.ListView[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]");

		WebDriverWait wait1 = new WebDriverWait(Ad, 4);
		
		wait1.until(ExpectedConditions.visibilityOf(AdEle));
	
		if(AdEle.isDisplayed())
		{
			System.out.println("Feed-1 Ad is present");
			ATUReports.add("Feed-1 Ad is present", false);
		}

		Thread.sleep(2000);
		
		// Reading the log file for feed_1 to verify PubAd Faud and Fgeo value
		
		BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));

		String line = "";
		String allLine = "";

		while ((line = r.readLine()) != null) {
			System.out.println("Sys data is ::" + line);
		}

		String FilePath = properties.getProperty("LogFilePath");

		try {
			FileInputStream fstream = new FileInputStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			// / read log line by line ------ strLine = br.readLines(6, 10); /
			StringBuffer sb = new StringBuffer("");
			while ((strLine = br.readLine()) != null) {
				// parse strLine to obtain what you want /
				// System.out.println (strLine);
				sb.append(strLine);
			}
			
			Map<String, String> mapkeys = new HashMap<String, String>();			
			List<String> pubad_faudvalues = new ArrayList<String>();
			List<String> pubad_fgeovalues = new ArrayList<String>();
			
			String req=null;
			
			if (sb.toString().contains("slotName=weather.feed1")) {
			    req = sb.toString().substring(sb.toString().lastIndexOf("slotName=weather.feed1"));
				req = req.substring(req.indexOf(",") + 1, req.indexOf("}"));
				String[] arrays = req.split(", ");
				System.out.println("Verifying the " + req);
				for (String keys : arrays) {
					System.out.println(keys);
					if (keys.contains("=")) {
						String[] key = keys.split("=");
						// System.out.println(key[0] + "---"+key[1]);
						mapkeys.put(key[0], key[1]);
					}
				}
								
				String faudValue=null;
				String fgeoValue=null;						
				for (Entry<String, String> entryKeys : mapkeys.entrySet()) {					
					// Verify FAUD Value
					if (entryKeys.getKey().contains("faud")) {
						faudValue = entryKeys.getValue();
						Assert.assertNotNull(faudValue);
						System.out.println("FAUD value is present");
						System.out.println("faud values are : " + faudValue);
						pubad_faudvalues.add(faudValue);
					}
					// Verify FGEO Value					
					if (entryKeys.getKey().contains("fgeo")) {
						fgeoValue = entryKeys.getValue();
						Assert.assertNotNull(fgeoValue);
						System.out.println("FGEO value is present");
						System.out.println("FGEO vaules are : " + fgeoValue);
						pubad_fgeovalues.add(fgeoValue);
					}
				}
			}
			
			//Verify the Factual_API_Call is present in Logs
			String factualCall =null;
			if (sb.toString().contains("https://location.wfxtriggers.com/geopulse/")) {
				factualCall = sb.toString().substring(sb.toString().lastIndexOf("https://location.wfxtriggers.com/geopulse/7620026f-cfb6-4d0c-9f8e-434ff0cd34d0?audience=true&proximity=true"));
				factualCall = factualCall.substring(factualCall.indexOf("http"), factualCall.indexOf("proximity")+14);
				System.out.println("Factual API call is present and the url is : \n"+factualCall);
				ATUReports.add("Factual API Call is present and the url is : \n"+factualCall,false);
			}
			
			List<String> filterValues = new ArrayList<String>();
			String fatual = null;
			String proximityfilter =null;
			Thread.sleep(2000);
			
			// Capturing the Factual Call Data (location.wfxtriggers.com/geopulse)
			if (sb.toString().contains("response from server is {" + '"' + "journaled")) {

				if (sb.toString().contains("response from server is {" + "\"journaled\"")) {					
					fatual = sb.toString().substring(sb.toString().lastIndexOf("response from server is {"+'"'+"journaled"));
					fatual = fatual.substring(fatual.indexOf("proximity")+12,fatual.indexOf('"'+"audience")-1);
					System.out.println("Verifing the Factual call " + fatual);
				}

				Thread.sleep(2000);
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(fatual.toString());
				JSONArray jsonObject = (JSONArray) obj;

				List<String> list = new ArrayList<String>();
				
				for (int index = 0; index < jsonObject.size(); index++) {
					JSONObject obj1 = (JSONObject) jsonObject.get(index);
				    proximityfilter=(String) obj1.get("filter");
					filterValues.add(proximityfilter);	
				}		
			}
			
			ATUReports.add("Verify the Factual values(FAUD,FGEO) in Feed_1 Call", false);
			String pubad_faud = pubad_faudvalues.toString();
			System.out.println("PubAd_FAUD Values "+ pubad_faud.toString());
			ATUReports.add("PubAd_FAUD values are present", false);
			
			ATUReports.add("Verify PubAd_FGEO values", false);
			String pubad_fgeo = pubad_fgeovalues.toString();
			System.out.println("PubAd_FGEO Values "+ pubad_fgeo.toString());
			ATUReports.add("PubAd_FGEO values are present", false);
			
			ATUReports.add("Verify Filter values in Location_Geopulse call", false);
			String filters= filterValues.toString().replaceAll(", ", ",");
			System.out.println("Location_Geopulse_Filter values "+ filters.toString());
			ATUReports.add("Location_Geopulse_Filter values are present", false);

			System.out.println("Geopulse values count : " + filterValues.size());

			 //Asserting the PubAd_FGEO values and Factual_call filter values
			for (int counter = 0; counter < filterValues.size(); counter++) {
				if (pubad_fgeo.contains(filterValues.get(counter))) {
					// won't run body since can't compare
					System.out.println(filterValues.get(counter)+" PubAD_FGEO_value is present in the Location_GeoPulse filter values");
				} else {
					// System.out.println("This is not valid "+filterValues.get(counter));
					System.out.println(filterValues.get(counter)+" PubAD_FGEO_value is NOT present in the Location_GeoPulse filter values");
				}
			}
			
			System.out.println("=====================================================");
			
			if(filters.equalsIgnoreCase(pubad_faudvalues.toString())){
				
				System.out.println("PubAd_FGEO values and Factual_call filter values are matched");
				ATUReports.add("PubAd_FGEO values and Factual_call filter values are matched", false);	
			}else{
				
				System.out.println("PubAd_FGEO values and Factual_call filter values are NOT matched");
				ATUReports.add("PubAd_FGEO values and Factual_call filter values are NOT matched", false);
				}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Factual Call Test_Case is done");
	}

}
