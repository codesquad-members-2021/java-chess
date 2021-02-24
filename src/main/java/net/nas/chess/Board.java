package net.nas.chess;

import net.nas.pieces.ChessPiece;
import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.NameOfChessPiece;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private String getRepresentationOfRank(int rankIndex) {
        return Arrays.stream(chessCells[rankIndex])
                .map(ChessPiece::getRepresentation)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return getRepresentationOfRank(RANK_OF_WHITE_PAWNS);
    }

    public String getBlackPawnsResult() {
        return getRepresentationOfRank(RANK_OF_BLACK_PAWNS);
    }

    public void add(ChessPiece piece, int rankIndex, int fileIndex) {
        if (piece == null) {
            throw new InvalidParameterException("Null value cannot be added in Board");
        }
        if (isInvalidIndex(rankIndex) || isInvalidIndex(fileIndex)) {
            throw new InvalidParameterException("index exceeded the bounds of the Board. rankIndex : " + rankIndex + " fileIndex : " + fileIndex);
        }
        chessCells[rankIndex][fileIndex] = piece;
        if (!piece.isBlank()) {
            numberOfPieces++;
        }
    }

    public void add(ChessPiece piece, String strCoordinate) {
        ChessCoordinate coordinate = ChessCoordinate.parseStringCoordinate(strCoordinate);
        add(piece, coordinate.rankIndex, coordinate.fileIndex);
    }

    public ChessPiece findPiece(int rankIndex, int fileIndex) {
        if (isInvalidIndex(rankIndex) || isInvalidIndex(fileIndex))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        return chessCells[rankIndex][fileIndex];
    }

    public ChessPiece findPiece(String strCoordinate) {
        ChessCoordinate coordinate = ChessCoordinate.parseStringCoordinate(strCoordinate);
        return chessCells[coordinate.rankIndex][coordinate.fileIndex];
    }

    private boolean isInvalidIndex(int index) {
        return 0 > index || index >= LENGTH_OF_BOARD;
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
            ColorOfChessPiece colorOfCurrPiece = ColorOfChessPiece.getColorByRepresentation(currChar);
            add(createChessPiece(nameOfCurrPiece, colorOfCurrPiece), rankIndex, i);
        }
    }

    public int getNumberOfDesignatedPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        int numberOfDesignatedPiece = 0;
        for (int rankIndex = 0; rankIndex < LENGTH_OF_BOARD; rankIndex++) {
            for (int fileIndex = 0; fileIndex < LENGTH_OF_BOARD; fileIndex++) {
                ChessPiece currCell = chessCells[rankIndex][fileIndex];
                if (currCell.hasSameProperty(name, color)) {
                    numberOfDesignatedPiece++;
                }
            }
        }
        return numberOfDesignatedPiece;
    }

    public float calculatePoint(ColorOfChessPiece color) {
        float totalPoint = 0;
        for (int fileIndex = 0; fileIndex < LENGTH_OF_BOARD; fileIndex++) {
            int numOfPawnInFile = 0;
            for (int rankIndex = 0; rankIndex < LENGTH_OF_BOARD; rankIndex++) {
                ChessPiece currentPiece = chessCells[rankIndex][fileIndex];
                if (currentPiece.isNotSameColor(color)) {
                    continue;
                }
                if (currentPiece.isBlank()) {
                    continue;
                }
                if (currentPiece.isSameName(NameOfChessPiece.PAWN)) {
                    numOfPawnInFile++;
                }
                totalPoint += currentPiece.getPoint();
            }
            if (numOfPawnInFile >= 2) {
                totalPoint -= numOfPawnInFile * NameOfChessPiece.SCORE_OF_SPECIAL_PAWN;
            }
        }
        return totalPoint;
    }

    public List<ChessPiece> getPiecesOfColor(ColorOfChessPiece color, boolean isAsc) {
        List<ChessPiece> pieceList = new ArrayList<>();
        for (int fileIndex = 0; fileIndex < LENGTH_OF_BOARD; fileIndex++) {
            for (int rankIndex = 0; rankIndex < LENGTH_OF_BOARD; rankIndex++) {
                ChessPiece currentPiece = chessCells[rankIndex][fileIndex];
                if (currentPiece.isNotSameColor(color)) {
                    continue;
                }
                if (currentPiece.isBlank()) {
                    continue;
                }
                pieceList.add(currentPiece);
            }
        }
        if (isAsc) {
            pieceList.sort(createBlackBishop().comparatorAsc);
        } else {
            pieceList.sort(createBlackBishop().comparatorDesc);
        }
        return pieceList;
    }
}
