package evgeny_borisov.spring_puzzlers.part_2.baruch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@Service
@Getter
@Setter
public class BaruchService {

    @Autowired
    private List<String> list;
}
