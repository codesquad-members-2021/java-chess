package net.woody.chess;

import static net.woody.utils.StringUtils.appendNewLine;

import net.woody.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final List<Rank> board = new ArrayList<>(BOARD_LENGTH);

    public Board() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
    }

    public void add(Piece piece, int rank, int file) {
        getRank(rank).add(file, piece);
    }

    public Rank getRank(int rank) {
        if (rank < 0 || board.size() <= rank) {
            throw new ArrayIndexOutOfBoundsException("Rank number " + rank + " is out of range!");
        }
        return board.get(rank);
    }

    public Piece findPiece(int rank, int file) {
        return getRank(rank).find(file);
    }

    public void initialize() {
        initBlackPieces();
        initBlackPawns();
        initWhitePawns();
        initWhitePieces();
    }

    // TODO : Rank에 팩토리 메소드 구현으로 좀 더 간단하게
    private void initBlackPieces() {
        Rank blackPieces = getRank(Piece.BLACK_PIECES_RANK);

        blackPieces.add(0, Piece.createBlackRook());
        blackPieces.add(1, Piece.createBlackKnight());
        blackPieces.add(2, Piece.createBlackBishop());
        blackPieces.add(3, Piece.createBlackQueen());
        blackPieces.add(4, Piece.createBlackKing());
        blackPieces.add(5, Piece.createBlackBishop());
        blackPieces.add(6, Piece.createBlackKnight());
        blackPieces.add(7, Piece.createBlackRook());
    }

    private void initBlackPawns() {
        Rank blackPawns = getRank(Piece.BLACK_PAWN_RANK);

        for (int i = 0; i < BOARD_LENGTH; i++) {
            blackPawns.add(i, Piece.createBlackPawn());
        }
    }

    private void initWhitePieces() {
        Rank whitePieces = getRank(Piece.WHITE_PIECES_RANK);

        whitePieces.add(0, Piece.createWhiteRook());
        whitePieces.add(1, Piece.createWhiteKnight());
        whitePieces.add(2, Piece.createWhiteBishop());
        whitePieces.add(3, Piece.createWhiteQueen());
        whitePieces.add(4, Piece.createWhiteKing());
        whitePieces.add(5, Piece.createWhiteBishop());
        whitePieces.add(6, Piece.createWhiteKnight());
        whitePieces.add(7, Piece.createWhiteRook());
    }

    private void initWhitePawns() {
        Rank whitePawns = getRank(Piece.WHITE_PAWN_RANK);

        for (int i = 0; i < BOARD_LENGTH; i++) {
            whitePawns.add(i, Piece.createWhitePawn());
        }
    }

    // TODO : 더 효율적인 방식 고려
    public int size() {
        int numOfPieces = 0;
        for (Rank rank : board) {
            numOfPieces += rank.size();
        }
        return numOfPieces;
    }


    // TODO : 네이밍 수정 혹은 toString 오버라이드
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board) {
            sb.append(appendNewLine(rank.toString()));
        }
        return sb.toString();
    }
}
