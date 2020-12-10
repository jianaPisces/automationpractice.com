package PageObjects;

import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjectsUtils.DriverUtil;
import PageObjectsUtils.ScreenshotUtil;

public class CartSummaryPageObject {
	
	private static By img_cart = By.cssSelector("a[title='View my shopping cart']");
	private static By lnk_checkOut = By.cssSelector("#button_order_cart");
	private static By txt_totalPrice = By.cssSelector("#total_price");
	private static By btn_proceedToCheckout_CartSummary =
			By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
	
	public static void clickCheckOut(WebDriver driver) throws InterruptedException {
		WebElement itemWE = driver.findElement(img_cart);
		DriverUtil.mouseOver(itemWE, driver);
		Thread.sleep(4000);
		WebElement element = driver.findElement(lnk_checkOut);
		element.click();
		driver.navigate().refresh();
	}
	
	public static boolean checkTotalPrice(WebDriver driver, String p1, String p2, String p3) {
		BigDecimal priceA = new BigDecimal(p1);
		BigDecimal priceB = new BigDecimal(p2);
		BigDecimal itemPrice = priceA.add(priceB);
		BigDecimal shippingP = new BigDecimal(p3);
//		System.out.println(itemPrice.add(shippingP).toString());
		String showP = driver.findElement(txt_totalPrice).getText();
//		System.out.println(showP);
		if (showP.contains(itemPrice.add(shippingP).toString().toString()))
			return true;
		return false;
	}
	
	public static void checkOut(WebDriver driver) {
		driver.findElement(btn_proceedToCheckout_CartSummary).click();
	}
	
	public static void screenShotCartNum(boolean take, WebDriver driver) throws Exception {
		if (take) {
			String fileName = ScreenshotUtil.setFileName("shoppingNumConfirm");
			ScreenshotUtil.takeSnapShot(driver, fileName);
		}
	}
	
}
