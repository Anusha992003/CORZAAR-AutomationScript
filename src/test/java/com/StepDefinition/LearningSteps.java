package com.StepDefinition;

import org.testng.Assert;

import com.Pages.HomePage;
import com.Pages.LearningPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LearningSteps {
	private LearningPage learningPage;
	
	@Given("User clicks on the course from My Programs section")
	public void user_clicks_on_the_course_from_my_programs_section() {
	    learningPage=new LearningPage(DriverFactory.getDriver());
	    learningPage.clickLearningModule();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("learning"));
        learningPage.verifyEnrolledProgramsCount();
	    learningPage.clickCourse();
	    learningPage.verifyCourse();
	}
	@Given("User verifies the overall course completion status at first")
	public void user_verifies_the_overall_course_completion_status_at_first() {
		learningPage.getStatus();
	}
	@Then("User clicks on a module to start the progress")
	public void user_clicks_on_a_module_to_start_the_progress() {
		learningPage.clickModule1();
	
	}
	@Then("User verifies the completion status")
	public void user_verifies_the_completion_status() {
	   learningPage.getStatus();
	}
	@When("User clicks on other remaining modules")
	public void user_clicks_on_other_remaining_modules() {
		learningPage.verifyModuleDisplay();
	    //learningPage.clickModule2();
	    //learningPage.clickModule3();
	}
	@Then("Course should get completed")
	public void course_should_get_completed() {
	    //learningPage.getStatus();
	}
	@Then("Official certificate should be generated")
	public void official_certificate_should_be_generated() {
	    learningPage.verifyCertificate();
	}

}
