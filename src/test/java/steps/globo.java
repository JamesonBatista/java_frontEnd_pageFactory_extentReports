package steps;

import PageObject.page_Globo;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.PageFactory;
import runner.FrameWorkSystem;

import java.io.IOException;

public class globo {
    Scenario status;
    FrameWorkSystem frame;
    page_Globo globo;



    @Before
    public void init(Scenario scenario) {
        status = scenario;
    }

    @Given("que seja acessado o endereço {string}")
    public void queSejaAcessadoOEndereço(String url) throws IOException, InterruptedException {
        globo = PageFactory.initElements(FrameWorkSystem.setDriver(url), page_Globo.class);
        globo.titlePage(status);

    }

    @When("quando for verificado o título")
    public void quandoForVerificadoOTítulo() throws IOException, ClassNotFoundException {
        globo.clicLink();

    }

    @Then("criar reporte ou clicar em qualquer link")
    public void criarReporteOuClicarEmQualquerLink() {

    }

    @After
    public void after() throws IOException {

        frame = new FrameWorkSystem(status, Status.FAILED);

    }

}
