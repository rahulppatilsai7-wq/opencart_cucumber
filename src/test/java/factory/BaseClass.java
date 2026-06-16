package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	static WebDriver driver;
	static Properties pro;
	static Logger log;
	
	public static WebDriver initializeBrowser() throws IOException {
		
		pro=getProperties();		
		String env=pro.getProperty("execution_env");
		String os=pro.getProperty("os");
		String browser=pro.getProperty("browser");
		
		if(env.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			switch(os) {
			case "mac" : capabilities.setPlatform(Platform.MAC); break;
			case "windows" : capabilities.setPlatform(Platform.WINDOWS); break;
			case "linux" : capabilities.setPlatform(Platform.LINUX); break;
			default : System.out.println("Invalid os");
			return null;
		}
			
			switch (browser) {
			case "windows":capabilities.setBrowserName("chome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			default : System.out.println("invalid browser");
			return null;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			}
		else if(env.equalsIgnoreCase("local")) {
			switch(browser.toLowerCase()) 
			{
			case "chrome":
		        driver=new ChromeDriver();
		        break;
		    case "edge":
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
		 return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Properties getProperties() throws IOException {
		FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		pro=new Properties();
		pro.load(file);
		return pro;		
	}
	
	public static Logger getLogger() {
		log=LogManager.getLogger();
		return log;
	}
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
		
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
			
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}

}
