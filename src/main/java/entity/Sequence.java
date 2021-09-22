package entity;

public class Sequence {

    private char character;
    private int count;

    public Sequence(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
