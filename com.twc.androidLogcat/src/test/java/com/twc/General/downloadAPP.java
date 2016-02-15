package com.twc.General;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.twc.driver.Driver;
import com.twc.driver.PropertyFile;

	@SuppressWarnings("unused")
	public class downloadAPP extends Driver {
		
//    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
//   @Test(priority=0)
		
		public void downloadTheAPP() throws InterruptedException, IOException {			
//			Properties properties = new Properties();
//
//			String dataFilePath = "/Users/monocept/Documents/workspace_luna/SimpleProject/DataFile.Properties";
//
//			File file = new File(dataFilePath);
//
//			try {
//				FileInputStream fileInput = new FileInputStream(file);
//				properties.load(fileInput);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
			
	      Driver.property();
		   PropertyFile.property();
//			String downloadPath ="/Users/monocept/Downloads/AndroidBuilds";
		
			String downloadPath = properties.getProperty("downloadPath");
			System.out.println("downloadPath is : "+downloadPath);
		
			FirefoxProfile profile = new FirefoxProfile();
			
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.dir", downloadPath);
			
			profile.setPreference("browser.helperApps.neverAsk.openFile",
					"text/csv,application/x-msexcel,application/octet-stream,application/vnd.android.package-archive,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk");
			
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
	"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.closeWhenDone", false);
			profile.setPreference("browser.download.useDownloadDir", false); 
			
//			String downloadLocalPath  = "/Users/monocept/Downloads/AndroidBuilds/";
			File index = new File(downloadPath);
			
			if (!index.exists()) {
				System.out.println("Specified folder is not exist and creating the same folder now");
			    index.mkdir();
			} else {
				System.out.println("Specified folder is exist and deleting the same folder");
				
//				String[]entries = index.list();
//				
//				System.out.println("Deleting all the files in the specified folder");
//				
//				for(String s: entries){
//				    File currentFile = new File(index.getPath(),s);
//				    currentFile.delete();
//				}
//				System.out.println("Deleted all the files in the specified folder");
				
				FileUtils.cleanDirectory(index);
				System.out.println("Deleted all the files in the specified folder");
				
//			    index.delete();
			    
//			    System.out.println("Deleted all the files in the specified folder - 1 ");
			    
//			    if (!index.exists()) {
//			        index.mkdir();
//			        System.out.println("Folder is created");
//			    }
			}
			
			WebDriver driver = new FirefoxDriver(profile);
			
			Thread.sleep(5000);
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
			driver.get("https://rink.hockeyapp.net/users/sign_in");
			
			driver.findElement(By.id("user_email")).sendKeys("kvelappan@weather.com");
			
			driver.findElement(By.id("user_password")).sendKeys("300interstate");
			
			driver.findElement(By.name("commit")).click();
			
			System.out.println("Logged-in into HockeyApp");
			
			Thread.sleep(2000);
		
			String Apps = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li[2]/a")).getText();
			
			System.out.println("Apps text :: "+Apps);
			
			driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li[2]/a")).click();
			
			//Click on Android Link
				
			Thread.sleep(2000);
			
	        String platforms = driver.findElement(By.xpath("//ul[@class='nav nav-pills']/li[2]")).getText();
			
			System.out.println("platforms text :: "+platforms);
		
			Thread.sleep(1000);
			
			driver.findElement(By.linkText("Android")).click();

			System.out.println("Selected Android in the Platforms Dropdown");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@type='text']")).click();
			
			String platform = driver.findElement(By.xpath("//ul[@class='nav nav-pills']/li[2]/a")).getText();
			
			System.out.println("Platform selected is : " + platform);	
		
			 // String expectedToClick = "Android Flagship Dev";
			 
			// String expectedToClick = "The Weather Channel (flagship)";
			 
			 String expectedToClick= properties.getProperty("BuildToDownload");
			 
			 System.out.println("expectedToClick is : " + expectedToClick);
			 
//			 differentBuilds db = new differentBuilds();
//			 //differentBuilds db = new differentBuilds();
//			 
//			if (expectedToClick.contains("Android Flagship Dev")) {
//					
//				db.downloadApp_AndroidFlagshipDev(driver);
//
//			} else if (expectedToClick.contains("The Weather Channel (flagship)")) {
//
//				db.downloadApp_TheWeatherChannelFlagship(driver);
//
//			}	
				
			Thread.sleep(90000);	
		} 


		/*
		public void downloadApp_AndroidFlagshipDev(WebDriver driver) throws InterruptedException{
				
			Thread.sleep(1000);
			// String flag =driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).getText();
			String flag = driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).getText();
			
			System.out.println("Flag :: " + flag);
			
			// driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).click();
			driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).click();

			Thread.sleep(1000);
			
			String  version  = driver.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).getText();
			
			System.out.println("Version of the build is :: "+version); 
			
			String ver = version.substring(version.indexOf("(")+1, version.indexOf(")"));
			
			String buildText = "TWC_"+ver+"_release.apk";
			
			System.out.println("Build Name is :: "+buildText);
			
			driver.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).click();
					
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='state']/a")).click();
			
			Thread.sleep(10000);
			
			driver.navigate().to("/Users/monocept/Downloads/AndroidBuilds");

		}
		
		public void downloadApp_TheWeatherChannelFlagship(WebDriver driver) throws InterruptedException{
				
			Thread.sleep(1000);
			
			//String flag = driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).getText();
			String flag = driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[4]/td[2]/div")).getText();

			System.out.println(" Flag :: " + flag);

			// driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).click();
			driver.findElement(By.xpath("//table[@id='apps']/tbody/tr[4]/td[2]/div")).click();
			
			String  version  = driver.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).getText();
			
			System.out.println(" Version of the build is :: "+version); 
			
			String ver = version.substring(version.indexOf("(")+1, version.indexOf(")"));
			
			String buildText = "TWC_"+ver+"_release.apk";
			
			System.out.println("Build Name is :: "+buildText);
			
			driver.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).click();
					
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='state']/a")).click();

			Thread.sleep(40000);
			
			driver.navigate().to("/Users/monocept/Documents/workspace_luna/SimpleProject/APK/");


			
//			driver.navigate().to(downloadPath);
			
//			Thread.sleep(1000);
//			
//			String buildNumber  = driver.findElement(By.xpath("//a[contains(text(),'TWC')")).getText();
//			
//			System.out.println("Build Number is "+buildNumber);
			
		} 
		*/
	}
