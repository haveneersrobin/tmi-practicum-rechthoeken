import java.util.ArrayList;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String algorithm = br.readLine();

        ArrayList<Rectangle> rectangles;
        rectangles = Util.parseInput(br);
        br.close();

        FirstAlgorithm algo1 = new FirstAlgorithm();
        ArrayList<ArrayList<Point>> intersections = algo1.calculateIntersections(rectangles);

        ArrayList<Point> result = new ArrayList<>();
        for(ArrayList<Point> p : intersections) {
            for(Point point : p ) {
                result.add(point);
            }
        }
        Set<Point> pointSet = new HashSet<>();
        pointSet.addAll(result);
        result.clear();
        result.addAll(pointSet);
        for(Point point : pointSet) {
            System.out.println(point);
        }
    }
}
