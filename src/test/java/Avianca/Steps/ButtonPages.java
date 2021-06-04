package Avianca.Steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ButtonPages {

	private WebDriver driver;
	private Questions questions;

	@FindBy(how = How.XPATH, using = "//button[text() = 'Buscar vuelos']")
	private WebElement btnSeachFlight;

	@FindBy(how = How.XPATH, using = "//avail-list-pres//expander-elem[2]/div/div/div/div/div[2]/div[1]/button")
	private WebElement btnSelectFligh;

	@FindBy(how = How.XPATH, using = "//input[@name = 'pbFechaIda']")
	private WebElement btnDatesTravel;

	@FindBy(how = How.XPATH, using = "//mat-dialog-actions/div[2]/button")
	private WebElement btnWantM;

	public ButtonPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);
	}

	public void btnSeachFlight() {
		btnSeachFlight.isDisplayed();
		btnSeachFlight.click();
	}

	public void btnSelectFligh() {
		btnSelectFligh.isDisplayed();
		btnSelectFligh.click();
		questions.impliciWait();

	}

	public void btnSelectPrice() {

		questions.impliciWait();
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class= 'ff-attributes']/button"));
		prices.get(1).click();
		questions.impliciWait();

	}

	public void datesTravelM(String initMothP, String initDayP, String endMothP, String endDayP) {

		questions.tiempoSegundos(1);
		btnDatesTravel.isDisplayed();
		btnDatesTravel.click();

		questions.impliciWait();
		WebElement dateInit = driver.findElement(By.xpath(
				"//div[@id='tab_reservatuvuelo']//section[contains(@class, 'promo-booking')]//div[contains(@class, 'idaYRegreso')]//div[contains(@class, 'calendar-container')]//div[@data-source='ida']//div[@data-day='2021."
						+ initMothP + "." + initDayP + "']"));

		dateInit.isDisplayed();
		dateInit.click();

		questions.tiempoSegundos(1);

		WebElement dateEnd = driver.findElement(By.xpath(
				"//div[@id='tab_reservatuvuelo']//section[contains(@class, 'promo-booking')]//div[contains(@class, 'idaYRegreso')]//div[contains(@class, 'calendar-container')]//div[@data-source='ida']//div[@data-day='2021."
						+ endMothP + "." + endDayP + "']"));
		dateEnd.click();

	}

	public void btnWantM() {
		btnWantM.isDisplayed();
		questions.impliciWait();
		btnWantM.click();
		questions.impliciWait();

	}

}
