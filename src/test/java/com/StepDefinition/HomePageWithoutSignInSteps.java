package com.StepDefinition;

import com.Pages.HomePageWithoutSignInPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageWithoutSignInSteps {
	private HomePageWithoutSignInPage home;
	
	@Given("User clicks on home page icon")
	public void user_clicks_on_home_page_icon() {
	    home=new HomePageWithoutSignInPage(DriverFactory.getDriver());
	    home.clickLogo();
	    home.verifyPage();
	}
	@Given("User clicks on All Disciplines link")
	public void user_clicks_on_all_disciplines_link() {
	    home.allDisciplines();
	}
	@When("User clicks on design option")
	public void user_clicks_on_design_option() {
	    home.clickDesignOption();
	}
	@Then("User should be navigated to courses page")
	public void user_should_be_navigated_to_courses_page() {
	    home.verifyCoursesPage();
	}
	@Then("design courses should be filtered and displayed")
	public void design_courses_should_be_filtered_and_displayed() {
	   home.verifyDesignFilter();
	   home.verifyDesignCourseCards();
	}
	
	@Given("User clicks on View All link")
	public void user_clicks_on_view_all_link() {
		home=new HomePageWithoutSignInPage(DriverFactory.getDriver());
		home.clickLogo();
	   home.clickView();
	   home.viewPage();
	}
	@Given("User clicks on any course from the featured courses section")
	public void user_clicks_on_any_course_from_the_featured_courses_section() {
	   home.clickCourse();
	   home.verifyDetailsPageNavigation();
	}
	@Then("User clicks on any institute card from the Accredited teaching institutes section")
	public void user_clicks_on_any_institute_card_from_the_accredited_teaching_institutes_section() {
	    home.clickInstitute();
	    home.verifyInstDetailsPage();
	}
	@Then("User clicks on view syllabus link of course card in institute details page")
	public void user_clicks_on_view_syllabus_link_of_course_card_in_institute_details_page() {
	    home.clickViewSyllabus();
	    home.verifyDisplayedPage();
	}
	@Then("User clicks on View all offers")
	public void user_clicks_on_view_all_offers() {
	    home.clickOffersBtn();
	    home.verifyOffersPage();
	}
	@Then("User clicks on Get certified and eligible button")
	public void user_clicks_on_get_certified_and_eligible_button() {
	    home.clickGet();
	}
	
	@Given("User clicks on All courses link")
	public void user_clicks_on_all_courses_link() {
		home=new HomePageWithoutSignInPage(DriverFactory.getDriver());
		home.clickLogo();
	   home.allLink();
	}
	@Given("User clicks on Scholarship & offers link")
	public void user_clicks_on_scholarship_offers_link() {
	    home.offersLink();
	}
	@Given("User clciks on Verify credentials link")
	public void user_clciks_on_verify_credentials_link() {
	    home.verifyLink();
	}
	@Given("User clicks on Learner space link")
	public void user_clicks_on_learner_space_link() {
		home.learnerLink();
	}
	@Given("User clicks on Merchant studio link")
	public void user_clicks_on_merchant_studio_link() {
	   home.merchantLink();
	}
	@Given("User clicks on Admin command center link")
	public void user_clicks_on_admin_command_center_link() {
	    home.adminLink();
	}

}
