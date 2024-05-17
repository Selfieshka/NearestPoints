package ru.kpfu.itis.kirillakhmetov.work;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomIntArray {
    public static int[] generateRandomIntArray(int size, int lowerBound, int upperBound) {
        Set<Integer> generatedNumbers = new HashSet<>();
        Random random = new Random();
        while (generatedNumbers.size() < size) {
            generatedNumbers.add(random.nextInt(upperBound) + lowerBound);
        }
        return generatedNumbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
