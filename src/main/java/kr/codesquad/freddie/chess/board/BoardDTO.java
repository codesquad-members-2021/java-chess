package kr.codesquad.freddie.chess.board;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDTO {
    private List<String> files;

    private BoardDTO(List<String> files) {
        this.files = files;
    }

    public static BoardDTO create(List<File> files) {
        return new BoardDTO(files.stream().map(File::getRepresentation).collect(Collectors.toList()));
    }

    public String getRepresentation() {
        return files.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
