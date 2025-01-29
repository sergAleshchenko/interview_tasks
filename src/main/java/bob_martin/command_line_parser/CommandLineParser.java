package bob_martin.command_line_parser;

import bob_martin.command_line_parser.exceptions.ArgsException;

/**
 * @author Sergei Aleshchenko
 */
public class CommandLineParser {

    public static void main(String[] args) {

        try {
            Args arg = new Args("l,p#,d*", args);

            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');

            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("logging: %s, port: %d, directory %s", logging, port, directory);
    }
}
