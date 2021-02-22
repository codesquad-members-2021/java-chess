package net.jung.chess;

import net.jung.chess.pieces.Color;
import net.jung.chess.pieces.Type;
import net.jung.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> blackPieceList = new ArrayList();
    private List<Piece> whitePieceList = new ArrayList();

    public void addWhitePiece(Piece piece) {
        if (piece.isWhite()) {
            whitePieceList.add(piece);
        }
    }

    public void addBlackPiece(Piece piece) {
        if (piece.isBlack()) {
            blackPieceList.add(piece);
        }
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
        initializePiecesExceptPawn(Color.BLACK);
        iniitializePawns(Color.BLACK);

        iniitializePawns(Color.WHITE);
        initializePiecesExceptPawn(Color.WHITE);
    }

    public void iniitializePawns(Color color){
        int maxPawnsSize = 8;
        for (int i = 0; i < maxPawnsSize; i++) {
            addPiece(Piece.createPiece(color, Type.PAWN));
        }
    }

    public void initializePiecesExceptPawn(Color color){
        addPiece(Piece.createPiece(color, Type.ROOK));
        addPiece(Piece.createPiece(color, Type.KNIGHT));
        addPiece(Piece.createPiece(color, Type.BISHOP));
        addPiece(Piece.createPiece(color, Type.QUEEN));
        addPiece(Piece.createPiece(color, Type.KING));
        addPiece(Piece.createPiece(color, Type.BISHOP));
        addPiece(Piece.createPiece(color, Type.KNIGHT));
        addPiece(Piece.createPiece(color, Type.ROOK));
    }

    public String getWhitePiecesResult() {
        return getPiecesRepresentation(whitePieceList);
    }

    public String getBlackPiecesResult() {
        return getPiecesRepresentation(blackPieceList);
    }

    public String getPiecesRepresentation(List<Piece> pieceList) {
        StringBuilder piecesRepresentation = new StringBuilder();
        for (int i = 0, colorPawnSize = pieceList.size(); i < colorPawnSize; i++) {
            piecesRepresentation.append(pieceList.get(i).getRepresentation());
            if(i==7)
                piecesRepresentation.append(System.getProperty("line.separator"));
        }
        return piecesRepresentation.toString();
    }

    public String boardLayoutToString() {
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
