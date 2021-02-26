package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Piece;

import java.util.stream.Collectors;

public class BoardView {
    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public String getRepresentation() {
        String result = board.getFiles().stream()
                .map(this::getRepresentationOf)
                .collect(Collectors.joining(System.lineSeparator()));

        return result;
    }

    private String getRepresentationOf(File file) {
        return file.getPieces().stream()
                .map(Piece::getRepresentation)
                .collect(Collectors.joining());
    }
}
