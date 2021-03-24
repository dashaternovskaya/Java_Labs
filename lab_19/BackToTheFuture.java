/*
int t=0; Выполняется t+=1000 каждую секунду и отображается в программе как время (мс).
Через сколько дней мы попадем в прошлое? Покажите ваши вычисления.
*/


package lab_19;

public class BackToTheFuture {
    static int t = 0;

    public static void start() {
        final int MS_IN_DAY = 24*60*60*1000;  // Количество мс в одних сутках
        int msCurrent = 0;  // Время в мс в рамках текущих суток
        int days = 0;

        // Если случится переполнение, t окажется <= Integer.MAX_VALUE+1000
        while(t > Integer.MAX_VALUE+1000){
                t += 1000;
                // System.out.println(t);
                msCurrent += 1000;
                if (msCurrent >= MS_IN_DAY) {
                    days += 1;
                    msCurrent = MS_IN_DAY - msCurrent;
                }
        }
        System.out.println("\nFinally, we are in the Past!");
        // Integer.MAX_VALUE = 2147483647, MS_IN_DAY = 86400000 ==> days = Integer.MAX_VALUE/MS_IN_DAY = 24,86.
        System.out.println("It required " + days + " days!");
    }


    public static void main(String[] args) {
        BackToTheFuture.start();
    }
}
