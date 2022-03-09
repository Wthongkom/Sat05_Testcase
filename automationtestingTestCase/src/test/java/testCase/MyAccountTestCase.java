package testCase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountTestCase {

	WebDriver driver;

	private String url = "http://practice.automationtesting.in";
	private String email = "abc555@gmail.com";
	private String password = "Testcase@abc555lol";
	
	By myAccountBT = By.id("menu-item-50");
	By Email = By.id("username");
	By Password = By.id("password");
	By clickonBlankArea = By.xpath("//html");
	By loginBT = By.xpath("//input[@name='login']");
	By ordersLink = By.xpath("//div[@id='page-36']/div/div[1]/nav/ul/li[2]/a");
	By addressLink = By.xpath("//div[@id='page-36']/div/div[1]/nav/ul/li[4]/a");
	By accountLink = By.xpath("//div[@id='page-36']/div/div[1]/nav/ul/li[5]/a");
	By logoutBT = By.xpath("//div[@id='page-36']/div/div[1]/nav/ul/li[6]/a");
	

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

//	@Ignore
	@Test
	public void TestCase1() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link which leads to Dashboard
		driver.findElement(myAccountBT).click();

//		9) User must view Dashboard of the site
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div")).getText());

	}

	@Ignore
	@Test
	public void TestCase2() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link
		driver.findElement(myAccountBT).click();

//		9) Click on Orders link
		driver.findElement(ordersLink).click();

//		10) User must view their orders on clicking orders link
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"page-36\"]/div/div[1]/div/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div/div")).getText());

	}

	@Ignore
	@Test
	public void TestCase3() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link
		driver.findElement(myAccountBT).click();

//		9) Click on Orders link
		driver.findElement(ordersLink).click();

//		10) Click view button
//		driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/table/tbody/tr/td[5]/a")).click();		

//		11) User must view his Order details,customer details and billing details on clicking view button

	}

	@Ignore
	@Test
	public void TestCase5() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link which leads to Dashboard
		driver.findElement(myAccountBT).click();

//		9) Click on Address link
		driver.findElement(addressLink).click();

//		10) User must view billing address and ship address
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText());

	}

	@Ignore
	@Test
	public void TestCase6() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link
		driver.findElement(myAccountBT).click();

//		9) Click on Address link
		driver.findElement(addressLink).click();

//		10) Click Edit on Shipping Address
		driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div/div/div[2]/header/a")).click();

//		11) User can Edit Shipping address
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div/form")).getText());

	}

	@Ignore
	@Test
	public void TestCase7() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link
		driver.findElement(myAccountBT).click();

//		9) Click on Account details
		driver.findElement(accountLink).click();

//		10) User can view account details where he can change his pasword also.
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div/form")).getText());

	}

	@Ignore
	@Test
	public void TestCase8() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(email);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());

//		8) Click on Myaccount link
		driver.findElement(myAccountBT).click();

//		9) Click on Logout button
		driver.findElement(logoutBT).click();

//		10) On clicking logout,User successfully comes out from the site
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='customer_login']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='customer_login']")).getText());

	}
	
}
