package autoit.maps;

import fp.forevo.manager.MasterScript;
import fp.forevo.manager.TestObjectManager;
import fp.forevo.proxy.*;

/**
 * Class generated automaticaly. Do not edit from text editor. Change it using Test Object Manager.
 * @author Test Object Manager by ForProgress
 * @see www.forprogress.com.pl
 * @since 2016-09-27 00:32:39
 */
public class WydajnoscPaliwaMap extends MasterScript {

	private TestObjectManager tomgr = new TestObjectManager(getProjectPath(this.getClass()), "res/autoit/WydajnoscPaliwa/WydajnoscPaliwa.map");

	/**
	 * <b>Description:</b> Okno kalkulatora systemu windows
	 */
	protected Window winKalkulator = getWindow(tomgr, "winKalkulator");

	/**
	 * <b>Description:</b> Pole do wpisania odleg³oœci<br/><br/>
	 * <b>Driver:</b> AutoIt<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> [CLASS:Edit; INSTANCE:1]<br/>
	 */
	protected TextBox txtOdleglosc = getTextBox(tomgr, winKalkulator, "txtOdleglosc");

	/**
	 * <b>Description:</b> Pole do wpisania zu¿ytego paliwa w litrach<br/><br/>
	 * <b>Driver:</b> AutoIt<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> 246<br/>
	 */
	protected TextBox txtZuzytePaliwo = getTextBox(tomgr, winKalkulator, "txtZuzytePaliwo");

	/**
	 * <b>Description:</b> Przycisk do obliczenia wartoœci<br/><br/>
	 * <b>Driver:</b> AutoIt<br/>
	 * <b>Class:</b> Button<br/>
	 * <b>Target:</b> [CLASS:Button; INSTANCE:29]<br/>
	 */
	protected Button btnOblicz = getButton(tomgr, winKalkulator, "btnOblicz");

	/**
	 * <b>Description:</b> Pole z wynikiem obliczeñ<br/><br/>
	 * <b>Driver:</b> AutoIt<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> 262<br/>
	 */
	protected TextBox txtWynikObliczen = getTextBox(tomgr, winKalkulator, "txtWynikObliczen");

}
