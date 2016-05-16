import java.util.ArrayList;

/**
 * Created by Robin on 31/03/16.
 */
public class Rectangle {

    private Point lo;
    private Point lb;
    private Point ro;
    private Point rb;

    public Rectangle(double loX, double loY, double rbX, double rbY) {
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
        return this.getLo().x() <= r2.getRo().x()
                && this.getRo().x() >= r2.getLo().x()
                && this.getLo().y() <= r2.getRb().y()
                && this.getRb().y() >= r2.getRb().y();

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



    private boolean onCertainEdge(double x, double y, Point lo, Point lb) {
        double dxc = x - lo.x();
        double dyc = y - lo.y();
        double dxl = lb.x() - lo.x();
        double dyl = lb.y() - lo.y();

        double cross = dxc * dyl - dyc * dxl;

        if (cross != 0) {
            return false;
        }

        if (Math.abs(dxl) >= Math.abs(dyl))
            return dxl > 0 ?
                    lo.x() <= x && x <= lb.x() :
                    lb.x() <= x && x <= lo.x();
        else
            return dyl > 0 ?
                    lo.y() <= y && y <= lb.y() :
                    lb.y() <= y && y <= lo.y();

    }

    private boolean onEitherEdge(double x, double y, Point lo, Point lb, Point ro, Point rb) {
        return onCertainEdge(x, y, lo, lb) ||
                onCertainEdge(x, y, lo, ro) ||
                onCertainEdge(x, y, ro, rb) ||
                onCertainEdge(x, y, lb, rb);


    }

    public  ArrayList<Point> intersections(Rectangle r2) {
        ArrayList<Point> intersectingPoints = new ArrayList();
        if(!this.contains(r2) && this.intersects(r2)) {
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
            if((x5 != this.getLo().x() || x5 != r2.getLo().x())
                    && (x6 != this.getRb().x() || x6 != r2.getRb().x())
                    && (y5 != this.getLo().y() || y5 != r2.getLo().y())
                    && (y6 != this.getRb().y() || y6 != r2.getRb().y())
                    && (x7 != this.getLo().x() || x7 != r2.getLo().x())
                    && (x8 != this.getRb().x() || x8 != r2.getRb().x())
                    && (y7 != this.getLo().y() || y7 != r2.getLo().y())
                    && (y8 != this.getRb().y() || y8 != r2.getRb().y())) {
                intersectingPoints.add(new Point(x5, y5));
                intersectingPoints.add(new Point(x6, y6));
                intersectingPoints.add(new Point(x7, y7));
                intersectingPoints.add(new Point(x8, y8));
                return intersectingPoints;
            }

            if(onEitherEdge(x5, y5, this.getLo(), this.getLb(), this.getRo(), this.getRb())) {
                intersectingPoints.add(new Point(x5, y5));
            }
            if(onEitherEdge(x6, y6, this.getLo(), this.getLb(), this.getRo(), this.getRb())) {
                intersectingPoints.add(new Point(x6, y6));
            }
            if(onEitherEdge(x7, y7, this.getLo(), this.getLb(), this.getRo(), this.getRb())) {
                intersectingPoints.add(new Point(x7, y7));
            }
            if(onEitherEdge(x8, y8, this.getLo(), this.getLb(), this.getRo(), this.getRb())) {
                intersectingPoints.add(new Point(x8, y8));
            }



        }
        return intersectingPoints;
    }
}
