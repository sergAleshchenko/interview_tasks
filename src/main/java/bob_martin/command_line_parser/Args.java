package bob_martin.command_line_parser;

import bob_martin.command_line_parser.exceptions.ArgsException;
import bob_martin.command_line_parser.marshallers.ArgumentMarshaller;
import bob_martin.command_line_parser.marshallers.BooleanArgumentMarshaller;
import bob_martin.command_line_parser.marshallers.DoubleArgumentMarshaller;
import bob_martin.command_line_parser.marshallers.IntegerArgumentMarshaller;
import bob_martin.command_line_parser.marshallers.StringArgumentMarshaller;
import bob_martin.command_line_parser.marshallers.StringArrayArgumentMarshaller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import static bob_martin.command_line_parser.ErrorCode.INVALID_ARGUMENT_FORMAT;
import static bob_martin.command_line_parser.ErrorCode.INVALID_ARGUMENT_NAME;
import static bob_martin.command_line_parser.ErrorCode.UNEXPECTED_ARGUMENT;

/**
 * @author Sergei Aleshchenko
 */
public class Args {

    private Map<Character, ArgumentMarshaller> marshallers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;


    public Args(String schema, String[] args) throws ArgsException {
        marshallers = new HashMap<>();
        argsFound = new HashSet<>();
        parseSchema(schema);
        parseArgumentStrings(Arrays.asList(args));
    }

    private void parseSchema(String schema) throws ArgsException {
        for (String element : schema.split(",")) {
            if (!element.isEmpty()) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);

        if (elementTail.isEmpty()) {
            marshallers.put(elementId, new BooleanArgumentMarshaller());
        } else if (elementTail.equals("*")) {
            marshallers.put(elementId, new StringArgumentMarshaller());
        } else if (elementTail.equals("#")) {
            marshallers.put(elementId, new IntegerArgumentMarshaller());
        } else if (elementTail.equals("##")) {
            marshallers.put(elementId, new DoubleArgumentMarshaller());
        } else if (elementTail.equals("[*]")) {
            marshallers.put(elementId, new StringArrayArgumentMarshaller());
        } else {
            throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
        }
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId)) {
            throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
        }
    }

    private void parseArgumentStrings(List<String> argsList) throws ArgsException {
        for (currentArgument = argsList.listIterator(), currentArgument.hasNext(); ; ) {
            String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException {
        for (int i = 0; i < argChars.length(); i++) {
            parseArgumentCharacter(argChars.charAt(i));
        }
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException {
        ArgumentMarshaller m = marshallers.get(argChar);
        if (m == null) {
            throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
        } else {
            argsFound.add(argChar);

            try {
                m.set(currentArgument);
            } catch (ArgsException e) {
                e.setErrorArgumentId(argChar);
                throw e;
            }
        }
    }

    public boolean has(char arg) {
        return argsFound.contains(arg);
    }

    public boolean getBoolean(char arg) {
        return BooleanArgumentMarshaller.getValue(marshallers.get(arg));
    }

    public int getInt(char arg) {
        return IntegerArgumentMarshaller.getValue(marshallers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarshaller.getValue(marshallers.get(arg));
    }

//    public String getDouble(char arg) {
//        return DoubleArgumentMarshaller.getValue(marshaller.get(arg));
//    }
//
//    public String[] getStringArray(char arg) {
//        return StringArrayArgumentMarshaller.getValue(marshaller.get(arg));
//    }
}
