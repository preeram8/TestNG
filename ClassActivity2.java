package testngactivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

public class ClassActivity2 {
	
	WebDriver driver;
	
    @Test
	
    public void testCase1() {
	
        String title = driver.getTitle();
	    System.out.println("Title is: " + title);
	    Assert.assertEquals(title, "Target Practice");
	  }
    
    @Test
	
    public void testCase2() {
	
    	WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
	    Assert.assertTrue(blackButton.isDisplayed());
	    Assert.assertEquals(blackButton.getText(), "black");
	
    }
	
    
	
    @Test(enabled = false)
	
    public void testCase3() {
	
	    String subHeading = driver.findElement(By.className("sub")).getText();
	    Assert.assertTrue(subHeading.contains("Practice"));
	
    }
	
    
	
    @Test
	
    public void testCase4() {
	
        throw new SkipException("Skipping test case");      
	
    }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
