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
        return boardPieceSize;
    }

    public int certainPieceSize(Piece.Color color, Piece.Type type) {   // 메서드 분리해서 반복문 여러개 제거
        int size = 0;
        for (Rank rank : rankList) {
            for (int i = 0; i < Rank.MAX_PIECES_IN_RANK; i++) {
                size += rank.getPiece(i).isColorType(color, type) ? 1 : 0;
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
        for (int i = 0; i < RANKS_ON_BOARD; i++) {
            rankList.add(Rank.initializeBlankRank());
        }
    }

    public String boardLayoutToString() {
        StringBuilder boardLayout = new StringBuilder();
        for (Rank rank : rankList) {
            boardLayout.append(appendNewLine(rank.getRankRepresentation()));
        }
        return boardLayout.toString();
    }

    public void reset() {
        for (Rank rank : rankList) {
            rank.resetRank();
        }
    }

    public Rank getRank(int rankNum) {
        return rankList.get(RANKS_ON_BOARD - rankNum);
    }

    public Piece findPiece(Position position) {
        return getRank(position.getRankIndex()).getPiece(position.getFileIndex());

    }

    public void addNewPiece(Position destination, Piece piece) {
        getRank(destination.getRankIndex()).replacePiece(destination.getFileIndex(), piece);
    }


    public void movePiece(Position startPosition, Position endPosition) {
        Piece foundPiece = findPiece(startPosition);

        if (foundPiece.isPiece()) {
            getRank(startPosition.getRankIndex()).replacePiece(startPosition.getFileIndex(), Piece.createBlank());
            getRank(endPosition.getRankIndex()).replacePiece(endPosition.getFileIndex(), foundPiece);
        }
    }

    public double calculatePoints(Piece.Color color) {
        double points = 0;

        List<Piece> colorPieceList = getPieceListByColor(color);
        for(int i =0; i<colorPieceList.size(); i++) {
            points += colorPieceList.get(i).getDefaultPoint();
        }

        points -= pawnSizeInFile(color) * 0.5;
        return points;
    }

    public List<Piece> getPieceListByColor(Piece.Color color) {
        List<Piece> colorPieceList = new ArrayList<>();

        for (Rank rank : rankList) {
            for (int i = 0; i < Rank.MAX_PIECES_IN_RANK; i++) {
                Piece piece = rank.getPiece(i);
                if (piece.getColor() == color) {
                    colorPieceList.add(piece);
                }
            }
        }
        return colorPieceList;
    }

    public int pawnSizeInFile(Piece.Color color) {
        int[] pawnsInFile = new int[8];
        int excessPawnsInFile = 0;

        for (Rank rank : rankList) {
            for (int i = 0; i < Rank.MAX_PIECES_IN_RANK; i++) {
               Piece piece = rank.getPiece(i);
               pawnsInFile[i] += piece.isColorType(color, Piece.Type.PAWN) ? 1 : 0;
            }
        }

        for (int pawnSize : pawnsInFile) {
            excessPawnsInFile += pawnSize > 1 ? pawnSize : 0 ;
        }

        return excessPawnsInFile;
    }

}
