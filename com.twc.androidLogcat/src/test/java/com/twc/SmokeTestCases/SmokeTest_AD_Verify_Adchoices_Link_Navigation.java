package com.twc.SmokeTestCases;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

import com.twc.driver.Driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

public class SmokeTest_AD_Verify_Adchoices_Link_Navigation extends Driver {

	WebElement adChoices = null;
	WebElement backButton = null;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void AdChoices_LinkVerification() throws InterruptedException {

		//Set the context
		@SuppressWarnings("unused")
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
				
		Thread.sleep(1000);
		
		ATUReports.add("Launch the app",false);
		
		System.out.println("Verify the AdChoices link url navigation");

		//Wait for the specified Element Presence
		WebDriverWait wait = new WebDriverWait(Ad, 6);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")));
		
		// Clicking on Menu Options
		WebElement menu = Ad.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ImageButton[1]"));

		menu.click();

		// Clicking on Setting link

		Ad.findElementByName("Settings").click();

		System.out.println("\"AdChoices\"" + " element is found under Settings and tap on \"AdChoices \"" + "link");
		
		ATUReports.add("\"AdChoices\"" + " element is found under Settings and tap on \"AdChoices \"" + "link",false);
		
		adChoices = Ad.findElementByName("AdChoices");
		
		adChoices.click();
		
		Thread.sleep(6000);
		
		//Browser is opened and get the url of AdChoices
		
		ATUReports.add("Verify the AdChoices Url in Browser",false);
		
		Ad.findElementById("com.android.chrome:id/url_bar").click();
		
		Thread.sleep(2000);
		
		String actualURL = Ad.findElementById("com.android.chrome:id/url_bar").getText();
		
		System.out.println("actualURL is : " + actualURL);
		
		ATUReports.add("actualURL is : " + actualURL,false);
		
		String expectedURL = "http://www.weather.com/services/ad-choices.html";
		
		Assert.assertEquals(actualURL, expectedURL);
		
		System.out.println("AdChoices url is displayed as expected");
		
		ATUReports.add("AdChoices url is displayed as expected",false);
		
		Thread.sleep(1000);
		
		Ad.navigate().back();
		
		Thread.sleep(1000);
		
		Ad.navigate().back();
		
		Thread.sleep(1000);
		
//		Ad.navigate().back();
		
		backButton = Ad.findElementByAccessibilityId("Navigate up");

		backButton.click();
		
		System.out.println("Back to the APP page");
		
		System.out.println("Verification of \"AdChoices\" url testcase is done ");

	}

}
