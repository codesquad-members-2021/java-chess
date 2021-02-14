package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    // 체스에서 row를 rank라고 한다.
    public static final int RANK_SIZE = 8;
    private List<File> files = new ArrayList<>();

    public Board() {
        for (int i = 0; i < RANK_SIZE; i++) {
            files.add(new File());
        }
    }

    public void add(Pawn pawn) {
        files.stream()
                .filter(File::isAddable)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("더 이상 추가할 수 없습니다. 현재 크기 : " + size()))
                .add(pawn);
    }

    public int size() {
        return files.stream()
                .mapToInt(File::size)
                .sum();
    }

    /**
     * 체스판은 아래와 같이 8*8칸으로 구성되는데, coulmn은 file row는 rank라고 한다.
     * 각 칸은 h1, d6와 같이 file + rank로 명명한다.
     * 만약 h1에 있는 체스말을 찾고 싶으면 filePawn(h, 1) 과 같이 사용할 수 있다.
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
    public Pawn findPawn(char fileIndex, int rankIndex) {
        return files.get(RANK_SIZE - rankIndex).get(fileIndex);
    }

    @Override
    public String toString() {
        return "Board{" + System.lineSeparator() +
                "files=" + System.lineSeparator() + files +
                '}';
    }
}
