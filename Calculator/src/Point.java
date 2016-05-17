/**
 * Created by Robin on 01/04/16.
 */
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double x() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double y() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x() + " " + this.y();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Point.class) {
            return false;
        }
        Point other = (Point) obj;
        if (this.x() == other.x() && this.y() == y()) {
            return true;
        }
        return false;
    }

}
