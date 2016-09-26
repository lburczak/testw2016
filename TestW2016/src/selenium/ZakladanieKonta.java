package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ZakladanieKonta {
	public WebDriver browser = null;
	public String url = "http://127.0.0.1:8080/gardenstore/pl/";
	public String user = "test223@test.pl";
	public String pass = "qwert1234";

	@BeforeTest
	public void beforeTest() {
		browser = new ChromeDriver();
		browser.get(url);
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void afterTest() {
		browser.quit();
	}

	@Test(priority = 0)
	public void otwarcieStronyLogowania() {
		WebElement btnLogin = browser.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
		btnLogin.click();

		Assert.assertEquals(browser.getTitle(), "Logowanie - GARDEN STORE");
	}

	@Test(priority = 1)
	public void zalozenieKonta() throws InterruptedException {
		WebElement editCreateMail = browser.findElement(By.id("email_create"));
		WebElement btnCreateAcc = browser.findElement(By.id("SubmitCreate"));

		editCreateMail.sendKeys(user);
		btnCreateAcc.click();

		WebElement rbMale = browser.findElement(By.id("id_gender1"));
		WebElement editFirstName = browser.findElement(By.id("customer_firstname"));
		WebElement editLastName = browser.findElement(By.id("customer_lastname"));
		WebElement editPswd = browser.findElement(By.id("passwd"));
		WebElement selectDays = browser.findElement(By.id("days"));
		WebElement selectMonths = browser.findElement(By.id("months"));
		WebElement selectYears = browser.findElement(By.id("years"));
		WebElement chbNews = browser.findElement(By.id("newsletter"));
		WebElement chbOptin = browser.findElement(By.id("optin"));
		WebElement btnSubmit = browser.findElement(By.id("submitAccount"));

		rbMale.click();
		editFirstName.sendKeys("FirstName");
		editLastName.sendKeys("LastName");
		editPswd.sendKeys(pass);

		// praca z comboBoxami
		Select select = new Select(selectDays);
		
		select.selectByValue("10");
		select = new Select(selectMonths);
		
		select.selectByVisibleText("Czerwiec ");
		select = new Select(selectYears);	
		select.selectByValue("1983");

		chbNews.click();
		chbOptin.click();

		btnSubmit.click();

		// czekamy na pojawienie siê tekstu - twoje konto zosta³o utworzone
		new WebDriverWait(browser, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']/p[1]")));
		
	}

	@Test(priority = 2)
	public void wylogujSie() {
		WebElement btnLogOut = browser.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a"));
		btnLogOut.click();
	}

	@Test(priority = 3)
	public void zalogujSie() {

		if (!browser.getTitle().equals("Logowanie - GARDEN STORE")) {
			WebElement btnLogin = browser.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
			btnLogin.click();
		}

		WebElement editEmail = browser.findElement(By.id("email"));
		WebElement editPswd = browser.findElement(By.id("passwd"));
		WebElement btnSubmit = browser.findElement(By.id("SubmitLogin"));

		editEmail.sendKeys(user);
		editPswd.sendKeys(pass);
		btnSubmit.click();
		Assert.assertEquals(browser.getTitle(), "Moje konto - GARDEN STORE");
	}
}
