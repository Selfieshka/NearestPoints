package ru.kpfu.itis.kirillakhmetov.work;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return Math.sqrt((this.x - point.x) * (this.x - point.x) +
                (this.y - point.y) * (this.y - point.y));
    }
}
