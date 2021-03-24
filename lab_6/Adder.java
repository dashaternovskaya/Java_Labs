/*
Дан интерфейс. Имплементируйте. Напишите unit-тесты. Один из тестов должен проверять сумму Integer.MAX_VALUE + 1
*/


package lab_6;

public class Adder implements Calculator {

    @Override
    public int sum(int x, int y) {
        int total;
        try {
            // Math.addExact() returns the sum of its arguments, throwing an exception if the result overflows an int
            total = Math.addExact(x, y);
        }
        catch(ArithmeticException e) {
            System.out.print("The result of x+y overflows an int, thus x+y = ");
            return 0;
        }
        return total;
    }


    public static void main(String[] args) {
        Adder obj = new Adder();
        System.out.println("\nSum of x and y:");
        System.out.println(obj.sum(-100, 50));
        System.out.println(obj.sum(10, Integer.MAX_VALUE));
    }
}