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
import pageObject.LandingPage;
import pageObject.PracticePage;

public class ValidatePractice  extends base {
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
	public void validatePracticePage() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LandingPage l = new LandingPage(driver);
		l.getPractice().click();
		PracticePage pp= new PracticePage(driver);
		pp.getText().click();
		pp.getText().sendKeys(prop.getProperty("ValueSwitchtoAlert"));
		pp.getOpenWindow().click();		
					
	}
	
	
	@AfterTest
	public void tearDown()
	{		
		driver.quit();
	}
	

}
