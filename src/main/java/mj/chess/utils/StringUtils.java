package mj.chess.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String inputString){
        StringBuffer newLinePlus = new StringBuffer();
        newLinePlus.append(inputString);
        newLinePlus.append(NEWLINE);
        return newLinePlus.toString();
    }

}
