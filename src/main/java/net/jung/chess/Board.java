package net.jung.chess;

import java.util.ArrayList;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> rankList = new ArrayList<Rank>();

    public int boardPieceSize() {
        int boardPieceSize = 0;
        for (Rank rank : rankList) {
            boardPieceSize += rank.rankPieceSize();
        }
        return boardPieceSize ;
    }

    public void initialize() {
        rankList.add(Rank.initializeBlackPieceRank());
        rankList.add(Rank.initializeBlackPawnRank());

        rankList.add(Rank.initializeBlankRank());
        rankList.add(Rank.initializeBlankRank());
        rankList.add(Rank.initializeBlankRank());
        rankList.add(Rank.initializeBlankRank());

        rankList.add(Rank.initializeWhitePawnRank());
        rankList.add(Rank.initializeWhitePieceRank());
    }



    public String boardLayoutToString() {
        StringBuilder boardLayout = new StringBuilder();
            for(Rank rank : rankList){
                boardLayout.append(appendNewLine(rank.getRankRepresentation()));
            }
        return boardLayout.toString();
    }

    public void reset() {
        for( Rank rank : rankList ) {
            rank.resetRank();
        }
    }


}
