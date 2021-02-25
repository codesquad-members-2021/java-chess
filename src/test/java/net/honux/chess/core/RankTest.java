package net.honux.chess.core;

import net.honux.chess.entity.pieces.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("Collection 내의 Piece 들이 Point 를 기준으로 정렬되는지 확인한다.")
    void sortToPieces() {
        final List<Piece> pieces = Arrays.asList(Piece.createBlackRook(), Piece.createBlackBishop(), Piece.createBlackKnight(), Piece.createBlackRook(),
                Piece.createBlackBishop(), Piece.createBlackKnight(), Piece.createBlackQueen(), Piece.createBlackKing());
        Collections.sort(pieces);
        assertThat(pieces.toString()).isEqualTo("[K, N, N, B, B, R, R, Q]");
    }
}
