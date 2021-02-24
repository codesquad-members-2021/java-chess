package net.jung.chess;

import net.jung.chess.pieces.Color;
import net.jung.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> blackPieceList = new ArrayList();
    private List<Piece> whitePieceList = new ArrayList();
    public static final String BLANK_RANK = appendNewLine("********");

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


    public int size() {
        return whitePieceListSize() + blackPieceListSize();
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
        initializeBlackPieces();
        initializePawns(Color.BLACK);

        initializePawns(Color.WHITE);
        initializeWhitePieces();
    }

    public void initializePawns(Color color) {
        int maxPawnsSize = 8;
        if(color == Color.WHITE) {
            for (int i = 0; i < maxPawnsSize; i++) {
            addWhitePiece(Piece.createWhitePawn());
            }
        return;
        }

        for(int j = 0; j < maxPawnsSize; j++) {
            addBlackPiece(Piece.createBlackPawn());
        }
    }

    public void initializeBlackPieces(){
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    public void initializeWhitePieces(){
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }


    public String getWhitePiecesRepresentation() {
        return getPiecesRepresentation(whitePieceList);
    }

    public String getBlackPiecesRepresentation() {
        return getPiecesRepresentation(blackPieceList);
    }

    public String getPiecesRepresentation(List<Piece> pieceList) {
        StringBuilder piecesRepresentation = new StringBuilder();
        for (int i = 0; i < pieceList.size(); i++) {
            piecesRepresentation.append(pieceList.get(i).getRepresentation());
            if(i==7) {
                piecesRepresentation.append(System.getProperty("line.separator"));
            }
        }
        return piecesRepresentation.toString();
    }

    public String boardLayoutToString() {

        StringBuilder boardLayout = new StringBuilder();
        boardLayout
                .append(appendNewLine(getBlackPiecesRepresentation()))
                .append(BLANK_RANK)
                .append(BLANK_RANK)
                .append(BLANK_RANK)
                .append(BLANK_RANK)
                .append(appendNewLine(getWhitePiecesRepresentation()));
        return boardLayout.toString();
    }

    public void reset() {
        whitePieceList.clear();
        blackPieceList.clear();
    }


}
