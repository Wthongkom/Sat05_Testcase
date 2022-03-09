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

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountRegistrationTestCase {

	WebDriver driver;

	private String url = "http://practice.automationtesting.in";
	String email = "abc555@gmail.com";
	String password = "Testcase@abc555lol";

	By myAccountBT = By.id("menu-item-50");
	By registerEmail = By.id("reg_email");
	By registerPassword = By.id("reg_password");
	By clickonBlankArea = By.xpath("//html");
	By registerBT = By.xpath("//input[@name='register']");
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

//	@Ignore
	@Test
	public void TestCase1() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter registered Email Address in Email-Address textbox
		Faker faker = new Faker();
		driver.findElement(registerEmail).sendKeys(faker.name().firstName() + "555@gmail.com");

//		5) Enter your own password in password textbox		
		driver.findElement(registerPassword).sendKeys(faker.name().firstName() + "Test@abc555lol");

//		6) Click on Register button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(registerBT).click();

//		7) User will be registered successfully and will be navigated to the Home page
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='page-36']/div/div[1]/div")).getText());
		System.out.println(driver.getTitle());

	}

	@Ignore
	@Test
	public void TestCase2() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter invalid Email Address in Email-Address textbox
		driver.findElement(registerEmail).sendKeys("abc123gmail.com");

//		5) Enter your own password in password textbox
		driver.findElement(registerPassword).sendKeys(password);

//		6) Click on Register button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(registerBT).click();

//		7) Registration must fail with a warning message(ie You must enter a valid email address)
		String actualUrl = driver.getCurrentUrl();
		String expexctedUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.equals(expexctedUrl));
		System.out.println("Registration fail : Failed ");

	}

	@Ignore
	@Test
	public void TestCase3() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter empty Email Address in Email-Address textbox
		driver.findElement(registerEmail).sendKeys("");

//		5) Enter your own password in password textbox
		driver.findElement(registerPassword).sendKeys(password);

//		6) Click on Register button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(registerBT).click();

//		7) Registration must fail with a warning message(ie please provide valid email address)
		String actualUrl = driver.getCurrentUrl();
		String expexctedUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.equals(expexctedUrl));
		System.out.println("Registration fail : Failed ");

	}

	@Ignore
	@Test
	public void TestCase4() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter valid Email Address in Email-Address textbox
		driver.findElement(registerEmail).sendKeys(email);

//		5) Enter empty password in password textbox
		driver.findElement(registerPassword).sendKeys("");

//		6) Click on Register button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(registerBT).click();

//		7) Registration must fail with a warning message(ie please enter an account password)
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

	@Ignore
	@Test
	public void TestCase5() {

//		3) Click on My Account Menu
		driver.findElement(myAccountBT).click();

//		4) Enter empty Email Address in Email-Address textbox
		driver.findElement(registerEmail).sendKeys("");

//		5) Enter empty password in password textbox
		driver.findElement(registerPassword).sendKeys("");

//		6) Click on Register button
		driver.findElement(clickonBlankArea).click();
		driver.findElement(registerBT).click();

//		7) Registration must fail with a warning message(ie please provide valid email address)
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
		System.out.println(driver.findElement(errorMessage).getText());

	}

}
