package testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopTestCase {

	WebDriver driver;

	private String url = "http://practice.automationtesting.in";

	By shopBT = By.id("menu-item-40");
	By filterBT = By.xpath("//div[@id='woocommerce_price_filter-2']/form/div/div[2]/button");
	By viewBasketBT = By.xpath("//div[@id='content']/ul/li[1]/a[3]");

	By fName = By.id("billing_first_name");
	By lName = By.id("billing_last_name");
	By email = By.id("billing_email");
	By pNumber = By.id("billing_phone");
	By address = By.id("billing_address_1");
	By city = By.id("billing_city");
	By pCode = By.id("billing_postcode");

	By payment = By.xpath("//div[@id='payment']/ul/li[3]/label");
	By placeOrderBT = By.xpath("//input[@id='place_order']");

	@Before
	public void beforeTest() {

//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void afterTest() {
		driver.close();
	}

	@Ignore
	@Test
	public void TestCase01() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Adjust the filter by price between 150 to 450 rps
		WebElement slidertap = driver.findElement(By.xpath("//div[@class='price_slider_wrapper']/div[1]/span[2]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slidertap, -28, 0).build().perform();

//		5) Now click on Filter button
		driver.findElement(filterBT).click();

//		6) User can view books only between 150 to 450 rps price
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='content']/ul/li['i']"));

		for (WebElement b : books) {
			System.out.println(b.getText());
		}
	}

	@Ignore
	@Test
	public void TestCase02() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click any of the product links available in the product category
		driver.findElement(By.xpath("//div[@id='content']/ul/li[1]/a[1]/h3")).click();

//		5) Now user can view only that particular product
		// div[@class='summary entry-summary']
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());

	}

	@Ignore
	@Test
	public void TestCase03() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on Sort by Popularity item in Default sorting dropdown
		WebElement sortingDropDown = driver.findElement(By.name("orderby"));

		Select select = new Select(sortingDropDown);
		select.selectByValue("popularity");

//		5) Now user can view the popular products only
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='content']/ul/li['i']"));

		for (WebElement b : books) {
			System.out.println(b.getText());
		}
	}

	@Ignore
	@Test
	public void TestCase04() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on Sort by Average ratings in Default sorting dropdown
		WebElement sortingDropDown = driver.findElement(By.name("orderby"));

		Select select = new Select(sortingDropDown);
		select.selectByValue("rating");

//		5) Now user can view the popular products only
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='content']/ul/li['i']"));

		for (WebElement b : books) {
			System.out.println(b.getText());
		}
	}

	@Ignore
	@Test
	public void TestCase05() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on Sort by Newness ratings in Default sorting dropdown
		WebElement sortingDropDown = driver.findElement(By.name("orderby"));

		Select select = new Select(sortingDropDown);
		select.selectByValue("date");

//		5) Now user can view the popular products only
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='content']/ul/li['i']"));

		for (WebElement b : books) {
			System.out.println(b.getText());
		}
	}

	@Ignore
	@Test
	public void TestCase06() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on Sort by Low to High Item in Default sorting dropdown
		WebElement sortingDropDown = driver.findElement(By.name("orderby"));

		Select select = new Select(sortingDropDown);
		select.selectByValue("price");

//		5) Now user can view the popular products only		
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='content']/ul/li['i']"));

		for (WebElement b : books) {
			System.out.println(b.getText());
		}
	}

	@Ignore
	@Test
	public void TestCase07() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on Sort by High to Low Item in Default sorting dropdown
		WebElement sortingDropDown = driver.findElement(By.name("orderby"));

		Select select = new Select(sortingDropDown);
		select.selectByValue("price-desc");

//		5) Now user can view the popular products only
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='content']/ul/li['i']"));

		for (WebElement b : books) {
			System.out.println(b.getText());
		}
	}

	@Ignore
	@Test
	public void TestCase08() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on read more button in home page
		driver.findElement(By.xpath("//div[@id='content']/ul/li[7]/a[2]")).click();

//		5) Read More option indicates the Out Of Stock.
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='stock out-of-stock']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//p[@class='stock out-of-stock']")).getText());

//		6) User cannot add the product which has read more option as it was out of stock.
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
	}

	@Ignore
	@Test
	public void TestCase09() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on Sale written product in home page
		driver.findElement(By.xpath("//div[@id='content']/ul/li[1]/a[1]/span[1]")).click();

//		5) User can clearly view the actual price with old price striken for the sale written products
		Assert.assertTrue(driver.findElement(By.xpath("//div[@itemprop='offers']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@itemprop='offers']")).getText());
	}

	@Ignore
	@Test
	public void TestCase10() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on the Add To Basket button which adds that book to your basket
		driver.findElement(By.xpath("//div[@id='content']/ul/li[1]/a[2]")).click();

//		5) User can view that Book in the Menu item with price .
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/ul/li[1]")).getText());
		System.out.println(" ");

//		6) Now click on View Basket link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always < subtotal because taxes are added in the subtotal
		System.out.println(driver.findElement(By.xpath("//div[@class='cart_totals ']")).getText());
		System.out.println(" ");

//		9) Now click on Proceed to Check out button which navigates to payment gateway page.
		By proceedToCkeckoutBT = By.xpath("//a[normalize-space()='Proceed to Checkout']");
		driver.findElement(proceedToCkeckoutBT).click();

//		10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		11) Now user can fill his details in billing details form and can opt any payment in the payment gateway 
//		like Direct bank transfer,cheque,cash or paypal.
		System.out.println(driver.getTitle());
		System.out.println(" ");

		// Fake information
		Faker faker = new Faker();

		driver.findElement(fName).sendKeys(faker.name().firstName());
		driver.findElement(lName).sendKeys(faker.name().lastName());
		driver.findElement(email).sendKeys(faker.name().firstName() + "555@gmail.com");
		driver.findElement(pNumber).sendKeys(faker.phoneNumber().cellPhone());
		driver.findElement(address).sendKeys(faker.address().streetAddress());
		driver.findElement(city).sendKeys(faker.address().city());
		driver.findElement(By.xpath("//div[@id='s2id_billing_state']/a")).click();
		driver.findElement(By.xpath("//ul[@id='select2-results-2']/li[10]")).click();
		driver.findElement(pCode).sendKeys(faker.address().zipCode());
		driver.findElement(payment).click();

//		12) Now click on Place Order button to complete process		
		driver.findElement(placeOrderBT).click();

//		13) On clicking place order button user completes his process where the page navigates 
//		to Order confirmation page with order details,bank details,customer details and billing details.
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-35']/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-35']/div/div[1]/ul")).getText());
	}

	@Ignore
	@Test
	public void TestCase11() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on the Add To Basket button which adds that book to your basket
		driver.findElement(By.xpath("//div[@id='content']/ul/li[1]/a[2]")).click();

//		5) User can view that Book in the Menu item with price .
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/ul/li[1]")).getText());
		System.out.println(" ");

//		6) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always < subtotal because taxes are added in the subtotal
		System.out.println(driver.findElement(By.xpath("//div[@class='cart_totals ']")).getText());
		System.out.println(" ");

//		9) Now click on Proceed to Check out button which navigates to payment gateway page.
		By proceedToCkeckoutBT = By.xpath("//a[normalize-space()='Proceed to Checkout']");
		driver.findElement(proceedToCkeckoutBT).click();

//		10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		11) Now user can fill his details in billing details form and can opt any payment in the payment 
//		gateway like Direct bank transfer,cheque,cash or paypal.
		System.out.println(driver.getTitle());
		System.out.println(" ");

		// Fake information
		Faker faker = new Faker();

		driver.findElement(fName).sendKeys(faker.name().firstName());
		driver.findElement(lName).sendKeys(faker.name().lastName());
		driver.findElement(email).sendKeys(faker.name().firstName() + "555@gmail.com");
		driver.findElement(pNumber).sendKeys(faker.phoneNumber().cellPhone());
		driver.findElement(address).sendKeys(faker.address().streetAddress());
		driver.findElement(city).sendKeys(faker.address().city());
		driver.findElement(By.xpath("//div[@id='s2id_billing_state']/a")).click();
		driver.findElement(By.xpath("//ul[@id='select2-results-2']/li[10]")).click();
		driver.findElement(pCode).sendKeys(faker.address().zipCode());
		driver.findElement(payment).click();

//		12) Now click on Place Order button to complete process		
		driver.findElement(placeOrderBT).click();

//		13) On clicking place order button user completes his process where the page navigates to 
//		Order confirmation page with order details,bank details,customer details and billing details
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-35']/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-35']/div/div[1]/ul")).getText());
	}

//	@Ignore
	@Test
	public void TestCase12() {

//		3) Click on Shop Menu
		driver.findElement(shopBT).click();

//		4) Click on the Add To Basket button which adds that book to your basket
		driver.findElement(By.xpath("//div[@id='content']/ul/li[1]/a[2]")).click();

//		5) User can view that Book in the Menu item with price .
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/ul/li[1]")).getText());
		System.out.println(" ");

//		6) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always < subtotal because taxes are added in the subtotal
		System.out.println(driver.findElement(By.xpath("//div[@class='cart_totals ']")).getText());
		System.out.println(" ");

//		9) The tax rate variers for India compared to other countries
//		10) Tax rate for indian should be 2% and for abroad it should be 5%
	}

}
