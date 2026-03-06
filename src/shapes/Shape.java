package shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {

    public enum CompareType { HEIGHT, BASE_AREA, VOLUME }
    private static CompareType compareType = CompareType.HEIGHT;

    protected double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() { return height; }

    public abstract double calcBaseArea();
    public abstract double calcVolume();

    public static void setCompareType(CompareType type) { compareType = type; }
    public static CompareType getCompareType() { return compareType; }

    // Comparable: height (ascending by default)
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.height, other.height);
    }

    // Comparator: based on chosen type (ascending by default)
    @Override
    public int compare(Shape s1, Shape s2) {
        switch (compareType) {
            case BASE_AREA: return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
            case VOLUME:    return Double.compare(s1.calcVolume(), s2.calcVolume());
            default:        return Double.compare(s1.getHeight(), s2.getHeight());
        }
    }
}