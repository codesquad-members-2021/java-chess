package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.CalculablePiece;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.Piece;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board {
    // 체스에서 row를 rank라고 한다.
    public static final int RANK_SIZE = 8;
    private List<File> files = new ArrayList<>();

    public Board() {
        for (int i = 0; i < RANK_SIZE; i++) {
            files.add(new File());
        }
    }

    public Board initialize() {
        initializePieceBy(Color.BLACK);
        initializeEmptyPiece();
        initializePieceBy(Color.WHITE);
        return this;
    }

    private void initializePieceBy(Color color) {
        int royalIndex = new RankIndex(color.royalInitializationRank()).getRankIndexForList();
        int pawnIndex = new RankIndex(color.pawnInitializationRank()).getRankIndexForList();

        files.get(royalIndex).fillWithRoyal(color);
        files.get(pawnIndex).fillWithPawn(color);
    }

    private void initializeEmptyPiece() {
        files.get(new RankIndex(3).getRankIndexForList()).fillWithBlank();
        files.get(new RankIndex(4).getRankIndexForList()).fillWithBlank();
        files.get(new RankIndex(5).getRankIndexForList()).fillWithBlank();
        files.get(new RankIndex(6).getRankIndexForList()).fillWithBlank();
    }

    public void move(String source, String destination) {
        set(destination, findPiece(source));
        set(source, Piece.createBlank());
    }

    public void add(Piece piece) {
        files.stream()
                .filter(File::isAddable)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("더 이상 추가할 수 없습니다. 현재 크기 : " + pieceCount()))
                .add(piece);
    }

    /**
     * 체스판은 아래와 같이 8*8칸으로 구성되는데, coulmn은 file row는 rank라고 한다.
     * 각 칸은 h1, d6와 같이 file + rank로 명명한다.
     * 만약 h1에 있는 체스말을 찾고 싶으면 <code>findPiece("h1")</code> 과 같이 사용할 수 있다.
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
     * @param position a~h 사이의 알파벳과 1~8 사이의 숫자 조합
     * @return 해당 칸에 존재하는 기물
     * @see <a href="https://www.dummies.com/games/chess/naming-ranks-and-files-in-chess/" >Naming Ranks and Files in Chess</a> 를 참고하였음.
     */
    public Piece findPiece(String position) {
        Position positionConverter = Position.of(position);
        return files.get(positionConverter.getRankIndexForList())
                .get(positionConverter.getFileIndexForList());
    }

    public Piece set(String position, Piece piece) {
        Position positionConverter = Position.of(position);

        return files.get(positionConverter.getRankIndexForList())
                .set(positionConverter.getFileIndexForList(), piece);
    }

    public int pieceCount() {
        return files.stream()
                .mapToInt(File::size)
                .sum();
    }

    public List<Piece> getPiecesBy(Color color) {
        return files.stream()
                .flatMap(file -> file.getPieces().stream())
                .filter(file -> file.getColor() == color)
                .sorted()
                .collect(Collectors.toList());
    }

    public String getRepresentation() {
        return files.stream()
                .map(File::getRepresentation)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public int getNumberOf(Color color, Kind kind) {
        return files.stream()
                .mapToInt(file -> file.getNumberOf(color, kind))
                .sum();
    }

    public Map<CalculablePiece, Double> groupingByCalculablePiece(Color color) {
        return files.stream()
                .flatMap(file -> file.getCalculablePieces().stream())
                .filter(calculablePiece -> calculablePiece.getColor() == color)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingDouble(CalculablePiece::getPoint)
                ));
    }

    @Override
    public String toString() {
        return "Board{" +
                "files=" + files +
                '}';
    }
}
