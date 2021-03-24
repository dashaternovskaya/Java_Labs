/*
Напишите обобщенный метод для поиска минимального элемента списка в диапазоне [begin, end).
Где [ – включительно, ) – исключительно. Напишите unit-тесты.
*/


package lab_5;

import java.util.Arrays;
import java.util.Random;

public class MinList {
    private Integer[] _arrInt = new Integer[10];
    private Double[] _arrDouble = new Double[10];

    public MinList() {
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

    // Интерфейс Comparable содержит один единственный метод int compareTo(E item), который сравнивает текущий объект
    // с объектом, переданным в качестве параметра. Если этот метод возвращает отрицательное число,
    // то текущий объект будет располагаться перед тем, который передается через параметр.
    public <T extends Comparable> T min(int lowBound, int upperBound, T[] anArray) {
        T tempMin = null;
        try {
            tempMin = anArray[lowBound];
            for(int i=lowBound; i<upperBound; i++) {
                if(anArray[i].compareTo(tempMin) < 0) {
                    tempMin = anArray[i];
                }
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("lowBound or/and upperBound is/are out of the array's bounds!");
        }

        return tempMin;
    }


    public static void main(String[] args) {
        MinList obj = new MinList();

        int lowBound = 1;
        int upperBound = 5;

        System.out.println("\nMin element in the [" + lowBound + "," + upperBound + ") diapason (_arrInt):");
        System.out.println(obj.min(lowBound, upperBound, obj._arrInt));

        System.out.println("\nMin element in the [" + lowBound + "," + upperBound + ") diapason (_arrDouble):");
        System.out.println(obj.min(lowBound, upperBound, obj._arrDouble));
    }
}
