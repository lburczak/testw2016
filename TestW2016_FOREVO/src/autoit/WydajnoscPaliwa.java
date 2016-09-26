package autoit;

import autoit.maps.WydajnoscPaliwaMap;
import fp.forevo.manager.TafException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WydajnoscPaliwa extends WydajnoscPaliwaMap {
	public String actualTitle = null;

	@Test(priority=0)
	public void sprawdzTytul() {		
		Assert.assertEquals(actualTitle, "Kalkulator");
	}
	
	@Test(priority=1)
	public void uruchomWydajnoscPaliwa() throws InterruptedException {
		autoIt.winActivate(actualTitle);
		
		// Naciœniêcie przycisku ALT+W
		autoIt.send("!{W}",false);		
		sleep(0.5);
		
		// Naciœniêcie przycisku A przy trzymanym ALT
		autoIt.send("{A}",false);
		sleep(0.5);
		
		// Naciœniêcie przycisku A przy trzymanym ALT
		autoIt.send("{A}",false);		
	}
	
	@Test(priority=2)
	public void wpiszParametry() throws InterruptedException, TafException {
		sleep(0.5);
		txtOdleglosc.setText("1000");
		sleep(0.5);
		txtZuzytePaliwo.setText("50");
		sleep(0.5);
		btnOblicz.click();				
	}
	
	@Test(priority=3)
	public void sprawdzWynik(){
		String wynik = txtWynikObliczen.getText();
		Assert.assertEquals(wynik, "5");
	}
	
	@Test(priority=4)
	public void uruchomWidokPodstawowy() throws InterruptedException {
		winKalkulator.activate();
		
		autoIt.send("!{W}",false);
		Thread.sleep(1000);
		autoIt.send("{P}",false);		
	}

	@BeforeTest
	public void beforeTest() {
		runApp("calc.exe");
		winKalkulator.activate();
		actualTitle = autoIt.winGetTitle("[ACTIVE]");
		autoIt.winActivate(actualTitle);
		autoIt.winWaitActive(actualTitle);
		
	}

	@AfterTest
	public void afterTest() {
		//winKalkulator.close();
	}

}
