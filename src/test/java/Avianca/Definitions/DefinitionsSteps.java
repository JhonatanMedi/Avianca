package Avianca.Definitions;

import org.openqa.selenium.WebDriver;

import Avianca.Pages.SearchFlightPage;
import Avianca.Pages.SelectFlightPage;
import Avianca.Steps.Connection;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionsSteps {

	private WebDriver driver;
	private Connection connection = new Connection();
	private SearchFlightPage searchFlightPage = new SearchFlightPage(driver);
	private SelectFlightPage selectFlightPage = new SelectFlightPage(driver);

	@Given("^open browser page Avianca$")
	public void abrir_navegador() {
		this.connection = new Connection();
		this.driver = this.connection.openBrowser();

	}

	@And("^search Flight from (.*) and destination (.*)$")
	public void searchFligth(String outPutP, String destinationP) {
		this.searchFlightPage = new SearchFlightPage(driver);
		this.searchFlightPage.fillOutFormM(outPutP, destinationP);

	}

	@And("^select date start month (.*) start day (.*) by the end of the month (.*) by the end of the day (.*)$")
	public void searchDates(String initMothP, String initDayP, String endMothP, String endDayP) {
		this.searchFlightPage = new SearchFlightPage(driver);
		this.searchFlightPage.selectDatesTravelM(initMothP, initDayP, endMothP, endDayP);

	}

	@When("^select second flight$")
	public void selectFlight() {
		this.selectFlightPage = new SelectFlightPage(driver);
		this.selectFlightPage.selectFlightM();
	}
	
	@Then("^show the flight information$")
	public void information() {
		this.selectFlightPage.flightInformationM();
	}

}