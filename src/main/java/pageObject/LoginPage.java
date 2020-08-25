package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
		
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By emailaddress= By.id("user_email");		
	public WebElement getEmail()
	{
		return driver.findElement(emailaddress);		
	}
	
	
	By password= By.id("user_password");	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	
	By Login=By.name("commit");	
	public WebElement clickLogIn()
	{
		return driver.findElement(Login);
	}
	
	

}
