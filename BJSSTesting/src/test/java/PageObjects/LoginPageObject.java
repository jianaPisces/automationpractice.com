package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
	private static By txt_email_LoginPage = By.id("email");
	private static By txt_passwd_LoginPage = By.id("passwd");
	private static By btn_signIn_LoginPage = By.id("SubmitLogin");
	private static By btn_proceedToCheckout_LoginPage_address =
			By.xpath("//p[@class='cart_navigation clearfix']//button");
	private static By ckb_termAgree_LoginPage_shipping =
			By.cssSelector("input[type='checkbox']");
	private static By lnk_wirePay = By.className("bankwire");
	private static By btn_confirmOrder =
			By.xpath("//p[@class='cart_navigation clearfix']//button");
	private static By txt_confirmation = By.xpath("//h1[contains(text(),'confirmation')]");
	
	
//	private By txt_emailCreate_LoginPage = By.id("email_create");
	
	public static void enterEmail(WebDriver driver, String email) {
		driver.findElement(txt_email_LoginPage).sendKeys(email);
	}
	
	public static void enterPassword(WebDriver driver, String passwd) {
		driver.findElement(txt_passwd_LoginPage).sendKeys(passwd);
	}
	
	public static void clickSignIn(WebDriver driver) {
		driver.findElement(btn_signIn_LoginPage).click();
	}
	
	public static void login(WebDriver driver, String email, String passwd) throws InterruptedException {
		enterEmail(driver, email);
		enterPassword(driver, passwd);
		Thread.sleep(2000);
		clickSignIn(driver);
	}
	
	public static void checkOut(WebDriver driver) {
		System.out.println("loginPage checkout");
		WebElement element = driver.findElement(btn_proceedToCheckout_LoginPage_address);
		element.click();
	}

	public static void agreeTerm(WebDriver driver) throws InterruptedException {
		System.out.println("loginPage agree term");
		WebElement element = driver.findElement(ckb_termAgree_LoginPage_shipping);
		boolean tick = false;
		do {
			if (!element.isSelected()) {
				Thread.sleep(2000);
				element.click();
			} else
				tick = true;
		} while(!tick);
	}
	
	public static void wirePay(WebDriver driver) {
		WebElement element = driver.findElement(lnk_wirePay);
		element.click();
	}
	
	public static void confirmOrder(WebDriver driver) {
		WebElement element = driver.findElement(btn_confirmOrder);
		element.click();
	}
	
	public static WebElement getTextConfirmation(WebDriver driver) {
		return driver.findElement(txt_confirmation);
	}
}
