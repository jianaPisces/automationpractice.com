package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObjectsUtils.DriverUtil;
import PageObjectsUtils.JSExecutorUtil;
import PageObjectsUtils.ScreenshotUtil;

public class ProductItemPageObject {

	private static By drp_size = By.cssSelector("#group_1");
	private static By btn_cart = By.cssSelector("#add_to_cart");
	private static By btn_continue = By.cssSelector("span[title='Continue shopping']");
	private static By btn_proceedToCheckout_ProductItem = 
			By.xpath("//a[@title='Proceed to checkout']");
	private static By txt_color = 
			By.xpath("//td[@class='cart_description']//a[contains(text(),'Orange')]");

	public static void eidtItem(WebDriver driver, String size) {
		WebElement element = driver.findElement(drp_size);
		DriverUtil.selectByVisibleText(element, size);
	}

	public static void addToCart(WebDriver driver) {
		WebElement element = driver.findElement(btn_cart);
		DriverUtil.waitThenClick(element, driver);
//		element.click();
	}

	public static void continueShopping(WebDriver driver) throws InterruptedException {
		WebElement element = driver.findElement(btn_continue);
		DriverUtil.waitThenClick(element, driver);
		Thread.sleep(3000);
	}
	
	public static void proceedToCheckout(WebDriver driver) throws InterruptedException {
		WebElement element = driver.findElement(btn_proceedToCheckout_ProductItem);
		DriverUtil.waitThenClick(element, driver);
		Thread.sleep(3000);
	}
	
	public static void assertWrongColor(WebDriver driver) throws Exception {
		WebElement element = driver.findElement(txt_color);
		String showColor = element.getText();
		String wrongColor = "black";
		if (!showColor.contains(wrongColor)) {
			JSExecutorUtil.drawBorder(element, driver);
			WebElement txtE = driver.findElement(By.xpath("//h1[@id='cart_title']"));
	    	JSExecutorUtil.viewElement(txtE, driver);
	    	String fileName = ScreenshotUtil.setFileName("WrongColorItem");
	    	ScreenshotUtil.takeSnapShot(driver, fileName);  	
		}
	}

}
