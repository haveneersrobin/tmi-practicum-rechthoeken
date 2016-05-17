import org.w3c.dom.css.Rect;

import java.util.ArrayList;

/**
 * Created by Robin on 31/03/16.
 */
public class FirstAlgorithm {

    public FirstAlgorithm() {}

    public ArrayList<ArrayList<Point>> calculateIntersections(ArrayList<Rectangle> rectangles) {
        ArrayList<ArrayList<Point>> allIntersections = new ArrayList<>();
        for(Rectangle r : rectangles) {
            for(Rectangle s : rectangles){
                if( r != s){
                    allIntersections.add(r.intersections(s));
                }
            }
        }
        return allIntersections;
    }

    /*public ArrayList<ArrayList<Point>> calculateIntersections(ArrayList<Rectangle> rectangles) {
        ArrayList<ArrayList<Point>> allIntersections = new ArrayList<>();
        int length = rectangles.size();
        for(int i = 0; i < length; i++) {
            for(int j = i; j < length; j++) {
                if(rectangles.get(i) != rectangles.get(j)){
                    allIntersections.add(rectangles.get(i).intersections(rectangles.get(j)));
                }
            }
        }
        return allIntersections;
    }*/
}
