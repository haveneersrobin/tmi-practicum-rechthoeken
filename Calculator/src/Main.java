import java.lang.reflect.Array;
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

        System.out.println("Algorithm used: " + algorithm.trim());
        System.out.println("Input file: " + args[0]);
        System.out.println("Running...");

        if(algorithm.trim().equals("1")) {
            FirstAlgorithm algo1 = new FirstAlgorithm();
            ArrayList<Point> list1 = algo1.calculateIntersections(rectangles);
            System.out.println("Number of intersections found: "+list1.size());
            System.out.println("See result file (algo1-result-"+args[0]+") for intersections and execution time.");
        }


        else if(algorithm.trim().equals("2")) {
            SecondAlgorithm algo2 = new SecondAlgorithm(args[0]);
            ArrayList<Point> list2 = algo2.calculateIntersections(rectangles);
            System.out.println("Number of intersections found: "+list2.size());
            System.out.println("See result file (algo2-result-"+args[0]+") for intersections and execution time.");

        }

        else if(algorithm.trim().equals("3")) {
            ThirdAlgorithm algo3 = new ThirdAlgorithm(args[0]);
            ArrayList<Point> list3 = algo3.calculateIntersections(rectangles);
            System.out.println("Number of intersections found: "+list3.size());
            System.out.println("See result file (algo3-result-"+args[0]+") for intersections and execution time.");

        }





    }
}
