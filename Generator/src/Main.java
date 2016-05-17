import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Robin on 16/05/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Eerste argument is hoeveel rechthoeken, tweede algoritme is welk algoritme
        ArrayList<String> coordinates = generateRandomRectanlges(Integer.parseInt(args[0]));
        int size = coordinates.size();
        String algorithm = args[1];
        coordinates.add(0, String.valueOf(size));
        coordinates.add(0, algorithm);
        Path file = Paths.get("/Users","/Robin","/Developer","/TMIPracticumSnijdendeRechthoeken","/Calculator","/out","/production","/data.txt");
        Files.write(file, coordinates, Charset.forName("UTF-8"));
    }

    public static ArrayList<String> generateRandomRectanlges(int size) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < size; i ++) {
            double x1 = (double) Math.round(ThreadLocalRandom.current().nextDouble(0,1) * 100) / 100;
            double y1 = (double) Math.round(ThreadLocalRandom.current().nextDouble(0,1) * 100) / 100;
            double x2 = -1.0;
            while(!(x2 > (x1+0.05))) {
                x2 = (double) Math.round(ThreadLocalRandom.current().nextDouble(0,1) * 100) / 100;
            }
            double y2 = -1.0;
            while(!(y2 > (y1+0.05))) {
                y2 = (double) Math.round(ThreadLocalRandom.current().nextDouble(0,1) * 100) / 100;
            }
            result.add(x1 + " " + y1 + " " + x2 + " " + y2);
        }
        return result;
    }
}
