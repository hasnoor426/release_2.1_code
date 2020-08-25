package Academy.E2EProject;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.base;
import pageObject.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

  
public class ValidateTitle extends base{
	public WebDriver driver; 
	public static Logger log=LogManager.getLogger(base.class.getName());
		
	@BeforeTest
	public void StartUp() throws IOException 
	{
		driver=initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));		
	}
	
	@Test
	public void basePageNavigation() throws IOException 
	{
		LandingPage l= new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());	
		log.info("Navigatation Bar is Displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

	
}
