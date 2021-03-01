package net.isaac.chess;

import net.isaac.pieces.Piece;
import net.isaac.utils.StringUtils;

import javax.swing.*;
import java.util.*;

import static net.isaac.chess.Rank.MIN_FILE;
import static net.isaac.chess.Rank.MAX_FILE;

public class Board {
    private static final int MIN_RANK = 1;
    private static final int MAX_RANK = 8;

    private final Map<Integer, Rank> pieces = new HashMap<>();

    public Board() {
        initialize();
    }

    public void initialize() {
        initializeEmpty();

        int pawnsRow = 1;
        initializePawns(Piece.Color.BLACK, MIN_RANK + pawnsRow);
        initializePawns(Piece.Color.WHITE, MAX_RANK - pawnsRow);

        int royalRow = 0;
        initializeRoyalPieces(Piece.Color.BLACK, MIN_RANK + royalRow);
        initializeRoyalPieces(Piece.Color.WHITE, MAX_RANK - royalRow);
    }

    public void initializeEmpty() {
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            pieces.put(rank, new Rank());
        }
    }

    private void initializeRoyalPieces(Piece.Color color, int rank) {
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

    public void add(Piece piece, String positionString) {
        Position position = Position.getPosition(positionString);
        if (position == null) {
            return;
        }

        add(piece, position.rank, position.file);
    }

    private void add(Piece piece, int rank, char file) {
        if (!isValidRank(rank)) {
            System.err.println("Board.add: rank 값이 범위를 벗어났습니다.(rank=" + rank + ")");
            return;
        }

        pieces.get(rank).setPiece(piece, file);
    }

    public Piece findPiece(String positionString) {
        Position position = Position.getPosition(positionString);
        if (position == null) {
            return null;
        }
        return findPiece(position.rank, position.file);
    }

    private Piece findPiece(int rank, char file) {
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

    public double calculatePoint(Piece.Color color) {
        //file 에 존재하는 pawn 개수 세기 위한 Map
        Map<Character, Integer> pawnNumAtFile = new HashMap<>();

        double point = 0;
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            for (char file = MIN_FILE; file <= MAX_FILE; file++) {
                Piece piece = findPiece(rank, file);
                if (piece.getColor() == color) {
                    point += piece.getType().defaultPoint;

                    //Pawn일 경우 map을 사용하여 같은 file에 몇 개의 pawn이 있는지 세준다.
                    if (piece.getType() == Piece.Type.PAWN) {
                        pawnNumAtFile.put(file, pawnNumAtFile.getOrDefault(file, 0) + 1);
                    }
                }
            }
        }

        //같은 file에 2개 이상인 pawn은 0.5점이므로 (0.5 * 개수)만큼 빼준다.
        for (Integer pawnNumInSameFile : pawnNumAtFile.values()) {
            if (pawnNumInSameFile > 1) {
                point -= (0.5 * (double) pawnNumInSameFile);
            }
        }

        return point;
    }

    public List<Piece> getSortedPieces(Piece.Color color, SortOrder sortOrder) {
        List<Piece> sortedPieces = new ArrayList<>();
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
            for (char file = MIN_FILE; file <= MAX_FILE; file++) {
                Piece piece = findPiece(rank, file);
                if (piece.getColor() == color && piece.getType() != Piece.Type.BLANK) {
                    sortedPieces.add(piece);
                }
            }
        }

        switch (sortOrder) {
            case ASCENDING:
                Collections.sort(sortedPieces);
                break;
            case DESCENDING:
                Collections.sort(sortedPieces, Collections.reverseOrder());
                break;
        }
        return sortedPieces;
    }
}
