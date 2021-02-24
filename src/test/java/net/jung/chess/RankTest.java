package net.jung.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    Rank rank;

    @BeforeEach
    void setter() {
        rank = new Rank();
    }

    @Test
    @DisplayName("initialize된 Rank 의 size는 8이어야 한다.")
    void checkRankSizeAfterInitialize() {
        Rank whitePawnRank = rank.initializeWhitePawnRank();
        Rank blackPawnRank = rank.initializeBlackPawnRank();
        Rank whitePieceRank = rank.initializeWhitePieceRank();
        Rank blackPieceRank = rank.initializeBlackPieceRank();
        Rank blankRank = rank.initializeBlankRank();

        assertAll(
                () -> assertThat(whitePawnRank.size()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(blackPawnRank.size()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(whitePieceRank.size()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(blackPieceRank.size()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(blankRank.size()).isEqualTo(0)
        );
    }
}
