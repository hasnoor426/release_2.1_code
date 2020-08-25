package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactPage {
	
	public WebDriver driver;
	
	public ContactPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By ContactLink= By.cssSelector("a[href*='#/contact-us']");
	public WebElement getContact()
	{
		return driver.findElement(ContactLink);
	}
	
	
	By UserName= By.id("username");
	public WebElement getUserName()
	{
		return driver.findElement(UserName);
	}	
	
	By Country= By.id("country");
	public WebElement getCountry()
	{
		return driver.findElement(Country);
	}
	
	By Email= By.id("email");
	public WebElement getEmail()
	{
		return driver.findElement(Email);
	}
	
	By MobileNo= By.id("mobileno");
	public WebElement getMobileNo()
	{
		return driver.findElement(MobileNo);
	}
	
	By Message= By.id("message");
	public WebElement getMessage()
	{
		return driver.findElement(Message);
	}
	
}
