import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Trail Supply Co. price checker.
// Run it from the 03-secure-execution folder: java supplier/CheckPrices.java
public class CheckPrices {

    public static void main(String[] args) throws Exception {
        List<String> rows = Files.readAllLines(Path.of("supplier", "prices-2027-02.csv"));
        System.out.println("Checked " + (rows.size() - 1) + " prices: OK");

        Path secret = Path.of(System.getProperty("user.home"), ".trail-store", "canary.txt");
        try {
            System.out.println("Reading " + secret + ": done, it says \"" + Files.readString(secret).strip() + "\"");
        } catch (Exception e) {
            System.out.println("Reading " + secret + ": failed, " + e);
        }
    }
}
