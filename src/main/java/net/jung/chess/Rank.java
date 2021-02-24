package net.jung.chess;
import java.util.*;

import static net.jung.chess.Piece.*;

public class Rank {
    private ArrayList<Piece> pieceList = new ArrayList<>();
    private Rank() {};
    private static final int MAX_RANK_NUMBER =8;

    public int size() {
        return pieceList.size();
    }

    public void addWhitePiece(Piece piece) {
        if(piece.isWhite()){
            pieceList.add(piece);
        }
    }

    public void addBlackPiece(Piece piece) {
        if(piece.isBlack()){
            pieceList.add(piece);
        }
    }

    public static Rank initializeWhitePawnRank() {
        Rank whitePawnRank = new Rank();
        for(int i =0; i< MAX_RANK_NUMBER; i++) {
            whitePawnRank.addWhitePiece(createWhitePawn());
        }
        return whitePawnRank;
    }

    public static Rank initializeBlackPawnRank() {
        Rank blackPawnRank = new Rank();
        for(int i =0; i< MAX_RANK_NUMBER; i++) {
            blackPawnRank.addBlackPiece(createBlackPawn());
        }
        return blackPawnRank;
    }


    public static Rank initializeWhitePieceRank() {
        Rank whitePieceRank = new Rank();

        whitePieceRank.addWhitePiece(createWhiteRook());
        whitePieceRank.addWhitePiece(createWhiteKnight());
        whitePieceRank.addWhitePiece(createWhiteBishop());
        whitePieceRank.addWhitePiece(createWhiteQueen());
        whitePieceRank.addWhitePiece(createWhiteKing());
        whitePieceRank.addWhitePiece(createWhiteBishop());
        whitePieceRank.addWhitePiece(createWhiteKnight());
        whitePieceRank.addWhitePiece(createWhiteRook());

        return whitePieceRank;
    }

    public static Rank initializeBlackPieceRank() {
        Rank blackPieceRank = new Rank();

        blackPieceRank.addBlackPiece(createBlackRook());
        blackPieceRank.addBlackPiece(createBlackKnight());
        blackPieceRank.addBlackPiece(createBlackBishop());
        blackPieceRank.addBlackPiece(createBlackQueen());
        blackPieceRank.addBlackPiece(createBlackKing());
        blackPieceRank.addBlackPiece(createBlackBishop());
        blackPieceRank.addBlackPiece(createBlackKnight());
        blackPieceRank.addBlackPiece(createBlackRook());

        return blackPieceRank;
    }

    public static Rank initializeBlankRank() {
        Rank blankRank = new Rank();

        for(int i =0; i<MAX_RANK_NUMBER; i++){
            blankRank.pieceList.add(createBlank());
        }
        return blankRank;
    }
}
