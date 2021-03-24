/*
Напишите обобщенный метод для перестановки двух элементов в списке по индексам. Напишите unit-тесты.
*/


package lab_4;

import java.util.Arrays;
import java.util.Random;

public class Swap {
    private Integer[] _arrInt = new Integer[10];
    private Double[] _arrDouble = new Double[10];

    public Swap() {
        // Заполнение массива _arrInt случайными целыми числами от 0 до 99 включительно
        Random rand = new Random();
        for(int i=0; i<_arrInt.length; i++) {
            _arrInt[i] = rand.nextInt(100);
        }

        // Заполнение массива _arrDouble случайными числами с плавающей запятой
        for(int i=0; i<_arrDouble.length; i++) {
            _arrDouble[i] = (double) Math.round(rand.nextDouble() * 100);
        }

        // Печать массива _arrInt
        System.out.println("\nMy integer array:");
        System.out.println(Arrays.toString(_arrInt));

        // Печать массива _arrDouble
        System.out.println("\nMy double array:");
        System.out.println(Arrays.toString(_arrDouble));
    }

    // Обобщения не работают в примитивными типами, но прекрасно работают с классами-обертками
    public <T> T[] swap(int i, int j, T[] anArray) {
        try{
            T temp = anArray[i];
            anArray[i] = anArray[j];
            anArray[j] = temp;
        }
        catch(Exception e) {
            System.out.println("i or/and j is/are out of the array's bounds!");
        }
        return anArray;
    }


    public static void main(String[] args) {
        Swap obj = new Swap();

        System.out.println("\nSwap results _arrInt:");
        System.out.println(Arrays.toString(obj.swap(1, 5, obj._arrInt)));

        System.out.println("\nSwap results _arrDouble:");
        System.out.println(Arrays.toString(obj.swap(1, 5, obj._arrDouble)));
    }
}


