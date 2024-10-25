package pages;

import drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.js.ScriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageInteractions;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class MainPage {

    WebDriver driver = DriverManager.getDriver();

    @FindBy(xpath = "//select[@name='url']/option")
    List<WebElement> optionsFromSearchList;

    @FindBy(xpath = "//select[@name='url']")
    WebElement dropdownFromSearchList;


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBoxFromHeader;

    @FindBy(xpath="//*[contains(@class, 'autocomplete-results-container')]//div[@role='button']")
    List<WebElement> listFromSearchingBox;


    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    //Método para clicar em uma caixa de seleção passando o atributo name como parâmetro
    public void clickNameOnOptionButton(String name, long timeoutInSecond) {
        PageInteractions.clickOnElement(driver.findElement(By.xpath("//select[@name='"+name+"']")), timeoutInSecond);
    }

    public void clickAtOffsetPage() {
      //  PageInteractions.clickOnElement(driver.findElement(By.xpath("//select[@name='"+name+"']")), timeoutInSecond);

       PageInteractions.clickAtOffset("//select[@name='url']", 2, 20);
    }

    public void expandDropdownList(){
        String script = "arguments[0].setAttribute('class', arguments[0].getAttribute('class') + ' expanded');";
        ((JavascriptExecutor) driver).executeScript(script, dropdownFromSearchList);
    }

    public boolean validatePageOrderTextFromSearchList() {

        PageInteractions.removeElementsStartingWithThreeSpaces(optionsFromSearchList);

        for(WebElement option: optionsFromSearchList){
            System.out.println(option.getText());
        }

        return PageInteractions.validateOrderTextFromAList(optionsFromSearchList);
    }

    public void clickOnAnOptionFromSearchDropdown(String optionToCLick){

        PageInteractions.selectAndClickByVisibleText(dropdownFromSearchList, optionToCLick);

    }

    public void setTextOnField(String text){
        PageInteractions.setText(searchBoxFromHeader, text);
    }

    public boolean verifyAutoCompletedListFromSearcher(String completedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Move o mouse até a posição calculada e clica
        boolean success = false;
        int attempts = 0;

        while (!success && attempts < 3) {
            try {
                wait.until(ExpectedConditions.visibilityOfAllElements(listFromSearchingBox));
                attempts++;
            } catch (StaleElementReferenceException e) {
                listFromSearchingBox = driver.findElements(By.xpath("//*[contains(@class, 'autocomplete-results-container')]//div[@role='button']"));
                attempts++;
            }
        }

        return PageInteractions.isTextPresentInElements(listFromSearchingBox, completedText);
    }

    public void clickOnElementUsingJS(String option) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(optionsFromSearchList));
        ScriptExecutor.clickOnAListUsingScroll(optionsFromSearchList, option);

    }

    public void clickOnLinkInMenuHeader(String link) {

        PageInteractions.clickOnElement(driver.findElement(By.xpath("//div[contains(@id,'nav-xshop')]//*[contains(text(),'"+link+"')]")), 15);

    }

    public boolean validateElement(String expectedTitle) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(29));
        wait.until(ExpectedConditions.titleContains(expectedTitle));

        // Verifica se o elemento esperado está presente na página carregada

        return Objects.requireNonNull(driver.getTitle()).contains(expectedTitle);

    }
}
