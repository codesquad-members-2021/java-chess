package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public enum Kind {
    PAWN("p", 1.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {

            return true;
        }
    },
    KNIGHT("n", 2.5) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            if (fileDistance + rankDistance != 3 || Math.abs(fileDistance - rankDistance) != 1) {
                return false;
            }

            return true;
        }
    },
    ROOK("r", 5.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            if (gradientOf(fileDistance, rankDistance) != 0) {
                return false;
            }

            return true;
        }
    },
    BISHOP("b", 3.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            if (gradientOf(fileDistance, rankDistance) != 1) {
                return false;
            }

            return true;
        }
    },
    QUEEN("q", 9.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            double gradient = gradientOf(fileDistance, rankDistance);

            if (!(gradient == 0 || gradient == 1)) {
                return false;
            }

            return true;
        }
    },
    KING("k", 0.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            if (1 < fileDistance || 1 < rankDistance) {
                return false;
            }

            return true;
        }
    },
    EMPTY(".", 0.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            return false;
        }
    };

    private final String representation;
    private final double point;

    Kind(String representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    abstract public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board);

    public String representation() {
        return representation;
    }

    public double point() {
        return point;
    }

    protected int distanceOf(int a, int b) {
        return a - b;
    }

    protected double gradientOf(int fileDistance, int rankDistance) {
        if (fileDistance == 0) {
            return 0;
        }
        return Integer.valueOf(rankDistance).doubleValue() / Integer.valueOf(fileDistance).doubleValue();
    }

    protected void checkColorOf(Position sourcePosition, Position targetPosition, Board board) {
        Piece sourcePiece = board.findPiece(sourcePosition.toString());
        Piece targetPiece = board.findPiece(targetPosition.toString());
        if (sourcePiece.getColor() == targetPiece.getColor()) {
            String message = "이동 위치의 기물이 같은 색상입니다. source : " + sourcePiece + ", target : " + targetPiece;
            throw new IllegalArgumentException(message);
        }
    }
}
