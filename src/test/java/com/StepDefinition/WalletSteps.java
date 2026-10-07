package com.StepDefinition;

import org.testng.Assert;

import com.Pages.WalletPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WalletSteps {
	private WalletPage walletPage;
	
	@Given("User clicks on wallet icon")
	public void user_clicks_on_wallet_icon() {
	    walletPage=new WalletPage(DriverFactory.getDriver());
	    walletPage.clickWallet();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("wallet"));
	}
	@Given("User verifies the title of navigated page")
	public void user_verifies_the_title_of_navigated_page() {
	    walletPage.getTitle();
	}
	@Then("User gets the available balance in wallet")
	public void user_gets_the_available_balance_in_wallet() {
	    walletPage.getBalance();
	}
	@Then("User copies the referral code")
	public void user_copies_the_referral_code() {
	    walletPage.clickCopyCodeBtn();
	}
	@Then("User verifies it")
	public void user_verifies_it() {
	    walletPage.veriyCopyMsg();
	}

}
