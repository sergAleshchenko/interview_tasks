package interview_300_questions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.io.IOException;

/**
 * @author Sergei Aleshchenko
 */
public class RuntimeDemo {

    private String any;

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("notepad");
    }
}
