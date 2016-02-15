package com.twc.AD_TestSuite;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

import com.twc.AppiumAutoStart.Capabilities_android;
import com.twc.AppiumAutoStart.movingFiles;
import com.twc.General.DeleteFile;
import com.twc.General.File_Exist;
import com.twc.General.TestMode;
import com.twc.General.app_Kill_Relaunch;
import com.twc.General.downloadAPP;
import com.twc.General.setAddress_Location;
import com.twc.General.toKnowBuildVersion;
import com.twc.SmokeTestCases.AD_C333172_CleanLaunch;
import com.twc.SmokeTestCases.SmokeTest_AD_C333170_Beacon;
import com.twc.SmokeTestCases.SmokeTest_AD_C333172_CleanLaunch;
import com.twc.SmokeTestCases.SmokeTest_AD_C333174_FactualCall;
import com.twc.SmokeTestCases.SmokeTest_AD_C333173_Verify_WeatherFX_ApiCall_RE;
import com.twc.SmokeTestCases.SmokeTest_AD_C333174_FactualCall_RE;
import com.twc.SmokeTestCases.SmokeTest_AD_C333175_Hourly;
import com.twc.SmokeTestCases.SmokeTest_AD_C333176_Map;
import com.twc.SmokeTestCases.SmokeTest_AD_C333177_News;
import com.twc.SmokeTestCases.SmokeTest_AD_C333179_Verify_PullToRefresh;
import com.twc.SmokeTestCases.SmokeTest_AD_C333180_10Day;
import com.twc.SmokeTestCases.SmokeTest_AD_C333180_Daily;
import com.twc.SmokeTestCases.SmokeTest_AD_C333180_Daily_15Days;
import com.twc.SmokeTestCases.SmokeTest_AD_C333182_Verify_Lotame_onApp_Launch;
import com.twc.SmokeTestCases.SmokeTest_AD_C333173_Verify_WeatherFX_ApiCall;
import com.twc.SmokeTestCases.SmokeTest_AD_C33318_HealthModule_ColdFlu;
import com.twc.SmokeTestCases.SmokeTest_AD_C33318_HealthModule_Allergy;
import com.twc.SmokeTestCases.SmokeTest_AD_C33319_SkiDetailsPage;
import com.twc.SmokeTestCases.SmokeTest_AD_C33319_SkiResorts;
import com.twc.SmokeTestCases.SmokeTest_AD_Verify_Adchoices_Link_Navigation;
import com.twc.driver.Driver;
import com.twc.driver.PropertyFile;
import com.twc.practices.news;

import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


@Listeners({ATUReportsListener.class, MethodListener.class })

@SuppressWarnings("unused")
public class Smoke_Test extends Driver{
	
	{
		System.setProperty("atu.reporter.config", "./atu.properties"); 
	}

	
	
	
	  //Pull To Refresh
	@Test(priority=0, threadPoolSize = 1,invocationCount = 1)	
	public void AD_C333179_Verify_AdCall_On_PulltoRefresh() throws ParseException, IOException, InterruptedException
	{
		SmokeTest_AD_C333179_Verify_PullToRefresh pulltorefresh = new SmokeTest_AD_C333179_Verify_PullToRefresh();
		pulltorefresh.Verify_PulltoRefresh();
	}
	
	  //Factual FX API Call == RE
	@Test(priority=1, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333174_FactualCall_On_FreshLaunch_RE() throws Exception {

		SmokeTest_AD_C333174_FactualCall_RE FactualTest_RE = new SmokeTest_AD_C333174_FactualCall_RE();
		FactualTest_RE.verify_facualcal_onfresh_launch();
	}
	
	//Weather FX API Call == RE
	@Test(priority=2, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333173_Verify_WeatherFX_ApiCall_On_FreshLaunch_RE() throws Exception {

		SmokeTest_AD_C333173_Verify_WeatherFX_ApiCall_RE wfxtg = new SmokeTest_AD_C333173_Verify_WeatherFX_ApiCall_RE();
		wfxtg.verify_WeatherFX_Apicall_On_FreshLaunch();
    }
		
	//LotameAdTargeting_On_AppLaunch 
	@Test(priority=3, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333182_LotameAdTargeting_On_AppLaunch() throws Exception
	{
		SmokeTest_AD_C333182_Verify_Lotame_onApp_Launch LotameAdTarget = new SmokeTest_AD_C333182_Verify_Lotame_onApp_Launch();
		LotameAdTarget.Verify_LotameCall_onapp_launch_test();
	}
			
	//Hourly Ad
	@Test(priority=4, threadPoolSize = 1,invocationCount = 1 )
	public void AD_C333175_Verify_Ad_Present_On_HourlyExtended_page() throws Exception {
		
		SmokeTest_AD_C333175_Hourly hourlyExtend = new SmokeTest_AD_C333175_Hourly();
		hourlyExtend.verify_adpresent_onextendedHourly_page();
	}

	//Daily Ad [15Days Button]
	@Test(priority=5, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333180_Verify_Ad_Present_On_DailyExtended_page() throws Exception {

		SmokeTest_AD_C333180_Daily_15Days tendayExtended = new SmokeTest_AD_C333180_Daily_15Days();
		tendayExtended.verify_adpresent_onextendedTenday_page();
	
	}
		//Maps page Ad
	@Test(priority=6, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333176_Verify_Ad_Present_On_MapsExtended_page() throws Exception {

		SmokeTest_AD_C333176_Map mapsExtended = new SmokeTest_AD_C333176_Map();
		mapsExtended.verify_adpresent_onextendedMap_page();

	} 
	
	//News Page Ad	
	@Test(priority=7, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333177_Verify_Ad_Present_On_NewsExtended_page() throws Exception {

		SmokeTest_AD_C333177_News newsExtended = new SmokeTest_AD_C333177_News();
		newsExtended.verify_adpresent_onextendedNews_page();

	}
	
	//CleanLaunch
	@Test(priority=8, threadPoolSize = 1,invocationCount = 1)
	public void AD_C333172_Verify_AdCalls_On_CleanLaunch() throws Exception {

		SmokeTest_AD_C333172_CleanLaunch cleanLaunch = new SmokeTest_AD_C333172_CleanLaunch();
		cleanLaunch.CleanLaunch_launch();

	}
	
	

	
//	*/
	
	/* 
	
		
	@Test(priority = 9, threadPoolSize = 1, invocationCount = 1)
	public void AD_Verify_CreativeID_ThirdPartyBeacon() throws Exception {

		SmokeTest_AD_C333170_Beacon thirdPartyBeacon = new SmokeTest_AD_C333170_Beacon();

		thirdPartyBeacon.Verify_CreativeID_ThirdPartyBeacon();

	}

	// Health Module - Cold & Flu Section
	// @Test(priority=1, dependsOnMethods = {"Change_APP_TO_TestMode"}, threadPoolSize = 1,invocationCount = 1)
	@Test(priority = 10, threadPoolSize = 1, invocationCount = 1)
	public void AD_Verify_SpotlightandBigBannerAd_On_HealthModule_Cold_Flu() throws Exception {

		SmokeTest_AD_C33318_HealthModule_ColdFlu cold_flu = new SmokeTest_AD_C33318_HealthModule_ColdFlu();
		cold_flu.verify_SpotLightAd_present_on_ColdFlu_section();

	}
	   
		//Health Module - Allergy Section
//		@Test(priority=2, dependsOnMethods = {"Change_APP_TO_TestMode"}, threadPoolSize = 1,invocationCount = 1)
		@Test(priority=11, threadPoolSize = 1,invocationCount = 1)
		public void AD_Verify_SpotlightandBigBannerAd_On_HealthModule_Allergy() throws Exception {

			SmokeTest_AD_C33318_HealthModule_Allergy allergy = new SmokeTest_AD_C33318_HealthModule_Allergy();
			allergy.verify_SpotLightAd_present_on_ColdFlu_section();

		}

		
	// SpotLight and Big Ad verification on SkiDetails Page
	@Test(priority = 12, threadPoolSize = 1, invocationCount = 1)
	public void AD_Verify_SpotlightandBigBannerAd_On_Ski_DetailsPage() throws Exception {

		SmokeTest_AD_C33319_SkiDetailsPage skiResorts = new SmokeTest_AD_C33319_SkiDetailsPage();
		skiResorts.verify_SpotLightAd_present_on_SkiDetails();

	}
				
	// Ad verification on SkiResorts Page
	@Test(priority = 13, threadPoolSize = 1, invocationCount = 1)
	public void AD_Verify_Ad_Present_On_SkiResortsPage() throws Exception {

		SmokeTest_AD_C33319_SkiResorts skiResorts = new SmokeTest_AD_C33319_SkiResorts();
		skiResorts.verify_SpotLightAd_present_on_SkiResorts();

	}
		
		 */
	
   /*
   
   
	// AdChoices Verification
	@Test(priority = 10, threadPoolSize = 1, invocationCount = 1)
	public void AdChoices_LinkVerification() throws Exception {

		SmokeTest_AD_Verify_Adchoices_Link_Navigation adchoices = new SmokeTest_AD_Verify_Adchoices_Link_Navigation();
		adchoices.AdChoices_LinkVerification();

	}

	// Ad verification on SkiResorts Page
	@Test(priority = 4, threadPoolSize = 1, invocationCount = 1)
	public void SmokeTest_AD_C33319_SkiResorts() throws Exception {

		SmokeTest_AD_C33319_SkiResorts skiResorts = new SmokeTest_AD_C33319_SkiResorts();
		skiResorts.verify_SpotLightAd_present_on_SkiResorts();

	}

	// Ad verification on Ski Details Page
	@Test(priority = 4, threadPoolSize = 1, invocationCount = 1)
	public void SmokeTest_AD_C33319_Ski_DetailsPage() throws Exception {

		SmokeTest_AD_C33319_SkiDetailsPage skiResorts = new SmokeTest_AD_C33319_SkiDetailsPage();
		skiResorts.verify_SpotLightAd_present_on_SkiDetails();

	}

	// Set the App in Test Mode
	// @Test(priority=0, threadPoolSize = 1,invocationCount = 1)
	@Test
	public void Change_APP_TO_TestMode() throws Exception {

		TestMode Ads_Test_Mode = new TestMode();
		Ads_Test_Mode.ChangeToTestMode();
	}
	
      */


		
   
	@BeforeSuite
	public void TestReportFiles() throws Exception {
	String path1="/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/TestReports";
	
	System.out.println("Delete all files of a directory");
			
			File index = new File(path1);
			if (!index.exists()) {
			    index.mkdir();
			    System.out.println("Creation is done -- 1");
			} else {
//			    index.delete();
//				FileUtils.deleteDirectory(new File(path1));
				FileUtils.cleanDirectory(new File(path1)); 
//				String[]entries = index.list();
//				for(String s: entries){
//				    File currentFile = new File(index.getPath(),s);
//				    currentFile.delete();
//				    System.out.println("Deleted");
//				}
				Thread.sleep(6000);
				if (!index.exists()) {
			        index.mkdir();
			        System.out.println("Creation is done");
			        Thread.sleep(4000);
			    }
			}
			System.out.println("Deletion of all files are done");
	}
	
	
	
	
	@SuppressWarnings("static-access")
	@BeforeTest
	public void Capabilities_Launch() throws Exception {
		
		//Download the APP
//		downloadAPP da = new downloadAPP();
//		da.downloadTheAPP();

		 //Calling the capabilities method
		Capabilities_android cap = new Capabilities_android();
	    cap.dcap();
		
		//Delete the log existed file
		DeleteFile DF = new DeleteFile();
		File_Exist FE = new File_Exist();
		
		if(FE.fileexist()) {
			DF.deleteFile();

		} else {
			System.out.println("File not exist");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void getBuildVersion() throws Exception {
		
		// Calling the method to know APP Build Version
		toKnowBuildVersion getBuildVersion = new toKnowBuildVersion();
		getBuildVersion.moreOptionsClick();

		// Calling the method to Set Address/Location in the APP
	  // setAddress_Location sa = new setAddress_Location();
     // sa.setLocation();
	
	    //To print the Device Name and Build Version in Reports
		String	AndroidVersion = properties.getProperty("platformVersion");

		String deviceName = properties.getProperty("deviceName");
		
		String buildVersion = properties.getProperty("buildVersion");

		Driver.property();
		
		PropertyFile.property();
		
		ATUReports.indexPageDescription = "<h1> Android Smoke Test Report </h1> <br/> <h2> on Build "+ buildVersion + "</h2> <br/> <h2>"+"Executed on " +deviceName+ " with OS : ("+AndroidVersion+")"+"</h2>";

		ATUReports.add("Setting IndexPageDescription : ",false);

		ATUReports.setAuthorInfo("Appium", "Android_SmokeTest", "Report");

		ATUReports.currentRunDescription = "<h1>Android_Smoke Tests-Detailed Report with Pie Chart</h1>";

	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void App_Kill_ReLaunch() throws Exception {
		
//		ATUReports.add("Killing the app and relaunch the app",false);
//		System.out.println("Killing the app and relaunch the app");
//		app_Kill_Relaunch.Kill_realaunch();

	}

	
	@SuppressWarnings({ "deprecation", "static-access" })
	@AfterSuite
	public void movefiles() throws IOException {
		movingFiles mf = new movingFiles();
		mf.movefiles();
		ATUReports.add("Moving TWC Image and CSS Files.",false);
	}
	
}
