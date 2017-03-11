import java.io.IOException;

/**
 * Created by G.Chalauri on 3/11/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        VowelCounter vowelCounter = new VowelCounter();
        vowelCounter.averageVowel("INPUT.txt");
    }
}
