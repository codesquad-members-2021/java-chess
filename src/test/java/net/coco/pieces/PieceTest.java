package net.coco.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("폰이 요구대로 생성되는지 테스트")
    void pawnColorTest() {
        verifyPiece(Color.WHITE);
        verifyPiece(Color.BLACK);
    }

    void verifyPiece(Color color) {
    }

}
