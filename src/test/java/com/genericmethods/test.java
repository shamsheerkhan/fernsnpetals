package com.genericmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.taskdefs.email.EmailAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.application.pages.Home;

public class test {

	static WebDriver driver;
	static URL url;

	public static void main(String[] args)  {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");

		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activelinks = new ArrayList<WebElement>();
		List<WebElement>brokenlinks=new ArrayList<WebElement>();
		System.out.println(linklist.size());
		for (WebElement e : linklist) {
			if (e.getAttribute("href") != null) {
				activelinks.add(e);
			}
			if (e.getAttribute("img") != null) {
				activelinks.add(e);
			}
		}
		System.out.println(activelinks.size());

		for (WebElement e : activelinks) {
			String linkUrl = getLinkUrl(e);
			System.out.println(linkUrl);
			boolean status1=false;
			try{
				url=new URL(linkUrl);
				status1=true;
			}catch(MalformedURLException ex){
				ex.printStackTrace();
			}
			HttpURLConnection connnection = null;
			if(status1){
				boolean statu2=false;
			try {
				connnection = (HttpURLConnection)url.openConnection();
				statu2=true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch(ClassCastException e1){
				e1.printStackTrace();
			}
			if(statu2){
			try {
				connnection.connect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(connnection.getResponseCode()==200){
					brokenlinks.add(e);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			}
		}
		System.out.println("brokenlins size present in page are "+brokenlinks.size());

	}
	//-----------------------------------------------------------------------------------
	public static String getLinkUrl(WebElement e){
		String url=e.getAttribute("href");
		if(url==null){
			e.getAttribute("src");
		}
		return url;
		
	}

}
