import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Robin on 13/04/16.
 */
public final class Util {

    private Util() {

    }

    public static ArrayList<Rectangle> parseInput(BufferedReader file) throws IOException{
        file.readLine();
        ArrayList<Rectangle> result = new ArrayList<>();

        String line;
        while((line = file.readLine())!=null) {
            result.add(Util.parseLine(line));
        }

        return result;
    }

    private static Rectangle parseLine(String line) {
        String[] splitted = line.split("\\s+");
        double[] coordinates = new double[4];
        for(int i=0; i<splitted.length; i++) {
            coordinates[i] = Double.parseDouble(splitted[i]);
        }
        return new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
    }

    public static ArrayList<Rectangle> generateRandomRectanlges(int size) {
        ArrayList<Rectangle> result = new ArrayList<>();
        for(int i = 0; i < size; i ++) {
            double x1 = ThreadLocalRandom.current().nextDouble(0,1);
            double y1 = ThreadLocalRandom.current().nextDouble(0,1);
            double x2 = -1.0;
            while(x2 < x1) {
                x2 = ThreadLocalRandom.current().nextDouble(0,1);
            }
            double y2 = -1.0;
            while(y2 < y1) {
                y2 = ThreadLocalRandom.current().nextDouble(0,1);
            }
            result.add(new Rectangle(x1,x2,y1,y2));
        }
        return result;
    }
}
