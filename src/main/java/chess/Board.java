package chess;

import pieces.Color;
import pieces.Piece;
import pieces.Type;

import java.util.ArrayList;

import static utils.StringUtils.*;

public class Board {

    private final ArrayList<ArrayList<Piece>> pieceRanks;
    private int size;
    private PositionParser positionParser = new PositionParser();

    private final int RANKS = 8;
    private final int FILES = 8;

    public Board() {
        this.pieceRanks = new ArrayList<>();
        for (int i = 0; i < RANKS; i++) {
            ArrayList<Piece> rank = new ArrayList<>();
            for (int j = 0; j < FILES; j++) {
                rank.add(Piece.createBlank());
            }
            this.pieceRanks.add(rank);
        }
        this.size = 0;
    }

    public void initializeEmpty() {
        for (ArrayList<Piece> rank : pieceRanks) {
            for (int i = 0; i < FILES; i++) {
                rank.set(i, Piece.createBlank());
            }
        }
    }

    private void initializeBlackPawns() {
        ArrayList<Piece> initBlackPawnsRank = pieceRanks.get(1);
        for (int i = 0; i < FILES; i++) {
            initBlackPawnsRank.set(i, Piece.createBlackPawn());
        }
        size += FILES;
    }

    private void initializeWhitePawns() {
        ArrayList<Piece> initWhitePawnsRank = pieceRanks.get(6);
        for (int i = 0; i < FILES; i++) {
            initWhitePawnsRank.set(i, Piece.createWhitePawn());
        }
        size += FILES;
    }

    private void initializeBlackPieces() {
        ArrayList<Piece> initBlackPieceRank = pieceRanks.get(0);
        initBlackPieceRank.set(0, Piece.createBlackRook());
        initBlackPieceRank.set(1, Piece.createBlackKnight());
        initBlackPieceRank.set(2, Piece.createBlackBishop());
        initBlackPieceRank.set(3, Piece.createBlackQueen());
        initBlackPieceRank.set(4, Piece.createBlackKing());
        initBlackPieceRank.set(5, Piece.createBlackBishop());
        initBlackPieceRank.set(6, Piece.createBlackKnight());
        initBlackPieceRank.set(7, Piece.createBlackRook());
        size += FILES;
    }

    private void initializeWhitePieces() {
        ArrayList<Piece> initWhitePieceRank = pieceRanks.get(7);
        initWhitePieceRank.set(0, Piece.createWhiteRook());
        initWhitePieceRank.set(1, Piece.createWhiteKnight());
        initWhitePieceRank.set(2, Piece.createWhiteBishop());
        initWhitePieceRank.set(3, Piece.createWhiteQueen());
        initWhitePieceRank.set(4, Piece.createWhiteKing());
        initWhitePieceRank.set(5, Piece.createWhiteBishop());
        initWhitePieceRank.set(6, Piece.createWhiteKnight());
        initWhitePieceRank.set(7, Piece.createWhiteRook());
        size += FILES;
    }

    private String getRankRepresentation(ArrayList<Piece> rank) {
        StringBuilder RankRepresentation = new StringBuilder();
        for (Piece piece : rank) {
            RankRepresentation.append(piece.getRepresentation());
        }
        return RankRepresentation.toString();
    }

    public void initialize() {
        initializeEmpty();
        initializeBlackPieces();
        initializeBlackPawns();
        initializeWhitePawns();
        initializeWhitePieces();
    }

    public String showBoard() {
        StringBuilder output = new StringBuilder();
        for (ArrayList<Piece> rank : pieceRanks) {
            output.append(appendNewLine(getRankRepresentation(rank)));
        }
        return output.toString();
    }

    public int pieceCount() {
        return size;
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int count = 0;
        for (ArrayList<Piece> rank : pieceRanks) {
            for (Piece piece : rank) {
                if (piece.getColor() == color && piece.getType() == type) {
                    count++;
                }
            }
        }
        return count;
    }

    public Piece findPiece(String position) {
        int rankIndex = positionParser.parseRankIndex(position);
        int fileIndex = positionParser.parseFileIndex(position);
        return pieceRanks.get(rankIndex).get(fileIndex);
    }

    public void move(String position, Piece piece) {
        int rankIndex = positionParser.parseRankIndex(position);
        int fileIndex = positionParser.parseFileIndex(position);
        pieceRanks.get(rankIndex).set(fileIndex, piece);
    }

    public double calculatePoint(Color color) {
        double resultPoint = 0;

        for (int j = 0; j < FILES; j++) {
            int pawnCount = 0;
            for (int i = 0; i < RANKS; i++) {
                Piece piece = pieceRanks.get(i).get(j);
                Type type = piece.getType();
                if (piece.getColor() == color) {
                    resultPoint += type.getPoint();
                    if (type == Type.PAWN) {
                        pawnCount++;
                    }
                }
            }
            if (pawnCount >= 2) {
                resultPoint -= pawnCount * 0.5;
            }
        }

        return resultPoint;
    }

    private class PositionParser {
        private int parseRankIndex(String position) {
            char rank = position.charAt(1);
            int rankPosition = Character.getNumericValue(rank);
            return RANKS - rankPosition;
        }
        private int parseFileIndex(String position) {
            char file = position.charAt(0);
            return file - 'a';
        }
    }

}
