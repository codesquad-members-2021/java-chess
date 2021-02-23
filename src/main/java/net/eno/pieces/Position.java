package net.eno.pieces;

import java.util.Objects;

public class Position {

    private char file;
    private int rank;

    public Position(String position) {
        setPosition(position);
    }

    private void setPosition(String location) {
        try {
            char file = location.charAt(0);
            int rank = Character.getNumericValue(location.charAt(1));
            if (location.length() == 2 &&
                    97 <= file && file <= 104 &&
                    1 <= rank && rank <= 8) {
                this.file = file;
                this.rank = rank;
            } else {
                System.out.println("location range error");
            }
        } catch (Exception e) {
            System.out.println("location parsing error");
        }
    }

    public int getFile() {
        return this.file - 'a';
    }

    public int getRank() {
        return 8 - this.rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return file == position.file && rank == position.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

}
