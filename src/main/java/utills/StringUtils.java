package utills;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {

    }

    public static String appendNewLine(){

        return NEWLINE;
    }
}
