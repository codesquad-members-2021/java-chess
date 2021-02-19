package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class File {
    public static final int SIZE = 8;
    private List<Piece> pieces = new ArrayList<>();

    public File add(Piece piece) {
        if (!isAddable()) {
            throw new IllegalArgumentException("파일 당 " + SIZE + "개만 추가 가능합니다.");
        }

        pieces.add(piece);

        return this;
    }

    /**
     * 체스판의 file은 column으로, 좌측부터 a에서 시작하여 h까지의 알파벳 인덱스로 매겨진다.
     * 첫 번째 칸 a는 array의 인덱스로 생각했을 때 0과 같고, h는 7과 같다.
     * 예를 들어 가장 좌측의 기물을 가져오려면 get('a') 와 같이 사용할 수 있다.
     *
     * @param fileIndex a~h 사이의 char
     * @return 해당 칸에 존재하는 기물
     * @see Board#findPiece(char, int)
     */
    public Piece get(char fileIndex) {
        return pieces.get(fileIndex - 'a');
    }

    /**
     * 기물을 변경하고 기존에 있던 기물을 반환한다.
     * 체스판의 file은 column으로, 좌측부터 a에서 시작하여 h까지의 알파벳 인덱스로 매겨진다.
     * 첫 번째 칸 a는 array의 인덱스로 생각했을 때 0과 같고, h는 7과 같다.
     * 가장 좌측의 기물을 변경하려면 set('a') 와 같이 사용할 수 있다.
     *
     * @param fileIndex 변경 대상의 인덱스 a~h 사이의 char
     * @param piece     변경할 기물
     * @return 해당 칸에 존재하던 기물
     * @see List#set(int, Object)
     * @see Board#findPiece(char, int)
     */
    public Piece set(char fileIndex, Piece piece) {
        return pieces.set(fileIndex - 'a', piece);
    }

    public Piece get(int index) {
        return pieces.get(index);
    }

    public int size() {
        return pieces.size();
    }

    public int getPieceNumberBy(Color color) {
        return (int) pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .count();
    }

    public boolean isAddable() {
        return size() < SIZE;
    }

    public void fillWithPawn(Color color) {
        fillWith(new Piece(color, Kind.PAWN));
    }

    public void fillWithBlank() {
        fillWith(Piece.createBlank());
    }

    private void fillWith(Piece piece) {
        while (isAddable()) {
            add(piece);
        }
    }

    public void fillWithRoyal(Color color) {
        PieceFactory pieceFactory = new PieceFactory(color);

        this.add(pieceFactory.createRook())
                .add(pieceFactory.createKnight())
                .add(pieceFactory.createBishop())
                .add(pieceFactory.createQueen())
                .add(pieceFactory.createKing())
                .add(pieceFactory.createBishop())
                .add(pieceFactory.createKnight())
                .add(pieceFactory.createRook());

    }

    public String getRepresentation() {
        if (pieces.isEmpty()) {
            return "........";
        }

        return pieces.stream()
                .map(Piece::getRepresentation)
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return "File{" +
                "pieces=" + pieces +
                '}';
    }
}
