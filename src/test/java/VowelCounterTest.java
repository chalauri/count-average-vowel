import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.assertEquals;

/**
 * Created by G.Chalauri on 3/11/2017.
 */
public class VowelCounterTest {
    @Test
    public void averageVowelTest() throws IOException {
        VowelCounter tester = new VowelCounter(); // MyClass is tested

        assertEquals(tester.averageVowel("INPUT.TXT"), buildResult2());

        assertEquals(tester.averageVowel("INPUT2.TXT"), buildResult());


      /*  Files.write(Paths.get("test-input.txt"), "Giga, who is programmer is working doing aoeas01010".getBytes("utf-8"),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

*/
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
