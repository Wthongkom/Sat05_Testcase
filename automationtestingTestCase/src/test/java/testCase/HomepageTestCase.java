package testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTestCase {

	WebDriver driver;

	WebDriverWait wait;

	private String url = "http://practice.automationtesting.in";

	By shopBT = By.xpath("//li[@id='menu-item-40']");
	By homeBT = By.xpath("//div[@id='content']/nav/a");
	By clickSliderBT = By.xpath("//*[@id='n2-ss-6-arrow-previous']/img");
	By threeSliderTop = By.xpath("//div[@id='n2-ss-6']/div");
	By threebookArrivals = By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div");
	By newItemArrivals = By.xpath("//*[@class='products']/li/a/img");
	By descriptionBT = By.xpath("//*[@class='description_tab active']/a");
	By reviewBT = By.xpath("//a[normalize-space()='Reviews (0)']");
	By addToBasketBT = By.xpath("//button[@type='submit']");
	By viewBasketBT = By.xpath("//li[@id='wpmenucartli']/a");
	By removeBT = By.xpath("//div[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[1]/a");
	By updateBasketBT = By.xpath("//input[@name='update_cart']");
	By proceedToCkeckoutBT = By.xpath("//a[normalize-space()='Proceed to Checkout']");

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

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Sliders only
		wait.until(ExpectedConditions.elementToBeClickable(clickSliderBT));
		driver.findElement(clickSliderBT).click();
		wait.until(ExpectedConditions.elementToBeClickable(clickSliderBT));
		driver.findElement(clickSliderBT).click();
		wait.until(ExpectedConditions.elementToBeClickable(clickSliderBT));
		driver.findElement(clickSliderBT).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threeSliderTop)));

		List<WebElement> sliders = driver.findElements(threeSliderTop);
		int numberOfSlides = sliders.size();

		System.out.println("It has " + numberOfSlides + " sliders");

//		6) The Home page must contains only three sliders
		Assert.assertTrue(numberOfSlides == 3);
		System.out.println("Homepage has only 3 sliders : Passed");
	}

	@Ignore
	@Test
	public void TestCase02() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
	}

	@Ignore
	@Test
	public void TestCase03() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());

		driver.navigate().back();

// 		8) Test whether it is navigating to next page where the user can add that book into his basket.	
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			driver.navigate().back();
		}
	}

	@Ignore
	@Test
	public void TestCase04() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket		
//		10) Click on Description tab for the book you clicked on.		
//		11) There should be a description regarding that book the user clicked on
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Click on Description
			driver.findElement(descriptionBT).click();

			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tab-description']")).isDisplayed());
			System.out.println(driver.findElement(By.xpath(" //div[@id='tab-description']")).getText());
			System.out.println("The description is appears : Passed ");
			System.out.println(" ");

			driver.navigate().back();
		}
	}

	@Ignore
	@Test
	public void TestCase05() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Now clock on Reviews tab for the book you clicked on.
//		11) There should be a Reviews regarding that book the user clicked on
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Click on Reviews
			driver.findElement(reviewBT).click();

			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='reviews']")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//div[@id='reviews']")).getText());
			System.out.println("Reviews : Passed ");
			System.out.println(" ");

			driver.navigate().back();
		}
	}

	@Ignore
	@Test
	public void TestCase06() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket		
//		11) User can view that Book in the Menu item with price.		
//		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}
	}

	@Ignore
	@Test
	public void TestCase07() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
//		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("7141");
		driver.findElement(By.xpath("//html")).click();

//		14) Click the add to basket button
		driver.findElement(addToBasketBT).click();

//		15) Now it throws an error prompt like you must enter a value between 1 and 20
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='stock in-stock']")).isDisplayed());
		String a = driver.findElement(By.xpath("//p[@class='stock in-stock']")).getText();
		System.out.println("Book has " + a + "can not add more than stock");
	}

	@Ignore
	@Test
	public void TestCase08() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
//		13) User can click on the Item link in menu item after adding the book 
//		in to the basket which leads to the check out page		
		driver.findElement(viewBasketBT).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/form")).getText());

	}

	@Ignore
	@Test
	public void TestCase09() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
//		13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
		driver.findElement(viewBasketBT).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/form")).getText());
		System.out.println(" ");

//		14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("krishnasakinala");
		driver.findElement(By.xpath("//input[@name='apply_coupon']")).click();

		// Coupon can not use it
		System.out.println(driver
				.findElement(By.xpath("//li[normalize-space()='Coupon usage limit has been reached.']")).getText());

//		15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox 
//		which give 50rps off on the total price

	}

	@Ignore
	@Test
	public void TestCase10() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
//		13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
		driver.findElement(viewBasketBT).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/form")).getText());
		System.out.println(" ");

//		14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("krishnasakinala");
		driver.findElement(By.xpath("//input[@name='apply_coupon']")).click();

		// Coupon can not use it
		System.out.println(driver
				.findElement(By.xpath("//li[normalize-space()='Coupon usage limit has been reached.']")).getText());

//		15) User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
//		because the coupon is applicable for the book price > 450 rps

	}

	@Ignore
	@Test
	public void TestCase11() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Now click on Remove this icon in Check out page which removes that book from the grid.
		driver.findElement(removeBT).click();

//		14) User has the feasibility to remove the book at the time of check out also
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='cart-empty']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//p[@class='cart-empty']")).getText());

	}

	@Ignore
	@Test
	public void TestCase12() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		wait.until(ExpectedConditions.elementToBeClickable(shopBT));
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		wait.until(ExpectedConditions.elementToBeClickable(homeBT));
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}
		
//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Click on textbox value under quantity in Check out page to add or subtract books.
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("2");
		driver.findElement(By.xpath("//html")).click();

//		14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//		15) Now click on Update Basket to reflect those changes
		driver.findElement(updateBasketBT).click();

//		16) User has the feasibility to Update Basket at the time of check out.
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText());
		System.out.println(driver.findElement(By.xpath("//tr[@class='cart_item']")).getText());

	}

	@Ignore
	@Test
	public void TestCase13() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Now User can find the Total price of the book in the Check out grid.
//		14) User has the feasibility to find the total price of the books at to find 
//		the total price of the books at the time of check out
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart-collaterals']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='cart-collaterals']")).getText());

	}

	@Ignore
	@Test
	public void TestCase14() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.	
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Click on textbox value under quantity in Check out page to add or subtract books
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("2");
		driver.findElement(By.xpath("//html")).click();

//		14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.		
//		15) Now click on Update Basket to reflect those changes
		driver.findElement(updateBasketBT).click();

//		16) User has the feasibility to Update Basket at the time of check out
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText());

	}

	@Ignore
	@Test
	public void TestCase15() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.	
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}


//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always < subtotal because taxes are added in the subtotal
//		15) Total
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).getText());

	}

	@Ignore
	@Test
	public void TestCase16() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.	
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always < subtotal because taxes are added in the subtotal
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).getText());
		System.out.println(" ");

		String currentUrl = driver.getCurrentUrl();

//		15) Now click on Proceed to Check out button which navigates to payment gateway page.
//		16) Clicking on Proceed to Checkout button leads to payment gateway page
//		17) Clicking on Proceed to Checkout button leads to payment gateway page
		driver.findElement(proceedToCkeckoutBT).click();

		String paymentUrl = driver.getCurrentUrl();
		Assert.assertFalse(currentUrl.equals(paymentUrl));
		System.out.println(driver.getTitle());

	}

	@Ignore
	@Test
	public void TestCase17() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.	
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always < subtotal because taxes are added in the subtotal
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).getText());
		System.out.println(" ");

//		15) Now click on Proceed to Check out button which navigates to payment gateway page.
		driver.findElement(proceedToCkeckoutBT).click();

//		16) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		17) Now user can fill his details in billing details form and can opt any payment 
//		in the payment gateway like Direct bank transfer,cheque,cash or paypal.

		// Fake information
		Faker faker = new Faker();

		driver.findElement(fName).sendKeys(faker.name().firstName());
		driver.findElement(lName).sendKeys(faker.name().lastName());
		driver.findElement(email).sendKeys(faker.name().firstName() + "555" + "@gmail.com");
		driver.findElement(pNumber).sendKeys(faker.phoneNumber().cellPhone());
		driver.findElement(address).sendKeys(faker.address().streetAddress());
		driver.findElement(city).sendKeys(faker.address().city());
		driver.findElement(By.xpath("//div[@id='s2id_billing_state']/a")).click();
		driver.findElement(By.xpath("//ul[@id='select2-results-2']/li[10]")).click();
		driver.findElement(pCode).sendKeys(faker.address().zipCode());
		driver.findElement(payment).click();

//		18) User has the feasibility to add coupon in the payment gateway page and 
//		also he can find billing,order and additional details.

		// Scroll page up
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -400);");
		
		driver.findElement(By.xpath("//*[@id='page-35']/div/div[1]/div[2]/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//form[@class='checkout_coupon']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//form[@class='checkout_coupon']")).getText());

	}

//	@Ignore
	@Test
	public void TestCase18() {

		wait = new WebDriverWait(driver, 30);

//		3) Click on Shop Menu	
		driver.findElement(shopBT).click();

//		4) Now click on Home menu button
		driver.findElement(homeBT).click();

//		5) Test whether the Home page has Three Arrivals only
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(threebookArrivals)));

		List<WebElement> allNewArrivalItems = driver.findElements(threebookArrivals);
		int numOfNewArrivalItem = allNewArrivalItems.size();

		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("There are 3 items new arrivals : Passed");

//		6) The Home page must contains only three Arrivals
		Assert.assertTrue(numOfNewArrivalItem == 3);
		System.out.println("Home page must contains only 3 new arrivals : Passed");
		System.out.println(" ");

//		7) Now click the image in the Arrivals
		driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText());
		System.out.println(" ");

		driver.navigate().back();

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.	
		for (int i = 0; i < numOfNewArrivalItem; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(newItemArrivals)));

			List<WebElement> newArrivalItemImages = driver.findElements(newItemArrivals);

			newArrivalItemImages.get(i).click();

			// Find ckeckoutbutton
			List<WebElement> addToBasketButton = driver.findElements(addToBasketBT);

			if (addToBasketButton.size() > 0) {
				Assert.assertTrue(addToBasketButton.size() > 0);
				System.out.println("This item is able to add to the basket : Passed");
				System.out.println(" ");

				driver.findElement(addToBasketBT).click();

				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='content']/div[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//li[@id='wpmenucartli']")).getText());
				System.out.println(" ");

			} else {
				driver.navigate().back();
				System.out.println("This item is not able to add to the basket");
			}
		}

//		12) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(viewBasketBT).click();

//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always < subtotal because taxes are added in the subtotal
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-34']/div/div[1]/div/div")).getText());
		System.out.println(" ");

//		15) Now click on Proceed to Check out button which navigates to payment gateway page.
		driver.findElement(proceedToCkeckoutBT).click();

//		16) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		17) Now user can fill his details in billing details form and can opt any payment in the payment 
//		gateway like Direct bank transfer,cheque,cash or paypal.

		// Fake information
		Faker faker = new Faker();

		driver.findElement(fName).sendKeys(faker.name().firstName());
		driver.findElement(lName).sendKeys(faker.name().lastName());
		driver.findElement(email).sendKeys(faker.name().firstName() + "555" + "@gmail.com");
		driver.findElement(pNumber).sendKeys(faker.phoneNumber().cellPhone());
		driver.findElement(address).sendKeys(faker.address().streetAddress());
		driver.findElement(city).sendKeys(faker.address().city());
		driver.findElement(By.xpath("//div[@id='s2id_billing_state']/a")).click();
		driver.findElement(By.xpath("//ul[@id='select2-results-2']/li[10]")).click();
		driver.findElement(pCode).sendKeys(faker.address().zipCode());
		driver.findElement(payment).click();

//		18) Now click on Place Order button to complete process		
		driver.findElement(placeOrderBT).click();

//		19) On clicking place-order button user completes the process where the page navigates to Order 
//		confirmation page with order details,bank details,customer details and billing details.

		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='woocommerce-thankyou-order-details order_details']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//ul[@class='woocommerce-thankyou-order-details order_details']")).getText());
	
	}

}
