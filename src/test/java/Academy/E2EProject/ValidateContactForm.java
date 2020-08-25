package Academy.E2EProject;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObject.ContactPage;
import pageObject.LandingPage;

public class ValidateContactForm extends base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());			
	
	@BeforeTest
	public void StartUp() throws IOException 
	{
		driver=initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void validateContact() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		LandingPage l = new LandingPage(driver);
		l.getContactUs().click();		
		log.info("Contact Page is Displayed");	
		Thread.sleep(6000);
		ContactPage cp= new ContactPage(driver);
		cp.getContact().click();
		cp.getUserName().sendKeys(prop.getProperty("UserName"));
		cp.getMobileNo().sendKeys(prop.getProperty("MobileNo"));;
		cp.getCountry().sendKeys(prop.getProperty("Country"));
		cp.getEmail().sendKeys(prop.getProperty("Email"));
		cp.getMessage().sendKeys(prop.getProperty("Message"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
