package ru.kpfu.itis.kirillakhmetov.work;

import static ru.kpfu.itis.kirillakhmetov.work.NearestPoints.minDistance;
import static ru.kpfu.itis.kirillakhmetov.work.RandomIntArray.generateRandomIntArray;

public class Main {
    public static void main(String[] args) {
        final int COUNT_POINTS = 100;
        final int LOWER_BOUND = -10000;
        final int UPPER_BOUND = 10000;

        // Генерируем уникальные координаты каждой точки
        int[] xCoordinates = generateRandomIntArray(COUNT_POINTS, LOWER_BOUND, UPPER_BOUND);
        int[] yCoordinates = generateRandomIntArray(COUNT_POINTS, LOWER_BOUND, UPPER_BOUND);
        Point[] points = new Point[COUNT_POINTS];

        // Заполнили массив с точками
        for (int i = 0; i < COUNT_POINTS; i++) {
            points[i] = new Point(xCoordinates[i], yCoordinates[i]);
        }

        double distance = minDistance(points, COUNT_POINTS);

        System.out.println("Минимальное расстояние: " + distance);
    }
}