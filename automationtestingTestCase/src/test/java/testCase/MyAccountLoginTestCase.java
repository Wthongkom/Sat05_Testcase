package testCase;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountLoginTestCase {

	WebDriver driver;

	private String url = "http://practice.automationtesting.in";
	private String username = "abc555@gmail.com";
	private String password = "Testcase@abc555lol";
	private String incorrectUsername = "abc5544@gmail.com";
	private String incorrectPassword = "Testcase@abc555suck";
	
	By myAccountBT = By.id("menu-item-50");	
	By Email = By.id("username");
	By Password = By.id("password");
	By clickonBlankArea = By.xpath("//html");
	By loginBT = By.xpath("//input[@name='login']");
	By errorMessage = By.xpath("//div[@id='body']//li[1]");
	
	

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
	public void TestCase1() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered username in username textbox
		driver.findElement(Email).sendKeys(username);

//		5) Enter password in password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) User must successfully login to the web page
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText());

	}

	@Ignore
	@Test
	public void TestCase2() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter incorrect username in username textbox
		driver.findElement(Email).sendKeys(incorrectUsername);

//		5) Enter incorrect password in password textbox.
		driver.findElement(Password).sendKeys(incorrectPassword);

//		6) Click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

	@Ignore
	@Test
	public void TestCase3() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter valid username in username textbox
		driver.findElement(Email).sendKeys(username);

//		5) Now enter empty password in the password textbox
		driver.findElement(Password).sendKeys("");

//		6) Click on login button.
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

	@Ignore
	@Test
	public void TestCase4() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter empty username in username textbox
		driver.findElement(Email).sendKeys("");

//		5) Now enter valid password in the password textbox
		driver.findElement(Password).sendKeys(password);

//		6) Click on login button.
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) Proper error must be displayed(ie Invalid username) and prompt to enter login again	
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

	@Ignore
	@Test
	public void TestCase5() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter empty username in username textbox
		driver.findElement(Email).sendKeys("");

//		5) Now enter empty password in the password textbox
		driver.findElement(Password).sendKeys("");

//		6) Click on login button.
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) Proper error must be displayed(ie required username) and prompt to enter login again	
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

	@Ignore
	@Test
	public void TestCase6() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter the password field with some characters.
		driver.findElement(Password).sendKeys("555abc12345");

//		5) The password field should display the characters in asterisks or 
//		bullets such that the password is not visible on the screen		
		WebElement passworddisplay = driver
				.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[2]/label/span"));
		Assert.assertTrue(passworddisplay.isDisplayed());
		System.out.println(passworddisplay.getText());

	}

	@Ignore
	@Test
	public void TestCase7() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter the case changed username in username textbox
		driver.findElement(Email).sendKeys("ABc555@gmail.com");

//		5) Enter the case chenged password in the password tetxbox
		driver.findElement(Password).sendKeys("Testcase@abc555LOL");

//		6) Now click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) Login must fail saying incorrect username/password.
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

//	@Ignore
	@Test
	public void TestCase8() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter the username in username textbox
		driver.findElement(Email).sendKeys(username);

//		5) Enter the password in the password tetxbox
		driver.findElement(Password).sendKeys(password);

//		6) Now click on login button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(loginBT).click();

//		7) Once your are logged in, sign out of the site
		driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[6]/a")).click();

//		8) Now press back button
		driver.navigate().back();

//		9) User shouldn’t be signed in to his account rather a general webpage must be visible
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='customer_login']/div[1]/h2")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='customer_login']/div[1]/h2")).getText() + " "
				+ driver.getTitle());

	}	
}
