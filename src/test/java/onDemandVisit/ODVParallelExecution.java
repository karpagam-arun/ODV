package onDemandVisit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ODVParallelExecution {
	@Test(dataProvider="logindata")
	private void tc0() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://pod.ondemandvisit.com/PD/login.aspx?F=L");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserName")).sendKeys("test1996");
		driver.findElement(By.id("txtPassword")).sendKeys("1996@test");
		driver.findElement(By.id("btnLogin")).click();

	}
	
	
	
	

}
