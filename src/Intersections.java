/**
 * Created by Robin on 13/04/16.
 */
public class Intersections {

    private Point first;
    private Point second;

    public Intersections(Point first, Point second) {
        setFirst(first);
        setSecond(second);
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

}
