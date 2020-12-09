package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.CurrentStep;
import util.ScreenshotReporter;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class FrameWorkSystem {

    static ExtentReports extent;
    static ExtentTest test;
    static WebDriver driver;
    static String textStep;
    static FileReader fileReader;
    static BufferedReader reader;
    Scenario bdd;

    public static void init() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reporter\\reporter.html");
        reporter.config().setDocumentTitle("Reporter");
        reporter.config().setReportName("All Tests");
        reporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("User test Executing", System.getProperty("os.name").toUpperCase());
        extent.setSystemInfo("System Operation", System.getProperty("user.name").toUpperCase());
    }

    public FrameWorkSystem(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        bdd = scenario;
    }


    public static WebDriver setDriver(String url) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void Test(String typeStep) throws IOException {

//        fileReader = new FileReader("file.txt");
//        reader = new BufferedReader(fileReader);
//        while ((textStep = reader.readLine()) != null) {
//            if (textStep.contains(typeStep)) {
        test.pass(CurrentStep.Test(typeStep) + "<br><font color=Lime> " + Status.PASSED + " </font></br>");
        test.addScreenCaptureFromPath(capture(), "<br><font color=Lime> " + typeStep + " Click open Screenshot </font></br>");
//            }
//        }
    }

    public FrameWorkSystem(Scenario scenario, Status status) throws IOException {
        if (scenario.isFailed()) {
            test.fail("<br><font color=red> " + status + " </font></br>");
            test.addScreenCaptureFromPath(capture(), "<br><font color=red> " + status + " Click open Screenshot </font></br>");
        }
        extent.flush();
        driver.quit();
        FileOutputStream writer = new FileOutputStream("file.txt");

    }

    public static String capture() throws IOException {
        return ScreenshotReporter.Screenshot(driver);

    }

    public static void remover(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; ++i) {
                remover(files[i]);
            }
        }
        f.delete();
    }

}
