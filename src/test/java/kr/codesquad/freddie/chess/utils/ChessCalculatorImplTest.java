package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.CalculablePiece;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ChessCalculatorImplTest {
    private ChessCalculatorImpl chessCalculatorImpl = new ChessCalculatorImpl();
    private PieceFactory blackPieceFactory = new PieceFactory(Color.BLACK);

    @Test
    void calculate() {
        List<File> files = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            File file = new File();
            file.fillWithBlank();
            files.add(file);
        }

        files.get(0).set(0, blackPieceFactory.createPawn());
        files.get(1).set(0, blackPieceFactory.createPawn());
        files.get(2).set(0, blackPieceFactory.createPawn());

        double result = new ChessCalculatorImpl().calculate(files, Color.BLACK);
        assertThat(result).isEqualTo(1.5);
    }
    @Test
    void groupingByCalculablePiece() {
        List<File> files = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            File file = new File();
            files.add(file);
        }

        files.get(Board.RANK_SIZE - Color.BLACK.pawnInitializationRank()).fillWithPawn(Color.BLACK);
        files.get(Board.RANK_SIZE - Color.BLACK.royalInitializationRank()).fillWithRoyal(Color.BLACK);
        files.get(2).fillWithBlank();
        files.get(3).fillWithBlank();
        files.get(4).fillWithBlank();
        files.get(5).fillWithBlank();
        files.get(Board.RANK_SIZE - Color.WHITE.pawnInitializationRank()).fillWithPawn(Color.WHITE);
        files.get(Board.RANK_SIZE - Color.WHITE.royalInitializationRank()).fillWithRoyal(Color.WHITE);


        Map<CalculablePiece, Double> calculablePieceDoubleMap = chessCalculatorImpl.groupingByCalculablePiece(files, Color.BLACK);


        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'a'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'b'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'c'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'd'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'e'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'f'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'g'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'h'))).isEqualTo(Kind.PAWN.point());

        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createRook(), 'a'))).isEqualTo(Kind.ROOK.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createKnight(), 'b'))).isEqualTo(Kind.KNIGHT.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createBishop(), 'c'))).isEqualTo(Kind.BISHOP.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createQueen(), 'd'))).isEqualTo(Kind.QUEEN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createKing(), 'e'))).isEqualTo(Kind.KING.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createBishop(), 'f'))).isEqualTo(Kind.BISHOP.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createKnight(), 'g'))).isEqualTo(Kind.KNIGHT.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createRook(), 'h'))).isEqualTo(Kind.ROOK.point());
    }
}
