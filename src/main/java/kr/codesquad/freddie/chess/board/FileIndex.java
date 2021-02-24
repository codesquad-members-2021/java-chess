package kr.codesquad.freddie.chess.board;

public class FileIndex {
    private char fileIndex;

    public FileIndex(char fileIndex) {
        if (fileIndex < 'a' || 'h' < fileIndex) {
            throw new IllegalArgumentException("올바른 fileIndex가 아닙니다. fileIndex : " + fileIndex);
        }

        this.fileIndex = fileIndex;
    }

    public char getFileIndex() {
        return fileIndex;
    }

    public int getFileIndexForList() {
        return fileIndex - 'a';
    }
}
