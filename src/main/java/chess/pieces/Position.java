package chess.pieces;

public class Position {
    private int rank, file;

    public Position(String position){
        char rankIndex = position.charAt(0);
        char fileIndex = position.charAt(1);

        this.rank = rankIndex - 'a';
        this.file = (Character.getNumericValue(fileIndex))-1;
    }

    public Position(int rank, int file){
        this.rank = rank-1;
        this.file = file-1;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

}
