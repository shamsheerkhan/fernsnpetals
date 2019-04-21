package com.genericmethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.MakeExtentReport;
import utils.Reports_utils;

public class GenericMethods extends MakeExtentReport {
	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties prop;
	static FileInputStream ip;

	// ****************************************GENERICMETHODS**********************//
	/*
	 * Method Name 			:= load_properties() 
	 * Input Parameter	 	:= NA 
	 * Output Parameters 	:= NA 
	 * Designer 			:= SHASHEER KHAN 
	 * Sprint# 				:= NA
	 */
	// *********************************************************************************//
	public static void load_properties() {
		prop = new Properties();

		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\config\\configuration.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// *******************************************************************************//
	/*
	 * Method Name 		:= hoverAndClick()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := Boolean
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:=
	 */
	// ********************************************************************************//
	public static void hoverAndClick(WebElement element) {

		try {
			// Wait till the WebElement is Displayed
			new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(element));
			
			Actions act=new Actions(driver);
			act.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// **************************************************************//
	// *******************************************************************************//
	/*
	 * Method Name 		:= hoverAndSendkeys()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//
	public static void hoverAndSendkeys(WebElement element, String keys) {

		try {
			// Wait till the WebElement is Displayed
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
			
			element.sendKeys(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// *******************************************************************************//
	/*
	 * Method Name 		:= lanunchBowser()
	 * 
	 * Input Parameter 	:= Browser name, application Url
	 * 
	 * OutPut Parameter := Launching Browser
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//
	public static void lanunchBowser() {
		load_properties();
		String browsername = prop.getProperty("browsername");
		String url = prop.getProperty("URL");
		if (browsername.equalsIgnoreCase("chrome")) {
			options =new ChromeOptions();
			options.addArguments("window-size=1400,800");
			//options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("cDriverpah"));
			driver = new ChromeDriver(options);
		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		new WebDriverWait(driver, 5);
		driver.get(url);
	}

	// *******************************************************************************//
	/*
	 * Method Name 		:= tearDownBrowser()
	 * 
	 * Input Parameter 	:= NA
	 * 
	 * OutPut Parameter := Quit Browser
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//

	public static void tearDownBrowser() {
		driver.close();
	}

	// **********************************************************************************//
	/*
	 * Method Name 		:= hoverAnElement()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//

	public static void hoverAnElement(WebElement element) {
		try {
			// Wait till the WebElement is Displayed
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ************************************************************************************//
	/*
	 * Method Name 		:= brokenlink()
	 * 
	 * Input Parameter 	:= Link URL
	 * 
	 * OutPut Parameter := Response code message
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//
	public static void brokenlink(WebElement element,String section_name) {
		try {
			String linkurl = getlinkurl(element);
			String lnkname = getElementname(element);
			URL url = new URL(linkurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			if (connection.getResponseCode() == 200) {
				System.out.println(section_name+" "+lnkname + "<--Response code is-->" + connection.getResponseCode());
			} else {
				System.out.println(section_name+" "+lnkname +" link is not working");
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// **************************************************************************************//
	/*
	 * Method Name 		:= getlinkurl()
	 * 
	 * Input Parameter 	:= WebElement,String section_name
	 * 
	 * OutPut Parameter := ElementAttribute value
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//
	public static String getlinkurl(WebElement element) {
		String linkurl = null;
		
		try {

			linkurl = element.getAttribute("href");
			if (linkurl == null) {

				linkurl = element.getAttribute("src");
			}
		} catch (Exception e) {
			System.out.println("un able to get attribute of :" + getElementname(element));
		}
		return linkurl;
	}

	// **************************************************************************************//
	/*
	 * Method Name 		:= getElementname()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := Element Name
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//
	public static String getElementname(WebElement element) {
		
		String lnkname = "";
		String linkurl = null;
		try {
			linkurl = getlinkurl(element);
			try {
				
				lnkname = element.getText();
				if (lnkname == null) {
					lnkname = linkurl.substring(linkurl.lastIndexOf("/") + 1, linkurl.lastIndexOf("."));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("un able to get the name of given WebElement");
		}
		return lnkname;
	}

	// **************************************************************************************//
	/*
	 * Method Name 		:= verifyElementExist()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// *****************************************************************************************//
	public static void verifyElementExist(WebElement element) {
		try {
			hoverAnElement(element);
			String elementname = getElementname(element);
			String pagename = driver.getTitle();
			if (element.isDisplayed()) {
				System.out.println(elementname + " is Displayed in " + pagename);
			} else
				System.out.println(elementname + " is Not Displayed in " + pagename);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//***********************************************************************************************//
	/*
	 * Method Name 			:= verify_Section_All_tabs_existence() 
	 * Input Parameters		:= List<WebElement> 
	 * OutPut Parameters	:= NA
	 * Designer				:= SHAMSHEER KHAN
	 * Sprint#				:= NA
	 */
	//***********************************************************************************************//
	public void verify_Section_All_tabs_existence(List<WebElement> elements,String section_name) {

		try {
			System.out.println("\n Going to verfying " + section_name + " section all tabs existence");
			System.out.println("\n No of tabs present in " + section_name + " section are " + elements.size() + "\n");
			for (WebElement e : elements) {
				verifyElementExist(e);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	//***********************************************************************************************//
		
	/*
	 * Method Name 			:= verify_Section_tabs_navigation() 
	 * Input Parameters		:= List<WebElement>,Section name 
	 * OutPut Parameters	:= NA
	 * Designer				:= SHAMSHEER KHAN
	 * Sprint#				:= NA
	 */
	// ***********************************************************************************************//
	public void verify_Section_tabs_navigation(List<WebElement> elements, String section_name) {

		try {
			System.out.println("\n Going to verfying " + section_name + " section tabs");
			System.out.println("\n No of tabs present in " + section_name + " section are " + elements.size() + "\n");
			for (WebElement e : elements) {

				brokenlink(e, section_name);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verifyElementText()
	 * 
	 * Input Parameter 	:= Expected test, Element
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:= NA
	 */
	// ********************************************************************************//
	public static void verifyElementText(String exp_text, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
		String act_text = getElementname(element);
		if (act_text.equals((exp_text).trim()))
			System.out.println("Element Text is matched");
		else
			System.out.println("Element Text is Not matched");
	}

	// *******************************************************************************//
	/*
	 * Method Name 		:= hoverAndClick_boolean()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := Boolean
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:=
	 */
	// ***************************************************************************************//
	public static boolean hoverAndClick_boolean(WebElement element) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).click().build().perform();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	// ****************************************************************************************//
	
}
