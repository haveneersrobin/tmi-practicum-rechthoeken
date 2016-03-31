import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robin on 31/03/16.
 */
public class FirstAlgorithm {

    // Empty constructor
    public FirstAlgorithm() {}

    private boolean contains(Rectangle r1, Rectangle r2) {
        if(r1.getLoX() < r2.getLoX() &&
                r1.getLoY() < r2.getLoY() &&
                r1.getRbX() > r2.getRbX() &&
                r1.getRbY() > r2.getRbY()
                ) {
            return true;
        } else if(r1.getLoX() > r2.getLoX() &&
                r1.getLoY() > r2.getLoY() &&
                r1.getRbX() < r2.getRbX() &&
                r1.getRbY() < r2.getRbY()
                ) {
            return true;
        }
        return false;
    }

    public ArrayList<Point> calculateIntersection(Rectangle r1, Rectangle r2) {
        ArrayList<Point> intersectingPoints = new ArrayList<>();
        if(!contains(r1, r2) {
            if(r1.get)
        }

    }




}
