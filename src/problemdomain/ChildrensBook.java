/*
 * @author Avery Johnson-Dhillon // Eric Gagne // John Holloway
 * @version September 28, 2022
 * 
 * Subclass of Books. 
 * 
 */

public class ChildrensBook extends Books{
    private String authors;
    private char format;

    /**
     * Constructor of Childrensbook class
     * 
     * @param isbn ISBN of book
     * @param callNumber Call number of book 
     * @param availableBooks Number of book available now
     * @param totalBooks Total number of a book in inventory
     * @param bookTitle Title of book
     * @param authors Book authors
     * @param format Book format
     */
    public ChildrensBook(long isbn, String callNumber, int availableBooks, int totalBooks,
                         String bookTitle, String authors, char format) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.authors= authors;
        this.format = format;
    }
    /**
     * Returns the format of the Childrensbook object
     * 
     * @return Book format
     */
    public char getFormat() {
        return format;
    }
    /**
     * Sets the format of the Childrensbook object
     * 
     * @param format Book format
     */
    public void setFormat(char format) {
        this.format = format;
    }
    /**
     * Returns the authors of the Childrensbook object
     * 
     * @return Book authors
     */
    public String getAuthors() {
        return authors;
    }
    /**
     * Sets the authors of the Childrensbook object
     * 
     * @param authors Book authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    /**
     * @return Formatted String displaying all the data fields of a Childrensbook object
     */
    @Override
    public String toString() {
        String temp = "";
        switch (getFormat()) {
            case 'P':
                temp = "Picture book";
                break;

            case 'E':
                temp = "Early Readers";
                break;

            case 'C':
                temp = "Chapter book";
                break;
        }

           return super.toString() + "\nAuthors:          " + getAuthors() +
                "\nFormat:           " + temp + "\n";
    }
}
