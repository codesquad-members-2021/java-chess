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

    public void initializeEmptyBoard() {
        for(int i =0; i< RANKS_ON_BOARD; i++) {
            rankList.add(Rank.initializeBlankRank());
        }
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
        return rankList.get(RANKS_ON_BOARD-rankNum);
    }

    public Piece findPiece(String location) {
         Position position = Position.at(location);
         return getRank(position.getRankIndex()).getPiece(position.getFileIndex());

    }

    public void addNewPiece(String destination, Piece piece) {
        Position position = Position.at(destination);
        getRank(position.getRankIndex()).replacePiece(position.getFileIndex(), piece);
    }


    public void movePiece(String from, String to) {
        Position startPosition = Position.at(from);
        Position endPosition = Position.at(to);

        Piece foundPiece = findPiece(from);

        if(foundPiece.isPiece()) {
            getRank(startPosition.getRankIndex()).replacePiece(startPosition.getFileIndex(), Piece.createBlank());
            getRank(endPosition.getRankIndex()).replacePiece(endPosition.getFileIndex(), foundPiece);
        }
    }
}
