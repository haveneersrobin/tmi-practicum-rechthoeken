import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Robin on 17/05/16.
 */
public class SecondAlgorithm {

    private String name;

    public SecondAlgorithm(String name) {
        this.name=name;
    }

    public ArrayList<Point> calculateIntersections(ArrayList<Rectangle> rectangles) throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<RectangleEvent> events = new ArrayList<>();
        ArrayList<Point> allIntersections = new ArrayList<>();
        Sweep activeRectangles = new Sweep(); // The "sweep line"

        long beginProcess = System.nanoTime();

        // Plaats alle events in een lijst
        for(Rectangle r : rectangles) {
            RectangleEvent start = new RectangleEvent(r.getLo().x(), r, "Start");
            RectangleEvent end = new RectangleEvent(r.getRo().x(), r, "End");
            events.add(start);
            events.add(end);
        }

        Collections.sort(events);
        for(RectangleEvent re : events) {
            if(!activeRectangles.contains(re.getRec())) {
                activeRectangles.add(re.getRec());
                for (Rectangle r : activeRectangles) {
                    if(re.getRec() != r) {
                        allIntersections.addAll(re.getRec().intersections(r));
                    }
                }
            }

            else {
                activeRectangles.remove(re.getRec());
            }
        }
        long totalTime = System.nanoTime() - beginProcess;
        System.out.println("Done!");
        System.out.println("Elapsed time :" + totalTime/1000000.0 + " milliseconds.");
        /*PrintWriter writer = new PrintWriter("algo2-result-"+name, "UTF-8");
        for(Point p : allIntersections) {
            writer.println(p);
        }
        writer.println();
        writer.print((double) totalTime/1000000.0);
        writer.close();*/
        return allIntersections;
    }
}
