package Academy.E2EProject;

import java.io.IOException; 
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Resources.base;
import pageObject.LandingPage;


public class ValidateNavigationBar extends base{
	public WebDriver driver; 
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void StartUp() throws IOException 
	{
		driver=initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test 
	public void basePageNavigation() throws IOException 
	{
		LandingPage l= new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");	
		log.info("Sucessfully validated message");	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

	
}
