package selenium.maps;

import fp.forevo.manager.MasterScript;
import fp.forevo.manager.TestObjectManager;
import fp.forevo.proxy.*;

/**
 * Class generated automaticaly. Do not edit from text editor. Change it using Test Object Manager.
 * @author Test Object Manager by ForProgress
 * @see www.forprogress.com.pl
 * @since 2016-09-26 16:15:29
 */
public class ZakladanieKontaForEvoMap extends MasterScript {

	private TestObjectManager tomgr = new TestObjectManager(getProjectPath(this.getClass()), "res/selenium/ZakladanieKontaForEvo/ZakladanieKontaForEvo.map");

	/**
	 * <b>Description:</b> Strona domowa sklepu GardenStore
	 */
	protected Window winHomePage = getWindow(tomgr, "winHomePage");

	/**
	 * <b>Description:</b> Przycisk logowania<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Button<br/>
	 * <b>Target:</b> cssSelector= .header_user_info > .login<br/>
	 */
	protected Button btnLogin = getButton(tomgr, winHomePage, "btnLogin");

	/**
	 * <b>Description:</b> Strona Logowania
	 */
	protected Window winStronaLogowania = getWindow(tomgr, "winStronaLogowania");

	/**
	 * <b>Description:</b> Pole tekstowe do podania adresu email<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> id=email_create<br/>
	 */
	protected TextBox txtStworzKonto_AdresEmail = getTextBox(tomgr, winStronaLogowania, "txtStworzKonto_AdresEmail");

	/**
	 * <b>Description:</b> Przycisk do stworzenia nowego konta<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Button<br/>
	 * <b>Target:</b> id=SubmitCreate<br/>
	 */
	protected Button btnStworzKonto = getButton(tomgr, winStronaLogowania, "btnStworzKonto");

	/**
	 * <b>Description:</b> Okno z formularzeme do tworzenia konta
	 */
	protected Window winStworzKonto = getWindow(tomgr, "winStworzKonto");

	/**
	 * <b>Description:</b> Radio button - Pan<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Element<br/>
	 * <b>Target:</b> id=id_gender1<br/>
	 */
	protected Element rbPan = getElement(tomgr, winStworzKonto, "rbPan");

	/**
	 * <b>Description:</b> <br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Element<br/>
	 * <b>Target:</b> id=id_gender2<br/>
	 */
	protected Element rbPani = getElement(tomgr, winStworzKonto, "rbPani");

	/**
	 * <b>Description:</b> Pole tekstowe do wpisania imienia<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> id=customer_firstname<br/>
	 */
	protected TextBox txtSK_imie = getTextBox(tomgr, winStworzKonto, "txtSK_imie");

	/**
	 * <b>Description:</b> Pole tekstowe do wpisania nazwiska<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> id=customer_lastname<br/>
	 */
	protected TextBox txtSK_nazwisko = getTextBox(tomgr, winStworzKonto, "txtSK_nazwisko");

	/**
	 * <b>Description:</b> Pole tekstowe do wpisania imienia<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> TextBox<br/>
	 * <b>Target:</b> id=passwd<br/>
	 */
	protected TextBox txtSK_haslo = getTextBox(tomgr, winStworzKonto, "txtSK_haslo");

	/**
	 * <b>Description:</b> ComboBox z dniem urodzenia<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> ComboBox<br/>
	 * <b>Target:</b> id=days<br/>
	 */
	protected ComboBox cbSK_DzienUrodzenia = getComboBox(tomgr, winStworzKonto, "cbSK_DzienUrodzenia");

	/**
	 * <b>Description:</b> ComboBox z miesi¹cem urodzenia<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> ComboBox<br/>
	 * <b>Target:</b> id=months<br/>
	 */
	protected ComboBox cbSK_MiesiacUrodzenia = getComboBox(tomgr, winStworzKonto, "cbSK_MiesiacUrodzenia");

	/**
	 * <b>Description:</b> ComboBox z rokiem urodzenia<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> ComboBox<br/>
	 * <b>Target:</b> id=years<br/>
	 */
	protected ComboBox cbSK_RokUrodzenia = getComboBox(tomgr, winStworzKonto, "cbSK_RokUrodzenia");

	/**
	 * <b>Description:</b> Chekbox - Zapisz siê do naszego newsletter<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Element<br/>
	 * <b>Target:</b> cssSelector=#uniform-newsletter > span<br/>
	 */
	protected Element chbSK_Newsletter = getElement(tomgr, winStworzKonto, "chbSK_Newsletter");

	/**
	 * <b>Description:</b> Checkbox - Chcê otrzymywaæ oferty promocyjne od naszych partnerów.<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Element<br/>
	 * <b>Target:</b> cssSelector=#uniform-optin > span<br/>
	 */
	protected Element chbSK_Promo = getElement(tomgr, winStworzKonto, "chbSK_Promo");

	/**
	 * <b>Description:</b> Przycisk potwierdzaj¹cy rejestracjê konta - Zarejestruj siê<br/><br/>
	 * <b>Driver:</b> WebDriver<br/>
	 * <b>Class:</b> Button<br/>
	 * <b>Target:</b> id=submitAccount<br/>
	 */
	protected Button btnSK_ZarejestrujSie = getButton(tomgr, winStworzKonto, "btnSK_ZarejestrujSie");

}
