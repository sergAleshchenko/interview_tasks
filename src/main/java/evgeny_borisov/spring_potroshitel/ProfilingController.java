package evgeny_borisov.spring_potroshitel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Setter
@Getter
public class ProfilingController implements ProfilingControllerMBean  {
    private boolean enabled = true;
}
