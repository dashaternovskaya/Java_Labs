package kurs_35;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class WinnerScoreTable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;  // Уникальный идентификатор версии сериализованного класса, чтобы избежать
    // ошибки InvalidClassException, возникающей при десериализации класса, если в нем были изменены поля/модификаторы и т.п.
    private final ArrayList<String> _winnersList;
    private final ArrayList<Integer> _scoresList;

    public WinnerScoreTable() {
        _winnersList = new ArrayList<>();
        _scoresList = new ArrayList<>();
    }

    // Добавление нового победителя и результата в таблицу
    public void addWinnerScore(String winner, int score) {
        _winnersList.add(winner);
        _scoresList.add(score);
    }

    // Печать таблицы результатов
    public void displayTable() {
        // Ошибка NullPointerException, возникающая при попытке распечатать несуществующую таблицу, обрабатывается
        // внутри метода Duel.loadWinnerScoreTable(), вызывающего данную функцию
        System.out.println("\nSaved Score-table for the previous Game Sessions:");
            for (int i = 0; i < _winnersList.size(); i++)
                System.out.println("Winner – " + _winnersList.get(i) + ", Score – " + _scoresList.get(i) + " Points");
    }
}

