import java.util.Scanner;

/*
     Ввести три числа. Если они могут быть длинами сторон
     равнобедренного остроугольного треугольника, вычислить
     его площадь. Вывести длины сторон и площадь в порядке
     возрастания.

 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите стороны остроугольного треугольника");
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        if ((a < b + c) | (b < c + a) | (c < b + a)) {
            System.out.println("Остроугольный треугольник");
            float arr[] = {a, b, c};
            java.util.Arrays.sort(arr);
            for(float i : arr)
                System.out.println(i);
            float square = (a + b + c) / 2;
            System.out.println("Площадь: " + square);
        } else System.out.println("Треугольник не остроугольный");
    }
}
