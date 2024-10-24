package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Defina o caminho do chromedriver aqui
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

            // Configurações do Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Opção para iniciar maximizado
            // options.addArguments("--headless"); // Descomente para rodar em modo headless

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
