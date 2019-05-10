package com.stepdefinitions;

import org.apache.tools.ant.launch.Launcher;

import com.application.pages.Home;
import com.genericmethods.GenericMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeTest extends GenericMethods {
	public static Home home;

	@Given("^User is on HomePage$")
	public void user_is_on_HomePage() {
		lanunchBowser();
	}

	@When("^User mouse hover on Birthday  Tab it should Display all the child Tabs$")
	public void user_mouse_hover_on_Birthday_Tab_it_should_Display_all_the_child_Tabs() {
		home = new Home();
		home.mouse_hover_BirthDay();
		//home.verify_Birthday_All_Section_All_tabs_existence();
		

	}

	@When("^User click  on child tabs they should navigate the Respective child  tab pages$")
	public void user_click_on_child_tabs_they_should_navigate_the_Respective_child_tab_pages() {
		home.verify_Birthday_All_Sections_tabs_navigation();
		hoverAnElement(home.tb_Birthday);
		
	}

	@Then("^All Child Tabs Text should match with Respective child Tabs page Text$")
	public void all_Child_Tabs_Text_should_match_with_Respective_child_Tabs_page_Text() {
		
		//home.verify_BirthDay_flowers_section_tabs_text();
		//home.verify_BirthDay_cakes_section_tabs_text();
		home.verify_BirthDay_Gifts_section_tabs_text();
		//home.verify_BirthDay_Plants_section_tabs_text();
		//home.verify_BirthDay_combos_section_tabs_text();
		//home.verify_BirthDay_recipient_section_tabs_text();
		
	}

}
