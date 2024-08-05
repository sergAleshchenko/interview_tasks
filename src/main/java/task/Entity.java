package task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */

public class Entity {
    private Map<String, Integer> parameter;


    public Entity() {
        parameter = new HashMap<>();
        String s = "";
    }


    public void addParameter(String name, Integer value) {
        if (parameter.get(name) != null) {
            System.out.println("Parameter " + name + " already exists");
        } else if (name == null || value == null) {
            System.out.println("name and value should be not null");
        } else {
            parameter.put(name, value);
        }
    }

    public Integer findByName(String name) {
        return parameter.get(name);
    }

    public Map<String, Integer> findAll() {
        return parameter;
    }

    public void deleteParameter(String name) {

        if (parameter.get(name) == null) {
            System.out.println("parameter does not exist");
        } else {
            parameter.remove(name);
        }
    }

    public Integer changeByName(String name, Integer value) {
        if (name == null) {
            System.out.println(name + " should not be null");
        } else {
            parameter.put(name, value);
            System.out.println(name + " " + "has changed to: " + value);
        }

        return parameter.get(name);
    }
}
