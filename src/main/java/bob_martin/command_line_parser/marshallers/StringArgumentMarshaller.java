package bob_martin.command_line_parser.marshallers;

import bob_martin.command_line_parser.exceptions.ArgsException;

import java.util.Iterator;

import static bob_martin.command_line_parser.ErrorCode.MISSING_STRING;

/**
 * @author Sergei Aleshchenko
 */
public class StringArgumentMarshaller implements ArgumentMarshaller {
    private String stringValue;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (Exception e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaller am) {
        if (am != null && am instanceof StringArgumentMarshaller) {
            return ((StringArgumentMarshaller) am).stringValue;
        } else {
            return "";
        }
    }
}
