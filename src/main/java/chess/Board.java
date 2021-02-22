package chess;

import pieces.Color;
import pieces.Piece;
import pieces.Type;

import java.util.ArrayList;

import static utils.StringUtils.*;

public class Board {

    private final ArrayList<ArrayList<Piece>> pieceRanks;
    private int size;

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

    private void initBlackPawns() {
        ArrayList<Piece> initBlackPawnsRank = pieceRanks.get(1);
        for (int i = 0; i < FILES; i++) {
            initBlackPawnsRank.set(i, Piece.createBlackPawn());
        }
        size += FILES;
    }

    private void initWhitePawns() {
        ArrayList<Piece> initWhitePawnsRank = pieceRanks.get(6);
        for (int i = 0; i < FILES; i++) {
            initWhitePawnsRank.set(i, Piece.createWhitePawn());
        }
        size += FILES;
    }

    private void initBlackPieces() {
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

    private void initWhitePieces() {
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
        initBlackPieces();
        initBlackPawns();
        initWhitePawns();
        initWhitePieces();
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

    public int countPieceByColorAndType(Color black, Type pawn) {
        return 0;
    }
}
