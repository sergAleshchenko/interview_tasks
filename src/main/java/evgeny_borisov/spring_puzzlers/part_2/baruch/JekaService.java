package evgeny_borisov.spring_puzzlers.part_2.baruch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@Service
public class JekaService {
    @Autowired
    private List<String> list;
}
