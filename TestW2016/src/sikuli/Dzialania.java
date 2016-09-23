package sikuli;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

public class Dzialania {
	public App kalkulator;
	public Screen ekran;
	
	
	@BeforeTest
	public void beforeTest() {
	kalkulator = App.open("calc.exe");
	ekran = new Screen();
	Settings.MoveMouseDelay=0.1f;
	Settings.OcrTextSearch=true;
	//Settings.MinSimilarity=0.7;
	Settings.OcrTextRead=true;
	}

	@AfterTest
	public void afterTest() {
		App.close("Kalkulator");
	}

	@Test(priority=0)
	public void dodawanie() throws FindFailed {
		ekran.find("sikuliobj/1.png").click();
		ekran.find("sikuliobj/2.png").click();
		ekran.find("sikuliobj/3.png").click();
		
		Pattern dodaj = new Pattern("sikuliobj/dodaj.png");
		ekran.find(dodaj.similar(0.99f)).click();
		
		ekran.find("sikuliobj/4.png").click();
		ekran.find("sikuliobj/5.png").click();
		ekran.find("sikuliobj/6.png").click();
	}
	
	@Test(priority=1)
	public void mnozenie() throws FindFailed {
				
		ekran.find("sikuliobj/mnozenie.png").click();		
		ekran.find("sikuliobj/7.png").click();
		ekran.find("sikuliobj/8.png").click();
		
	}
	
	@Test(priority=2)
	public void dzielenie() throws FindFailed {
		Pattern dzielenie = new Pattern("sikuliobj/dzielenie.png");		
		ekran.find(dzielenie.similar(0.99f)).click();
		
		ekran.find("sikuliobj/9.png").click();		
		
		
	}	
	
	@Test(priority=3)
	public void odejmowanie() throws FindFailed {
		
		ekran.find("sikuliobj/odejmij.png").click();
		ekran.find("sikuliobj/5.png").click();
		ekran.find("sikuliobj/0.png").click();
		ekran.find("sikuliobj/2.png").hover();
		ekran.find("sikuliobj/0.png").click();
		ekran.find("sikuliobj/2.png").hover();
		ekran.find("sikuliobj/0.png").click();
	}
	
	@Test(priority=4)
	public void wynik() throws FindFailed{
		
		//klikniêcie na przycisk równoœci
		ekran.find("sikuliobj/rownosci.png").click();
		
		Pattern p = new Pattern("sikuliobj/wynik.png").similar(0.6f);
		String wynik = ekran.find(p).text();
		System.out.println(wynik);
		
		Assert.assertEquals(wynik, "18");
	}
	

}
