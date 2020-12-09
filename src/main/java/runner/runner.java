package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"util.GetStep"},
        features = {"features"},
        monochrome = true,
//        tags = "@outline",
        glue = {"steps"}
)
public class runner {

    @BeforeClass
    public static void before() {
        FrameWorkSystem.remover(new File("reporter\\screenshots"));
        FrameWorkSystem.init();
    }

    @AfterClass
    public static void tearDown() throws FileNotFoundException {
    }
}
