public class Periodical extends Book{
    private char frequency;

    /**
     *
     * @param isbn
     * @param callNumber
     * @param availableBooks
     * @param totalBooks
     * @param bookTitle
     * @param frequency
     */
    public Periodical(long isbn, String callNumber, int availableBooks, int totalBooks,
               String bookTitle, char frequency) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.frequency = frequency;
    }

    /**
     *
     * @return
     */
    public char getFrequency() {
        return frequency;
    }

    /**
     *
     * @param frequency
     */
    public void setFrequency(char frequency) {
        this.frequency = frequency;
    }
}


