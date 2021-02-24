package cooper.chess.piece;

import cooper.chess.Board;

import java.util.List;

public class PointCalculator {
    private final List<Piece> pieceList;

    public PointCalculator(List<Piece> pieceList) {
        this.pieceList = pieceList;
    }

    public double calculate(Color color) {
        double result = 0;

        int col = 0;
        while (col < Board.BOARD_SIZE) {
            result += calculateEachColumn(col, color);
            col += 1;
        }

        return result;
    }

    private double calculateEachColumn(int col, Color color) {
        double result = 0;
        int pawnCount = 0;
        int row = 0;

        while (row < Board.BOARD_SIZE) {
            Piece piece = pieceList.get(8 * row + col);

            row += 1;

            if (piece.getColor() != color) {
                continue;
            }

            if (piece.getType() == Type.PAWN) {
                pawnCount += 1;
                continue;
            }

            result += piece.getType().getDefaultPoint();
        }

        return result + getPawnPoint(pawnCount);
    }

    private double getPawnPoint(int pawnCount) {
        return pawnCount > 1 ?
                pawnCount * Type.PAWN.getDefaultPoint() - 0.5
                : pawnCount * Type.PAWN.getDefaultPoint();
    }
}
