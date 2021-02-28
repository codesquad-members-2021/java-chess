package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import piece.Piece;
import piece.Color;
import piece.Type;
import piece.Position;

public class Board {
    private final List<Rank> board = new ArrayList<>();

    public List<Rank> getBoard() {
        return board;
    }

    public int countPieces(Color color, Type type) {
        int count = 0;
        for (Rank rank : board) {
            count += rank.countPieces(color, type);
        }
        return count;
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            board.add(Rank.initializeBlankLine(i));
        }
    }

    public void initialize() {
        board.add(Rank.initializeWhitePieces(0));
        board.add(Rank.initializeWhitePawns(1));
        board.add(Rank.initializeBlankLine(2));
        board.add(Rank.initializeBlankLine(3));
        board.add(Rank.initializeBlankLine(4));
        board.add(Rank.initializeBlankLine(5));
        board.add(Rank.initializeBlackPawns(6));
        board.add(Rank.initializeBlackPieces(7));
    }

    public Piece findPiece(String position) {
        Position p = new Position(position);
        Rank rank = board.get(p.getYIndex());
        return rank.findPiece(p.getXIndex());
    }

    public void move(String positionStr, Piece piece) {
        Position position = new Position(positionStr);
        Rank rank = board.get(position.getYIndex());
        rank.move(position.getXIndex(), piece);
    }

    public double calculatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        return pieces.stream()
                .mapToDouble(piece -> getPoint(piece, pieces))
                .sum();
    }

    public double getPoint(Piece piece, List<Piece> pieces) {
        double point = piece.getPoint();
        if (piece.matchType(Type.PAWN) && checkAdjacentPawn(piece, pieces)) {
            return point - 0.5;
        }
        return point;
    }

    private boolean checkAdjacentPawn(Piece piece, List<Piece> pieces) {
        List<Position> prevNextRows = piece.getPosition().getPrevNextRows();
        for (Position position : prevNextRows) {
            if (pieces.contains(new Piece(piece.getColor(), piece.getType(), position))) {
                return true;
            }
        }
        return false;
    }

    public List<Piece> findPiecesByColor(Color color) {
        return this.board.stream()
                .flatMap(rank -> rank.findPiecesByColor(color).stream())
                .collect(Collectors.toList());
    }

}
