import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Robin on 18/05/16.
 */
public class ThirdAlgorithm {

    private String name;

    public ThirdAlgorithm(String name) {
        this.name=name;
    }

    public ArrayList<Point> calculateIntersections(ArrayList<Rectangle> rectangles) throws FileNotFoundException, UnsupportedEncodingException {

        ArrayList<RectangleEvent> events = new ArrayList<>();
        ArrayList<Point> allIntersections = new ArrayList<>();

        long beginProcess = System.nanoTime();

        // Plaats alle events in een lijst
        // Dit algoritme werkt enkel indien op elke
        for(Rectangle r : rectangles) {
            RectangleEvent start = new RectangleEvent(r.getLo().x(), r, "Start");
            RectangleEvent end = new RectangleEvent(r.getRo().x(), r, "End");
            events.add(start);
            events.add(end);
        }


        Collections.sort(events);

        BST<Key, Interval> tree = new BST<>();

        int i = 0;
        for(RectangleEvent re : events) {
            Key key = new Key(re.getxCo(), re.getRec());
            if(!tree.contains(key)) {
                tree.put(key, re.getRec().getYInterval());
                for (Key keys : tree.keys()) {
                    if(!keys.equals(key)) {
                        if (keys.getRetangle().getYInterval().overlaps(re.getRec().getYInterval())) {
                            allIntersections.addAll(keys.getRetangle().intersections(re.getRec()));
                        }
                    }
                }
            }
            else  {
                tree.delete(key);
            }
        }
        long totalTime = System.nanoTime() - beginProcess;

        System.out.println("Done!");
        System.out.println("Elapsed time :" + totalTime/1000000.0 + " milliseconds.");
        /*PrintWriter writer = new PrintWriter("algo3-result-"+name, "UTF-8");
        for(Point p : allIntersections) {
            writer.println(p);
        }
        writer.println();
        writer.print((double) totalTime/1000000.0);
        writer.close();*/
        return allIntersections;
    }
}
