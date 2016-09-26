package selenium;

import selenium.maps.ZakladanieKontaForEvoMap;
import org.testng.annotations.Test;
import fp.forevo.manager.TafException;
import fp.forevo.proxy.Browser;
import org.testng.annotations.BeforeTest;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ZakladanieKontaForEvo extends ZakladanieKontaForEvoMap {
	public String url = "http://127.0.0.1:8080/gardenstore/pl/";
	public String user = "test222@test.pl";
	public String pass = "qwert1234";
	

	@Test(priority=0)
	public void otwarcieStronyLogowania() throws TafException {
		btnLogin.click();		
		Assert.assertEquals(browser.getTitle(), "Logowanie - GARDEN STORE");
	}
	
	@Test(priority=1)
	public void zalozenieKonta() throws TafException{
		txtStworzKonto_AdresEmail.setText(user);
		btnStworzKonto.click();
		
		Assert.assertTrue(winStronaLogowania.assertText("STWÓRZ KONTO"));
		
		rbPan.click();
		txtSK_imie.setText("TestImie");
		txtSK_nazwisko.setText("TestNaziwsko");
		txtSK_haslo.setText(pass);
		
		cbSK_DzienUrodzenia.selectByValue("26");
		cbSK_MiesiacUrodzenia.selectByVisibleText("Wrzesieñ ");
		cbSK_RokUrodzenia.selectByValue("2016");
		
		chbSK_Newsletter.click();
		chbSK_Promo.click();
		
		btnSK_ZarejestrujSie.click();
	
	
	}
	
	@BeforeTest
	public void beforeTest() {
		runBrowser(Browser.Chrome, url);
		browser.manage().window().maximize();		
		
	}

	@AfterTest
	public void afterTest() {
		//browser.quit();
	}

}
