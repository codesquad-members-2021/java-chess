package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public enum Kind {
    PAWN("p", 1.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            Piece sourcePiece = board.findPiece(sourcePosition.toString());
            Piece targetPiece = board.findPiece(targetPosition.toString());

            int fileDistance = distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex());
            int rankDistance = distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex());

            //TODO: 메소드 추출 필요

            // 방향 확인
            if (sourcePiece.isWhite() && 0 < rankDistance || sourcePiece.isBlack() && rankDistance < 0) {
                return false;
            }

            // 2칸 이상 이동
            if (2 < Math.abs(rankDistance) || 1 < Math.abs(fileDistance)) {
                return false;
            }
            
            // 대각선 이동인데 잡아먹을 수 없는 경우
            if (gradientOf(Math.abs(fileDistance), Math.abs(rankDistance)) == 1 &&
                    (sourcePiece.getColor() == targetPiece.getColor() || targetPiece.getColor() == Color.NOCOLOR)) {
                return false;
            }

            // 대각선인데 1직선이 아닐 경우
            if (gradientOf(Math.abs(fileDistance), Math.abs(rankDistance)) != 1 &&
                    gradientOf(Math.abs(fileDistance), Math.abs(rankDistance)) != 0) {
                return false;
            }

            return true;
        }
    },
    KNIGHT("n", 2.5) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            return fileDistance + rankDistance == 3 && Math.abs(fileDistance - rankDistance) == 1;
        }
    },
    ROOK("r", 5.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            return gradientOf(fileDistance, rankDistance) == 0;
        }
    },
    BISHOP("b", 3.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            return gradientOf(fileDistance, rankDistance) == 1;
        }
    },
    QUEEN("q", 9.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            double gradient = gradientOf(fileDistance, rankDistance);

            return gradient == 0 || gradient == 1;
        }
    },
    KING("k", 0.0) {
        @Override
        public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
            checkColorOf(sourcePosition, targetPosition, board);
            int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
            int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

            return 1 >= fileDistance && 1 >= rankDistance;
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
