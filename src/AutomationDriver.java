import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		// Invoke .exe file
		System.setProperty("webdriver.chrome.driver", "F:\\\\chromedriver.exe");
		// create driver object and implement the methods of webDriver
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		AutomationDriver.exerciseOne(driver);
		AutomationDriver.exerciseTwo(driver);
		AutomationDriver.exerciseThree(driver);
		AutomationDriver.exerciseFour(driver);
		AutomationDriver.exerciseFive(driver);
		AutomationDriver.exerciseSix(driver);
		AutomationDriver.exerciseSeven(driver);
		AutomationDriver.exerciseEight(driver);
		AutomationDriver.exerciseNine(driver);

	}

	private static void exerciseOne(WebDriver driver) throws InterruptedException {
		// select the radio1 button
	driver.findElement(By.xpath("//input[@value='radio1']")).click();
		// check whether radio1 is selected or not
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		Thread.sleep(3000);
		// select the radio2 button
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		// check whether radio2 is selected or not
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
	
	}

	private static void exerciseTwo(WebDriver driver) throws InterruptedException {
		// find the attribute which is common
		driver.findElement(By.id("autocomplete")).sendKeys("United States");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		// check whether selected option matches with expected
		for (WebElement option : options)
			if (option.getText().equalsIgnoreCase("United States Minor Outlying Islands")) {
				option.click();
				break;
			}

	}

	private static void exerciseThree(WebDriver driver) throws InterruptedException {
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		// give the knowledge where select dropDown is present
		Select dropdown = new Select(staticDropdown);
		//select the option from dropDown panel
		driver.findElement(By.id("dropdown-class-example")).click();
		for (int i = 1; i < 4; i++) {
			dropdown.selectByIndex(i);
			dropdown.getFirstSelectedOption().getText();

		}

	}

	private static void exerciseFour(WebDriver driver) throws InterruptedException {
		//click the checkBox
		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		
		driver.findElement(By.id("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption2")).click();
		
		driver.findElement(By.id("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption3")).click();
		//call the methods
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointTwo(driver);
	}

	private static void exerciseFourPointOne(WebDriver driver) {
		// to count no of checkBoxes find the common locator of all
		int count = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		for (int i = 0; i < count; i++) {
			driver.findElements(By.cssSelector("input[type='checkbox']")).get(i).click();
			//To verify checkBox is selected or not
			Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
		}

	}

	private static void exerciseFourPointTwo(WebDriver driver) throws InterruptedException {
		// to count no of checkboxes find the common locator of all
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(2000);

		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(2000);

		driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());

	}

	private static void exerciseFive(WebDriver driver) throws InterruptedException {
		// to maximize window
		driver.manage().window().maximize();
		driver.findElement(By.id("openwindow")).click();
		//give knowledge of all windows present in selenium
		Set<String> windows = driver.getWindowHandles(); 
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		Thread.sleep(1000);

	}

	private static void exerciseSix(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parent = it.next();
		String child = it.next();
		Thread.sleep(2000);
		// switching to child window
		driver.switchTo().window(child);
		driver.close();
		//switching to parent window
		driver.switchTo().window(parent);

	}

	private static void exerciseSeven(WebDriver driver) throws InterruptedException {
		//using the locators have to pass the keys
		driver.findElement(By.id("name")).sendKeys("sid");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("*[value='Alert']")).click();
		Thread.sleep(2000);
		//accept the alert
		driver.switchTo().alert().accept();

	}

	private static void exerciseEight(WebDriver driver) throws InterruptedException {
		// scroll the window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.id("product"));
		// to find row size
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		int i = 0;
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"));
		Thread.sleep(200);
	}

	private static void exerciseNine(WebDriver driver) throws InterruptedException {
		//scroll window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		//create action class to handle interactions
		Actions ad = new Actions(driver);
		Thread.sleep(3000);
		// to move to specific element
		ad.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).build().perform();
		Thread.sleep(5000);
		ad.moveToElement( driver.findElement(By.linkText("Top"))).click().build().perform();

	}

}
