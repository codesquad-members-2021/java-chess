package net.isaac.chess;

import net.isaac.pieces.Piece;
import net.isaac.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static net.isaac.chess.Rank.MIN_FILE;
import static net.isaac.chess.Rank.MAX_FILE;

public class Board {
    private static final int MIN_RANK = 1;
    private static final int MAX_RANK = 8;

    private Map<Integer, Rank> pieces = new HashMap<>();

    public Board() {
        initialize();
    }

    public void initialize() {
        setBlankBoard();

        int pawnsRow = 1;
        initializePawns(Piece.Color.BLACK, MIN_RANK + pawnsRow);
        initializePawns(Piece.Color.WHITE, MAX_RANK - pawnsRow);

        int specialRow = 0;
        initializeSpecialPieces(Piece.Color.BLACK, MIN_RANK + specialRow);
        initializeSpecialPieces(Piece.Color.WHITE, MAX_RANK - specialRow);
    }

    private void setBlankBoard() {
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            pieces.put(rank, new Rank());
        }
    }

    private void initializeSpecialPieces(Piece.Color color, int rank) {
        add(Piece.createPiece(color, Piece.Type.ROOK), rank, 'a');
        add(Piece.createPiece(color, Piece.Type.KNIGHT), rank, 'b');
        add(Piece.createPiece(color, Piece.Type.BISHOP), rank, 'c');
        add(Piece.createPiece(color, Piece.Type.QUEEN), rank, 'd');
        add(Piece.createPiece(color, Piece.Type.KING), rank, 'e');
        add(Piece.createPiece(color, Piece.Type.BISHOP), rank, 'f');
        add(Piece.createPiece(color, Piece.Type.KNIGHT), rank, 'g');
        add(Piece.createPiece(color, Piece.Type.ROOK), rank, 'h');
    }

    private void initializePawns(Piece.Color color, int rank) {
        for (char file = MIN_FILE; file <= MAX_FILE; file++) {
            add(Piece.createPiece(color, Piece.Type.PAWN), rank, file);
        }
    }

    public String getRepresentation() {
        String ret = "";
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            for (char file = MIN_FILE; file <= MAX_FILE; file++) {
                ret += findPiece(rank, file).getRepresentation();
            }
            ret = StringUtils.appendNewLine(ret);
        }
        return ret;
    }

    public void add(Piece piece, int rank, char file) {
        if (!isValidRank(rank)) {
            System.err.println("Board.add: rank 값이 범위를 벗어났습니다.(rank=" + rank + ")");
            return;
        }

        pieces.get(rank).setPiece(piece, file);
    }

    public Piece findPiece(int rank, char file) {
        if (!isValidRank(rank) || pieces.get(rank) == null) {
            return null;
        }

        return pieces.get(rank).getPiece(file);
    }

    private boolean isValidRank(int rank) {
        return rank >= MIN_RANK && MAX_RANK >= rank;
    }

    public int pieceCount() {
        int count = 0;
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            for (char file = MIN_FILE; file <= MAX_FILE; file++) {
                if (findPiece(rank, file).getType() != Piece.Type.BLANK) {
                    count++;
                }
            }
        }
        return count;
    }

    public int pieceCount(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            for (char file = MIN_FILE; file <= MAX_FILE; file++) {
                Piece piece = findPiece(rank, file);
                if (piece.getColor() == color && piece.getType() == type) {
                    count++;
                }
            }
        }
        return count;
    }
}
