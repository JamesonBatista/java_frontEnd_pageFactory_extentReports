package steps;

import PageObject.page_Google;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import runner.FrameWorkSystem;

import java.io.IOException;

public class google {
    Scenario status;
    page_Google google;
    FrameWorkSystem frame;

    @Before
    public void init(Scenario scenario) {
        status = scenario;
    }

    @Given("que seja acessado o site {string}")
    public void queSejaAcessadoOSite(String url) throws IOException, InterruptedException {
        google = PageFactory.initElements(FrameWorkSystem.setDriver(url), page_Google.class);
        google.titlePage(status);
    }


    @When("for efetuado pesquisa sobre {string}")
    public void forEfetuadoPesquisaSobre(String search) throws IOException, ClassNotFoundException {
        google.Search(search);

    }

    @Then("o primeiro link deve ser acessado")
    public void oPrimeiroLinkDeveSerAcessado() throws IOException {
        google.clickLink();
    }

    @After
    public void after() throws IOException {
        frame = new FrameWorkSystem(status, Status.FAILED);

    }
}
