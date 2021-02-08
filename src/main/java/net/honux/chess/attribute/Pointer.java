package net.honux.chess.attribute;

public class Pointer {

    char x;
    int y;

    public Pointer(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getPointer(){
        StringBuilder sb = new StringBuilder(this.x);
        sb.append(this.y);
        return sb.toString();
    }
}
