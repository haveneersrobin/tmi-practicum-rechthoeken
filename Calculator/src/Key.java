
public class Key implements Comparable<Key> {

    private Double x;
    private Rectangle rh;

    public Key(Double x, Rectangle rh) {
        super();
        this.x = x;
        this.rh = rh;
    }

    public Rectangle getRetangle() {
        return this.rh;
    }

    @Override
    public String toString() {
        return "Sleutel{" + "x=" + x + ", rh=" + rh + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rh == null) ? 0 : rh.hashCode());
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Key other = (Key) obj;
        return this.compareTo(other) == 0;
    }

    @Override
    public int compareTo(Key o) {
        Key other = (Key) o;
        double result = this.x - other.x;
        if (result == 0) {
            if (this.rh.equals(other.rh)) {
                return 0;
            }
        }
        return result > 0 ? 1 : -1;
    }

}
