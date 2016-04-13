/**
 * Created by Robin on 31/03/16.
 */
public class FirstAlgorithm {

    // Empty constructor
    public FirstAlgorithm() {}

    public boolean contains(Rectangle r1, Rectangle r2) {
        if(r1.getLoX() < r2.getLoX() &&
                r1.getLoY() < r2.getLoY() &&
                r1.getRbX() > r2.getRbX() &&
                r1.getRbY() > r2.getRbY()
                ) {
            return true;
        } else if(r1.getLoX() > r2.getLoX() &&
                r1.getLoY() > r2.getLoY() &&
                r1.getRbX() < r2.getRbX() &&
                r1.getRbY() < r2.getRbY()
                ) {
            return true;
        }
        return false;
    }

    public Intersections calculateIntersection(Rectangle r1, Rectangle r2) {
        /**
         *               +----+
         *               |    |
         *  +------------++   |     +-------------+
         *  |            ++---+ ==> |             |
         *  |             |         |             |
         *  |             |         |            ++---+
         *  +-------------+         +------------++   |
         *                                       |    |
         *                                       +----+
         */
        // Right
        if (r2.getLoX() < r1.getRbX() && r2.getLoY() < r1.getRbY()) {
            // Top right
            if (r2.getLoY() > r1.getLoY() && r2.getRbY() > r1.getRbY()) {
                return new Intersections(new Point(r2.getLoX(), r1.getRbY()), new Point(r1.getRbX(), r2.getLoY()));
            }
            // Right edge
            else if (r2.getLoY() > r1.getLoY() && r2.getRbY() < r1.getRbY()) {
                return new Intersections(new Point(r1.getRbX(), r2.getLoY()), new Point(r1.getRbX(), r2.getRbY()));
            }
            // Right bottom
            else if (r2.getLoY() < r1.getLoY() && r2.getRbY() < r1.getRbY()) {
                return new Intersections(new Point(r2.getLoX(), r1.getLoY()), new Point(r1.getRbX(), r2.getRbY()));
            }
        }
        // Bottom
        /**
         *
         *  +--------------+     +--------------+
         *  |              |     |              |
         *  |+---+         | ==> |         +---+|
         *  ||   |         |     |         |   ||
         *  ++---+--------+      +---------+---++
         *   |   |                         |   |
         *   +---+                         +---+
         */
        else if (r2.getLoX() > r1.getLoX() && r2.getLoX() < r1.getRbX() && r2.getLoY() < r1.getLoY()) {
            return new Intersections(new Point(r2.getLoX(), r1.getLoY()), new Point(r2.getRbX(), r1.getLoY()));
        }
        // Left
        /**
         * +----+
         * |    |
         * |   ++-------------+         +--------------+
         * +---++             | ==>     |              |
         *     |              |         |              |
         *     |              |     +--++              |
         *     +--------------+     |  ++--------------+
         *                          |   |
         *                          +---+
         */
        else if (r2.getLoX() < r1.getLoX() && r2.getLoY() < r1.getRbY()) {
            //Left bottom
            if (r2.getLoY() < r1.getLoY() && r2.getRbY() < r1.getRbY()) {
                return new Intersections(new Point(r1.getLoX(), r2.getRbY()),new Point(r1.getLoX(), r2.getRbY()));
            }
            //Left edge
            if(r2.getLoY() > r1.getLoY() && r2.getRbY() < r1.getRbY()) {
                return new Intersections(new Point(r1.getLoX(), r2.getLoY()), new Point(r1.getLoX(), r2.getRbY()));
            }
            //Left top
            if(r2.getLoY() > r1.getLoY() && r2.getRbY() > r1.getRbY()) {
                return new Intersections(new Point(r1.getLoX(), r2.getLoY()), new Point(r2.getRbX(), r1.getRbY()));
            }
        }
        // Top
        /**
         *   +---+                          +---+
         *   |   |                          |   |
         *  ++-------------+      +-------------++
         *  ||   |         |      |         |   ||
         *  |+---+         | ==>  |         +---+|
         *  |              |      |              |
         *  +--------------+      +--------------+
         */
        else if(r2.getLoY() < r1.getRbY() && r2.getLoX() >= r1.getLoX() && r2.getRbX() <= r1.getRbX()) {
            return new Intersections(new Point(r2.getLoX(),r1.getRbY()),new Point(r2.getRbX(),r1.getRbY()));
        }
        return null;
    }
}
