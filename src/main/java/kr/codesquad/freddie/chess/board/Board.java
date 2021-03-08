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
    private Files files = new Files();

    public Board() {
        for (int i = 0; i < RANK_SIZE; i++) {
            files.add(new File());
        }
    }

    public void initializePieceBy(Color color) {
        files.fillWithRoyalAt(color);
        files.fillWithPawnAt(color);
    }

    public void initializeEmptyPiece() {
        files.fillWithBlankAt(new RankIndex(3).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(4).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(5).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(6).getRankIndexForList());
    }

    public void add(Piece piece) {
        files.add(piece);
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
     * @param input a~h 사이의 알파벳과 1~8 사이의 숫자 조합
     * @return 해당 칸에 존재하는 기물
     * @see <a href="https://www.dummies.com/games/chess/naming-ranks-and-files-in-chess/" >Naming Ranks and Files in Chess</a> 를 참고하였음.
     */
    public Piece findPiece(String input) {
        return files.findPiece(Position.of(input));
    }

    public void set(String input, Piece piece) {
        files.set(Position.of(input), piece);
    }

    public int pieceCount() {
        return files.pieceCount();
    }

    public Map<CalculablePiece, Double> groupingByCalculablePiece(Color color) {
        return files.groupingByCalculablePiece(color);
    }

    public List<File> getFiles() {
        return files.getFiles();
    }

    @Override
    public String toString() {
        return "Board{" +
                "files=" + files +
                '}';
    }
}
