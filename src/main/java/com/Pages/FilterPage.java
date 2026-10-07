package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class FilterPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public FilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[text()='Courses']")
	private WebElement coursesBtn;
	
	@FindBy(xpath="//span[contains(@class,'text-sm font-bold')]")
	private WebElement filterTitle;
	
	@FindBy(xpath="(//select[contains(@class,'w-full bg-surface-alt dark:bg')])[1]")
	private WebElement disciplineDropdown;
	
	@FindBy(xpath="(//div[contains(@class,'w-5 h-5 rounded-md')])[3]")
	private WebElement deliveryFormatCheckbox;
	
	@FindBy(xpath="(//select[contains(@class,'w-full bg-surface-alt dark:bg')])[2]")
	private WebElement durationDropdown;
	
	@FindBy(xpath="(//div[contains(@class,'w-5 h-5 rounded-md')])[5]")
	private WebElement freeCheckbox;
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement resetOption;
	
	@FindBy(xpath="//span[contains(@class,'text-xs sm:text-sm font')]")
	private WebElement filterCount;
	
	@FindBy(xpath="//a[contains(@class,'group flex flex-col bg-white dark:bg-dar')]")
	private List<WebElement> courseCards;
	
	@FindBy(xpath="//span[contains(@class,'px-2.5 py-0.5 rounded-full')]")
	private List<WebElement> disciplineCards;
	
	@FindBy(xpath="//span[contains(@class,'bg-surface-alt dark:bg-slate-800 px-2 py-0.5 rounded-md ')]")
	private List<WebElement> deliveryFormatCards;
	
	@FindBy(xpath="//span[contains(@class,'bg-surface-alt dark:bg-slate-800 px-2 py-0.5 rounded-md')][1]")
	private List<WebElement> durationCards;
	
	@FindBy(xpath="//span[text()='Free']")
	private List<WebElement> freeCards;
	
	@FindBy(xpath="//h3[contains(@class,'text-base font-bold ')]")
	private WebElement zeroMatchFilter;
	
	public void clickCoursesBtn() {
		elementUtils.click(coursesBtn);
	}
	
	public void verifyPageTitle() {
		String tit= elementUtils.getText(filterTitle);
		System.out.println("Displayed title: "+tit);
	}
	
	public void selectDiscipline() {
		elementUtils.selectByText(disciplineDropdown, "Technology");
	}
	
	public void verifyDisciplineCards() {
		elementUtils.waitForVisibilityOfAllElements(disciplineCards);
		String count=elementUtils.getText(filterCount);
		System.out.println("Course displayed: " +count);
		boolean found = false;
		for (WebElement cards : disciplineCards) {
			String text=elementUtils.getText(cards);
			if(text.contains("Technology")){
				found = true;
			}
		}
		if(found) {
			System.out.println("Technology courses are displayed as per filter");
		}
	}
	
	public void selectDeliveryFormat() {
		elementUtils.click(deliveryFormatCheckbox);
	}
	
	public void verifyDeliveryFormatCards() {
		elementUtils.waitForVisibilityOfAllElements(deliveryFormatCards);
		String count=elementUtils.getText(filterCount);
		System.out.println("Course displayed: " +count);
		boolean found = false;
		for (WebElement cards : deliveryFormatCards) {
			String text=elementUtils.getText(cards);
			if(text.contains("Hybrid")){
				found = true;
			}
		}
		if(found) {
			System.out.println("Hybrid courses are displayed as per filter");
		}
	}
	
	public void selectDuration() {
		elementUtils.selectByText(durationDropdown, "1–3 months");
	}
	
	public void verifyDurationCards() {
		elementUtils.waitForVisibilityOfAllElements(durationCards);
		String count=elementUtils.getText(filterCount);
		System.out.println("Course displayed: " +count);
		boolean found = false;
		for (WebElement cards : durationCards) {
			String duration=elementUtils.getText(cards);
			if (duration.contains("months")) {
				int months= Integer.parseInt(duration.replaceAll("[^0-9]", ""));
				if(months>=1 && months<=3) {
					found = true;
				}
			}
			else if(duration.contains("weeks")){
				int weeks= Integer.parseInt(duration.replaceAll("[^0-9]", ""));
				if(weeks>=4 && weeks<=12) {
					found = true;
				}
			}
		}
		if(found) {
			System.out.println("1-3 months duration courses are displayed as per filter");
		}
	}
	
	public void selectFree() {
		elementUtils.click(freeCheckbox);
	}
	
	public void verifyFreeCards() {
		elementUtils.waitForVisibilityOfAllElements(freeCards);
		String count=elementUtils.getText(filterCount);
		System.out.println("Course displayed: " +count);
		boolean found = false;
		for (WebElement cards : freeCards) {
			String text=elementUtils.getText(cards);
			if(text.contains("Free")){
				found = true;
			}
		}
		if(found) {
			System.out.println("Free courses are displayed as per filter");
		}
	}
	
	public void clickReset() {
		elementUtils.click(resetOption);
	}
	
	public void allFilters() {
		elementUtils.selectByText(disciplineDropdown, "Technology");
		elementUtils.click(deliveryFormatCheckbox);
		elementUtils.selectByText(durationDropdown, "1–3 months");
		elementUtils.click(freeCheckbox);
	}
	
	public void verifyAllFiltersResult() {
		String count=elementUtils.getText(filterCount);
		int count1=Integer.parseInt(count.replaceAll("\\D", ""));
		if(count1==0) {
			String text=elementUtils.getText(zeroMatchFilter);
			System.out.println("Result: "+ text);
		}
		else {
			elementUtils.waitForVisibilityOfAllElements(courseCards);
			System.out.println("Course displayed: " +count);
		}
		
	}

}
