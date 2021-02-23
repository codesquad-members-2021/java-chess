package chess;

import pieces.Piece;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces  = new ArrayList<>();
    private List<Piece> blackPieces  = new ArrayList<>();

    public static final int PAWN_NUMBER = 8;

    private void addWhitePawn(Piece whitePawn) {
        whitePawns.add(whitePawn);
    }

    private void addBlackPawn(Piece blackPawn) {
        blackPawns.add(blackPawn);
    }

    public void initialize() {
        for(int i = 0; i < PAWN_NUMBER; i++){
            addWhitePawn(Piece.createWhitePawnInstance());
            addBlackPawn(Piece.createBlackPawnInstance());
        }
            addWhitePieces();
            addBlackPieces();
    }

    private void addWhitePieces() {
        whitePieces.add(Piece.createWhiteRookInstance());
        whitePieces.add(Piece.createWhiteKnightInstance());
        whitePieces.add(Piece.createWhiteBishopInstance());
        whitePieces.add(Piece.createWhiteKingInstance());
        whitePieces.add(Piece.createWhiteQueenInstance());
        whitePieces.add(Piece.createWhiteBishopInstance());
        whitePieces.add(Piece.createWhiteKnightInstance());
        whitePieces.add(Piece.createWhiteRookInstance());
    }

    private void addBlackPieces() {
        blackPieces.add(Piece.createBlackRookInstance());
        blackPieces.add(Piece.createBlackKnightInstance());
        blackPieces.add(Piece.createBlackBishopInstance());
        blackPieces.add(Piece.createBlackKingInstance());
        blackPieces.add(Piece.createBlackQueenInstance());
        blackPieces.add(Piece.createBlackBishopInstance());
        blackPieces.add(Piece.createBlackKnightInstance());
        blackPieces.add(Piece.createBlackRookInstance());
    }

    String bringWhitePawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < whitePawns.size(); i++){
            sb.append(Piece.WHITE_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    String bringBlackPawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < blackPawns.size(); i++){
            sb.append(Piece.BLACK_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    String getDotOnBoard(){
        return "........";
    }

    public void printBoard(){
        String board = bringBoard();
        System.out.println(board);
    }

    public int pieceCount() {
        return sizeOfPieces();
    }

    private int sizeOfPieces() {
        return whitePawns.size() +
                whitePieces.size() +
                blackPawns.size() +
                blackPieces.size();
    }

    public String bringBoard() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.appendNewLine(getDotOnBoard()));
        sb.append(StringUtils.appendNewLine(bringWhitePawnsRepresentation()));
        sb.append(StringUtils.appendNewLine(getDotOnBoard()));
        sb.append(StringUtils.appendNewLine(getDotOnBoard()));
        sb.append(StringUtils.appendNewLine(getDotOnBoard()));
        sb.append(StringUtils.appendNewLine(getDotOnBoard()));
        sb.append(StringUtils.appendNewLine(bringBlackPawnsRepresentation()));
        sb.append(StringUtils.appendNewLine(getDotOnBoard()));

        return sb.toString();
    }
}

