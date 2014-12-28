/*
     Ввести три числа. Если они могут быть длинами сторон
     прямоугольного треугольника, вывести их в порядке возрастания,
     вычислить площадь полученного треугольника
 */

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите стороны прямоугольного треугольника");
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        if ((c == Math.sqrt(a * a + b * b) | (b == Math.sqrt(a * a + c * c))) | a == Math.sqrt(c * c + b * b)) {
            System.out.println("Прямоугольный треугольник");
            float arr[] = {a, b, c};
            java.util.Arrays.sort(arr);
            for(float i : arr)
                System.out.println(i);
            float square = (a + b + c) / 2;
            System.out.println("Площадь: " + square);
        } else System.out.println("Треугольник не прямоугольный");
    }
}
