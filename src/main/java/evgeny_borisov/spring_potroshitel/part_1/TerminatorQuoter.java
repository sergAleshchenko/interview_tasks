package evgeny_borisov.spring_potroshitel.part_1;

import lombok.Setter;

import javax.annotation.PostConstruct;

/**
 * @author Sergei Aleshchenko
 */

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    @Setter
    private int repeat;
    @Setter
    private String message;

    @PostConstruct
    public void init() {
        System.out.println("Phase 2 ");
        System.out.println(repeat);
    }


    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("3 phase");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
