package test_Ng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Sample_WeeklyTS_nonbill_onlyActi_TE_noCF {

	@Test
	public void WeeklyTimeSheetsPage() throws InterruptedException {
			
		String activity ="Meeting";
				
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
	
	
	//activity dropdown
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]")));
		WebElement activityDropDown = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]"));
		activityDropDown.click();
						 
		WebElement activitySearchBox = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		activitySearchBox.sendKeys(activity);		    
					
		List<WebElement> activityOptions = driver.findElements(By.xpath("//*[@class='select2-results']")); 
		for (int i = 0;
			 i <= activityOptions.size(); i++) {
			 System.out.println(activityOptions.get(i).getText()); 
				if(activityOptions.get(i).getText().contains(activity)) {
					activityOptions.get(i).click();
		break; } }    
	
	Thread.sleep(2000);
	//change to nonbillable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]/following-sibling::div[@class='COL_BILL bill']/input[@type='checkbox']")));  
		WebElement checkbox = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]/following-sibling::div[@class='COL_BILL bill']/input[@type='checkbox']"));
		if(checkbox.isSelected()) {
		checkbox.click();}
		else {}
	
	//sunday
		WebElement sunday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_0')]/input"));
		sunday_time.click();
		sunday_time.sendKeys("1");
	//monday
		WebElement monday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_1')]/input"));
		monday_time.click();
		monday_time.sendKeys("1");
				
	//tuesday
		WebElement tuesday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_2')]/input"));
		tuesday_time.click();
		tuesday_time.sendKeys("0");
						
	//wednesday
		WebElement wednesday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_3')]/input"));
		wednesday_time.click();
		wednesday_time.sendKeys("0");
				
	//thursday
		WebElement thursday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_4')]/input"));
		thursday_time.click();
		thursday_time.sendKeys("1");
				
				
	//friday
		WebElement friday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_5')]/input"));
		friday_time.click();
		friday_time.sendKeys("1");
				
	//saturday	
		WebElement saturday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_6')]/input"));
		saturday_time.click();
		saturday_time.sendKeys("1.5");
				
	//click outside table to auto save
		driver.findElement(By.className("weekly")).click();
							
		
}
	
	
}
