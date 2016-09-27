package sikuli;


import sikuli.maps.DzialaniaForEvo_sposob2Map;


import org.testng.annotations.Test;

import fp.forevo.manager.TafException;

import org.testng.annotations.BeforeTest;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DzialaniaForEvo_sposob2 extends DzialaniaForEvo_sposob2Map {
	@Test(priority = 0)
	public void dodawanie() throws FindFailed, TafException {

		btn1.click();
		btn2.click();
		btn3.click();

		btnDodawanie.click();

		btn4.click();
		btn5.click();
		btn6.click();
	}

	@Test(priority = 1)
	public void mnozenie() throws TafException {
		btnMnozenie.click();
		btn7.click();
		btn8.click();
	}

	@Test(priority = 2)
	public void dzielenie() throws TafException {
		btnDzielenie.click();
		btn9.click();
	}

	@Test(priority = 3)
	public void odejmowanie() throws TafException {
		btnOdejmowanie.click();		
		btn5.click();
		btn0.click();
		btn0.click();
		btn0.click();
	}

	@Test(priority = 4)
	public void wynik() throws TafException {
		btnRownosci.click();
		String wynik = objWynik.getText();
		System.out.println(wynik);
		Assert.assertEquals(wynik, "18");
	}

	@BeforeTest
	public void beforeTest() {
		runApp("calc.exe");
		winKalkulator2.activate();
		setTag("Win81New");
	}

	@AfterTest
	public void afterTest() {
		winKalkulator2.close();
	}

}
