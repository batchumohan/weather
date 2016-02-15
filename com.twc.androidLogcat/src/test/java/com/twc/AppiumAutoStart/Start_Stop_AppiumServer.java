package com.twc.AppiumAutoStart;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import com.twc.driver.Driver;
import com.twc.driver.PropertyFile;

public class Start_Stop_AppiumServer {
	
	private  Process process;  
	private  String APPIUMSERVERSTART = "/usr/local/bin/appium";
	

	@SuppressWarnings("unused")
	public void startAppiumServer() throws IOException, InterruptedException { 
		
		//Reading data from Property file
		 Driver.property();
		 PropertyFile.property();
		 
		//CommandLine Arguments for Starting the APPIUM Server	
		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
	//	command.addArgument("/Users/monocept/Desktop/Appium1.4.11",false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");	
		command.addArgument("--no-reset", false);
		command.addArgument("--log-level", false);
		command.addArgument("error");
		//command.addArgument("--log");
		//command.addArgument("/Users/aparna/Documents/sys11.log");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
      
    }  
      
    public  void stopAppiumServer() throws IOException {  
        String[] command ={"/usr/bin/killall","-KILL","node"};  
        
        Runtime.getRuntime().exec(command);  
        //System.out.println("Appium server stop");  
    }  

//  killall adb
    
    public  void killadb() throws IOException {  
        String[] command ={"/usr/bin/killall","-KILL","adb"};
        Runtime.getRuntime().exec(command); 
        
        String[] command1 ={"/usr/bin/killall","-KILL","-9 adb"}; 
        Runtime.getRuntime().exec(command1);  
        //System.out.println("Killing the adb server");  
    } 
    
   
  /*  
    //Uninstall the APK if exist on Device
    public  void uninstallAPK() throws IOException, InterruptedException { 
    String adbPath = properties.getProperty("adbPath");
    try{
         String[] str ={"/bin/bash", "-c", adbPath+"shell pm uninstall com.weather.Weather"};
//        // String[] str ={"/bin/bash", "-c","/Users/monocept/Documents/adt-bundle-mac-x86_64-20130522/sdk/platform-tools/adb shell pm uninstall com.weather.Weather"};
	     Process p = Runtime.getRuntime().exec(str);	
	     Thread.sleep(4000);
	     System.out.println("App is exist and uninstalled the same.");
       }catch (Exception e)
         {
    	  System.out.println("App is not exist to Uninstall.");
    	 }
   }
 
   
   */
}
