package inheritance.example_2;

import interview_300_questions.Employee;
import patterns.state.ui.Player;

import java.util.Comparator;

public interface SomeInterface1 {
    int a = 0;
    
    void doSomething1();

    static void doSomething2() {
        System.out.println("SomeInterface1.doSomething2()");
    }

    default void doSomething3() {
        System.out.println("SomeInterface1.doSomething3()");

        Comparator<Player> byRanking =
                (player1, player2) -> Integer.compare(player1.getRanking(), player2.getRanking());
    }

}
