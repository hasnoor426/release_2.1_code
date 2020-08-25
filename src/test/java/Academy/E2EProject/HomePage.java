package Academy.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Resources.base;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends base{
	public WebDriver driver; 
	public static Logger log=LogManager.getLogger(base.class.getName());
		
	@BeforeTest
	public void StartUp() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialize");
 
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException 
	{	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("Home Page is displayed");
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();		 
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.clickLogIn().click();
		log.info(text);
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data= new Object [2][3];
			data[0][0]="nonrestricteduser@qa.com";
			data[0][1]="Testpassword";
			data[0][2]="Restricted User";
			
			data[1][0]="restricteduser@qa.com";
			data[1][1]="Testpassword";
			data[1][2]="Non Restricted User";
			
			return data;		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	

}
