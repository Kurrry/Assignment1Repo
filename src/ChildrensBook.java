public class ChildrensBook extends Books{
    private String authors;
    private char format;

    public ChildrensBook(long isbn, String callNumber, int availableBooks, int totalBooks,
                         String bookTitle, String authors, char format) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.authors= authors;
        this.format = format;
    }

    public char getFormat() {
        return format;
    }

    public void setFormat(char format) {
        this.format = format;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
