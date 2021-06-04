package Avianca.Steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

	private WebDriver driver;
	private Questions questions;

	public ElementsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);

	}

	public void scrollReserver() {

		questions.tiempoSegundos(1);
		WebElement reserver = driver.findElement(By.id("reservatuvuelo"));
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView();", reserver);
		questions.impliciWait();
	}

	public void scrollDown() {

		questions.impliciWait();
		WebElement scroll = driver
				.findElement(By.xpath("//div[1]/fare-comparison-table-cont/fare-comparison-table-pres/div"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> button = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(button.get(3)).build().perform();
		questions.impliciWait();
	}

}
