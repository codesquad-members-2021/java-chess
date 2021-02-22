package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.utils.ChessCalculator;
import kr.codesquad.freddie.chess.utils.ChessCalculatorImpl;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    // 체스에서 row를 rank라고 한다.
    public static final int RANK_SIZE = 8;
    private List<File> files = new ArrayList<>();
    private ChessCalculator chessCalculator;

    public Board() {
        this(new ChessCalculatorImpl());
    }

    public Board(ChessCalculator chessCalculator) {
        this.chessCalculator = chessCalculator;

        for (int i = 0; i < RANK_SIZE; i++) {
            files.add(new File());
        }
    }

    public void add(Piece piece) {
        files.stream()
                .filter(File::isAddable)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("더 이상 추가할 수 없습니다. 현재 크기 : " + pieceCount()))
                .add(piece);
    }

    public int pieceCount() {
        return files.stream()
                .mapToInt(File::size)
                .sum();
    }

    /**
     * 체스판은 아래와 같이 8*8칸으로 구성되는데, coulmn은 file row는 rank라고 한다.
     * 각 칸은 h1, d6와 같이 file + rank로 명명한다.
     * 만약 h1에 있는 체스말을 찾고 싶으면 findPiece(h, 1) 과 같이 사용할 수 있다.
     *
     * <p>
     * <code>
     * ╭a--b--c--d--e--f--g--h ╮<br/>
     * ╔══╤══╤══╤══╤══╤══╤══╤══╗╮<br/>
     * ║▓▓│░░│▓▓│░░│▓▓│░░│▓▓│░░║8<br/>
     * ║░░│▓▓│░░│▓▓│░░│▓▓│░░│▓▓║7<br/>
     * ║▓▓│░░│▓▓│d6│▓▓│░░│▓▓│░░║6<br/>
     * ║░░│▓▓│░░│▓▓│░░│▓▓│░░│▓▓║5<br/>
     * ║▓▓│░░│▓▓│░░│▓▓│░░│▓▓│░░║4<br/>
     * ║░░│▓▓│░░│▓▓│░░│▓▓│░░│▓▓║3<br/>
     * ║▓▓│░░│▓▓│░░│▓▓│░░│▓▓│░░║2<br/>
     * ║░░│▓▓│░░│▓▓│░░│▓▓│░░│h1║1<br/>
     * ╚══╧══╧══╧══╧══╧══╧══╧══╝╯
     * </code>
     *
     * @param fileIndex a~h 사이의 char
     * @param rankIndex 1~8 사이의 int
     * @return 해당 칸에 존재하는 기물
     * @see <a href="https://www.dummies.com/games/chess/naming-ranks-and-files-in-chess/" >Naming Ranks and Files in Chess</a> 를 참고하였음.
     */
    public Piece findPiece(char fileIndex, int rankIndex) {
        return files.get(convertRankIndexToListIndex(rankIndex)).get(fileIndex);
    }

    public Piece set(char fileIndex, int rankIndex, Piece piece) {
        return files.get(convertRankIndexToListIndex(rankIndex)).set(fileIndex, piece);
    }

    public int getNumberOf(Color color, Kind kind) {
        return files.stream()
                .mapToInt(file -> file.getNumberOf(color, kind))
                .sum();
    }

    public Board initialize() {
        initializePieceBy(Color.BLACK);
        initializeEmptyPiece();
        initializePieceBy(Color.WHITE);
        return this;
    }

    private void initializePieceBy(Color color) {
        int royalIndex = convertRankIndexToListIndex(color.royalInitializationRank());
        int pawnIndex = convertRankIndexToListIndex(color.pawnInitializationRank());

        files.get(royalIndex).fillWithRoyal(color);
        files.get(pawnIndex).fillWithPawn(color);
    }

    private void initializeEmptyPiece() {
        files.get(convertRankIndexToListIndex(3)).fillWithBlank();
        files.get(convertRankIndexToListIndex(4)).fillWithBlank();
        files.get(convertRankIndexToListIndex(5)).fillWithBlank();
        files.get(convertRankIndexToListIndex(6)).fillWithBlank();
    }

    private int convertRankIndexToListIndex(int rankIndex) {
        return RANK_SIZE - rankIndex;
    }

    public String getRepresentation() {
        return files.stream()
                .map(File::getRepresentation)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public double getScoreOf(Color color) {
        return chessCalculator.calculate(files, color);
    }

    @Override
    public String toString() {
        return "Board{" + System.lineSeparator() +
                "files=" + System.lineSeparator() + files +
                '}';
    }
}
