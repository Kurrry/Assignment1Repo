/*
 * @author Avery Johnson-Dhillon // Eric Gagne // John Holloway
 * @version September 28, 2022
 * 
 * This is the superclass of Books. It has subclasses of ChildrensBook, Cookbook, Paperback, and Periodical
 * 
 */
package problemdomain;
public abstract class Books {
    private long isbn;
    private String callNumber;
    private int availableBooks;
    private int totalBooks;
    private String bookTitle;

    /**
     * Constructor of Books class. 
     * 
     * @param isbn ISBN of book
     * @param callNumber Call number of book 
     * @param availableBooks Number of book available now
     * @param totalBooks Total number of a book in inventory
     * @param bookTitle Title of book
     */
    Books(long isbn, String callNumber, int availableBooks, int totalBooks, String bookTitle) {
        this.isbn = isbn;
        this.callNumber = callNumber;
        this.availableBooks = availableBooks;
        this.totalBooks = totalBooks;
        this.bookTitle = bookTitle;
    }

    /**
     * Sets the ISBN of a Books object
     * 
     * @param isbn ISBN of book
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    
    /**
     * Sets the call number of a Books object
     * 
     * @param callNumber Call number of book
     */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /**
     * Sets the number of copies currently available to rent of a Books object
     * 
     * @param availableBooks Number of books available now
     */
    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    /**
     * Sets the total number of copies in inventory of a Books object
     * 
     * @param totalBooks Total number of a book in inventory
     */
    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    /**
     * Sets the title of a Books object
     * 
     * @param bookTitle Title of book
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Returns the ISBN of a Books object
     * 
     * @return ISBN of book
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Returns the call number of a Books object
     * 
     * @return Call number of book
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * Returns the number of books available to rent at the moment of a Books object
     * 
     * @return Number of books available now
     */
    public int getAvailableBooks() {
        return availableBooks;
    }

    /**
     * Returns the total number of a book in the inventory of a Books object
     * 
     * @return Total number of a book in inventory
     */
    public int getTotalBooks() {
        return totalBooks;
    }

    /**
     * Returns the title of a Books object
     * 
     * @return Title of book
     */
    public String getBookTitle() {
        return bookTitle;
    }
    
    /**
     * @return Formatted String displaying all the data fields of a Books object
     */
    @Override
    public String toString() {
        return "ISBN:             " + getIsbn() +
                "\nCall Number:      " + getCallNumber() +
                "\nAvailable:        " + getAvailableBooks() +
                "\nTotal:            " + getTotalBooks() +
                "\nTitle:            " + getBookTitle();
    }
}