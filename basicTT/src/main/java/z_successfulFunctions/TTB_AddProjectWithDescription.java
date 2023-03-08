package z_successfulFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TTB_AddProjectWithDescription {

    WebDriver driver;
	
	String [][] data=null;
	
	@DataProvider(name="clientName")
	  public String[][] loginProvider() throws BiffException, IOException 
	  {
		data = getexcelDATA();
		return data;
		  
	  } 
	 public String[][] getexcelDATA() throws BiffException, IOException
	      {
		  FileInputStream excel = new FileInputStream("D:\\drive\\selenium excel files\\TTB client,organisation names.xls");
		  Workbook workbook = Workbook.getWorkbook(excel);	  	   
		  Sheet sheet = workbook.getSheet(2);
		  int rowcount = sheet.getRows();
		  int columncount = sheet.getColumns();
		  
		  String testdata[][] = new String[rowcount-1][columncount];
		  
		  for (int i=1; i<rowcount; i++)
		  {
			  for (int j=0; j<columncount; j++)
			  {
				  testdata[i-1][j]=	sheet.getCell(j, i).getContents();
			  }
		  }
		  return testdata;
    	  }
	 
	 
	 @BeforeTest
	 public void login() {
	    System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com ");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	 }
	
	
	@Test(dataProvider = "clientName")
	   public void sampleForAddProject (String cli_org_Name, String proName) throws InterruptedException  {
					
						
			WebElement ProjectsButton = driver.findElement(By.id("mnu_project-home"));
			ProjectsButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
			System.out.println("Projects Page Loaded Successfully");

			WebElement addProjectButton = driver.findElement(By.xpath("//*[@class='ctrl_btn orange large add-project']"));
			addProjectButton.click();
			 
			WebElement clientDropDown = driver.findElement(By.xpath("//*[@class='select2-choice select2-default']"));
			clientDropDown.click(); 
							
			driver.findElement(By.id("s2id_autogen1_search")).sendKeys(cli_org_Name);
			
			Thread.sleep(300);
			 
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='select2-results']"));
		    for (int i = 0; i <= allOptions.size(); i++) {
					System.out.println(allOptions.get(i).getText());
			    if (allOptions.get(i).getText().contains(cli_org_Name)) {
					allOptions.get(i).click();
					System.out.println("Client dropdown value selected successfully");
					break;
					}
			        }
		    
			WebElement projectName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_projectNameTextBoxWithValidator_textBoxValue"));
			projectName.sendKeys(proName);
			
			WebElement projectDescription = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_projectDescriptionTextBox']"));
			projectDescription.sendKeys("The Project-'"+proName+"'is created");
			
			
		    WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_saveProjectImageButton"));
			save.click();
			 		
	        }
						
	 @AfterTest public void logout() {
			  
			WebElement logout = driver.findElement(By.id("signout"));
			logout.click();
			driver.close(); 
			} 
}
