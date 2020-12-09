package PageObject;

import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.FrameWorkSystem;

import java.io.IOException;

public class page_Outline {
    static WebDriver title;
    FrameWorkSystem frame;
    String textTitle;

    public page_Outline(WebDriver driver) {
        PageFactory.initElements(driver, this);
        title = driver;
    }

    @FindBy(xpath = "//*[@id=\"shellmenu_0\"]")
    WebElement microsoft;

    @FindBy(xpath = "//*[@id=\"menuHorizontal\"]/ul/li[3]/a")
    WebElement youtubeClick;

    @FindBy(xpath = "//*[@id=\"home-menu\"]/li[2]/div[1]/a/span[1]")
    WebElement globoClick;

    public void openPage(Scenario scenario) throws IOException {
        frame = new FrameWorkSystem(scenario);
        frame.Test(Given.getGherkinName());

    }

    public void VerifyTitle(String urlTitle) throws IOException {
        textTitle = urlTitle;
        Assert.assertEquals(urlTitle, title.getTitle());
        frame.Test(When.getGherkinName());
    }

    public void clickLink() throws IOException, InterruptedException {
        if (textTitle.contains("globo")) {

            globoClick.click();
            Thread.sleep(3000);
            frame.Test(Then.getGherkinName());

        } else if (textTitle.contains("YouTube")) {

            youtubeClick.click();
            Thread.sleep(3000);
            frame.Test(Then.getGherkinName());

        } else if (textTitle.contains("Microsoft")) {

            microsoft.click();
            Thread.sleep(3000);
            frame.Test(Then.getGherkinName());
        }
    }
}
