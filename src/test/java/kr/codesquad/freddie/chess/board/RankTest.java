package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void add() {
        int size = 8;

        for (int i = 0; i < size; i++) {
            Rank rank = new Rank();

            for (int j = 0; j < i; j++) {
                rank.add(new Pawn());
            }
            assertThat(rank.size())
                    .isEqualTo(i);
        }
    }

    @Test
    void add_8개초과() {
        Rank rank = new Rank();

        for (int i = 0; i < 8; i++) {
            rank.add(new Pawn());
        }

        assertThatThrownBy(() -> rank.add(new Pawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("랭크 당 8개만 추가 가능합니다.");
    }
}