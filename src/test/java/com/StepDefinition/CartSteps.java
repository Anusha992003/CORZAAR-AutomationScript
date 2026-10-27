package com.StepDefinition;

import org.testng.Assert;

import com.Pages.CartPage;
import com.Pages.FilterPage;
import com.Pages.HomePage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	private CartPage cartPage;
	String expectedCourse;
	
	@Given("User clicks on any course")
	public void user_clicks_on_any_course() {
		cartPage = new CartPage(DriverFactory.getDriver());
		//cartPage.verifyEmptyCart();
		
		FilterPage filterPage = new FilterPage(DriverFactory.getDriver());
		filterPage.clickCoursesBtn();
		
	    expectedCourse=cartPage.getSelectedCourseName();
	    System.out.println("Selected course: "+expectedCourse);
		cartPage.clickCourse();
	}
	@Given("User should be navigated to course details page")
	public void user_should_be_navigated_to_course_details_page() {
          cartPage.getDetailsPageTitle();
	}
	@When("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
	    cartPage.pageRefresh();
	    cartPage.clickCartBtn();
	    //cartPage.addCoursesToCart();
	}
	@Then("Cart icon should be displayed with the number of courses added")
	public void cart_icon_should_be_displayed_with_the_number_of_courses_added() {
	    cartPage.cartCount();
	}
	@Then("User clicks on cart icon")
	public void user_clicks_on_cart_icon() {
	    cartPage.clickCartIcon();
	}
	@Then("User should be redirected to cart page")
	public void user_should_be_redirected_to_cart_page() {
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("cart"));
	    cartPage.verifyCourseCount();
	    cartPage.addTwoCourseFees();
	    cartPage.verifyDelete();
	}
	@Then("User enters promo code and clicks on apply button {string}")
	public void user_enters_promo_code_and_clicks_on_apply_button(String code) {
		cartPage.validateOptionalReferral();
		cartPage.validateInvaildCoupon();
	    cartPage.enterCode(code);
	    cartPage.clickApplyBtn();
	    cartPage.enterReferralCode();
	}
	@Then("User verifies the total after applying coupon")
	public void user_verifies_the_total_after_applying_coupon() {
	    cartPage.verifyFees();
	}
	@Then("User clicks on Pay and enroll button")
	public void user_clicks_on_pay_and_enroll_button() {
	    cartPage.clickPayAndEnrollBtn();
	}
	@Then("User should be navigated to learning space")
	public void user_should_be_navigated_to_learning_space() {
	   cartPage.getTitle();
	   //Assert.assertTrue(cartPage.isCourseDisplayed(expectedCourse),"Selected course is not displayed in learning space");
	}

}
