package com.twc.General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class differentBuilds {
	
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
				
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='state']/a")).click();
		
		Thread.sleep(90000);
		
		driver.navigate().to("/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/APKFile1");
		
		Thread.sleep(180000);
		
		//driver.quit();

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
				
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='state']/a")).click();

		Thread.sleep(180000);
		
		driver.navigate().to("/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/APKFile1");
		
		Thread.sleep(60000);
		
//		driver.quit();
		
//		driver.navigate().to(downloadPath);
		
//		Thread.sleep(1000);
//		
//		String buildNumber  = driver.findElement(By.xpath("//a[contains(text(),'TWC')")).getText();
//		
//		System.out.println("Build Number is "+buildNumber);
		
	}

}
