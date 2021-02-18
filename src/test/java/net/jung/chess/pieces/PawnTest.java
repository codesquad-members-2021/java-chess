package net.jung.chess.pieces;

import net.jung.chess.Color;
import net.jung.chess.Name;
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
        Piece piece = Piece.createPiece(color, Name.PAWN);
        assertThat(piece.getColor()).isEqualTo(color);
    }

//    @Test
//    @DisplayName("기본생성자로 흰색 폰을 만들어야한다.")
//    void createDefaultConstructor(){
//        Piece piece = new Piece();
//        assertEquals(Color.WHITE, piece.getColor());
//    }

    @Test
    @DisplayName("흰색폰은 'p' 검은색 폰은 'P'의 representation을 가진다.")
    void verifyRepresentation(){
        Piece whitePiece = Piece.createPiece(Color.WHITE, Name.PAWN);
        assertThat(whitePiece.getRepresentation()).isEqualTo('p');

        Piece blackPiece = Piece.createPiece(Color.BLACK, Name.PAWN);
        assertThat(blackPiece.getRepresentation()).isEqualTo('P');
    }


}
