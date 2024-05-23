package evgeny_borisov.spring_potroshitel.part_1;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled = true;
}
