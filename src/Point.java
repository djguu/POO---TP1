import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

final class Point implements Comparable<Point> {

    private double x;
    private double y;


    public Point(double x, double y) throws PointNegativeException{
        if (x<0) throw new PointNegativeException("x tem que ser positivo");
        if (y<0) throw new PointNegativeException("y tem que ser positivo");
        this.x = x;
        this.y = y;
    }


    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    public double distance (Point p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }


    public String toString() {
        return String.format("Point(%g, %g)", x, y);
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        else {
            Point other = (Point)obj;
            return x == other.x && y == other.y;
        }
    }


    public int hashCode() {
        return Objects.hash(x, y);
    }


    public int compareTo(Point other) {
        if (x != other.x)
            return Double.compare(x, other.x);
        else
            return Double.compare(y, other.y);
    }

}


