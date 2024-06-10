package spring_demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@Component
@Getter
@Setter
public class CollectionBean {

    @Autowired
    private List<String> names;

    public void printNames() {
        System.out.println(names);
    }

}
