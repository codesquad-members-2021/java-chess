package net.jung.chess;
import java.util.*;

import static net.jung.chess.Piece.*;

public class Rank {
    private ArrayList<Piece> pieceList = new ArrayList<>();
    private Rank() {};
    private static final int MAX_RANK_NUMBER =8;


    public static Rank initializeWhitePawnRank() {
        Rank whitePawnRank = new Rank();
        for(int i =0; i< MAX_RANK_NUMBER; i++) {
            whitePawnRank.pieceList.add(createWhitePawn());
        }
        return whitePawnRank;
    }

    public static Rank initializeBlackPawnRank() {
        Rank blackPawnRank = new Rank();
        for(int i =0; i< MAX_RANK_NUMBER; i++) {
            blackPawnRank.pieceList.add(createBlackPawn());
        }
        return blackPawnRank;
    }


    public static Rank initializeWhitePieceRank() {
        Rank whitePieceRank = new Rank();

        whitePieceRank.pieceList.add(createWhiteRook());
        whitePieceRank.pieceList.add(createWhiteKnight());
        whitePieceRank.pieceList.add(createWhiteBishop());
        whitePieceRank.pieceList.add(createWhiteQueen());
        whitePieceRank.pieceList.add(createWhiteKing());
        whitePieceRank.pieceList.add(createWhiteBishop());
        whitePieceRank.pieceList.add(createWhiteKnight());
        whitePieceRank.pieceList.add(createWhiteRook());

        return whitePieceRank;
    }

    public static Rank initializeBlackPieceRank() {
        Rank blackPieceRank = new Rank();

        blackPieceRank.pieceList.add(createBlackRook());
        blackPieceRank.pieceList.add(createBlackKnight());
        blackPieceRank.pieceList.add(createBlackBishop());
        blackPieceRank.pieceList.add(createBlackQueen());
        blackPieceRank.pieceList.add(createBlackKing());
        blackPieceRank.pieceList.add(createBlackBishop());
        blackPieceRank.pieceList.add(createBlackKnight());
        blackPieceRank.pieceList.add(createBlackRook());

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
