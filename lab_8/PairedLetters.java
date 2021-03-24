/*
Надо реализовать метод, который принимает на вход String, удаляет рядом стоящие парные буквы и возвращает остаток.
Примеры ожидаемого поведения программы:
"aab" -> "b", "aabb" -> "", "abfbaf" -> "abfbaf”, "abccbaf" -> "f"
Реализовать метод и описать его алгоритмическую сложность. Напишите unit-тесты.
*/


package lab_8;

public class PairedLetters {

    // Ответ на вопрос: Алгоритмическая сложность метода = O(n)
    public static String removePairedLetters(String str) {
        int i = 0;

        while(i < str.length()-1) {
            if(str.charAt(i) == str.charAt(i+1)) {
                str = str.substring(0, i) + str.substring(i+2);
                i = 0;
            }
            else
                i++;
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println("\nRemaining str (before/after):");
        System.out.println("aab = " + PairedLetters.removePairedLetters("aab"));
        System.out.println("aabb = " + PairedLetters.removePairedLetters("aabb"));
        System.out.println("abfbaf = " + PairedLetters.removePairedLetters("abfbaf"));
        System.out.println("abccbaf = " + PairedLetters.removePairedLetters("abccbaf"));
        System.out.println("avvfff = " + PairedLetters.removePairedLetters("avvfff"));
    }
}
