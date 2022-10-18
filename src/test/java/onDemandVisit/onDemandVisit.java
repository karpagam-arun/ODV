package onDemandVisit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class onDemandVisit {
	public static void main(String[] args) throws AWTException, InterruptedException {
			//login		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://pod.ondemandvisit.com/PD/login.aspx?F=L");
			driver.manage().window().maximize();
			driver.findElement(By.id("txtUserName")).sendKeys("test1996");
			driver.findElement(By.id("txtPassword")).sendKeys("1996@test");
			driver.findElement(By.id("btnLogin")).click();
		
			//  Priority OnDemand Home Page
			
			driver.findElement(By.id("cphContent_PCBodyContent_radioMe")).click();
			
			driver.findElement(By.id("cphContent_PCBodyContent_lblVideoVisit")).click();
			driver.findElement(By.id("cphContent_PCBodyContent_rcbPharmacy")).click();
		//Select card
		WebElement selectCard = driver.findElement(By.id("cphContent_PCBodyContent_drpPaymentType"));
			
			Select s=new Select(selectCard);
			s.selectByValue("Card");	
		
		//select Specialty
		driver.findElement(By.xpath("//input[@value='-- Select Speciality--']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement selectInternalMed = driver.findElement(By.xpath("//li[text()='Internal medicine']"));
		
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
				
		Thread.sleep(2000);
		//select Reason
				driver.findElement(By.xpath("//input[@value='-- Select Reason --']")).click();
		
				driver.findElement(By.xpath("//input[@Class='rcbCheckAllItemsCheckBox']")).click();
				driver.findElement(By.xpath("//div[@class='row'][1]")).click();
				Thread.sleep(2000);

		//Reason TextBox
				driver.findElement(By.xpath("//textarea[@placeholder='Reason for Visit']")).sendKeys("Check All");
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Thread.sleep(4000);
		//Click See Provider
				driver.findElement(By.id("cphContent_PCBodyContent_btnCreate")).click();
				Thread.sleep(2000);
				
		//confirmAlert		
				driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
				//Alert confirmAlert=driver.switchTo().alert();
				//confirmAlert.accept();
			
				Thread.sleep(2000);
				
		//Intake Form
				
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='sv-title sv-question__title sv-question__title--required']/parent::div/following-sibling::div/child::fieldset/child::div/child::label//child::span//child::span[@data-bind='text: koRenderedHtml'][text()='Yes']"))).click();
				driver.findElement(By.xpath("//h5[@class='sv-title sv-question__title sv-question__title--required']/parent::div/following-sibling::div/child::fieldset/child::div/child::label//child::span//child::span[@data-bind='text: koRenderedHtml'][text()='Yes']")).click();
				
				Thread.sleep(2000);
		//Details of Medicine textbox
				driver.findElement(By.id("sq_101i")).sendKeys("Dolo 650");
				
				
				//Intake Form allergy	
				driver.findElement(By.xpath("//h5[@aria-label='Do you have any medication allergy ?']//parent::div/following-sibling::div/fieldset/child::div[2][@class='sv-item sv-radio sv-selectbase__item sv-q-col-1 sv-radio--allowhover']")).click();
				Thread.sleep(2000);
	//complete button in intake form
				
				driver.findElement(By.xpath("//input[@value='Complete'][@class='sv-btn sv-footer__complete-btn']")).click();
				Thread.sleep(5000);
	//click next in doc upload
		
				driver.findElement(By.xpath("//span[@commandargument='53731']")).click();
				driver.findElement(By.id("cphContent_PCBodyContent_btnSaveFinal1")).click();
				
				
			/*	WebElement nextBtn = driver.findElement(By.xpath("//input[@type='button'][@id='cphContent_PCBodyContent_btnSearch']"));
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;
		
			js.executeScript("arguments[0].scrollIntoView(true)",nextBtn);
			 js.executeScript("arguments[0].click()", nextBtn); */
			
				 
			
			
					Thread.sleep(2000);
					System.out.println("done");
				  
				  driver.findElement(By.id("cphContent_PCBodyContent_btnCancel")).click();
				  Thread.sleep(5000);
					//Alert confirmAlert=driver.switchTo().alert();
				//	confirmAlert.accept();		
				  driver.findElement(By.id("ctl00_ctl00_cphContent_PCBodyContent_rwCancelRequest_C_txtCancelReason")).sendKeys("TestData");
				  driver.findElement(By.id("ctl00_ctl00_cphContent_PCBodyContent_rwCancelRequest_C_btnCancleRequest")).click();
				  Thread.sleep(5000);
				
	}

}
