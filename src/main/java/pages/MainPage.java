package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageInteractions;

import java.util.List;

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
        PageInteractions.clickOnElement(driver.findElement(By.xpath("//select[@name='"+name+"']")), 8);
    }

    public boolean validatePageOrderTextFromSearchList() {

        PageInteractions.removeElementsStartingWithThreeSpaces(optionsFromSearchList);

        return PageInteractions.validateOrderTextFromAList(optionsFromSearchList);
    }

    public void clickOnAnOptionFromSearchDropdown(String optionToCLick){

        PageInteractions.selectAndClickByVisibleText(dropdownFromSearchList, optionToCLick);

    }

    public void setTextOnField(String text){
        PageInteractions.setText(searchBoxFromHeader, text);
    }

    public boolean verifyAutoCompletedListFromSearcher(String completedText) {
        return PageInteractions.isTextPresentInElements(listFromSearchingBox, completedText);
    }
}
