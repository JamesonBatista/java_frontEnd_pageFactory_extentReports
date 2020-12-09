package PageObject;

import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.FrameWorkSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class page_Google {
    FrameWorkSystem frame;

    WebDriver title;

    public page_Google(WebDriver driver) {
        PageFactory.initElements(driver, this);
        title = driver;
    }

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement search;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3")
    WebElement clickLink;

    public void titlePage(Scenario scenario) throws IOException {
        frame = new FrameWorkSystem(scenario);
        Assert.assertEquals("Google", title.getTitle());
        frame.Test(Given.getGherkinName());

    }

    public void Search(String text) throws IOException {
        search.click();
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
        frame.Test(When.getGherkinName());

    }

    public void clickLink() throws IOException {
        clickLink.click();
        Assert.assertEquals("Front-end Java - Programação / Java - GUJ", title.getTitle());
        frame.Test(Then.getGherkinName());

    }
}
