package net.woody.pieces;

public enum Color {

    WHITE, BLACK, NOCOLOR;

    // TODO : 쓰이지 않는다, 제거해도 좋음
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
