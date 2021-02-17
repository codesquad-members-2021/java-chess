package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardDTOTest {
    @Test
    void getRepresentation() {
        List<File> files = new ArrayList<>(Arrays.asList(
                new File(),
                new File().fillWith(Color.BLACK),
                new File(),
                new File(),
                new File(),
                new File(),
                new File().fillWith(Color.WHITE),
                new File()
        ));

        String representation = BoardDTO.create(files).getRepresentation();
        String expected = new StringBuilder()
                .append("........").append(System.lineSeparator())
                .append("PPPPPPPP").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("pppppppp").append(System.lineSeparator())
                .append("........")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    @Test
    void getRepresentation_empty() {
        List<File> files = new ArrayList<>(Arrays.asList(
                new File(),
                new File(),
                new File(),
                new File(),
                new File(),
                new File(),
                new File(),
                new File()
        ));

        String representation = BoardDTO.create(files).getRepresentation();
        String expected = new StringBuilder()
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    @Test
    void getRepresentation_init_board() {
        String representation = new Board().initialize()
                .toDTO()
                .getRepresentation();

        String expected = new StringBuilder()
                .append("........").append(System.lineSeparator())
                .append("PPPPPPPP").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("pppppppp").append(System.lineSeparator())
                .append("........")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    @Test
    void getRepresentation_not_init_board() {
        String representation = new Board()
                .toDTO()
                .getRepresentation();

        String expected = new StringBuilder()
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }
}
