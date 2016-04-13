/**
 * Created by Robin on 31/03/16.
 */
public class Rectangle {

    private double loX;
    private double loY;
    private double rbX;
    private double rbY;

    public Rectangle(double loX, double loY, double rbX, double rbY) {
        this.setLoX(loX);
        this.setLoY(loY);
        this.setRbX(rbX);
        this.setRbY(rbY);

    }

    public double getLoY() {
        return this.loY;
    }

    public void setLoY(double loY) {
        this.loY = loY;
    }

    public double getLoX() {
        return this.loX;
    }

    public void setLoX(double loX) {
        this.loX = loX;
    }

    public double getRbX() {
        return this.rbX;
    }

    public void setRbX(double rbX) {
        this.rbX = rbX;
    }

    public double getRbY() {
        return this.rbY;
    }

    public void setRbY(double rbY) {
        this.rbY = rbY;
    }

    public double calculateWidth() {
        return this.getRbX()-this.getLoX();
    }
    public double calculateHeight() {
        return this.getRbY()-this.getLoY();
    }

    @Override
    public String toString() {
        return "Rectangle[LoX: " + this.getLoX() + ", LoY: "+ this.getLoY() + ", RbX: "+ this.getRbX() + ", RbY: " + this.getRbY()+ "]";
    }

}
