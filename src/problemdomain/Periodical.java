/*
 * @author Avery Johnson-Dhillon // Eric Gagne // John Holloway
 */

public class Periodical extends Books{
    private char frequency;

    /**
     * Constructor of Periodical class
     *
     * @param isbn ISBN of book
     * @param callNumber Call number of book 
     * @param availableBooks Number of book available now
     * @param totalBooks Total number of a book in inventory
     * @param bookTitle Title of book
     * @param frequency Publication frequency
     */
    public Periodical(long isbn, String callNumber, int availableBooks, int totalBooks,
                      String bookTitle, char frequency) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.frequency = frequency;
    }

    /**
     * Returns the publication frequency of a Periodical object
     *
     * @return Publication frequency
     */
    public char getFrequency() {
        return frequency;
    }

    /**
     * Sets the publication frequency of a Periodical object
     *
     * @param frequency Publication frequency
     */
    public void setFrequency(char frequency) {
        this.frequency = frequency;
    }
    
    /**
     * @return Formatted String displaying all the data fields of a Periodical object
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


