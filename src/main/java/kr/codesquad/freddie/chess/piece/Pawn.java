package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public class Pawn extends Piece {
    private Pawn(Color color, Kind kind) {
        super(color, kind);
    }

    public static Pawn create(Color color) {
        return new Pawn(color, Kind.PAWN);
    }

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
}
