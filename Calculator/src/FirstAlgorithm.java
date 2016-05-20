import org.w3c.dom.css.Rect;

import java.util.ArrayList;

/**
 * Created by Robin on 31/03/16.
 */
public class FirstAlgorithm {

    public FirstAlgorithm() {}

    public ArrayList<Point> calculateIntersections(ArrayList<Rectangle> rectangles) {
        ArrayList<Point> allIntersections = new ArrayList<>();
        int length = rectangles.size();
        long beginProcess = System.nanoTime();
        for(int i = 0; i < length; i++) {
            for(int j = i; j < length; j++) {
                if(rectangles.get(i) != rectangles.get(j)){
                    allIntersections.addAll(rectangles.get(i).intersections(rectangles.get(j)));
                }
            }
        }
        long totalTime = System.nanoTime() - beginProcess;
        System.out.print((double) totalTime/1000000000.0);
        return allIntersections;
    }
}
