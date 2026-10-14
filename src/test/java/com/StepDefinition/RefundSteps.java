package com.StepDefinition;

import org.testng.Assert;

import com.Pages.RefundPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RefundSteps {
	private RefundPage refundPage;
	
	@Given("User moves to learning space page")
	public void user_moves_to_learning_space_page() {
	    refundPage=new RefundPage(DriverFactory.getDriver());
	    refundPage.clickLearning();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("learning"));
	}
	@When("User clicks on any course from the list")
	public void user_clicks_on_any_course_from_the_list() {
	    refundPage.clickCourseCard();
	}
	@When("User clicks on refund option")
	public void user_clicks_on_refund_option() {
	    refundPage.clickRefundBtn();
	}
	@Then("User verifies the displayed popup")
	public void user_verifies_the_displayed_popup() {
	    refundPage.getPopupTitle();
	    refundPage.clickCancel();
	    Assert.assertFalse(refundPage.isRefundPopupClosed(),"Refund popup is still displayed");
	}
	@Then("User clicks the submit button without entering the reason")
	public void user_clicks_the_submit_button_without_entering_the_reason() {
	    refundPage.clickRefundBtn();
	    refundPage.submitWithoutReason();
	    refundPage.getReasonValidationMessage();
	}
	@Then("User enters the reason for refund {string}")
	public void user_enters_the_reason_for_refund(String reason) {
	    refundPage.enterReason(reason);
	}
	@Then("User clicks on submit button")
	public void user_clicks_on_submit_button() {
	    refundPage.confirmRefund();
	}
	@Then("User verifies the popup displayed after submit")
	public void user_verifies_the_popup_displayed_after_submit() {
	    refundPage.getMsgAfterSubmit();
	}
	@Then("User validates the visibility of refund claim in profile page")
	public void user_validates_the_visibility_of_refund_claim_in_profile_page() {
	    
	}

}
