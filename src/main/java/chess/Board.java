package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
    public static final int MAX_PAWN = 8;
    public static final int HEIGHT = 9;
    public static final int WIDTH = 9;
    public static final int INITIAL_HEIGHT_OF_BLACK_PAWN = 2;
    public static final int INITIAL_HEIGHT_OF_WHITE_PAWN = 7;

    private final List<Pawn> blackPawns = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();

    public List<Pawn> blackPawns() {
        return Collections.unmodifiableList(blackPawns);
    }

    public List<Pawn> whitePawns() {
        return Collections.unmodifiableList(whitePawns);
    }

    public boolean addBlackPawn(Pawn pawn) {
        return blackPawns.add(pawn);
    }

    public boolean addWhitePawn(Pawn pawn) {
        return whitePawns.add(pawn);
    }

    public int size() { // 검은색 pawn과 흰색 pawn의 전체 개수를 반환한다.
        return blackPawns.size() + whitePawns.size();
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    /* 흰색 pawn 8개, 검은색 pawn 8개를 생성해서 각각의 list에 추가한다. */
    public String[][] initialize() {
        for (int i = 0; i < Board.MAX_PAWN; i++) {
            addBlackPawn(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
            addWhitePawn(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
        }

        String[][] boardFilledWithDots = fillDotsOnBoard();                       // board의 각 요소를 "."으로 초기화하여 빈 체스판을 표현한다.
        String[][] boardFilledWithPawns = fillPawnsOnBoard(boardFilledWithDots);  // "."으로 표현된 빈 체스판 위에 "P"와 "p"로 구분되어 표현되는 검은색과 흰색 Pawn을 각각의 초기 위치에 넣는다.

        return boardFilledWithPawns;
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환하여 출력한다. */
    public String print(String[][] initializedBoard) {
        StringBuilder chessBoard = new StringBuilder("");

        for (int height = 1; height < Board.HEIGHT; height++) {  // 편의상 board의 index 0은 사용하지 않기 때문에 height 및 width를 1로 초기화했다.
            for (int width = 1; width < Board.WIDTH; width++) {
                chessBoard.append(initializedBoard[height][width]);
            }
            chessBoard.append("\n");
        }

        return chessBoard.toString();
    }

    /* 빈 체스판을 표현하기 위해 board에 점들을 채운다. */
    private String[][] fillDotsOnBoard() {
        String[][] board = new String[Board.HEIGHT][Board.WIDTH];  // 편의를 위해 index 0은 사용하지 않는다. ( 1 ~ 8 사용)

        for (String[] line : board) {                              // 2차원 배열을 "."로 채운다.
            Arrays.fill(line, ".");
        }

        return board;
    }

    /* 점들로 표현된 빈 체스판 위에 초기위치대로 검은색(P)과 흰색(p) Pawn을 채운다. */
    private String[][] fillPawnsOnBoard(String[][] board) {
        for (int i = 1; i < Board.WIDTH; i++) {                                                        // board는 index 0이 있지만 편의상 1부터 시작하기 때문에 i의 초기값은 1이다.
            board[Board.INITIAL_HEIGHT_OF_WHITE_PAWN][i] = whitePawns.get(i - 1).getRepresentation();  // white and black pawns의 index는 0부터 시작하기 때문에 i - 1을 해주었다.
            board[Board.INITIAL_HEIGHT_OF_BLACK_PAWN][i] = blackPawns.get(i - 1).getRepresentation();
        }

        return board;
    }

    public String getBlackPawnsResult() {
        StringBuilder blackPawnRepresentations = new StringBuilder("");

        for (Pawn black : blackPawns) {
            blackPawnRepresentations.append(black.getRepresentation());
        }

        return blackPawnRepresentations.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder whitePawnRepresentations = new StringBuilder("");

        for (Pawn white : whitePawns) {
            whitePawnRepresentations.append(white.getRepresentation());
        }

        return whitePawnRepresentations.toString();
    }

}
