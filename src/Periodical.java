public class Periodical extends Books{
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
    @Override
    public String toString() {
           return "ISBN:             " + getIsbn() +
                "\nCall Number:      " + getCallNumber() +
                "\nAvailable:        " + getAvailableBooks() +
                "\nTotal:            " + getTotalBooks() +
                "\nTitle:            " + getBookTitle() +
                "\nFrequency:        " + getFrequency();
    }
}


