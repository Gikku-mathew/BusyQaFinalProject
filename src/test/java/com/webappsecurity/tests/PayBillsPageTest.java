package com.webappsecurity.tests;


import java.time.LocalDate;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.webappsecurity.pages.HomePage;
import com.webappsecurity.pages.LoginPage;
import com.webappsecurity.pages.PayBillsPage;

public class PayBillsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	PayBillsPage payBillsPage;
	
	@Test
	public void validatePayBillsPayeetextTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		String actualText= payBillsPage.validatePayeeText("sprint");
		System.out.println(actualText);	
		Assert.assertEquals("For 12119415161214 Sprint account",actualText );
		System.out.println("test passed");
	}
	@Test
	public void verifyEnterAmountFields() {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		if(payBillsPage.verifyAmountTextField()==true) {
			payBillsPage.verifyEnterAmountFields("1000");
		}
		logger.info("entered 1000 into amount box");
	}
	
	@Test
	public void verifyEnterDescriptionFields() {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		if(payBillsPage.verifyDescriptionTextField()==true) {
			payBillsPage.verifyEnterDescriptionField("hellooo");
		}
		logger.info("entered message into descripton box");
	}
	@Test
	public void verifyEnterDate() {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		String enterDate="2019-09-30";
		payBillsPage.validateCalender(enterDate);
		
		LocalDate date1= LocalDate.now();
		logger.info("expecting future date");
		System.out.println("Current date parse : "+ date1);
		LocalDate date2= LocalDate.parse(enterDate);
		System.out.println("enter date parse : "+ date2);
		
		if(date1.isAfter(date2)) {
			Assert.assertTrue(false,"expecting future date");
		}
		else if(date1.isBefore(date2)) {
			Assert.assertTrue(true,"future date ");
		}
		else if(date1.equals(date2)) {
			Assert.assertTrue(true, "current date");
		// TODO	
			
		}
	}

	
}

