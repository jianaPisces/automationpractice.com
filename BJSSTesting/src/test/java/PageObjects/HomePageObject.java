package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObjectsUtils.DriverUtil;


public class HomePageObject {

	// Locator for product items
	private By link_women = By.cssSelector("a[title='Women']");
	private static By btn_quickView = By.xpath("//a[@class='quick-view']");
	private static By txt_purchaseNum = By.xpath("//div[@class='shopping_cart']"
			+ "//span[@class='ajax_cart_quantity']");

	//Locator for item prop window

	public static void quickView(WebDriver driver, String item) throws InterruptedException {
		WebElement itemWE = driver.findElement(itemImage(item));
		DriverUtil.mouseOver(itemWE, driver);
		driver.findElement(btn_quickView).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
//		WebElement size = driver.findElement(txt_itemName_PopUpItemPage);
//		JSExecutorUtil.drawBorder(size, driver);
	
	}
	
	public static void moreToViewItem(WebDriver driver, String item) {
		WebElement itemWE = driver.findElement(itemImage(item));
		DriverUtil.mouseOver(itemWE, driver);
		WebElement link = driver.findElement(By.partialLinkText(item));
		link.click();
	}
	
	public void navigateToWomenPage(WebDriver driver) {
		driver.findElement(link_women).clear();
	}
	
	public static boolean checkPurchaseNumber(WebDriver driver, String expectNum) {
		String showNum = driver.findElement(txt_purchaseNum).getText();
		if (showNum.equals(expectNum)) {
			return true;
		}
		return false;
	}

	private static By itemImage(String item) {
		return By.xpath("//a[@title='" + item + "']");
	}
}
