package PageObject;

import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.When;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.FrameWorkSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class page_Globo {
    FrameWorkSystem frame;
    WebDriver title;

    public page_Globo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        title = driver;
    }

    @FindBy(xpath = "//*[@id=\"home-menu\"]/li[1]/div[1]/a/span[1]")
    WebElement click_Link;

    public void titlePage(Scenario scenario) throws IOException {
        frame = new FrameWorkSystem(scenario);

        Assert.assertEquals("globo.com - Absolutamente tudo sobre notícias, esportes e entretenimento", title.getTitle());
        frame.Test(Given.getGherkinName());

    }

    public void clicLink() throws IOException {

        click_Link.click();
        Assert.assertEquals("G1 - O portal de notícias da Globo", title.getTitle());
        frame.Test(When.getGherkinName());

    }

}
