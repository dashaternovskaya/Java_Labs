/*
Напишите функцию, на входе которой расстояние до места назначения (S, м) и время в пути (T, мин).
Вычислить скорость (км/ч). Напишите тесты.
*/

package lab_24;

public class Speed {
    public static <T> double findSpeed(T distance, T time) {
        double d;
        double t;
        // Чтобы избежать ClassCastException при попытке привести переменную типа Integer к типу double,
        // сперва выполняется приведение к типу int, а затем уже к double
        if (distance instanceof Integer)
            d = (double)((int)distance);
        else
            d = (double)distance;

        if (time instanceof Integer)
            t = (double)((int)time);
        else
            t = (double)time;

        return d/t;
    }

    public static void main(String[] args) {
        System.out.println("\nSpeed results: ");
        System.out.println("int, int = " + String.format("%.2f", Speed.findSpeed(350, 3)) + " km/h");
        System.out.println("double, int = " + String.format("%.2f", Speed.findSpeed(350.0, 3)) + " km/h");
        System.out.println("int, double = " + String.format("%.2f", Speed.findSpeed(350, 3.0)) + " km/h");
        System.out.println("double, double = " + String.format("%.2f", Speed.findSpeed(350.0, 3.0)) + " km/h");
    }
}
