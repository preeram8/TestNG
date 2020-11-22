package testngactivities;


import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
public class Activity8 {
	WebDriver driver;
	  @Test(dataProvider = "Authentication")
public void loginTestCase(String user_name, String username_password) {
	 
      WebElement usernameField = driver.findElement(By.id("user_name"));
  	  WebElement passwordField = driver.findElement(By.id("username_password"));
	 usernameField.sendKeys(user_name);
	 passwordField.sendKeys(username_password);
	 driver.findElement(By.id("bigbutton")).click();
  }
public void account_table () {
	WebElement salesbtn = driver.findElement(By.id("grouptab_0"));
	 salesbtn.click();
	
	WebElement accounts_btn = driver.findElement(By.id("moduleTab_9_Accounts"));
	accounts_btn.click();
	
}
public void readTable() {
	List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'oddListRows1')]/tbody/tr"));
	System.out.println("Number of rows are: " + rows.size());
}
  @DataProvider(name = "Authentication")
  public Object[][] credentials() {
     return new Object[][] {{"admin", "pa$$w0rd"}};
  }
  @BeforeClass
  public void beforeClass() {
	  
      driver = new FirefoxDriver();
      WebDriverWait wait = new WebDriverWait(driver,10);
	  driver.get("http://alchemy.hguy.co/crm");
  }
  @AfterClass
  	  public void afterClass() {
		  driver.close();
	  }
  }