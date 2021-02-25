package net.woody.chess;

import net.woody.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private static final int BOARD_LENGTH = 8;

    private final List<Piece> pieces = new ArrayList<>(BOARD_LENGTH);

    public Rank() {
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(Piece.createBlank());
        }
    }

    // TODO : file 인자 validation 추가
    public void add(int file, Piece piece) {
        pieces.set(file, piece);
    }

    // TODO : file 인자 validation 부분을 다른 메소드로 분리
    // TODO : 예외처리 클라이언트가 이해할 수 있는 최상단의 예외로 던져주자
    public Piece find(int file) {
        if (file < 0 || size() <= file) {
            throw new ArrayIndexOutOfBoundsException("File number " + file + " is out of range!");
        }
        return pieces.get(file);
    }

    public int size() {
        return pieces.size();
    }

    @Override
    public String toString() {
        // TODO : sb 네이밍 바꾸기
        StringBuilder sb = new StringBuilder();
        if (pieces.size() == 0) {
            return "........";
        }
        // TODO : for-loop을 풀어적거나
        pieces.forEach(piece -> sb.append(piece.getRepresentation()));
        return sb.toString();
    }
}
