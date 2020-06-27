package by.tsikunov.day4_2.enumerator;

public enum SortDirection {
    INCREASING(1),
    DISCREASING(-1);

    private final int direction;
    private SortDirection(int direction){
        this.direction = direction;
    }
    public int getDirection() {
        return direction;
    }
}
