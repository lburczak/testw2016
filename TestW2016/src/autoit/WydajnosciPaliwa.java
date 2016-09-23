package autoit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.sikuli.script.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.awt.RenderingHints.Key;
import java.io.File;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

public class WydajnosciPaliwa {
	public AutoItX autoit=null;
	public String actualTitle = null;
		
	@BeforeTest
	public void beforeTest() {
		String jacobDllVersionToUse;

		if (jvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
		} else {
			jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
		}
		File file = new File("C:\\Program Files\\ForProgress\\ForEVO\\drivers\\", jacobDllVersionToUse);
		
		System.out.println(jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		autoit = new AutoItX();
		autoit.run("calc.exe");
		actualTitle = autoit.winGetTitle("[ACTIVE]");
		autoit.winActivate(actualTitle);
		autoit.winWaitActive(actualTitle);
	}

	@AfterTest
	public void afterTest() {
		autoit.winClose(actualTitle);
	}
	
	@Test(priority=0)
	public void sprawdzTytul() {
		
		Assert.assertEquals(actualTitle, "Kalkulator");
	}
	
	@Test(priority=1)
	public void uruchomWydajnoscPaliwa() throws InterruptedException {
		autoit.winActivate(actualTitle);
		
		// Naciœniêcie przycisku ALT+W
		autoit.send("!{W}",false);		
		Thread.sleep(1000);
		
		// Naciœniêcie przycisku A przy trzymanym ALT
		autoit.send("{A}",false);
		Thread.sleep(1000);
		
		// Naciœniêcie przycisku A przy trzymanym ALT
		autoit.send("{A}",false);		
	}
	
	@Test(priority=2)
	public void wpiszParametry() throws InterruptedException {
		Thread.sleep(500);
		autoit.ControlSetText(actualTitle, "", "[CLASS:Edit; INSTANCE:1]", "1000");
		Thread.sleep(500);
		autoit.ControlSetText(actualTitle, "", "[CLASS:Edit; INSTANCE:2]", "50");
		Thread.sleep(500);
		autoit.controlClick(actualTitle, "", "[CLASS:Button; INSTANCE:29]");
				
	}
	@Test(priority=3)
	public void sprawdzWynik(){
		String wynik = autoit.controlGetText(actualTitle, "", "[CLASS:Edit; INSTANCE:7]");
		Assert.assertEquals(wynik, "5");
	}
	
	@Test(priority=4)
	public void uruchomWidokPodstawowy() throws InterruptedException {
		autoit.winActivate(actualTitle);
		
		autoit.send("!{W}",false);
		Thread.sleep(1000);
		autoit.send("{P}",false);		
	}

	/**
	 *
	 * Funkcja zwraca wersjê JVM (32 bitowa albo 64 bitowa wersja)
	 */
	public String jvmBitVersion() {
		return System.getProperty("sun.arch.data.model");
	}
}
