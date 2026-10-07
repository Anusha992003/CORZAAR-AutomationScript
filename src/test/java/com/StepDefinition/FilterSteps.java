package com.StepDefinition;

import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import com.Pages.FilterPage;
import com.Pages.HomePage;

public class FilterSteps {
	
	private FilterPage filterPage;
	
	@Given("User is on courses page with filter options")
	public void user_is_on_courses_page_with_filter_options() {
	    filterPage = new FilterPage(DriverFactory.getDriver());
	    filterPage.clickCoursesBtn();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("courses"));
	    filterPage.verifyPageTitle();
	}
	@When("User selects an option from discipline dropdown")
	public void user_selects_an_option_from_discipline_dropdown() {
	    filterPage.selectDiscipline();
	}
	@Then("User should get the filtered result according to selected discipline option")
	public void user_should_get_the_filtered_result_according_to_selected_discipline_option() {
	    filterPage.verifyDisciplineCards();
	}
	@Then("User clicks on reset option to clear the selected result")
	public void user_clicks_on_reset_option_to_clear_the_selected_result() {
	    filterPage.clickReset();
	}
	@Then("User selects an option from delivery format section")
	public void user_selects_an_option_from_delivery_format_section() {
	    filterPage.selectDeliveryFormat();
	}
	@Then("User should get the filtered result according to selected delivery format option")
	public void user_should_get_the_filtered_result_according_to_selected_delivery_format_option() {
	    filterPage.verifyDeliveryFormatCards();
	}
	@Then("User selects an option from program duration dropdown")
	public void user_selects_an_option_from_program_duration_dropdown() {
		filterPage.clickReset();
	    filterPage.selectDuration();
	}
	@Then("User should get the filtered result according to selected program duration option")
	public void user_should_get_the_filtered_result_according_to_selected_program_duration_option() {
	    filterPage.verifyDurationCards();
	}
	@When("User clicks on Free enrollment only checkbox")
	public void user_clicks_on_free_enrollment_only_checkbox() {
		filterPage.clickReset();
	    filterPage.selectFree();
	}
	@Then("User should get only free courses")
	public void user_should_get_only_free_courses() {
	    filterPage.verifyFreeCards();
	}
	@Then("User verifies the result by applying all filters simultaneously")
	public void user_verifies_the_result_by_applying_all_filters_simultaneously() {
		filterPage.clickReset();
	    filterPage.allFilters();
	    filterPage.verifyAllFiltersResult();
	}
	@Then("User clicks on reset option")
	public void user_clicks_on_reset_option() {
	    filterPage.clickReset();
	}

}
