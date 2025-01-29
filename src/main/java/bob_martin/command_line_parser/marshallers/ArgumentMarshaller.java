package bob_martin.command_line_parser.marshallers;

import bob_martin.command_line_parser.exceptions.ArgsException;

import java.util.Iterator;

/**
 * @author Sergei Aleshchenko
 */
public interface ArgumentMarshaller {
    void set(Iterator<String> currentArgument) throws ArgsException;
}
