package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int SIZE = 12;
    private static final int ERR_EMPTY = -1;
    private static final int ERR_FULL = SIZE - 1;

    private final int[] numbers = new int[SIZE];


    private int total = ERR_EMPTY;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == ERR_EMPTY;
    }

    protected boolean isFull() {
        return total == ERR_FULL;
    }

    protected int peekaboo() {
        if (callCheck())
            return ERR_EMPTY;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return ERR_EMPTY;
        return numbers[total--];
    }

}
