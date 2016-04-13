import java.util.ArrayList;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String algorithm = br.readLine();

        ArrayList<Rectangle> rectangles;
        rectangles = Util.parseInput(br);
        br.close();

        System.out.println("Rects:" + rectangles);

        FirstAlgorithm algo1 = new FirstAlgorithm();

        ArrayList<Intersections> result = new ArrayList<Intersections>();
        for(Rectangle r1 : rectangles) {
            for(Rectangle r2 :  rectangles) {
                if(r1 != r2) {
                    result.add(algo1.calculateIntersection(r1, r1));
                }
            }
        }

        if(result.size() == 0) {
            System.out.println("No intersections found");
        }
        else {
            System.out.println(result);
            for(Intersections i : result) {
                System.out.println(i.getFirst());
                System.out.println(i.getSecond());
            }
        }

    }
}
