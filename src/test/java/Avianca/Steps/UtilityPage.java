package Avianca.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UtilityPage {

	private WebDriver driver;
	private Questions questions;

	public UtilityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);

	}

	public void alert() {

		questions.tiempoSegundos(4);
		WebElement texto = driver.findElement(By.xpath("//bound-displayer-pres/div"));

		String texto2 = texto.getText();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Vuelo Seleccionado: " + texto2.replace("\n", " ,") + "');");
		questions.tiempoSegundos(1);
	}

}
