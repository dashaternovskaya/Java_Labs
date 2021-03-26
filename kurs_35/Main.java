/*
Игра на реакцию и точность. Два игрока. При старте - вводят свои имена. "Стреляют" по очереди.
После вывода программой строки "к барьеру" игрок1 отсчитывает про себя X секунд и нажимает Ввод, являющийся сигналом к выстрелу.
"Смертельный выстрел" должен попасть в окрестность точки t=X секунд.
Количество X секунд определяется выбором части тела, в которую производится выстрел: сердце - 15, голова - 8, живот - 5.
Размер окрестности определяется уровнем сложности и составляет на сложном уровне +\- 100 мс, на среднем +\- 200 мс, на легком +\- 300 мс.
Промах игрока1 передает ход игроку2.

Персистенция результатов игроков в файл + 10 баллов (сохранение количества "выбитых" баллов 15/8/5 для каждого игрока и загрузка этих
результатов при старте - вывод таблицы результатов)
*/


package kurs_35;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Загрузка результатов предыдущих матчей из файла "Table.ser", печать таблицы результатов
        WinnerScoreTable loadedTable = Duel.loadWinnerScoreTable();

        System.out.println("\nGAME STARTED... ");
        System.out.println("""
                _________________________________________________________________________________________________
                Goal of the Game – to shoot the Opponent.\s
                After being challenged to a Duel, you are prompted to shoot (press ENTER) at anytime you want. 
                Start to count down the Time from the very Beginning. To hit the Opponent's Belly, Head or Heart, 
                you have to shoot (press ENTER) in 5, 8 or 15 Sec correspondingly!
                The Player, who will be the first to gain more than 0 Points, wins!
                -------------------------------------------------------------------------------------------------""");

        System.out.print("\nEnter 1st Player's Name: ");
        Player player1 = new Player(1);
        System.out.print("Enter 2nd Player's Name: ");
        Player player2 = new Player(2);
        System.out.println("\nWelcome to Duel, " + player1.getName() + " and " + player2.getName() + "!");

        Duel.chooseDifficulty();
        System.out.println("\nYou've chosen Game Difficulty " + Duel.getDifficulty() + ", thus you have to hit the Opponent accurate to " +
                Duel.getAccuracy() + " MSec!");

        Scanner input = new Scanner(System.in);
        Duel.process(player1, player2, input, loadedTable);
        input.close();
    }
}
