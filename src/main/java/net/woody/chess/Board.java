package net.woody.chess;

import static net.woody.utils.StringUtils.appendNewLine;

import net.woody.pieces.Color;
import net.woody.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final List<Rank> board = new ArrayList<>(BOARD_LENGTH);
    private int size = 0;

    public Board() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
    }

    public void add(Piece piece) {
        int rank = getPawnRank(piece);
        getRank(rank).add(piece);
        size++;
    }

    private int getPawnRank(Piece newPiece) {
        return (newPiece.getColor() == Color.WHITE) ? Piece.WHITE_PAWN_RANK : Piece.BLACK_PAWN_RANK;
    }

    public Rank getRank(int rank) {
        if (rank < 0 || board.size() <= rank) {
            throw new ArrayIndexOutOfBoundsException("Rank number " + rank + " is out of range!");
        }
        return board.get(rank);
    }

    public Piece findPawn(int rank, int file) {
        return getRank(rank).find(file);
    }

    public void initialize() {
        initPieces();
        initPawns();
    }

    // TODO : 간결하게 수정
    public void initPieces() {
        Rank blackPieces = getRank(Piece.BLACK_PIECES_RANK);
        Rank whitePieces = getRank(Piece.WHITE_PIECES_RANK);

        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());

        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());

    }

    public void initPawns() {
        Rank blackPawns = getRank(Piece.BLACK_PAWN_RANK);
        Rank whitePawns = getRank(Piece.WHITE_PAWN_RANK);

        for (int i = 0; i < BOARD_LENGTH; i++) {
            blackPawns.add(Piece.createBlackPawn());
            whitePawns.add(Piece.createWhitePawn());
            size += 2;
        }
    }

    public String getWhitePawnsResult() {
        return getRank(Piece.WHITE_PAWN_RANK).toString();
    }

    public String getBlackPawnsResult() {
        return getRank(Piece.BLACK_PAWN_RANK).toString();
    }

    public int size() {
        return size;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board) {
            sb.append(appendNewLine(rank.toString()));
        }
        return sb.toString();
    }
}
