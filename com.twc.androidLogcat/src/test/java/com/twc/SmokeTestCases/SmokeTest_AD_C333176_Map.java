package com.twc.SmokeTestCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;

import com.twc.General.Swipe;
import com.twc.General.app_Kill_Relaunch;
import com.twc.driver.Driver;

public class SmokeTest_AD_C333176_Map extends Driver {

	@SuppressWarnings({ "unused", "deprecation" })
	public void verify_adpresent_onextendedMap_page() throws Exception {

		//Set the Native Context
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");

		ATUReports.add("Launch the app", false);
		
		System.out.println("Searching for Radar & Maps module");
		ATUReports.add("Scroll to Radar & Maps module", false);
		int MAX_SWIPES = 10;
		for (int i = 0; i<MAX_SWIPES; i++) {
			WebElement maps = null;

			try {
				// Ad.findElementById(" com.weather.Weather:id/driving_difficulty_module_title");
				maps = Ad.findElementByName("Radar & Maps");

			} catch (Exception e) {
				// System.out.println(e);
			}

			if (maps != null && maps.isDisplayed()) {
				
				System.out.println("Radar and Maps module is present and tap on Map Image");
				
				ATUReports.add("Radar and Maps module is present and tap on Map Image",false);
				
				try{
				Ad.findElementByName("Radar & Maps").click();
				}catch(Exception e){
//					Ad.findElementById("map_module_thumbnail").click();
//					Ad.findElementByClassName("android.widget.ImageView").click();
					Ad.findElementByAccessibilityId("Radar Map").click();
				}
				WebElement extendMaps = Ad.findElementById("maps_play_pause"); //com.weather.Weather:id/toolbar_title
				
				if(extendMaps.isDisplayed())
				{
					System.out.println("On Extended Maps page");
					ATUReports.add("On Extended Maps page",false);
				}
				//Verify the Ad on Extended Map page
				MobileElement AdEle = (MobileElement) Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]");
				WebDriverWait wait1 = new WebDriverWait(Ad, 4);
				wait1.until(ExpectedConditions.visibilityOf(AdEle));

				if (AdEle.isDisplayed()) {
					Thread.sleep(2000);
					System.out.println("Ad is present on Extended Radar & Maps page");
					ATUReports.add("Ad is present on Extended Radar & Maps page",false);
					
					// Clicking back button
//					WebElement backButton = Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ImageButton[1]");
//					backButton.click();
					Ad.findElementByClassName("android.widget.ImageButton").click();
					Thread.sleep(2000);
				}
				break;

			} else {
				System.out.println("Radar & Maps module is NOT present and scrolling down");

				Swipe.swipe();

			}
		}
	}

}
