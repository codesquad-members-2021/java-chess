package net.jung.chess;

import net.jung.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> blackPieceList = new ArrayList();
    private List<Piece> whitePieceList = new ArrayList();

    public void addWhitePiece(Piece piece) {
        if (piece.getColor() == Color.WHITE)
            whitePieceList.add(piece);
    }

    public void addBlackPiece(Piece piece) {
        if (piece.getColor() == Color.BLACK)
            blackPieceList.add(piece);
    }

    public void addPiece(Piece piece){
        if(piece.getColor()==Color.WHITE) {
            whitePieceList.add(piece);
            return;
        }
        blackPieceList.add(piece);
    }

    public int size() {
        return whitePieceList.size() + blackPieceList.size();
    }

    public int whitePieceListSize() {
        return whitePieceList.size();
    }

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
        piecesExceptPawnInitialize(Color.BLACK);
        pawnInitialize(Color.BLACK);

        pawnInitialize(Color.WHITE);
        piecesExceptPawnInitialize(Color.WHITE);
    }

    public void pawnInitialize(Color color){
        int MAX_PAWNS_SIZE = 8;
        for (int i = 0; i < MAX_PAWNS_SIZE; i++) {
            addPiece(Piece.createPiece(color, Name.PAWN));
        }
    }

    public void piecesExceptPawnInitialize(Color color){
        addPiece(Piece.createPiece(color, Name.ROOK));
        addPiece(Piece.createPiece(color, Name.KNIGHT));
        addPiece(Piece.createPiece(color, Name.BISHOP));
        addPiece(Piece.createPiece(color, Name.QUEEN));
        addPiece(Piece.createPiece(color, Name.KING));
        addPiece(Piece.createPiece(color, Name.BISHOP));
        addPiece(Piece.createPiece(color, Name.KNIGHT));
        addPiece(Piece.createPiece(color, Name.ROOK));
    }

    public String getWhitePiecesResult() {
        return getPiecesResult(whitePieceList);
    }

    public String getBlackPiecesResult() {
        return getPiecesResult(blackPieceList);
    }

    public String getPiecesResult(List<Piece> pieceList) {
        StringBuilder pawnReps = new StringBuilder();
        for (int i = 0, colorPawnSize = pieceList.size(); i < colorPawnSize; i++) {
            pawnReps.append(pieceList.get(i).getRepresentation());
            if(i==7)
                pawnReps.append(System.getProperty("line.separator"));
        }
        return pawnReps.toString();
    }

    public String print() {
        String blankRow = "********";
        StringBuilder boardLayout = new StringBuilder();
        boardLayout
                .append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(blankRow))
                .append(appendNewLine(getWhitePiecesResult()));
        return boardLayout.toString();
    }

    public void reset() {
        whitePieceList.clear();
        blackPieceList.clear();
    }


}
