/*
Имеется класс Spaceship. Создайте 3 экземпляра. Напишите методы, которые находят:
a) среднюю скорость кораблей
б) минимальную скорость кораблей
*/


package lab_3;

import java.util.Arrays;

public class Main {
    // Метод, вычисляющий среднюю скорость кораблей (Задание а)
    public static double averageSpeed(Spaceship sp1, Spaceship sp2, Spaceship sp3) {
        double averageSpeed;

        try {
            // Math.addExact() returns the sum of its arguments, throwing an exception if the result overflows an int
            int totalSpeed = Math.addExact(sp1.getSpeed(), sp2.getSpeed());
            totalSpeed = Math.addExact(totalSpeed, sp3.getSpeed());
            averageSpeed = (double)(totalSpeed)/3;
        }
        catch(ArithmeticException e) {
            System.out.println("Total speed of three spaceships overflows an Integer, so it is impossible" +
                    " to calculate an average speed :'(");
            return 0;
        }
        return averageSpeed;
    }

    // Метод, вычисляющий минимальную скорость кораблей (Задание б)
    public static int minSpeed(Spaceship sp1, Spaceship sp2, Spaceship sp3) {
        int[] allSpeed = new int[]{sp1.getSpeed(), sp2.getSpeed(), sp3.getSpeed()};
        int minSpeed = Arrays.stream(allSpeed).min().getAsInt();

        return minSpeed;
    }


    public static void main(String[] args) {
        System.out.println("\nInteger.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE + 1 = " + (Integer.MAX_VALUE + 1));
        System.out.println("Integer.MAX_VALUE + 2 = " + (Integer.MAX_VALUE + 2));

        Spaceship obj1 = new Spaceship(1000);
        Spaceship obj2 = new Spaceship(2000);
        Spaceship obj3 = new Spaceship(3000);
        Spaceship objMax = new Spaceship(Integer.MAX_VALUE);

        // Задание а)
        System.out.println("\nAverage speed of three spaceships:");
        System.out.println(averageSpeed(obj1, obj2, obj3) + " km/h");

        System.out.println("\nAverage speed of three spaceships:");
        System.out.println(averageSpeed(obj1, obj2, objMax) + " km/h");

        // Задание б)
        System.out.println("\nMinimum speed of three spaceships:");
        System.out.println(minSpeed(obj1, obj2, obj3)  + " km/h");
    }
}
