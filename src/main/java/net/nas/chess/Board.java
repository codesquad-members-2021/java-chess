package net.nas.chess;

import net.nas.pieces.ChessPiece;
import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.NameOfChessPiece;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static net.nas.pieces.ChessPiece.*;
import static net.nas.utils.StringUtils.appendNewLine;

public class Board {
    public static final int LENGTH_OF_BOARD = 8;

    public static final int RANK_OF_WHITE_KING = 0;
    public static final int RANK_OF_WHITE_PAWNS = 1;
    public static final int RANK_OF_BLACK_PAWNS = 6;
    public static final int RANK_OF_BLACK_KING = 7;

    public static final int FILE_OF_ROOK = 0;
    public static final int FILE_OF_KNIGHT = 1;
    public static final int FILE_OF_BISHOP = 2;
    public static final int FILE_OF_WHITE_QUEEN = 3;
    public static final int FILE_OF_WHITE_KING = 4;
    public static final int FILE_OF_BLACK_QUEEN = 4;
    public static final int FILE_OF_BLACK_KING = 3;

    public static final char START_OF_FILE = 'a';
    public static final char END_OF_FILE = 'h';

    private final ChessPiece[][] chessCells;
    private int numberOfPieces = 0;

    public Board() {
        chessCells = new ChessPiece[LENGTH_OF_BOARD][LENGTH_OF_BOARD];
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            for (int j = 0; j < LENGTH_OF_BOARD; j++) {
                chessCells[i][j] = ChessPiece.createBlankPiece();
            }
        }
    }

    public void initialize() {
        initRanksOfPawns();
        initRanksOfKings();
    }

    private static ChessCoordinate parseStringCoordinate(String strCoordinate) {
        if (strCoordinate.length() != 2) {
            throw new InvalidParameterException("Invalid Coordinate! can not parse parameter");
        }
        char fileIndex = Character.toLowerCase(strCoordinate.charAt(0));
        int rankIndex = Character.getNumericValue(strCoordinate.charAt(1));

        if (fileIndex < START_OF_FILE || END_OF_FILE < fileIndex) {
            throw new InvalidParameterException("Invalid File Index! fileIndex : " + fileIndex);
        }
        if (rankIndex < 1 || LENGTH_OF_BOARD < rankIndex) {
            throw new InvalidParameterException("Invalid Rank Index! rankIndex : " + rankIndex);
        }

        return new ChessCoordinate(rankIndex - 1, fileIndex - START_OF_FILE);
    }

    private void initRanksOfPawns() {
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            add(createWhitePawn(), RANK_OF_WHITE_PAWNS, i);
            add(createBlackPawn(), RANK_OF_BLACK_PAWNS, i);
        }
    }

    private void initRanksOfKings() {
        initRankOfWhiteKing();
        initRankOfBlackKing();
    }

    private void initRankOfWhiteKing() {
        add(createWhiteRook(), RANK_OF_WHITE_KING, FILE_OF_ROOK);
        add(createWhiteRook(), RANK_OF_WHITE_KING, LENGTH_OF_BOARD - FILE_OF_ROOK - 1);
        add(createWhiteKnight(), RANK_OF_WHITE_KING, FILE_OF_KNIGHT);
        add(createWhiteKnight(), RANK_OF_WHITE_KING, LENGTH_OF_BOARD - FILE_OF_KNIGHT - 1);
        add(createWhiteBishop(), RANK_OF_WHITE_KING, FILE_OF_BISHOP);
        add(createWhiteBishop(), RANK_OF_WHITE_KING, LENGTH_OF_BOARD - FILE_OF_BISHOP - 1);
        add(createWhiteQueen(), RANK_OF_WHITE_KING, FILE_OF_WHITE_QUEEN);
        add(createWhiteKing(), RANK_OF_WHITE_KING, FILE_OF_WHITE_KING);
    }

    private void initRankOfBlackKing() {
        add(createBlackRook(), RANK_OF_BLACK_KING, FILE_OF_ROOK);
        add(createBlackRook(), RANK_OF_BLACK_KING, LENGTH_OF_BOARD - FILE_OF_ROOK - 1);
        add(createBlackKnight(), RANK_OF_BLACK_KING, FILE_OF_KNIGHT);
        add(createBlackKnight(), RANK_OF_BLACK_KING, LENGTH_OF_BOARD - FILE_OF_KNIGHT - 1);
        add(createBlackBishop(), RANK_OF_BLACK_KING, FILE_OF_BISHOP);
        add(createBlackBishop(), RANK_OF_BLACK_KING, LENGTH_OF_BOARD - FILE_OF_BISHOP - 1);
        add(createBlackQueen(), RANK_OF_BLACK_KING, FILE_OF_BLACK_QUEEN);
        add(createBlackKing(), RANK_OF_BLACK_KING, FILE_OF_BLACK_KING);
    }

    public String getRepresentationOfBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = LENGTH_OF_BOARD - 1; i >= 0; i--) {
            sb.append(appendNewLine(getRepresentationOfRank(i)));
        }
        return sb.toString();
    }

    private String getRepresentationOfRank(int rankIdx) {
        return Arrays.stream(chessCells[rankIdx])
                .map(ChessPiece::getRepresentation)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return getRepresentationOfRank(RANK_OF_WHITE_PAWNS);
    }

    public String getBlackPawnsResult() {
        return getRepresentationOfRank(RANK_OF_BLACK_PAWNS);
    }

    public void add(ChessPiece piece, int rankIdx, int fileIdx) {
        if (piece == null) {
            throw new InvalidParameterException("Null value cannot be added in Board");
        }
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx)) {
            throw new InvalidParameterException("index exceeded the bounds of the Board. rankIndex : " + rankIdx + " fileIndex : " + fileIdx);
        }
        chessCells[rankIdx][fileIdx] = piece;
        if (!piece.isBlank()) {
            numberOfPieces++;
        }
    }

    public ChessPiece findPiece(int rankIdx, int fileIdx) {
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        return chessCells[rankIdx][fileIdx];
    }

    public ChessPiece findPiece(String strCoordinate) {
        ChessCoordinate coordinate = parseStringCoordinate(strCoordinate);
        return chessCells[coordinate.rankIndex][coordinate.fileIndex];
    }

    private boolean isInvalidIdx(int idx) {
        return 0 > idx || idx >= LENGTH_OF_BOARD;
    }

    public int size() {
        return numberOfPieces;
    }

    public void initBoardByStringArray(String[] stringArray) {
        if (stringArray.length != LENGTH_OF_BOARD) {
            throw new InvalidParameterException("The length of a string array should have to be same with a " +
                    "length of a chess board. Length of stringArray : " + stringArray.length);
        }
        for (int i = 0; i < stringArray.length; i++) {
            initRankByString(stringArray[i], stringArray.length - i - 1);
        }
    }

    private void initRankByString(String strRank, int rankIndex) {
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            char currChar = strRank.charAt(i);
            NameOfChessPiece nameOfCurrPiece = NameOfChessPiece.getNameByRepresentation(String.valueOf(currChar));
            ColorOfChessPiece colorOfCurrPiece;
            if (currChar == '.') {
                colorOfCurrPiece = ColorOfChessPiece.BLANK;
            } else if (currChar < 'a') {
                colorOfCurrPiece = ColorOfChessPiece.BLACK;
            } else {
                colorOfCurrPiece = ColorOfChessPiece.WHITE;
            }
            add(createChessPiece(nameOfCurrPiece, colorOfCurrPiece), rankIndex, i);
        }
    }

    public int getNumberOfDesignatedPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        int numberOfDesignatedPiece = 0;
        for (int rankIndex = 0; rankIndex < LENGTH_OF_BOARD; rankIndex++) {
            for (int fileIndex = 0; fileIndex < LENGTH_OF_BOARD; fileIndex++) {
                ChessPiece currCell = chessCells[rankIndex][fileIndex];
                if (currCell.getRepresentation().equals(color.getRepresentationByColor(name))) {
                    numberOfDesignatedPiece++;
                }
            }
        }
        return numberOfDesignatedPiece;
    }

}
