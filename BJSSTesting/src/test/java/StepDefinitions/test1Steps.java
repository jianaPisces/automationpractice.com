package StepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.CartSummaryPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.ProductItemPageObject;
import PageObjectsUtils.DriverUtil;
import PageObjectsUtils.JSExecutorUtil;
import PageObjectsUtils.ScreenshotUtil;
import io.cucumber.java.en.*;

public class test1Steps {

	WebDriver driver = null;

	@Given("setup Browser")
	public void setup_browser() {
		driver = DriverUtil.openChrome(driver);
	}

	@Then("go to home page of automationpractice.com")
	public void navigate_to_home_page_of_automationpractice_com() {
		DriverUtil.goToHomePage(driver);
	}

	@When("^click to quick-view (.*)$")
	public void click_to_quick_view_item(String item) throws InterruptedException {
	    HomePageObject.quickView(driver, item);	    
	}

	@Then("^edit Quantity, (.*), Color for (.*)$")
	public void edit_quantity_m_color_for_item(String size, String item ) 
			throws InterruptedException {	
		HomePageObject.moreToViewItem(driver, item);
		ProductItemPageObject.eidtItem(driver, size);
	}

	@And("add the item to basket")
	public void add_the_item_to_basket() {
		ProductItemPageObject.addToCart(driver);
	}

	@Then("continue shopping")
	public void continue_shoping() throws InterruptedException {
		ProductItemPageObject.continueShopping(driver);
	}

	@And("^open another item with name (.*)$")
	public void open_another_item(String item) throws InterruptedException {
		DriverUtil.goToHomePage(driver);
		driver.navigate().refresh();
		HomePageObject.moreToViewItem(driver, item);
	}

	@Then("add the itemB to basket")
	public void add_the_itemB_to_basket() throws InterruptedException {
		ProductItemPageObject.addToCart(driver);
		
	}
	
	@Then("check out to shopping cart summary")
	public void check_out_to_shopping_cart_summary() throws InterruptedException {
		ProductItemPageObject.proceedToCheckout(driver);
	}

	@And("^check shopping with (.*) items$")
	public void check_shopping_with_2_items(String num) throws Exception {
//		ProductItemPageObject.continueShopping(driver);
		boolean test = HomePageObject.checkPurchaseNumber(driver, num);
		Assert.assertTrue(test);
		CartSummaryPageObject.screenShotCartNum(test, driver);
	}
	
	@And("^check total price (.*), (.*), (.*) and got a failed assert image$")
	public void check_total_price(String p1, String p2, String p3) throws Exception {
		boolean test = CartSummaryPageObject.checkTotalPrice(driver, p1, p2, p3);
		Assert.assertTrue(test);
		ProductItemPageObject.assertWrongColor(driver);
	}

	@Then("proceed to checkout")
	public void checkout_with_wire() {
		CartSummaryPageObject.checkOut(driver);
	}
	
	@And("^login with (.*), (.*)$")
	public void login_with_validCredential(String email, String password)
			throws InterruptedException {
		driver.navigate().refresh();
		LoginPageObject.login(driver, email, password);
	}
	
    @Then("complete checkout")
    public void back_to_checkout() throws InterruptedException {
    	LoginPageObject.checkOut(driver);
    	LoginPageObject.agreeTerm(driver);
    	LoginPageObject.checkOut(driver);
    	LoginPageObject.wirePay(driver);
    	LoginPageObject.confirmOrder(driver);

    }
    
    @And("take a screenshot")
    public void screenshot_testResult() throws Exception {
    	WebElement element = LoginPageObject.getTextConfirmation(driver);
    	JSExecutorUtil.viewElement(element, driver);
    	String fileName = ScreenshotUtil.setFileName("test1Result");
    	ScreenshotUtil.takeSnapShot(driver, fileName);   	
		DriverUtil.closeChrome(driver);
    }


}
