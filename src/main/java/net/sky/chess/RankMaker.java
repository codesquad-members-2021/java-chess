package net.sky.chess;

import net.sky.pieces.PieceMaker;

public class RankMaker {

    PieceMaker pieceMaker;

    public RankMaker(PieceMaker pieceMaker) {
        this.pieceMaker = pieceMaker;
    }

    public Rank createPieceRank() {
        Rank rank = new Rank();
        rank.add(pieceMaker.createRook());
        rank.add(pieceMaker.createKnight());
        rank.add(pieceMaker.createBishop());
        rank.add(pieceMaker.createQueen());
        rank.add(pieceMaker.createKing());
        rank.add(pieceMaker.createBishop());
        rank.add(pieceMaker.createKnight());
        rank.add(pieceMaker.createRook());
        return rank;
    }

    public Rank createPawnRank() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.add(pieceMaker.createPawn());
        }
        return rank;
    }

    public static Rank createBlankRank() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.add(PieceMaker.createBlank());
        }
        return rank;
    }
}
