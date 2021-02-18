package net.jung.chess;

import net.jung.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> blackPieceList = new ArrayList();
    private List<Piece> whitePieceList = new ArrayList();

    public void addWhitePiece(Piece piece) {
        if(piece.getColor() == Color.WHITE)
        whitePieceList.add(piece);
    }

    public void addBlackPiece(Piece piece) {
        if(piece.getColor() == Color.BLACK)
        blackPieceList.add(piece);
    }

    public int size() {
        return whitePieceList.size() + blackPieceList.size();
    }

    public int whitePieceListSize() { return whitePieceList.size(); }

    public int blackPieceListSize() {
        return blackPieceList.size();
    }

    public Piece findWhitePiece(int index) {
        return whitePieceList.get(index);
    }

    public Piece findBlackPiece(int index) {
        return blackPieceList.get(index);
    }

    public void initialize() {
        int MAX_PAWNS_SIZE =8;
        for (int i = 0; i < MAX_PAWNS_SIZE; i++) {
            addWhitePiece(Piece.createPiece(Color.WHITE, Name.PAWN));
            addBlackPiece(Piece.createPiece(Color.BLACK, Name.PAWN));
        }
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePieceList);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPieceList);
    }

    public String getPawnsResult(List<Piece> pieceList) {
        StringBuilder pawnReps = new StringBuilder();
        int colorPawnSize = pieceList.size();
        for (int i = 0; i < colorPawnSize; i++) {
            pawnReps.append(pieceList.get(i).getRepresentation());
        }
        return pawnReps.toString();
    }

    public String print() {
        String blankRow = "********";
        StringBuilder boardLayout = new StringBuilder();
        boardLayout.append(appendNewLine(blankRow))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(blankRow);
        return boardLayout.toString();
    }

    public void reset(){
        whitePieceList.clear();
        blackPieceList.clear();
    }


}
