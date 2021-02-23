package net.tree.chess;

<<<<<<< HEAD
import net.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
=======
import net.tree.pieces.Pawn;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.junit.jupiter.api.BeforeEach;
>>>>>>> kyu가 리뷰해준 내용 반영하였습니다.
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
>>>>>>> 3c74074... feat : Do Mission2
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
=======
import static org.junit.jupiter.api.Assertions.*;
=======
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
>>>>>>> feat : Do Mission2
<<<<<<< HEAD
>>>>>>> 3c74074... feat : Do Mission2
=======
=======
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
>>>>>>> rebase mission3
<<<<<<< HEAD
>>>>>>> 5913482... rebase mission3
=======
=======
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
>>>>>>> feat : Do Mission2
<<<<<<< HEAD
>>>>>>> 8a78563... feat : Do Mission2
=======
=======
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
>>>>>>> fix : mission3
<<<<<<< HEAD
>>>>>>> 50300b1... fix : mission3
=======
=======
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
>>>>>>> Dion이 리뷰해주신 내용 반영하다.
>>>>>>> 4e4c335... Dion이 리뷰해주신 내용 반영하다.

class BoardTest {

<<<<<<< HEAD
    private Board board;
=======
class BoardTest {
>>>>>>> 4e4c335... Dion이 리뷰해주신 내용 반영하다.

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @BeforeEach
    void setup() {
        board = new Board();
=======
=======
>>>>>>> 5913482... rebase mission3
=======
>>>>>>> a20eb16... kyu가 리뷰해준 내용 반영하였습니다.
<<<<<<< HEAD
    @DisplayName("하얀색, 검정색 pawn 만들기")
    @Test
    public void create() {
=======
    @Test
    public void create() throws Exception {
>>>>>>> feat : Do Mission2
=======
    @DisplayName("하얀색, 검정색 pawn 만들기")
    @Test
    public void create() {
>>>>>>> rebase mission3
        Board board = new Board();

=======
    Board board;

    @BeforeEach
    void makeNewBoard() {
        board = new Board();
    }

    @DisplayName("하얀색, 검정색 pawn 만들기")
    @Test
<<<<<<< HEAD
    public void create() {
>>>>>>> kyu가 리뷰해준 내용 반영하였습니다.
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> rebase mission3
=======
    void createWhitePawnAndBlackPawn() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.addPawntopawnList(white);
>>>>>>> Dion이 리뷰해주신 내용 반영하다.
        Assertions.assertAll(
            () -> assertThat(board.checkPawnSize()).isEqualTo(1),
            () -> assertThat(board.findPawn(0)).isEqualTo(white)
        );
<<<<<<< HEAD

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.addPawntopawnList(black);
        Assertions.assertAll(
                () -> assertThat(board.checkPawnSize()).isEqualTo(2),
                () -> assertThat(board.findPawn(1)).isEqualTo(black)
        );
>>>>>>> 3c74074... feat : Do Mission2
    }

    @DisplayName("보드 생성하기(모든 피스 포함)")
    @Test
<<<<<<< HEAD
    void createBoard() {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard())
                .isEqualTo(
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));

        System.out.println(board.showBoard());
=======
    public void checkPawnList() {
        Board board = new Board();
=======
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

=======
>>>>>>> rebase mission3

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        Assertions.assertAll(
                () -> assertEquals(2, board.checkPawnSize()),
                () -> assertEquals(black, board.findPawn(1))
        );
    }

<<<<<<< HEAD
    @DisplayName("컴파일 에러 발생시키기")
    @Test
    public void checkPawnList() throws Exception {
        Board board = new Board();
<<<<<<< HEAD
        assertTrue(board.pawnList.add("7"));
>>>>>>> feat : Do Mission2
=======
        //assertTrue(board.pawnList.add("7"));
>>>>>>> feat : Do Mission3
        assertTrue(board.pawnList.add(new Pawn()));
>>>>>>> 3c74074... feat : Do Mission2
    }

<<<<<<< HEAD
    //개행 추가시키는 메소드
    private String appendNewLine(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(StringUtils.NEWLINE);
        return sb.toString();
    }
=======
>>>>>>> feat : Do Mission2


=======
    @DisplayName("보드 초기화 및 그리기")
    @Test
    void initializeBoardAndAppend() {
        board.initialize();
        board.appendBoardWithPawns();
    }

    @DisplayName("보드 초기화하기")
    @Test
    void initializeBoard() {
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getPawnsResult(Pawn.WHITE_REPRESENTATION));
        assertThat("PPPPPPPP").isEqualTo(board.getPawnsResult(Pawn.BLACK_REPRESENTATION));

    }
<<<<<<< HEAD
>>>>>>> a101753... feat : Do Mission3
=======

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1f82d36... feat : Do Mission2
=======
    @DisplayName("pawnList 확인해보기 ")
    @Test
    public void checkPawnList() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.checkPawnSize());
        assertEquals(white, board.findPawn(0));

<<<<<<< HEAD
>>>>>>> 5913482... rebase mission3
=======
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.checkPawnSize());
        assertEquals(black, board.findPawn(1));
=======
    @DisplayName("whitePawn과 blackPawn 1개씩으로 pawnList 확인해보기 ")
    @Test
    void checkPawnListWithWhitePawnAndBlackPawn() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.addPawntopawnList(white);
        assertThat(board.checkPawnSize()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.addPawntopawnList(black);
        assertThat(board.checkPawnSize()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
>>>>>>> 4e4c335... Dion이 리뷰해주신 내용 반영하다.
    }
<<<<<<< HEAD
>>>>>>> 8a78563... feat : Do Mission2
=======

>>>>>>> a20eb16... kyu가 리뷰해준 내용 반영하였습니다.
}

