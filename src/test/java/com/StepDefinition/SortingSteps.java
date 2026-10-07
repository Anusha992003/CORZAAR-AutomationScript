package com.StepDefinition;

import org.testng.Assert;

import com.Pages.FilterPage;
import com.Pages.HomePage;
import com.Pages.SortingPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortingSteps {
	
	private SortingPage sortingPage;
	
	@Given("User click the sort dropdown")
	public void user_click_the_sort_dropdown() {
	    sortingPage=new SortingPage(DriverFactory.getDriver());
	    FilterPage filterPage=new FilterPage(DriverFactory.getDriver());
	    filterPage.clickCoursesBtn();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("courses"));
	    sortingPage.clickSortDropdown();
	}
	@Given("User select the Highest rated option from sort dropdown")
	public void user_select_the_highest_rated_option_from_sort_dropdown() {
	    sortingPage.selectSortOption("Highest Rated");
	}
	@Then("All courses should change to descending order based on ratings")
	public void all_courses_should_change_to_descending_order_based_on_ratings() {
	   sortingPage.validateHighestRated();
	}
	@When("User select the Price \\(Low to High) option")
	public void user_select_the_price_low_to_high_option() {
	    sortingPage.selectSortOption("Price: Low to High");
	}
	@Then("Courses should be arranged in ascending order based on price")
	public void courses_should_be_arranged_in_ascending_order_based_on_price() {
	    sortingPage.validatePriceLowToHigh();
	}
	@Then("User select the Price \\(High to Low) option")
	public void user_select_the_price_high_to_low_option() {
	   sortingPage.selectSortOption("Price: High to Low");
	}
	@Then("Courses should be arranged in descending order based on price")
	public void courses_should_be_arranged_in_descending_order_based_on_price() {
	   sortingPage.validatePriceHighToLow();
	}

}
