package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotReporter {

    public static String Screenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dateFormat = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
        String img = "image" + dateFormat + ".png";
        String path = "./screenshots/" + img;
        FileUtils.copyFile(src, new File("reporter\\screenshots\\" + img));

        return path;

    }
}