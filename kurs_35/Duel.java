package kurs_35;

import java.io.*;
import java.util.Scanner;

public class Duel {
    private static String _difficulty;  // Выбранный уровень сложности
    private static double _accuracyInMSec;  // Допустимая погрешность в мс (зависит от выбранного уровня сложности)
    private final static int _heart = 15;
    private final static int _head = 8;
    private final static int _belly = 5;

    public static void chooseDifficulty() {
        System.out.println("\nPlease, choose Difficulty:");
        System.out.println("1 – Low \n2 – Medium \n3 – Hard");
        Scanner sc = new Scanner(System.in);
        _difficulty = sc.next();
        // Если пользователь не ввел уровень сложности (от 1 до 3), устанавливается уровень по умолчанию (1 – Low)
        if (!(_difficulty.equals("1") | _difficulty.equals("2") | _difficulty.equals("3"))) {
            _difficulty = "1";
            System.out.println("Difficulty has to be the number between 1 and 3!" +
                    " By default Difficulty = 1 (Low)");
        }

        if (_difficulty.equals("1"))
            _accuracyInMSec = 300;
        else if(_difficulty.equals("2"))
            _accuracyInMSec = 200;
        else
            _accuracyInMSec = 100;
    }

    public static String getDifficulty() {
        return _difficulty;
    }

    public static double getAccuracy() {
        return _accuracyInMSec;
    }

    // Игровой раунд (ход одного игрока)
    public static int gameRound(Scanner sc, Player currentPlayer) {
        long startTimeInMSec;  // Начало раунда (мс)
        long endTimeInMSec = 0;  // Конец раунда (мс)
        double resultInSec;  // Результат (сек)  = (Конец раунда (мс) - Начало раунда (мс)) / 1000

        System.out.println("I challenge " + currentPlayer.getName() +  " to a duel! Press ENTER to shoot.");
        startTimeInMSec = System.currentTimeMillis();

        if(sc.nextLine().strip().equals(""))
            endTimeInMSec = System.currentTimeMillis();
        resultInSec = (double)(endTimeInMSec - startTimeInMSec)/1000;

        // Статистика для отладки --------------------------------------------------------------
        System.out.println("startTimeInMSec = " + startTimeInMSec);
        System.out.println("endTimeInMSec = " + endTimeInMSec);
        System.out.println("resultInMSec = " + (endTimeInMSec - startTimeInMSec));
        System.out.println("resultInSec = " + resultInSec);
        System.out.println("_pointVicinityInMSec = " + _accuracyInMSec);
        System.out.println("_pointVicinityInSeC = " + _accuracyInMSec/1000);

        System.out.println("Math.abs(resultInSec - _heart) = " + Math.abs(resultInSec - _heart));
        System.out.println("Math.abs(resultInSec - _head)  = " + Math.abs(resultInSec - _head));
        System.out.println("Math.abs(resultInSec - _belly) = " + Math.abs(resultInSec - _belly));
        // --------------------------------------------------------------------------------------

        if (Math.abs(resultInSec - _heart) <= _accuracyInMSec/1000) {
            return _heart;
        }
        else if (Math.abs(resultInSec - _head) <= _accuracyInMSec/1000) {
            return _head;
        }
        else if (Math.abs(resultInSec - _belly) <= _accuracyInMSec/1000) {
            return _belly;
        }
        else
            return 0;
    }

    // Игровой матч (может состоять из нескольких раундов, пока не появится победитель).
    public static void process(Player pl1, Player pl2, Scanner sc, WinnerScoreTable table) {
        int result = 0;

        Player currentPlayer = pl1;
        while (result == 0) {
            System.out.println("\n...Now plays " + currentPlayer.getName() + ". Press ENTER to start.");

            if (sc.nextLine().strip().equals("")) {
                result = Duel.gameRound(sc, currentPlayer);

                System.out.println("Result = " + result + " Points");
                if (result == 0) {
                    System.out.println("MISSED! Thus...");
                    currentPlayer = (currentPlayer == pl1) ? pl2 : pl1;  // Тернарный оператор
                }
                else {
                    System.out.println("Hurrah! " + currentPlayer.getName() + " has won!");
                    System.out.println("\n--------------- G A M E    O V E R ---------------");
                    table.addWinnerScore(currentPlayer.getName(), result);  // Добавление нового победителя и результата в таблицу
                    saveWinnerScoreTable(table);  // Сохранение победителя и результата в файл "Table.ser"
                    sc.close();
                }
            }
        }
    }

    // Сохранение победителя и результата в файл "Table.ser"
    public static void saveWinnerScoreTable(WinnerScoreTable table) {
        try {
            // Создаем 2 потока для сериализации объекта и сохранения его в файл
            // FileOutputStream записывает данные в файл, а ObjectOutputStream преобразует объект в байты.
            FileOutputStream outputStream = new FileOutputStream("/Users/DashaT/IdeaProjects/Labs_Semester_6/src/kurs_35/Table.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(table);  // Сохраняем таблицу в файл
            objectOutputStream.close();  // Закрываем поток и освобождаем ресурсы
        }
        catch (IOException e) {
            System.out.println("Winner and Score cannot be saved.");
        }
    }

    // Загрузка результатов предыдущих матчей из файла "Table.ser", печать таблицы результатов
    public static WinnerScoreTable loadWinnerScoreTable() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/DashaT/IdeaProjects/Labs_Semester_6/src/kurs_35/Table.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            WinnerScoreTable table = (WinnerScoreTable) objectInputStream.readObject();  // Загрузка результатов предыдущих матчей из файла "Table.ser"
            table.displayTable();  // Печать таблицы результатов
            return table;
        }
        catch (IOException | ClassNotFoundException | NullPointerException e) {
            System.out.println("\nPrevious Score-table cannot be loaded, cause it doesn't exist.");
            return new WinnerScoreTable();
        }
    }
}
