package PageObjectsUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
	
	public static WebDriver openChrome(WebDriver driver) {
		System.out.println("Step - Open Chrome Browser");

		System.setProperty("webdriver.chrome.driver", "C:/Softwares/chromedriver.exe");
		ChromeOptions options = getDesiredCapabilities();
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void goToLoginPage(WebDriver driver) {
//		System.out.println("on login page on automationparctice.com");
	    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	public static void goToHomePage(WebDriver driver) {
//		System.out.println("on Home page on automationparctice.com");
	    driver.get("http://automationpractice.com/index.php");
	}
	
	public static void closeChrome(WebDriver driver) {
		System.out.println("Close the Chrome Browser");
		driver.close();
		driver.quit();
	}

	private static ChromeOptions getDesiredCapabilities() {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox");
		options.addArguments("--remote-debugging-port=9225");

		return options;
	}
	
	public void assertWithHeaderTitle(WebDriver driver, String title) {
		driver.findElement(By.cssSelector("h1[itemprop='name']")).getAttribute("innnerHTML").equalsIgnoreCase(title);
	}
	
	public static void mouseOver(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();		
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public static void setText(String text, WebElement element) {
		element.sendKeys(text);
	}
	
	public static void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static boolean validateText(WebElement element, WebDriver driver, String expectedTxt) {
		String observedTxt = element.getText();
		if (observedTxt.equals(expectedTxt)) {
			return true;
		}
		return false;
	}
	
	public static void waitThenClick(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
}

//String mainWindowHandle = driver.getWindowHandle();
//Set<String> allWindowHandles = driver.getWindowHandles();
//
//System.out.println("windows count " + allWindowHandles.size());
//
//Iterator<String> iterator = allWindowHandles.iterator();

//while (iterator.hasNext()) {
//	System.out.println("2056");
//  String ChildWindow = iterator.next();
//  if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
//  	System.out.println("2058");	
//      driver.switchTo().window(ChildWindow);
//      
//      driver.findElement(txt_itemName_PopUpItemPage)
//      .getAttribute("innerHTML")
//      .equalsIgnoreCase(title);
//      
//      System.out.println("-----99999--------------"
//				+ driver.getTitle());
//      
//      By drp_size_PopUpItemPage = By.xpath("//select[@id='group_1']");
//      Select drpSize = new Select(driver.findElement(drp_size_PopUpItemPage));
//		drpSize.selectByVisibleText("M");
//  }
//}
