public class ChildrensBook extends Books{
    private String authors;
    private char format;

    public ChildrensBook(long isbn, String callNumber, int availableBooks, int totalBooks,
                         String bookTitle, String authors, char format) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.authors= authors;
        this.format = format;
    }
    /**
     * @return format
     */
    public char getFormat() {
        return format;
    }
    /**
     * @param format
     */
    public void setFormat(char format) {
        this.format = format;
    }
    /**
     * @return authors
     */
    public String getAuthors() {
        return authors;
    }
    /**
     * @param authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    /**
     * @return string
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
