import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Robin on 16/05/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Eerste argument is hoeveel rechthoeken, tweede algoritme is welk algoritme
        ArrayList<String> coordinates = generateRandomRectanlges(Integer.parseInt(args[0]));
        long size = coordinates.size();
        String algorithm = args[1];
        coordinates.add(0, String.valueOf(size));
        coordinates.add(0, algorithm);
        Path file = Paths.get("/Users","/Robin","/Developer","/TMIPracticumSnijdendeRechthoeken","/Calculator","/out","/artifacts","/Calculator_jar","/data.txt");
        Files.write(file, coordinates, Charset.forName("UTF-8"));
    }

    public static ArrayList<String> generateRandomRectanlges(long size) {
        Random random = new Random();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < size; i ++) {
            int x1 = random.nextInt(100);
            int y1 = random.nextInt(100);
            int x2 = random.nextInt(100 - x1) + x1;
            int y2 = random.nextInt(100 - y1) + y1;
            double x1D = x1/100.0;
            double x2D = x2/100.0;
            double y1D = y1/100.0;
            double y2D = y2/100.0;
            result.add(x1D + " " + y1D + " " + x2D + " " + y2D );
        }
        return result;
    }

    private static double getRandomValue(final double lowerBound, final double upperBound, final Random random) {

        if (lowerBound < 0 || upperBound <= lowerBound ) {
            throw new IllegalArgumentException("Put error message here");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;

        return dbl;
    }
}
