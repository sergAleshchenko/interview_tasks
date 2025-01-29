package bob_martin.command_line_parser.marshallers;

import bob_martin.command_line_parser.exceptions.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static bob_martin.command_line_parser.ErrorCode.INVALID_INTEGER;
import static bob_martin.command_line_parser.ErrorCode.MISSING_INTEGER;

/**
 * @author Sergei Aleshchenko
 */
public class IntegerArgumentMarshaller implements ArgumentMarshaller {
    private int intValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;

        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaller am) {
        if (am != null && am instanceof IntegerArgumentMarshaller) {
            return ((IntegerArgumentMarshaller) am).intValue;
        } else {
            return 0;
        }
    }
}
