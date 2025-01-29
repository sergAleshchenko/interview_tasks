package bob_martin.command_line_parser.marshallers;

import bob_martin.command_line_parser.exceptions.ArgsException;

import java.util.Iterator;

/**
 * @author Sergei Aleshchenko
 */
public class BooleanArgumentMarshaller implements ArgumentMarshaller {
    private boolean booleanValue = false;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }

    public static boolean getValue(ArgumentMarshaller am) {
        if (am != null && am instanceof BooleanArgumentMarshaller) {
            return ((BooleanArgumentMarshaller) am).booleanValue;
        } else {
            return false;
        }
    }
}
