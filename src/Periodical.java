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
    
    /**
     * @return string
     */
    @Override
    public String toString() {
        String temp = "";
        switch (getFrequency()) {
            case 'D':
                temp = "Daily";
                break;

            case 'W':
                temp = "Weekly";
                break;

            case 'M':
                temp = "Monthly";
                break;

            case 'B':
                temp = "Bimonthly";
                break;

            case 'Q':
                temp = "Quarterly";
                break;
        }

           return super.toString() +
                "\nFrequency:        " + temp + "\n";
    }
}


