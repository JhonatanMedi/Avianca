package Avianca.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Avianca.Steps.ButtonPages;
import Avianca.Steps.ElementsPage;

import Avianca.Steps.UtilityPage;

import net.thucydides.core.annotations.Step;

public class SelectFlightPage {

	private WebDriver driver;
	private ButtonPages buttonPages;

	private UtilityPage utilityPage;
	private ElementsPage elementsPage;

	public SelectFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.buttonPages = new ButtonPages(driver);
		this.utilityPage = new UtilityPage(driver);
		this.elementsPage = new ElementsPage(driver);

	}

	@Step
	public void selectFlightM() {

		buttonPages.btnSelectFligh();
		elementsPage.scrollDown();
		buttonPages.btnSelectPrice();

		List<WebElement> pr = driver.findElements(By.id("mat-dialog-0"));
		if (pr.size() > 0) {
			buttonPages.btnWantM();

		}

	}

	@Step
	public void flightInformationM() {

		utilityPage.alert();
		driver.switchTo().alert().accept();
		driver.close();

	}
}
