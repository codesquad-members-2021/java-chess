package net.isaac.chess;

public class Position {
    public final int rank;
    public final char file;

    private Position(char file, int rank) {
        this.rank = rank;
        this.file = file;
    }

    public static Position getPosition(String position) {
        if (!isValid(position)) {
            return null;
        }
        char file = Character.toLowerCase(position.charAt(0));
        int rank = Character.getNumericValue(position.charAt(1));
        return new Position(file, rank);
    }

    private static boolean isValid(String position) {
        return (position.length() == 2 &&
                Character.isAlphabetic(position.charAt(0)) &&
                Character.isDigit(position.charAt(1)));
    }
}
