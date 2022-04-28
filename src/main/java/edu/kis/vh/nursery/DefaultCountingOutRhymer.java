package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int SIZE = 12;
    private static final int ERR_EMPTY = -1;
    private static final int ERR_FULL = getSIZE() - 1;

    private final int[] numbers = new int[getSIZE()];

    public static int getSIZE() {
        return SIZE;
    }

    public static int getErrEmpty() {
        return ERR_EMPTY;
    }

    public static int getErrFull() {
        return ERR_FULL;
    }


    public int getTotal() {
        return total;
    }

    private int total = getErrEmpty();

    public void countIn(int in) {
        if (!isFull())
            getNumbers()[setTotal(getTotal() + 1)] = in;
    }

    protected boolean callCheck() {
        return getTotal() == getErrEmpty();
    }

    protected boolean isFull() {
        return getTotal() == getErrFull();
    }

    protected int peekaboo() {
        if (callCheck())
            return getErrEmpty();
        return getNumbers()[getTotal()];
    }

    public int countOut() {
        if (callCheck())
            return getErrEmpty();
        int ret = getTotal();
        setTotal(getTotal() - 1);
        return getNumbers()[ret];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int setTotal(int total) {
        this.total = total;
        return total;
    }
}
