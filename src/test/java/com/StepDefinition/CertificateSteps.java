package com.StepDefinition;

import org.testng.Assert;

import com.Pages.CertificatePage;
import com.Pages.HomePage;
import com.Pages.LearningPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CertificateSteps {
	private CertificatePage certificatePage;
	String expectedName;
	
	@Given("User clicks on generated certificate link")
	public void user_clicks_on_generated_certificate_link() {
	   LearningPage learningPage=new LearningPage(DriverFactory.getDriver());
	   learningPage.clickLearningModule();
	   Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("learning"));
	   learningPage.clickCourse();
	   certificatePage=new CertificatePage(DriverFactory.getDriver());
	   expectedName=certificatePage.getCourseNameInLearningSpace();
	   certificatePage.clickURL();
	}
	@Given("User verifies the page navigation")
	public void user_verifies_the_page_navigation() {
	    certificatePage.getTitle();
	}
	@Then("User validates the certificate ID")
	public void user_validates_the_certificate_id() {
		String actualName=certificatePage.getCourseNameInCertificate();
		Assert.assertEquals(actualName, expectedName,"Course names are not matching");
	    certificatePage.verifyCertificateID();
	}
	@Then("User clicks on the view button")
	public void user_clicks_on_the_view_button() {
	   certificatePage.clickViewBtn();
	}
	@Then("User verifies the navigated page")
	public void user_verifies_the_navigated_page() {
		   certificatePage.verifyPage();
	}

}
