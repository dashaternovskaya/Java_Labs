/*
Реализуйте метод boolean swap(int i, int j, int[] anArray), меняющий местами элементы по индексам i и j
в массиве anArray и возвращающий false, если индексы выходят за пределы массива.
*/


package lab_1;

import java.util.Arrays;
import java.util.Random;

public class SimpleSwap {
    private int[] _arr = new int[10];

    public SimpleSwap() {
        // Заполнение массива _arr случайными целыми числами от 0 до 99 включительно
        Random rand = new Random();
        for(int i=0; i<_arr.length; i++) {
            _arr[i] = rand.nextInt(100);
        }

        // Печать массива _arr
        System.out.println("\nMy array:");
        System.out.println(Arrays.toString(_arr));
    }

    public boolean swap(int i, int j, int[] anArray) {
        if(i>=_arr.length | j>=_arr.length) {
            return false;
        }
        else {
            int temp = anArray[i];
            anArray[i] = anArray[j];
            anArray[j] = temp;
            return true;
        }
    }


    public static void main(String[] args) {
        SimpleSwap obj = new SimpleSwap();
        System.out.println("\nSwap results:");
        System.out.println(obj.swap(4, 8, obj._arr));  // returns true
        System.out.println(obj.swap(6, 10, obj._arr));  // returns false
    }
}
