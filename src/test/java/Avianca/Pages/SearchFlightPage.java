package Avianca.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Avianca.Steps.ButtonPages;
import Avianca.Steps.ElementsPage;
import Avianca.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class SearchFlightPage {

	private WebDriver driver;
	private ElementsPage elementsPage;
	private Questions questions;
	private ButtonPages buttonPages;

	@FindBy(how = How.XPATH, using = "//input[@class = 'form-control airport pbOrigen airport_ida airport_mvvn valid']")
	private WebElement inputOutPut;

	@FindBy(how = How.XPATH, using = "//fieldset/div/div[2]/div[2]/div[1]/label/div/input")
	private WebElement inputDestination;

	@FindBy(how = How.XPATH, using = "//input[@data-txt-ida = 'Ida']")
	private WebElement inputDateOutPut;

	@FindBy(how = How.XPATH, using = "///input[@name = 'pbFechaRegreso']")
	private WebElement inputDateReturn;

	public SearchFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementsPage = new ElementsPage(driver);
		this.questions = new Questions(driver);
		this.buttonPages = new ButtonPages(driver);
	}

	@Step
	public void fillOutFormM(String outPutP, String destinationP) {
		questions.impliciWait();
		elementsPage.scrollReserver();

		inputOutPut.clear();
		inputOutPut.sendKeys(outPutP);
		questions.impliciWait();
		inputOutPut.sendKeys(Keys.ARROW_DOWN);
		questions.impliciWait();
		inputOutPut.sendKeys(Keys.ENTER);

		questions.tiempoSegundos(1);
		questions.impliciWait();
		inputDestination.isDisplayed();
		inputDestination.clear();
		inputDestination.sendKeys(destinationP);
		inputDestination.sendKeys(Keys.ARROW_DOWN);
		inputDestination.sendKeys(Keys.ENTER);
		questions.impliciWait();

	}

	@Step
	public void selectDatesTravelM(String initMothP, String initDayP, String endMothP, String endDayP) {

		buttonPages.datesTravelM(initMothP, initDayP, endMothP, endDayP);
		buttonPages.btnSeachFlight();

	}

}
