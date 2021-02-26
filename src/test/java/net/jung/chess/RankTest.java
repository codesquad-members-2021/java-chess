package net.jung.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    Rank rank;
    Rank whitePawnRank;
    Rank blackPawnRank;
    Rank whitePieceRank;
    Rank blackPieceRank;
    Rank blankRank;

    @BeforeEach
    void setter() {
        rank = new Rank();
        whitePawnRank = rank.initializeWhitePawnRank();
        blackPawnRank = rank.initializeBlackPawnRank();
        whitePieceRank = rank.initializeWhitePieceRank();
        blackPieceRank = rank.initializeBlackPieceRank();
        blankRank = rank.initializeBlankRank();

    }

    @Test
    @DisplayName("initialize된 Rank 의 size는 8이어야 한다.")
    void checkRankSizeAfterInitialize() {
        assertAll(
                () -> assertThat(whitePawnRank.rankPieceSize()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(blackPawnRank.rankPieceSize()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(whitePieceRank.rankPieceSize()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(blackPieceRank.rankPieceSize()).isEqualTo(Rank.MAX_PIECES_IN_RANK),
                () -> assertThat(blankRank.rankPieceSize()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("getRepresentation으로 리턴되는 스트링을 검증한다.")
    void checkGetRepresentation() {
        assertAll(
                () -> assertThat(whitePawnRank.rankLayoutToString()).isEqualTo("pppppppp"),
                () -> assertThat(blackPawnRank.rankLayoutToString()).isEqualTo("PPPPPPPP"),
                () -> assertThat(whitePieceRank.rankLayoutToString()).isEqualTo("rnbqkbnr"),
                () -> assertThat(blackPieceRank.rankLayoutToString()).isEqualTo("RNBQKBNR"),
                () -> assertThat(blankRank.rankLayoutToString()).isEqualTo("********")
        );
    }

    @Test
    @DisplayName("replace메서드는 index와 Piece를 매개변수로 받아 위치의 piece를 바꾼다.")
    void checkReplace() {
        whitePieceRank.replacePiece(0, Piece.createBlackBishop());
        whitePieceRank.replacePiece(1, Piece.createBlackPawn());
        blankRank.replacePiece(3, Piece.createWhiteKing());

        assertAll(
                () -> assertThat(whitePieceRank.getPiece(0)).isEqualTo(Piece.createBlackBishop()),
                () -> assertThat(whitePieceRank.getPiece(1)).isEqualTo(Piece.createBlackPawn()),
                () -> assertThat(blankRank.getPiece(3)).isEqualTo(Piece.createWhiteKing())
        );
    }
}
