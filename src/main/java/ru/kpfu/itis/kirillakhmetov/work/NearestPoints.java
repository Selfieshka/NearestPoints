package ru.kpfu.itis.kirillakhmetov.work;

import java.util.Arrays;
import java.util.Comparator;

public class NearestPoints {

    public static double minDistance(Point[] points, int n) {
        // Сортируем все точки по x
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        return findMinDistance(points, n);
    }

    //
    private static double findMinDistance(Point[] points, int n) {
        // Простой перебор, если точек <= 3; O(n^2)
        if (n <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    double distance = points[i].distance(points[j]);
                    if (distance < min) {
                        min = distance;
                    }
                }
            }
            return min;
        }

        // Принцип "разделяй и властвуй", если точек >=4; O(nlog(n))
        int mid = n / 2;
        Point midPoint = points[mid];

        // Рекурсивные вызовы функции для правой и левой частей плоскости от средней линии
        double distanceL = findMinDistance(points, mid);
        double distanceR = findMinDistance(Arrays.copyOfRange(points, mid, n), n - mid);

        double distance = Math.min(distanceL, distanceR);

        // Создаем массив точек, которые находятся около средней линии
        Point[] strip = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(points[i].x - midPoint.x) < distance) {
                strip[j] = points[i];
                j++;
            }
        }

        // Выбирается минимальное расстояние из правой и левой плоскостей,
        // и расстояния точек около средней линии
        return Math.min(distance, aroundMiddleLine(strip, j, distance));
    }


    // Находим минимальное расстояние между точками около средней линии
    private static double aroundMiddleLine(Point[] strip, int size, double d) {
        double min = d;
        // Сортируем точки по y
        Arrays.sort(strip, 0, size, Comparator.comparingInt(p -> p.y));

        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
                double distance = strip[i].distance(strip[j]);
                if (distance < min) {
                    min = distance;
                }
            }
        }

        return min;
    }
}
