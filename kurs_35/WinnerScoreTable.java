package kurs_35;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class WinnerScoreTable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;  // Уникальный идентификатор версии сериализованного класса, чтобы избежать
    // ошибки InvalidClassException, возникающей при десериализации класса, если в нем были изменены поля/модификаторы и т.п.
    private final ArrayList<String> _WINNERS_LIST;
    private final ArrayList<Integer> _SCORES_LIST;

    public WinnerScoreTable() {
        _WINNERS_LIST = new ArrayList<>();
        _SCORES_LIST = new ArrayList<>();
    }

    // Добавление нового победителя и результата в таблицу
    public void addWinnerScore(String winner, int score) {
        _WINNERS_LIST.add(winner);
        _SCORES_LIST.add(score);
    }

    // Печать таблицы результатов
    public void displayTable() {
        // Ошибка NullPointerException, возникающая при попытке распечатать несуществующую таблицу, обрабатывается
        // внутри метода Duel.loadWinnerScoreTable(), вызывающего данную функцию
        System.out.println("\nSaved Score-table for the previous Game Sessions:");
            for (int i = 0; i < _WINNERS_LIST.size(); i++)
                System.out.println("Winner – " + _WINNERS_LIST.get(i) + ", Score – " + _SCORES_LIST.get(i) + " Points");
    }
}

