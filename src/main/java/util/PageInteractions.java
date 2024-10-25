package util;

import drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class PageInteractions {

    static WebDriver driver = DriverManager.getDriver();

    //Método para clicar no elemento com tratativa de exceções
    public static void clickOnElement(WebElement element, long timeoutInSecond){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond)); // Define o tempo de espera

        try {
            // Espera o botão ser clicável
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            // Tratamento para quando o botão não estiver clicável dentro do tempo
            throw new TimeoutException ("O elemento "+element+" não estava disponível para clique após o tempo de espera.");
        } catch (NoSuchElementException e) {
            // Tratamento para quando o elemento não for encontrado
            throw new NoSuchElementException("O elemento "+element+" não foi encontrado na página.");
        } catch (ElementNotInteractableException e) {
            // Tratamento para quando o botão estiver presente, mas não puder ser clicado
            throw new ElementNotInteractableException("O elemento "+element+" está presente, mas não pode ser clicado.");
        } catch (Exception e) {
            // Tratamento geral para qualquer outra exceção inesperada
            throw new RuntimeException("Ocorreu um erro inesperado ao tentar clicar no elemento O elemento "+element+".", e);
        }
    }
    //Valida se a lista de elementos está em ordem alfabética
    public static boolean validateOrderTextFromAList(List<WebElement> elements){

        // Extrai o texto de cada WebElement
        List<String> texts = elements.stream()
                .map(WebElement::getText) // Mapeia os WebElements para os textos
                .collect(Collectors.toList());

        // Verifica se a lista de textos está em ordem alfabética
        return texts.stream()
                .sorted() // Ordena os textos
                .collect(Collectors.toList()) // Coleta a lista ordenada
                .equals(texts); // Compara com a lista original de textos

    }

    public static void removeElementsStartingWithThreeSpaces(List<WebElement> elements) {
        elements.removeIf(element -> element.getText().startsWith(" "));
    }

    public static void selectAndClickByVisibleText(WebElement element, String visibleText) {

        // Cria um objeto Select para interagir com a lista
        Select select = new Select(element);

        // Seleciona o item pelo texto visível
        select.selectByVisibleText(visibleText);

        // Opcional: Obtém o item selecionado e clica nele
        WebElement selectedOption = select.getFirstSelectedOption();
        selectedOption.click();
    }

    public static void setText(WebElement inputField, String text) {

        // Limpa o campo de texto antes de inserir o novo valor (opcional)
        inputField.clear();

        // Insere o texto no campo de entrada
        inputField.sendKeys(text);
    }

    public static boolean isTextPresentInElements(List<WebElement> elements, String text) {
        // Itera sobre a lista de WebElements e verifica se algum deles contém o texto
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public static void clickAtOffset(String dropdown, int offsetX, int offsetY) {
        // Cria uma instância de Actions para realizar o clique

        WebElement dropdownElement = driver.findElement(By.xpath(dropdown));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(dropdownElement));
        Actions actions = new Actions(driver);

        // Calcula a posição do elemento
        int x = dropdownElement.getLocation().getX() + offsetX; // Adiciona o deslocamento ao X do elemento
        int y = dropdownElement.getLocation().getY() + offsetY; // Posição Y do elemento

        // Move o mouse até a posição calculada e clica
        boolean success = false;
        int attempts = 0;

        while (!success && attempts < 3) {
            try {
                // Atualiza a página e espera que o dropdown esteja visível
//                driver.navigate().refresh();
//                wait.until(ExpectedConditions.visibilityOf(dropdownElement));

                // Tenta clicar no elemento
                actions.moveByOffset(x, y).click().perform();
                success = true; // Se não ocorrer uma exceção, a ação foi bem-sucedida
            } catch (StaleElementReferenceException e) {
                // Captura StaleElementReferenceException e tenta novamente
                dropdownElement = driver.findElement(By.xpath(dropdown)); // Altere para o seletor correto
                attempts++; // Incrementa o número de tentativas
            } catch (MoveTargetOutOfBoundsException e) {
                // Captura MoveTargetOutOfBoundsException e tenta novamente
                dropdownElement = driver.findElement(By.xpath(dropdown)); // Altere para o seletor correto
                attempts++; // Incrementa o número de tentativas
            }

            // Aguarda novamente a visibilidade do dropdown após as exceções
         //   wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        }


    }}

