/**
 * Created by Robin on 17/05/16.
 */
public class RectangleEvent implements Comparable<RectangleEvent> {

    private double xCo;
    private Rectangle rec;
    private String type;

    public RectangleEvent(double xCo, Rectangle rectangle, String type) {
        this.xCo = xCo;
        this.rec = rectangle;
        this.type = type;
    }

    public double getxCo() {
        return xCo;
    }

    public void setxCo(double xCo) {
        this.xCo = xCo;
    }

    public Rectangle getRec() {
        return rec;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(RectangleEvent other) {
        if(this.xCo > other.getxCo()) {
            return 1;
        }
        else if(this.xCo < other.getxCo()) {
            return -1;
        }
        else if(this.type.equals(other.getType())) {
            return 0;
        }
        else if(this.type.equals("End")) {
            return 1;
        }
        else {
            return -1;
        }

    }

    @Override
    public String toString() {
        return "\n----------\nRectangle Event met \nxco = " + xCo + "\nRectangle = " + rec + "\nType" + type + "\n----------";
    }





}
