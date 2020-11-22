package testngactivities;


import org.testng.annotations.Test;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.interactions.Actions;

public class Activity2 {
	
	WebDriver driver;
	
	
	  @Test
	  public void NaviColor() throws InterruptedException {
		  WebElement username = driver.findElement(By.id("user_name"));
		  WebDriverWait wait = new WebDriverWait(driver,50);
		  WebElement password =  driver.findElement(By.id("username_password"));
		  username.sendKeys("admin");
		  password.sendKeys("pa$$w0rd");
		  driver.findElement(By.id("bigbutton")).click();
	
		  //Ativity5 - Get the color of the navigation menu
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("desktop-toolbar")));
		  WebElement navicol = driver.findElement(By.className("desktop-toolbar"));
		  System.out.println("Color of the navigation toolbar is " +navicol.getCssValue("color"));
		  
		//Activity6 - Make sure that the “Activities” menu item exists and is clickable
		  
		  String Activities = driver.findElement(By.id("grouptab_3")).getText();
		  Assert.assertEquals("ACTIVITIES", Activities);
		 
		  
		  Actions action = new Actions(driver);
		
		WebElement sales = driver.findElement(By.id("grouptab_0"));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
		sales.click();
		
        WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moduleTab_9_Leads")));
	    action.moveToElement(leads).click().build().perform();
	    Thread.sleep(7000);
		 
		WebElement LEADS = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/h2"));
		wait.until(ExpectedConditions.visibilityOf(LEADS));
		
	//Activity7	
		WebElement addinfo1 = driver.findElement(By.xpath("//*[@id='adspan_b1c63253-060a-2095-ca8a-5f87e05bce57']/span"));
		addinfo1.click();
		
	//Activity9	
		for (int i=1; i<10; i++) {
			
			  WebElement name = driver.findElement(By.xpath("//tr[\" + i + \"]/td[@field='name']"));
			  System.out.println("name "  + name);
		} 
		
		for (int i=1; i<10; i++) {
			
			  WebElement user = driver.findElement(By.xpath("//tr[\" + i + \"]/td[@field='assigned_user_name']"));
			  System.out.println("name "  + user);
		}
			  }
	  
	  @Test
	  public void f() throws InterruptedException {
		  driver.get("https://alchemy.hguy.co/crm");
		  driver.findElement(By.xpath("//div/input[@id='user_name']")).sendKeys("admin");
		  driver.findElement(By.xpath("//div/input[@id='username_password']")).sendKeys("pa$$w0rd");
		  driver.findElement(By.id("bigbutton")).click();
		 
		  WebElement home = driver.findElement(By.xpath("//a[@id='grouptab_0']"));	
		  WebDriverWait wait = new WebDriverWait(driver, 50);
		  wait.until(ExpectedConditions.visibilityOf(home));
		  WebElement Accounts = driver.findElement(By.xpath("//li/a[@id='moduleTab_9_Accounts']"));
		  Actions action = new Actions(driver);
		  action.moveToElement(home).click().build().perform();
		 
		 
		  wait.until(ExpectedConditions.visibilityOf(Accounts));
		 
		  action.moveToElement(Accounts).click().build().perform();
		 
		  Thread.sleep(5000);
		 
		  WebElement ACCOUNTS = driver.findElement(By.xpath("//*[@id='content']/div[1]/h2]"));
		wait.until(ExpectedConditions.visibilityOf(ACCOUNTS));
		 
		for (int i=1; i<10; i++) {
		
		
		  WebElement name = driver.findElement(By.xpath("//tr[" + i + "]/td[@field='name']"));
		 
			 
		  System.out.println("name: " + name.getText());
		
		
		}
		 }
		 
		 
		
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
