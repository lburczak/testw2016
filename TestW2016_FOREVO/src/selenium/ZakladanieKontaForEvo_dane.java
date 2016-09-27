package selenium;

import org.testng.annotations.Test;

import fp.forevo.manager.TafException;
import fp.forevo.proxy.Browser;
import selenium.maps.ZakladanieKontaForEvoMap;

import org.testng.annotations.BeforeTest;

import java.text.ParseException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ZakladanieKontaForEvo_dane extends ZakladanieKontaForEvoMap {
	public String url = "http://127.0.0.1:8080/gardenstore/pl/";
	public String user = "";
	public String pass = "";
	public String dzien = "";
	public String miesiac = "";
	public String rok = "";

	@Test(priority = 0)
	public void otwarcieStronyLogowania() throws TafException {
		btnLogin.click();
		Assert.assertEquals(browser.getTitle(), "Logowanie - GARDEN STORE");
	}

	public void pobierzDate() throws ParseException {
		
		
		String dateInString = data.xlsGetValue("Data_urodzenia");		
		String[] tablica = dateInString.split("-");
		dzien = tablica[0];
		miesiac = tablica[1]; 
		rok = tablica[2];
	
	}

	@Test(priority = 1)
	public void zalozenieKonta() throws TafException, ParseException {

		data.xlsSetAsCurrentUnlockedRow();
		user = data.xlsGetValue("Email");
		pass = data.xlsGetValue("Haslo");
		pobierzDate();		
		
		txtStworzKonto_AdresEmail.setText(user);
		System.out.println("");
		btnStworzKonto.click();

		Assert.assertTrue(winStronaLogowania.assertText("STWÓRZ KONTO"));

		rbPan.click();
		txtSK_imie.setText(data.xlsGetValue("Imie"));
		txtSK_nazwisko.setText(data.xlsGetValue("Nazwisko"));
		txtSK_haslo.setText(pass);
		cbSK_DzienUrodzenia.selectByValue(dzien);
		cbSK_MiesiacUrodzenia.selectByValue(miesiac);
		cbSK_RokUrodzenia.selectByValue(rok);
		chbSK_Newsletter.click();
		chbSK_Promo.click();
		btnSK_ZarejestrujSie.click();

		data.xlsSetRowAsLocked();
		Assert.assertTrue(winStworzKonto.assertText("Twoje konto zosta³o utworzone."));
		data.xlsSetValue("Sukces", "Tak");
				
	}

	@Test(priority = 2)
	public void wylogujSie() throws TafException {
		btnWyloguj.click();
	}

	@Test(priority = 3)
	public void zalogujSie() throws TafException {
		if (!browser.getTitle().equals("Logowanie - GARDEN STORE")) {
			btnLogin.click();
		}

		txtLog_AdresEmail.setText(user);
		txtLog_Haslo.setText(pass);
		btnLog_ZalogujSie.click();

		Assert.assertEquals(browser.getTitle(), "Moje konto - GARDEN STORE");
	}

	@BeforeTest
	public void beforeTest() {
		data.xlsImportWorkbook("D:/DyskGoogle/TestWarez-ForEvo/dane_testowe.xls");
		data.xlsSetCurrentSheet("Konta");

		runBrowser(Browser.Chrome, url);
		browser.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		data.xlsSaveWorkbook("D:/DyskGoogle/TestWarez-ForEvo/dane_testowe.xls");
		browser.quit();
	}

}
