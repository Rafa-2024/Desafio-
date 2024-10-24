package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import drivers.DriverManager;

public class Hook {

    @Before
    public void abrirNavegador() {
        // Inicializa o driver antes de cada cenário
        DriverManager.getDriver();
        System.out.println("Navegador aberto.");
    }

    @After
    public void fecharNavegador() {
        // Fecha o driver após cada cenário
        DriverManager.closeDriver();
        System.out.println("Navegador fechado.");
    }

}
