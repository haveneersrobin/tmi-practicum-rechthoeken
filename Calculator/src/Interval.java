/**
 * Created by Robin on 18/05/16.
 */
public class Interval {

    private double start;
    private double end;

    public Interval(double start, double end) {
        this.start=start;
        this.end=end;
    }

    public double getStart() {
        return this.start;
    }

    public double getEnd() {
        return this.end;
    }

    public double getIntervalLength() {
        return this.end-this.start;
    }

    public boolean overlaps(Interval other) {
        return this.getEnd() > other.getStart() && this.getStart() < other.getEnd();
    }
}
