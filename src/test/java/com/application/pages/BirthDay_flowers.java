package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.GenericMethods;

public class BirthDay_flowers extends GenericMethods{
	@FindBy(how=How.XPATH,using="//h1[text()='Birthday Flowers Online']")
	public static WebElement txt_birthday_flowers;
	
	//****************************INITIALIZATION*************************************//
	public BirthDay_flowers(){
		PageFactory.initElements(driver, this);
	}
	//****************************METHOD_IMPLIMENTATION******************************//
	/*
	 * Method Name 			:=mouse_hover_BirthDay() 
	 * Input Parameters		:= NA 
	 * OutPut Parameters	:= NA
	 * Designer				:= SHAMSHEER KHAN
	 * Sprint				:= # 
	 */
	//***********************************************************************************************//
	public void verify_text_of_page(){
		
	}

}
