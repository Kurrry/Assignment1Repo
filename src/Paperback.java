public class Paperback extends Book{
    private String authors;
    private int year;
    private String genre;

    /**
     *
     * @param isbn
     * @param callNumber
     * @param availableBooks
     * @param totalBooks
     * @param bookTitle
     * @param authors
     * @param year
     * @param genre
     */
    public Paperback(long isbn, String callNumber, int availableBooks, int totalBooks,
              String bookTitle, String authors, int year, String genre) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.authors = authors;
        this.year = year;
        this.genre = genre;
    }

    /**
     *
     * @return
     */
    public String getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     *
     * @return
     */
    public short getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(short year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public char getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(char genre) {
        this.genre = genre;
    }
}
