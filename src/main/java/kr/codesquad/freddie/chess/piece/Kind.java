package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;

public enum Kind {
    PAWN("p", 1.0) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {

        }
    },
    KNIGHT("n", 2.5) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {
            int fileDistance = distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex());
            int rankDistance = distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex());

            if (fileDistance + rankDistance != 3 || Math.abs(fileDistance - rankDistance) != 1) {
                String message = "이동 위치가 올바르지 않습니다. : source : " + sourcePosition + ", target : " + targetPosition;
                throw new IllegalArgumentException(message);
            }
        }
    },
    ROOK("r", 5.0) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {
            int fileDistance = distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex());
            int rankDistance = distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex());

            if (!(fileDistance == 0 || rankDistance == 0)) {
                String message = "이동 위치가 올바르지 않습니다. : source : " + sourcePosition + ", target : " + targetPosition;
                throw new IllegalArgumentException(message);
            }
        }
    },
    BISHOP("b", 3.0) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {
            int fileDistance = distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex());
            int rankDistance = distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex());

            if (fileDistance == 0 || rankDistance / fileDistance != 1) {
                String message = "이동 위치가 올바르지 않습니다. : source : " + sourcePosition + ", target : " + targetPosition;
                throw new IllegalArgumentException(message);
            }
        }
    },
    QUEEN("q", 9.0) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {

        }
    },
    KING("k", 0.0) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {
            int fileDistance = distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex());
            int rankDistance = distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex());

            if (1 < fileDistance || 1 < rankDistance) {
                String message = "이동 위치가 올바르지 않습니다. : source : " + sourcePosition + ", target : " + targetPosition;
                throw new IllegalArgumentException(message);
            }
        }
    },
    EMPTY(".", 0.0) {
        @Override
        public void verifyMovePosition(Position sourcePosition, Position targetPosition) {

        }
    };

    private final String representation;
    private final double point;

    Kind(String representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    abstract public void verifyMovePosition(Position sourcePosition, Position targetPosition);

    public String representation() {
        return representation;
    }

    public double point() {
        return point;
    }

    protected int distanceOf(int a, int b) {
        return Math.abs(a - b);
    }
}
