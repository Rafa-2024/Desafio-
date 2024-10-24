package util.js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static drivers.DriverManager.driver;


public class ScriptExecutor {

    public static void clickUsingJavaScript(WebElement element) {

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            // Executa um clique no elemento usando JavaScript
            jsExecutor.executeScript("arguments[0].click();", element);
        }


    public static void clickOnAListUsingScroll(List<WebElement> options, String optionText){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Encontra a opção desejada e realiza o scroll até ela
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                // Rola até a opção desejada
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);
                // Clique na opção se desejado
                option.click(); // Clica na opção, se necessário
                break; // Sai do loop após encontrar e rolar para a opção
            }
        }

    }

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    // Obtém as opções do dropdown

}

