package net.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String text) {
        //인자로 전달한 메소드에 newline문자 추가하는 메소드
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(NEWLINE);
        return sb.toString();
    }

    //생성자를 private으로 선언해서 StringUtils 클래스를 직접 생성할 수 없도록 한다.
    private StringUtils() { }


}
