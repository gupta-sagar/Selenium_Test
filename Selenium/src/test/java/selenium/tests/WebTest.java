package selenium.tests;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception 
	{
		//driver = new HtmlUnitDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void  tearDown() throws Exception
	{
		driver.close();
		driver.quit();
	}

	@Test
	public void participantCount() throws Exception 
	{
		// This code was shown in the class lecture, so used same as base
		driver.get("http://www.checkbox.io/studies.html");
		//fail("Not yet implemented");
		String path = "//div[@class='span8']//span[contains(text(),'Frustration of Software Developers')]";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		WebElement pathContains = driver.findElement(By.xpath(path));
		WebElement partCount = pathContains.findElement(By.xpath("../../..//div[@class='span4']/p/span[@class='backers']"));
		assertNotNull(partCount);
		// Check if the text has value 55
		assertEquals(partCount.getText(), "55");
	}
	@Test
	public void studiesClosed() throws Exception
	{
		//this code was given in WebTest file so used same logic
		driver.get("http://www.checkbox.io/studies.html");
		String path = "//a[@class='status']/span[contains(text(),'CLOSED')]";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		List<WebElement> statuses = driver.findElements(By.xpath(path));
		assertNotNull(statuses);
		//Check if the Web Elements list with closed status button has size 5
		assertEquals(5, statuses.size());
	}
	@Test
	public void canClickOpenedStudies() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		String path = "//a[@class='status']/span[contains(text(),'OPEN')]/../..//button[@class='btn btn-info']";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		List<WebElement> openButtons = driver.findElements(By.xpath(path));
		assertNotNull(openButtons);
		//System.out.println(openButtons.size());
		//For each button check if each button is enabled or not to see it can be clicked or not
		for(int i=0; i<openButtons.size(); i++)
			assertEquals(true, openButtons.get(i).isEnabled());
	}
	@Test
	public void hasAmazonRewardImage() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		String path = "//div[@class='span8']//span[contains(text(),'Software Changes Survey')]";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		WebElement span = driver.findElement(By.xpath(path));
		WebElement awardDiv = span.findElement(By.xpath("../..//div[@class='award']"));
		assertNotNull(awardDiv);
		WebElement imgTag = awardDiv.findElement(By.tagName("img"));
		//System.out.println(imgTag.getAttribute("src"));
		assertNotNull(imgTag);
		//Check if image tag has image source which is equal to http://www.checkbox.io/media/amazongc-micro.jpg
		assertEquals(imgTag.getAttribute("src"), "http://www.checkbox.io/media/amazongc-micro.jpg");
		// To check if image is displayed or not
		//assertEquals(imgTag.isDisplayed(), true);
	}

}
