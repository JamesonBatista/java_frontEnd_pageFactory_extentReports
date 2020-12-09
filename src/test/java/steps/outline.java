package steps;

import PageObject.page_Outline;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.PageFactory;
import runner.FrameWorkSystem;

import java.io.IOException;

public class outline {
    Scenario status;
    FrameWorkSystem frame;
    page_Outline outline;

    @Before
    public void before(Scenario scenario) {
        status = scenario;
    }

    @Given("que seja acessado a lista de sites {string}")
    public void queSejaAcessadoAListaDeSites(String url) throws IOException, InterruptedException {
        outline = PageFactory.initElements(FrameWorkSystem.setDriver(url), page_Outline.class);
        outline.openPage(status);
    }


    @When("for verificado os titulos {string}")
    public void forVerificadoOsTitulos(String title) throws IOException {
        outline.VerifyTitle(title);

    }

    @Then("uma pagina qualquer dentro do site e acessado")
    public void umaPaginaQualquerDentroDoSiteEAcessado() throws IOException, InterruptedException {
        outline.clickLink();
    }

    @After
    public void after() throws IOException {
        frame = new FrameWorkSystem(status, Status.FAILED);
    }

}
