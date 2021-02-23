package net.nas.chess;

import java.security.InvalidParameterException;

public class ChessCoordinate {
    public final int rankIndex;
    public final int fileIndex;

    protected ChessCoordinate(int rankIndex, int fileIndex) {
        this.rankIndex = rankIndex;
        this.fileIndex = fileIndex;
    }

    protected static ChessCoordinate parseStringCoordinate(String strCoordinate) {
        if (strCoordinate.length() != 2) {
            throw new InvalidParameterException("Invalid Coordinate! can not parse parameter");
        }
        char fileIndex = Character.toLowerCase(strCoordinate.charAt(0));
        int rankIndex = Character.getNumericValue(strCoordinate.charAt(1));

        if (fileIndex < Board.START_OF_FILE || Board.END_OF_FILE < fileIndex) {
            throw new InvalidParameterException("Invalid File Index! fileIndex : " + fileIndex);
        }
        if (rankIndex < 1 || Board.LENGTH_OF_BOARD < rankIndex) {
            throw new InvalidParameterException("Invalid Rank Index! rankIndex : " + rankIndex);
        }
        return new ChessCoordinate(rankIndex - 1, fileIndex - Board.START_OF_FILE);
    }
}
