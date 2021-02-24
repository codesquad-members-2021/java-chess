package net.jung.chess;

import java.util.ArrayList;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> rankList = new ArrayList<Rank>();
    public static final int RANKS_ON_BOARD = 8;

    public int boardPieceSize() {
        int boardPieceSize = 0;

        for (Rank rank : rankList) {
            boardPieceSize += rank.rankPieceSize();
        }
        return boardPieceSize ;
    }

    public int certainPieceSize(Piece.Color color, Piece.Type type) {
        int size = 0;
        for( Rank rank : rankList ) {
            for(int i =0; i< Rank.MAX_PIECES_IN_RANK; i++) {
                boolean isColorType = (rank.getPiece(i).getType() == type)
                                    && (rank.getPiece(i).getColor() == color);
                size += isColorType ? 1 : 0 ;
            }
        }
        return size;
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

    public Rank getRank(int rankNum) {
        if( 1>rankNum || rankNum >8 ){
            throw new IllegalArgumentException("Rank는 1~8까지 있습니다.");
        }
        return rankList.get(RANKS_ON_BOARD-rankNum);
    }

    public Piece findPiece(String location) {
         char[] position = location.toCharArray();
         if(position.length == 2 && isValidFile(position[0]) && isValidRank(position[1])){
             int fileAlphabet = position[0] - 'a';
             int rankNum = position[1]-'0';
             return getRank(rankNum).getPiece(fileAlphabet);
         }
         throw new IllegalArgumentException("입력한 값을 확인해주세요. \"a1\"~\"h8\"까지 가능합니다.");
    }

    public boolean isValidRank(char rankNum) {
        return (rankNum >= '1' && rankNum <= '8' );
    }

    public boolean isValidFile(char fileAlphabet) {
        return (fileAlphabet >= 'a' && fileAlphabet <= 'h');
    }


}
