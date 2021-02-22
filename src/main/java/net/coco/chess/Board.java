package net.coco.chess;

import net.coco.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Rank> ranks = new ArrayList<>();
    public static final int BOARD_CELLS = 8;

    public void initialize() {
        clearPieces();
        ranks.add(Rank.initWhitePieces());
        ranks.add(Rank.initWhitePawns());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlackPawns());
        ranks.add(Rank.initBlackPieces());
    }

    private void clearPieces() {
        for (Rank rank : ranks) {
            rank.clear();
        }
    }

    public String getRankResult(int findRank) {
        return getPiecesToString(ranks.get(findRank).getPieces());
    }


    private String getPiecesToString(List<Piece> pieces) {
        return pieces.stream()
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

}
