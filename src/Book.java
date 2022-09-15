abstract class Book {
    private long isbn;
    private String callNumber;
    private int availableBooks;
    private int totalBooks;
    private String bookTitle;

    /**
     *
     * @param isbn
     * @param callNumber
     * @param availableBooks
     * @param totalBooks
     * @param bookTitle
     */
    Book(long isbn, String callNumber, int availableBooks, int totalBooks, String bookTitle) {
        this.isbn = isbn;
        this.callNumber = callNumber;
        this.availableBooks = availableBooks;
        this.totalBooks = totalBooks;
        this.bookTitle = bookTitle;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @param callNumber
     */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /**
     *
     * @param availableBooks
     */
    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    /**
     *
     * @param totalBooks
     */
    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    /**
     *
     * @param bookTitle
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     *
     * @return
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     *
     * @return
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     *
     * @return
     */
    public int getAvailableBooks() {
        return availableBooks;
    }

    /**
     *
     * @return
     */
    public int getTotalBooks() {
        return totalBooks;
    }

    /**
     *
     * @return
     */
    public String getBookTitle() {
        return bookTitle;
    }
}

/*
The problem:

The ABC Book Company wants to implement a system to manage their books more efficiently. The system should allow both employees and patrons to checkout, find, and list books.
A data file containing a sample list of books is provided. The data file contains a combination of four different types of books: children’s books, cookbooks, paperbacks, and periodicals.
Each book is uniquely identified using an ISBN and the information for each type of book is described in the formatting section.
The ABC Book Company wants an interactive program that does the following:


1.	Checkout a book.
•	Allows a patron to checkout a book using its ISBN. If the book is unavailable, the user will be informed and the program will return back to the main menu.
    Otherwise, if the book is available, the available count will be decremented and the book information will be displayed.
2.	Find books by title.
•	Allows a patron to enter a search term and the program will display a list of books that have a title matching the search term.
3.	Display books of a specific type.
•	Allows a patron to view a list of books with a specific type.
    The user will also enter a format, diet, genre, or frequency (depending on the type of book) and the book list will be narrowed down further.
4.	Produce a list of random books.
•	Allows a patron to print a list of random books. The list of books can contain any type of book.



types of books:
    children: Picture book, Early Readers, or Chapter book
    cookbook: Diabetic, Vegetarian, Gluten-free, International, or None
    paperback: Adventure, Drama, Education, Classic, Fantasy, or Science Fiction
    periodicals: Daily, Weekly, Monthly, Bimonthly, and Quarterly. A periodical cannot be checked out

ISBN length = 13

Animal anim = new Cat();
Cat cat = (Cat) anim;

D) Objects will be created as Book test = new SubClassType for storing List. List contents will be displayed by downcasting
Objects to appropriate subtype based on isbn.
*/
