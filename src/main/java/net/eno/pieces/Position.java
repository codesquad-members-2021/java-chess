package net.eno.pieces;

public class Position {

    private char file;
    private int rank;

    public Position(String position) {
        setPosition(position);
    }

    private void setPosition(String position) {
        try {
            char file = position.charAt(0);
            int rank = Character.getNumericValue(position.charAt(1));
            if (position.length() == 2 &&
                    (97 <= file && file <= 104) &&
                    (1 <= rank && rank <= 8)) {
                this.file = file;
                this.rank = rank;
            } else {
                System.out.println("location range error");
            }
        } catch (Exception e) {
            System.out.println("location parsing error");
        }
    }

    public int getFileIndex() {
        return this.file - 'a';
    }

    public int getRankIndex() {
        return 8 - this.rank;
    }

}
