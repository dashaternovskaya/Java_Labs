/*
На входе N аргументов командной строки
Посчитать частоту появления слов среди аргументов (вывести в алфавитном порядке)
*/


package lab_12;

import java.util.*;
import java.util.stream.Collectors;

public class ArgumentFrequency {
    private static ArrayList<String> _argumentList = new ArrayList<>();
    private static Map<String, Integer> _frequencyMap = new LinkedHashMap<>();

    // Формирование списка аргументов командной строки
    public static void formArgumentList(Scanner sc) {
        System.out.println("\nEnter your arguments on separate lines (press ENTER to type new argument)." +
                "\nPress ENTER twice to finish: ");

        while (true) {
            String str = sc.nextLine().strip();

            if (str.strip().equals(""))
                break;

            _argumentList.add(str);
        }
    }

    // Вычисление частоты появления слов среди аргументов (в алфавитном порядке)
    public static void countFrequency() {
        _argumentList = _argumentList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
        int counter = 1;

        for (int i = 0; i < _argumentList.size(); i++) {
            // Провека условия i < _argumentList.size()-1, чтобы избежать ошибки IndexOutOfBoundsException
            if (i < _argumentList.size()-1 && _argumentList.get(i).equals(_argumentList.get(i + 1)))
                counter += 1;
            else {
                _frequencyMap.put(_argumentList.get(i), counter);
                counter = 1;
            }
        }

        System.out.println("Frequency of the given arguments (in alphabetical order):");
//        for(Map.Entry<String, Integer> item : _frequencyMap.entrySet())
//            System.out.printf("Word: %s,  Frequency =  %s \n", item.getKey(), item.getValue());
        _frequencyMap.entrySet().forEach(System.out::println);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArgumentFrequency.formArgumentList(input);
        input.close();
        ArgumentFrequency.countFrequency();
    }
}
