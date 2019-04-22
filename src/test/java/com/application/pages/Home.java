package com.application.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericmethods.GenericMethods;
import com.readExcel.ReadExcel;

public class Home extends GenericMethods {
	public static ReadExcel read_excel;
	// ************************************TAB_SECTION**************************************//
	@FindBy(how = How.XPATH, using = "//div[@id='nvpush_cross']")
	public static WebElement btn_close_window;
	@FindBy(how = How.XPATH, using = "//a[@id='#birthdaymenu']")
	public static WebElement tb_Birthday;
	// ******************************BIRTHDAY_SUBMENU_TABS****************************************//

	List<WebElement> list_Birthday_flowers = driver.findElements(By.xpath("//div[@id='birthdaymenu']//section[1]//a"));
	List<WebElement> list_Birthday_cakes = driver.findElements(By.xpath("//div[@id='birthdaymenu']//section[2]//a"));
	List<WebElement> list_Birthday_gifts = driver.findElements(By.xpath("//div[@id='birthdaymenu']//section[3]//a"));
	List<WebElement> list_Birthday_plants = driver.findElements(By.xpath("//div[@id='birthdaymenu']//section[4]//a"));
	List<WebElement> list_Birthday_combos = driver.findElements(By.xpath("//div[@id='birthdaymenu']//section[5]//a"));
	List<WebElement> list_Birthday_recipient = driver
			.findElements(By.xpath("//div[@id='birthdaymenu']//section[6]//a"));

	// *********************************INITIALIZING*************************************************//
	public Home() {
		PageFactory.initElements(driver, this);
	}

	// *******************************METHOD_IMPLEMENTATION******************************************//
	/*
	 * Method Name 		:=mouse_hover_BirthDay() 
	 * Input_Parameters := NA 
	 * OutPut_Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint 			:= #
	 */
	// ***********************************************************************************************//
	public void mouse_hover_BirthDay() {
		boolean flag = false;
		try {
			hoverAndClick(btn_close_window);
			hoverAnElement(tb_Birthday);
			logStatus("pass", "Successfully mouse hovered on BirthDay Tab");
			flag = true;
		} catch (Exception e) {
			logStatus("fail", "Unable to mouse hover on BirthDay Tab");
			e.printStackTrace();
		}
		if (flag)
			System.out.println("Successfully mouse hovered on BirthDay Tab");
		else
			System.out.println("Unable to mouse hover on BirthDay Tab");

	}

	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_Birthday_All_Sections_tabs_navigation() 
	 * Input_Parameters := NA 
	 * OutPut_Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_Birthday_All_Sections_tabs_navigation() {
		boolean flag = false;
		try {

			verify_Section_tabs_navigation(list_Birthday_flowers, "BirthDay Flowers");
			verify_Section_tabs_navigation(list_Birthday_cakes, "BirthDay Cakes");
			verify_Section_tabs_navigation(list_Birthday_gifts, "BirthDay Gifts");
			verify_Section_tabs_navigation(list_Birthday_plants, "BirthDay Plants");
			verify_Section_tabs_navigation(list_Birthday_combos, "BirthDay Combos");
			verify_Section_tabs_navigation(list_Birthday_recipient, "BirthDay Recipient");
			flag = true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		if (flag)
			System.out.println("Successfully child tabs navigated to respective page");
		else
			System.out.println("child tabs unable to navigate the respective page");

	}

	// ***********************************************************************************************//
	/*
	 * Method Name 			:= verify_Birthday_flowers_All_tabs_existence() 
	 * Input_Parameters 	:= NA 
	 * OutPut_Parameters 	:= NA 
	 * Designer 			:= SHAMSHEER KHAN
	 * Sprint# 				:= NA
	 */
	// ***********************************************************************************************//
	public void verify_Birthday_All_Section_All_tabs_existence() {
		boolean flag = false;
		try {
			verify_Section_All_tabs_existence(list_Birthday_flowers, "BirthDay Flowers");
			verify_Section_All_tabs_existence(list_Birthday_cakes, "BirthDay Cakes");
			verify_Section_All_tabs_existence(list_Birthday_gifts, "BirthDay Gifts");
			verify_Section_All_tabs_existence(list_Birthday_plants, "BirthDay Plants");
			verify_Section_All_tabs_existence(list_Birthday_combos, "BirthDay Commbos");
			verify_Section_All_tabs_existence(list_Birthday_recipient, "BirthDay Recipient");
			logStatus("pass","Successfully all child tabs "
					+ "are Displayed on mouse hover of BorthDay Tab" );
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			logStatus("fail","On mouse hover of BirthDay Tab the child Tabs  or not displayed" );
		}
		if (flag)
			System.out.println("Successfully all child tabs "
					+ "are Displayed on mouse hover of BorthDay Tab");
		else
			System.out.println("On mouse hover of BirthDay Tab the child Tabs  or not displayed");

	}

	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_BirthDay_cakes_section_tabs_text()
	 * Input Parameters := NA 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_BirthDay_cakes_section_tabs_text() {

		int no_rows = list_Birthday_cakes.size();
		verification_child_section_tabs_text("BirthDay", "Cakes", no_rows, 4);
	}
	
	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_BirthDay_flowers_section_tabs_text() 
	 * Input Parameters := NA 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_BirthDay_flowers_section_tabs_text() {

		int no_rows = list_Birthday_flowers.size();
		verification_child_section_tabs_text("BirthDay", "Flowers", no_rows, 4);
	}

	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_BirthDay_Gifts_section_tabs_text()
	 * Input Parameters := NA 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_BirthDay_Gifts_section_tabs_text() {

		int no_rows = list_Birthday_gifts.size();
		verification_child_section_tabs_text("BirthDay", "Gifts", no_rows, 4);
	}
	
	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_BirthDay_Plants_section_tabs_text()
	 * Input Parameters := NA 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_BirthDay_Plants_section_tabs_text() {

		int no_rows = list_Birthday_plants.size();
		verification_child_section_tabs_text("BirthDay", "Plants", no_rows, 4);
	}
	
	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_BirthDay_combos_section_tabs_text()
	 * Input Parameters := NA 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_BirthDay_combos_section_tabs_text() {

		int no_rows = list_Birthday_combos.size();
		verification_child_section_tabs_text("BirthDay", "Combos", no_rows, 4);
	}
	
	// ***********************************************************************************************//
	/*
	 * Method Name 		:= verify_BirthDay_recipient_section_tabs_text()
	 * Input Parameters := NA 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verify_BirthDay_recipient_section_tabs_text() {

		int no_rows = list_Birthday_recipient.size();
		verification_child_section_tabs_text("BirthDay", "Recipient", no_rows, 4);
	}
	//***********************************************************************************************//
	/*
	 * Method Name 		:= verification_child_section_tabs_text() 
	 * Input Parameters := file_name, sheet_name, row_id, parameters 
	 * OutPut Parameters:= NA 
	 * Designer 		:= SHAMSHEER KHAN 
	 * Sprint# 			:= NA
	 */
	// ***********************************************************************************************//
	public void verification_child_section_tabs_text(String filename, String sheetname, int row_id, int parameters) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try{
			for (int i = 1; i <= row_id; i++) {
		
			ArrayList<String> input = read_excel.getTestData(filename, sheetname, i, parameters);
			String parent_xpath = input.get(0);
			String section_child_xpath = input.get(1);
			String element_xpath = input.get(2);
			String exp_text = input.get(3);
			System.out.println(parent_xpath + " " + section_child_xpath + " " + element_xpath + " " + exp_text);
			
			try{
				
				boolean flag = false;
				WebElement e=driver.findElement(By.xpath(section_child_xpath));
					hoverAnElement(tb_Birthday);
					if( hoverAndClick_boolean(e)){
					WebElement text_element_xpath = driver.findElement(By.xpath(element_xpath));
					verifyElementText(exp_text, text_element_xpath);
					logStatus("pass", "Text matched");
					flag=true;
					}
					if (flag) {
						driver.navigate().back();
						
					}
			}catch(Exception e){
			e.printStackTrace();
			logStatus("fail", "Text not  matched");
			}

		}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	//***********************************************************************************************//
}
