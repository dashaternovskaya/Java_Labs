/*
Реализуйте метод int min(int a, int b, int c), находящий минимальный из трех аргументов без использования
утилитарных функций стандартной библиотеки Java.
*/


package lab_2;

public class Min3 {

    public static int min(int a, int b, int c) {
        if(a<b & a<c) {
            return a;
        }
        else if(b<a & b<c) {
            return b;
        }
        else {
            return c;
        }
    }


    public static void main(String[] args) {
        System.out.println("\nResults:");
        System.out.println(Min3.min(1, 10, 100));
        System.out.println(Min3.min(200, 2, 20));
        System.out.println(Min3.min(5000, 1000, 50));
    }
}
