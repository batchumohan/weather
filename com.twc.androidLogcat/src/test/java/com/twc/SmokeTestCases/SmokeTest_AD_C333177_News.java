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

public class SmokeTest_AD_C333177_News extends Driver{
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void verify_adpresent_onextendedNews_page() throws Exception
	{
		//Set the Native Context
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		
		ATUReports.add("Launch the app",false);
		
		System.out.println("Searching for News module");
		ATUReports.add("Scroll to News module",false);
		
		int MAX_SWIPES = 10;
		
		for (int i = 0; i<MAX_SWIPES; i++) {

			WebElement news = null;

			try {
//				news = Ad.findElementById("com.weather.Weather:id/news_title");
				news = Ad.findElementByName("News");
				
			} catch (Exception e) {
				// System.out.println("Exception message :: "+e);	
			}

			if(news!=null && news.isDisplayed())
			{  
				System.out.println("News module is present and tap on News Image");
				ATUReports.add("News module is present and tap on News Image",false);
				
                    //Click on News image 
					Ad.findElementById("com.weather.Weather:id/grid_item_1").click();
//				    Ad.findElementByAccessibilityId("Small video thumbnail").click();
					
					//WebDriverWait wait = new WebDriverWait(Ad, 10);
					//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageButton")));
					String extendNews = Ad.findElementById("toolbar_title").getText(); //com.weather.Weather:id/toolbar_title
					System.out.println("Text : "+ extendNews);
					if(extendNews.contains("News"))
					{
						System.out.println("On Extended News page");
						ATUReports.add("On Extended News page",false);
					}
					
					//Verify the Ad on News Page
					MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]");
					WebDriverWait wait1 = new WebDriverWait(Ad, 10);
					wait1.until(ExpectedConditions.visibilityOf(AdEle));
					if(AdEle.isDisplayed())
					{
						System.out.println("Ad is present on Extended News page");
						ATUReports.add("Ad is present on Extended News page",false);
						Thread.sleep(2000);
						// Clicking back button
//						Ad.findElementByAccessibilityId("Navigate up").click();
						Ad.findElementByClassName("android.widget.ImageButton").click();
					
				    }break;

			}else
			{
               System.out.println("News module is NOT present and scrolling down");
				
				Swipe.swipe();
			}
		}
	}
}
