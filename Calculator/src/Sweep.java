import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sweep implements Iterable<Rectangle> {
    private final Set<Rectangle> rectangles = new HashSet<Rectangle>();

    public Sweep() {
    }

    public void add(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public void remove(Rectangle Rectangle) {
        rectangles.remove(Rectangle);
    }

    public Collection<Rectangle> getRectangles() {
        return this.rectangles;
    }

    public boolean contains(Rectangle rectangle) {
        return rectangles.contains(rectangle);
    }

    @Override
    public Iterator<Rectangle> iterator() {
        return rectangles.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sweeper with " + rectangles.size()
                + " active rectangles:");
        for (Rectangle c : this)
            builder.append("\n\t" + c);
        return builder.toString();
    }
}