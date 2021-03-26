package kurs_35;

import java.util.Scanner;

public class Player {
    private String _name;

    public Player(int num) {
        Scanner sc = new Scanner(System.in);
        _name = sc.nextLine().strip();
        if (_name.equals(""))  // Если игрок не ввел имя, ему присваивается имя по умолчанию
            _name = "Noname" + num;
    }

    public String getName() {
        return _name;
    }
}
