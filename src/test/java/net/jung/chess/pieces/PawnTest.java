package net.jung.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다.")
    void createPawnsByColor(){
        Color white = Color.WHITE;
        Color black = Color.BLACK;

        verifyPawn(white);
        verifyPawn(black);
    }

    private void verifyPawn(Color color){
        Piece piece = Piece.createPiece(color, Type.PAWN);
        assertThat(piece.getColor()).isEqualTo(color);
    }


    @Test
    @DisplayName("흰색폰은 'p' 검은색 폰은 'P'의 representation을 가진다.")
    void verifyRepresentation(){
        Piece whitePiece = Piece.createPiece(Color.WHITE, Type.PAWN);
        assertThat(whitePiece.getRepresentation()).isEqualTo('p');

        Piece blackPiece = Piece.createPiece(Color.BLACK, Type.PAWN);
        assertThat(blackPiece.getRepresentation()).isEqualTo('P');
    }


}
