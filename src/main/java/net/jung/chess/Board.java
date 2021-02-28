package net.jung.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int RANKS_ON_BOARD = 8;
    private List<Rank> rankList = new ArrayList<Rank>();

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
            boardLayout.append(appendNewLine(rank.rankLayoutToString()));
        }
        return boardLayout.toString();
    }

    public void reset() {
        rankList.clear();
    }

    public Rank getRank(int rankNum) {
        return rankList.get(RANKS_ON_BOARD - rankNum);
    }

    public Piece findPiece(Position position) {
        return getRank(position.getRankIndex()).getPiece(position.getFileIndex());
    }

    public void addNewPiece(Position position, Piece newPiece) {
        getRank(position.getRankIndex()).replacePiece(position.getFileIndex(), newPiece);
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
        points = colorPieceList.stream()
                .mapToDouble(Piece::getDefaultPoint)
                .sum();

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
            if(pawnSize>1) {
                excessPawnsInFile += pawnSize ;
            }
        }

        return excessPawnsInFile;
    }

    public List<Piece> sortColorPiecesAscending(Piece.Color color) {
        List<Piece> colorPieceList = getPieceListByColor(color);
        Collections.sort(colorPieceList);
        return colorPieceList;
    }

    public List<Piece> sortColorPiecesDescending(Piece.Color color) {
        List<Piece> colorPieceList = getPieceListByColor(color);
        colorPieceList.sort(Collections.reverseOrder());
        return colorPieceList;
    }

}
