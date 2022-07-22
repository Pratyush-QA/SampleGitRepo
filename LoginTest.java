package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Guru99HomePage;
import pages.Guru99LoginPage;

public class LoginTest {
	
    WebDriver driver;
    Guru99LoginPage login;
    Guru99HomePage home;
    
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		login=new Guru99LoginPage(driver);
		login.openWebsite("https://demo.guru99.com/V4/");
		login.enterId("mngr424615");
		login.enterPassword("AnyhAvU");
		home=login.clickBtn();
		//or
		//login.clickBtn();
		//home=new Guru99HomePage(driver);
		home.clickPayment();
		//home.handlePopups();
		System.out.println(home.getTitle());
		if(home.getTitle().equals("Guru99 Payment Gateway")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
			
		}
		home.closeBrowser();
	}
}
