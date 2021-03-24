/*
Написать метод, на вход - 2 итератора по числам. Известно, что коллекции под итераторами упорядочены и бесконечны.
Необходимо вывести все элементы первой коллекции, которых нет во второй. Напишите unit-тесты.
*/


package lab_7;

import java.util.*;

public class TwoIterators {
    private ArrayList<Integer> _arr1 = new ArrayList<Integer>();
    private ArrayList<Integer> _arr2 = new ArrayList<Integer>();

    public TwoIterators() {
        // Заполнение массивов случайными целыми числами от 0 до 19 включительно
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            _arr1.add(rand.nextInt(20));
            _arr2.add(rand.nextInt(20));
        }

        // Печать массивов
        System.out.println("\nMy arrays:");
        System.out.println("_arr1 = " + _arr1);
        System.out.println("_arr2 = " + _arr2);
    }

    public void findDifference() {
        Iterator<Integer> it1 = _arr1.iterator();
        Iterator<Integer> it2;

        while(it1.hasNext()) {
            it2 = _arr2.iterator();
            int elementInArr1 = it1.next();
            while(it2.hasNext()) {
                int elementInArr2 = it2.next();
                if (elementInArr1 == elementInArr2){
                    it1.remove();
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        TwoIterators obj = new TwoIterators();
        obj.findDifference();
        System.out.println("\nResulting array:");
        System.out.println(obj._arr1);
    }


}
