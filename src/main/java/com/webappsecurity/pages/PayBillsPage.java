package com.webappsecurity.pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

	public PayBillsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[contains(text(),'Pay Bills')]") WebElement PayBills_btn;
	@FindBy(id="sp_amount") WebElement amount_txt;
	@FindBy(id="sp_description") WebElement description_txt;
	@FindBy(id="sp_date") WebElement click_dateBox;
	
	
	public void validateClickOnPayBills() {
		  PayBills_btn.click();
	}
	
	public String validatePayeeText(String value) throws InterruptedException {
		// get vlaue from select drop down
		Select select=new Select(driver.findElement(By.id("sp_payee")));
		select.selectByValue(value);
		//click on help button
		driver.findElement(By.xpath("//a[@id='sp_get_payee_details']")).click();
		// return a text
		return driver.findElement(By.xpath("//p[@class='help-block']")).getText();
		
	}
	public boolean verifyAmountTextField() {
	return  driver.findElement(By.xpath("//*[@id='sp_amount']")).isDisplayed();
		
	}
	public void verifyEnterAmountFields(String amt) {
		 amount_txt.sendKeys(amt);
	}
	
	public boolean verifyDescriptionTextField() {
		return description_txt.isDisplayed();
		
	}
	
	public void verifyEnterDescriptionField(String desc) {
		description_txt.sendKeys("hellooo");
	}
	
	public void validateCalender(String dateVal) {
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", click_dateBox);
		
	}
	
	

}
