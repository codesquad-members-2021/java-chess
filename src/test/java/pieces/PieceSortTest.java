package pieces;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class PieceSortTest {
    SoftAssertions softly;

    @BeforeEach
    void testInit() {
        softly = new SoftAssertions();
    }

    @AfterEach
    void afterTest() {
        softly.assertAll();
    }

    @Test
    @DisplayName("기물의 점수를 기준으로 정렬")
    void sortPiecesByPoint() {
        Collection<Piece> pieceCollection = new ArrayList<>();
        addPiecesInCollection(pieceCollection);

        verifySortUsingStream(pieceCollection);
        verifySortUsingMethod(pieceCollection);

    }

    private void addPiecesInCollection(Collection<Piece> pieceCollection) {
        pieceCollection.add(Piece.createBlackRook());
        pieceCollection.add(Piece.createWhiteRook());
        pieceCollection.add(Piece.createBlackKnight());
        pieceCollection.add(Piece.createWhiteKnight());
        pieceCollection.add(Piece.createBlackBishop());
        pieceCollection.add(Piece.createWhiteBishop());
        pieceCollection.add(Piece.createBlackQueen());
        pieceCollection.add(Piece.createWhiteQueen());
        pieceCollection.add(Piece.createBlackKing());
        pieceCollection.add(Piece.createWhiteKing());
        pieceCollection.add(Piece.createWhitePawn());
        pieceCollection.add(Piece.createBlackPawn());
        pieceCollection.add(Piece.createBlank());
    }

    private void verifySortUsingStream(Collection<Piece> pieceCollection) {
        Collection<Piece> blackPiecesDescOrderByStream = pieceCollection.stream()
                .filter(Piece::isBlack)
                .sorted(Comparator.comparing(Piece::getType, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        Collection<Piece> whitePiecesDescOrderByStream = pieceCollection.stream()
                .filter(Piece::isWhite)
                .sorted(Comparator.comparing(Piece::getType, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        Collection<Piece> blackPiecesAscOrderByStream = pieceCollection.stream()
                .filter(Piece::isBlack)
                .sorted(Comparator.comparing(Piece::getType))
                .collect(Collectors.toList());

        Collection<Piece> whitePiecesAscOrderByStream = pieceCollection.stream()
                .filter(Piece::isWhite)
                .sorted(Comparator.comparing(Piece::getType))
                .collect(Collectors.toList());

        verifyBlackPiecesDecreasingOrder(blackPiecesDescOrderByStream);
        verifyWhitePiecesDecreasingOrder(whitePiecesDescOrderByStream);
        verifyBlackPiecesAscendingOrder(blackPiecesAscOrderByStream);
        verifyWhitePiecesAscendingOrder(whitePiecesAscOrderByStream);
    }

    private void verifySortUsingMethod(Collection<Piece> pieceCollection) {
        List<Piece> blackPieces = new ArrayList<>();
        List<Piece> whitePieces = new ArrayList<>();
        for (Piece piece : pieceCollection) {
            if (piece.isBlack()) {
                blackPieces.add(piece);
            }
            if (piece.isWhite()) {
                whitePieces.add(piece);
            }
        }

        Collections.sort(blackPieces, Comparator.comparing(Piece::getType));
        verifyBlackPiecesAscendingOrder(blackPieces);

        Collections.sort(blackPieces, Comparator.comparing(Piece::getType, Comparator.reverseOrder()));
        verifyBlackPiecesDecreasingOrder(blackPieces);

        whitePieces.sort(Comparator.comparing(Piece::getType));
        verifyWhitePiecesAscendingOrder(whitePieces);

        whitePieces.sort(Comparator.comparing(Piece::getType, Comparator.reverseOrder()));
        verifyWhitePiecesDecreasingOrder(whitePieces);
    }

    private void verifyBlackPiecesAscendingOrder(Collection<Piece> blackPieceCollection) {
        softly.assertThat(blackPieceCollection).containsExactly(
                Piece.createBlackKing(),
                Piece.createBlackPawn(),
                Piece.createBlackKnight(),
                Piece.createBlackBishop(),
                Piece.createBlackRook(),
                Piece.createBlackQueen());
    }

    private void verifyBlackPiecesDecreasingOrder(Collection<Piece> blackPieceCollection) {
        softly.assertThat(blackPieceCollection).containsExactly(
                Piece.createBlackQueen(),
                Piece.createBlackRook(),
                Piece.createBlackBishop(),
                Piece.createBlackKnight(),
                Piece.createBlackPawn(),
                Piece.createBlackKing());
    }

    private void verifyWhitePiecesAscendingOrder(Collection<Piece> whitePieceCollection) {
        softly.assertThat(whitePieceCollection).containsExactly(
                Piece.createWhiteKing(),
                Piece.createWhitePawn(),
                Piece.createWhiteKnight(),
                Piece.createWhiteBishop(),
                Piece.createWhiteRook(),
                Piece.createWhiteQueen());
    }

    private void verifyWhitePiecesDecreasingOrder(Collection<Piece> whitePieceCollection) {
        softly.assertThat(whitePieceCollection).containsExactly(
                Piece.createWhiteQueen(),
                Piece.createWhiteRook(),
                Piece.createWhiteBishop(),
                Piece.createWhiteKnight(),
                Piece.createWhitePawn(),
                Piece.createWhiteKing());
    }

}
