package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CurrentStep {
    static String textStep;
    static String str;
    static FileReader fileReader;
    static BufferedReader reader;

    public static String Test(String typeStep) throws IOException {

        fileReader = new FileReader("file.txt");
        reader = new BufferedReader(fileReader);
        while ((textStep = reader.readLine()) != null) {
            if (textStep.contains(typeStep)) {
                str = textStep;
            }
        }
        return str;

    }
}
