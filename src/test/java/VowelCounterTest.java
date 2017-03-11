import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by G.Chalauri on 3/11/2017.
 */
public class VowelCounterTest {
    @Test
    public void averageVowelTest1() throws IOException {
        VowelCounter tester = new VowelCounter(); // MyClass is tested

        assertEquals(tester.averageVowel("INPUT.TXT", "OUTPUT.TXT"), buildResult2());


        String testText = "Giga, who is programmer is working doing aoeas01010";
        Files.write(Paths.get("test-input.txt"), testText.getBytes("utf-8"),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        tester.averageVowel("test-input.txt", "test-output.txt");
        String testResult = readFile("test-output.txt");


        assertEquals(testResult, buildResult());
    }


    @Test
    public void averageVowelTest2() throws IOException {
        VowelCounter tester = new VowelCounter(); // MyClass is tested

        String testText = "Platon made bamboo boats";
        Files.write(Paths.get("test-input1.txt"), testText.getBytes("utf-8"),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        tester.averageVowel("test-input1.txt", "test-output1.txt");
        String testResult = readFile("test-output1.txt");


        assertEquals(testResult, buildResult2());
    }


    public String readFile(String file) throws IOException {

        Path path = Paths.get(file);
        StringBuilder builder = new StringBuilder();
        try {
            List<String> contents = Files.readAllLines(path);

            for (String content : contents) {
                builder.append(content);
                builder.append(System.lineSeparator());
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }

        return builder.toString();
    }

    private String buildResult() {
        StringBuilder builder = new StringBuilder();
        builder.append("({a, e, o}, 10) -> 3.5");
        builder.append(System.lineSeparator());
        builder.append("({i, o}, 5) -> 2.0");
        builder.append(System.lineSeparator());
        builder.append("({i, o}, 7) -> 2.0");
        builder.append(System.lineSeparator());
        builder.append("({i}, 2) -> 1.0");
        builder.append(System.lineSeparator());
        builder.append("({a, i}, 4) -> 2.0");
        builder.append(System.lineSeparator());
        builder.append("({o}, 3) -> 1.0");
        builder.append(System.lineSeparator());

        return builder.toString();
    }


    private String buildResult2() {
        StringBuilder builder = new StringBuilder();
        builder.append("({a, o}, 5) -> 2.0");
        builder.append(System.lineSeparator());
        builder.append("({a, o}, 6) -> 2.5");
        builder.append(System.lineSeparator());
        builder.append("({a, e}, 4) -> 2.0");
        builder.append(System.lineSeparator());


        return builder.toString();
    }
}
