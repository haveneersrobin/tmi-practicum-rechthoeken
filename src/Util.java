import java.io.*;
import java.util.ArrayList;

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
            System.out.println(line);
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
}
