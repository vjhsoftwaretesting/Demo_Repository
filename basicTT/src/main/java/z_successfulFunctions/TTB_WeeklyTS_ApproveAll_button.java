package z_successfulFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TTB_WeeklyTS_ApproveAll_button {

	@Test
	public void WeeklyTimeSheetsPage() throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123"+Keys.ENTER);
		
		Thread.sleep(500);
	//weekly timesheet
		WebElement WeeklyTimeSheetsButton = driver.findElement(By.xpath("//*[@title='Weekly Timesheets']"));
		WeeklyTimeSheetsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lnkViewWeek")));
		 System.out.println("WeeklyTimeSheets Page Loaded Successfully");
	
	//Approve All button
		driver.findElement(By.id("btnApproveAll")).click(); 
		 
}}
