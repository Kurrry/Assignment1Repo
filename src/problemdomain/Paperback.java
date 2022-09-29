/*
 * @author Avery Johnson-Dhillon // Eric Gagne // John Holloway
 * @version Sept 28, 2022
 * 
 * Subclass of Books
 */

package problemdomain;
public class Paperback extends Books{
    private String authors;
    private int year;
    private char genre;

    /**
     * Constructor of Paperback class
     *
     * @param isbn ISBN of book
     * @param callNumber Call number of book 
     * @param availableBooks Number of book available now
     * @param totalBooks Total number of a book in inventory
     * @param bookTitle Title of book
     * @param authors Book authors
     * @param year Year of publication
     * @param genre Book genre
     */
    public Paperback(long isbn, String callNumber, int availableBooks, int totalBooks,
              String bookTitle, String authors, int year, char genre) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.authors = authors;
        this.year = year;
        this.genre = genre;
    }

    /**
     * Returns the book authors of a Paperback object
     *
     * @return Book authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     *Sets the book authors of a Paperback object
     *
     * @param authors Book authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * Returns the publication year of a Paperback object
     *
     * @return Year of publication
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the publication year of a Paperback object
     *
     * @param year Year of publication
     */
    public void setYear(short year) {
        this.year = year;
    }

    /**
     * Returns the genre of a Paperback object
     *
     * @return Book genre
     */
    public char getGenre() {
        return genre;
    }

    /**
     * Sets the genre of a Paperback object
     *
     * @param genre Book genre
     */
    public void setGenre(char genre) {
        this.genre = genre;
    }
    
    /*
     * @return Formatted String displaying all the data fields of a Paperback object
     */
    @Override
    public String toString() {
        String temp = "";
        switch (getGenre()) {
            case 'D':
                temp = "Drama";
                break;

            case 'A':
                temp = "Adventure";
                break;

            case 'E':
                temp = "Education";
                break;

            case 'C':
                temp = "Classic";
                break;

            case 'F':
                temp = "Fantasy";
                break;

            case 'S':
                temp = "Science Fiction";
                break;
        }

           return super.toString() + "\nAuthors:          " + getAuthors() +
                "\nYear:             " + getYear() +
                "\nGenre:            " + temp + "\n";
    }
}
