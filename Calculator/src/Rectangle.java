import java.util.ArrayList;

/**
 * Created by Robin on 31/03/16.
 */
public class Rectangle {

    private Point lo;
    private Point lb;
    private Point ro;
    private Point rb;

    public Rectangle (double loX, double loY, double rbX, double rbY) {
        lo = new Point(loX, loY);
        lb = new Point(loX, rbY);
        ro = new Point(rbX, loY);
        rb = new Point(rbX, rbY);

    }

    public Point getLb() {
        return this.lb;
    }

    public Point getLo() {
        return this.lo;
    }

    public Point getRo() {
        return this.ro;
    }

    public Point getRb() {
        return this.rb;
    }

    public Interval getYInterval() {
        return new Interval(this.getLo().y(), this.getLb().y());
    }

    @Override
    public String toString() {
        return "Rectangle[LoX: " + this.lo.x() + ", LoY: "+ this.lo.y() + ", RbX: "+ this.rb.x() + ", RbY: " + this.rb.y()+ "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Rectangle.class) {
            return false;
        }
        Rectangle other = (Rectangle) obj;
        if (this.getLo().equals(other.getLo()) && this.getLb().equals(other.getLb()) && this.getRo().equals(other.getRo()) && this.getRb().equals(other.getRb())) {
            return true;
        }
        return false;
    }

    private boolean intersects(Rectangle r2) {
        if(this.getRb().x() < r2.getLb().x() || r2.getRb().x() < this.getLb().x() || this.getRb().y() < r2.getLo().y() || r2.getRb().y() < this.getLo().y()) {
            return false;
        }
        else {
            return true;
        }

    }

    private boolean contains(Rectangle r2) {
        if(this.getLo().x() < r2.getLo().x() &&
                this.getLo().y() < r2.getLo().y() &&
                this.getRb().x() > r2.getRb().x() &&
                this.getRb().y() > r2.getRb().y()
                ) {
            return true;
        } else if(this.getLo().x() > r2.getLo().x() &&
                this.getLo().y() > r2.getLo().y() &&
                this.getRb().x() < r2.getRb().x() &&
                this.getRb().y() < r2.getRb().y()
                ) {
            return true;
        }
        return false;
    }

    private static boolean isACorner(Point point, Rectangle r) {
        return point.equals(r.getLb()) || point.equals(r.getLo()) || point.equals(r.getRb()) || point.equals(r.getRo());
    }


    public  ArrayList<Point> intersections(Rectangle r2) {
        ArrayList<Point> intersectingPoints = new ArrayList();
        if((!this.contains(r2)) && this.intersects(r2)) {
            // Bereken de coordinaten van de hoekpunten van de rechthoek die gevormd wordt door de snijding
            double x5 = Math.max(this.getLo().x(), r2.getLo().x());
            double y5 = Math.max(this.getLo().y(), r2.getLo().y());
            double x6 = Math.min(this.getRb().x(), r2.getRb().x());
            double y6 = Math.min(this.getRb().y(), r2.getRb().y());

            double x7 = x5;
            double y7 = y6;
            double x8 = x6;
            double y8 = y5;
            // Geen van de 4 coordinaten is een van de vier hoekpunten

            Point first = new Point(x5, y5);
            Point second = new Point(x6, y6);
            Point third = new Point(x7, y7);
            Point fourth = new Point(x8, y8);

            if (!(isACorner(first, this) || isACorner(first, r2))) {
                intersectingPoints.add(first);
            }
            if ((!isACorner(second, this) && (!isACorner(second, r2)))) {
                intersectingPoints.add(second);
            }
            if ((!isACorner(third, this) && (!isACorner(third, r2)))) {
                intersectingPoints.add(third);
            }
            if ((!isACorner(fourth, this) && (!isACorner(fourth, r2)))) {
                intersectingPoints.add(fourth);
            }
        }
        return intersectingPoints;
    }
}
