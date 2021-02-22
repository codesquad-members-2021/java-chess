package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        files.get(0).set('a', blackPieceFactory.createPawn());
        files.get(1).set('a', blackPieceFactory.createPawn());
        files.get(2).set('a', blackPieceFactory.createPawn());

        double result = new ChessCalculatorImpl().calculate(files, Color.BLACK);
        assertThat(result).isEqualTo(1.5);
    }

    @Test
    void getRotatedFiles() {
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


        List<File> rotatedFiles = chessCalculatorImpl.getRotatedFilesBy(files, Color.BLACK);

        assertThat(rotatedFiles.get(0).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(1).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(2).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(3).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(4).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(5).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(6).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);
        assertThat(rotatedFiles.get(7).getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(1);

        assertThat(rotatedFiles.get(0).getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(1);
        assertThat(rotatedFiles.get(1).getNumberOf(Color.BLACK, Kind.KNIGHT)).isEqualTo(1);
        assertThat(rotatedFiles.get(2).getNumberOf(Color.BLACK, Kind.BISHOP)).isEqualTo(1);
        assertThat(rotatedFiles.get(3).getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(1);
        assertThat(rotatedFiles.get(4).getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(1);
        assertThat(rotatedFiles.get(5).getNumberOf(Color.BLACK, Kind.BISHOP)).isEqualTo(1);
        assertThat(rotatedFiles.get(6).getNumberOf(Color.BLACK, Kind.KNIGHT)).isEqualTo(1);
        assertThat(rotatedFiles.get(7).getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(1);
    }
}
