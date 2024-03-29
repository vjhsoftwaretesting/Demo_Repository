package test_Ng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ToGetServer {
	WebDriver driver;
	
	@Test
	public void serverNumber () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
	    co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
	    driver.get("https://secure.ebillity.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	String email = "vpcbmar@mailinator.com";
	String pword = "Test123";
		
			  WebElement userID = driver.findElement(By.id("txtEmail"));
			  userID.sendKeys(email);
			  
			  WebElement password = driver.findElement(By.id("txtPassword"));
			  password.sendKeys(pword);
			  WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
			  submitButton.click(); 
			 
	String expectedServer = "Server 11V";
			 
	
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"paddingLeft5 paddingRight5\"]")));	  
			 				 
			  while (!driver.findElement(By.xpath("//*[@class=\"paddingLeft5 paddingRight5\"]")).getText().equals(expectedServer)) {
					
					WebElement logout = driver.findElement(By.id("signout")); logout.click();
					 
					Thread.sleep(100);
										  
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
										
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmail")));
					WebElement userID1 = driver.findElement(By.id("txtEmail"));
					userID1.sendKeys(email);
					WebElement password1 = driver.findElement(By.id("txtPassword"));
					password1.sendKeys(pword);
					WebElement submitButton1 = driver.findElement(By.xpath("//*[@type='submit']"));
					submitButton1.click();
					}
				 
}}
