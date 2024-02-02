package assignmentOneModuleTen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOneModuleTen {

//	Write a TestScript to execute Test Suite in Maven
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@BeforeTest
	public void setUp()
	{
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.navigate().to("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='login_wrapper-inner']"))));
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}	
}
