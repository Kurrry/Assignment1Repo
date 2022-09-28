public class Cookbook extends Books{
    private String publisher;
    private char diet;


    public Cookbook(long isbn, String callNumber, int availableBooks, int totalBooks,
                    String bookTitle, String publisher, char diet) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.publisher = publisher;
        this.diet = diet;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public char getDiet() {
        return diet;
    }

    public void setDiet(char diet) {
        this.diet = diet;
    }
    @Override
    public String toString() {
           return "ISBN:             " + getIsbn() +
                "\nCall Number:      " + getCallNumber() +
                "\nAvailable:        " + getAvailableBooks() +
                "\nTotal:            " + getTotalBooks() +
                "\nTitle:            " + getBookTitle() +
                "\nDiet:             " + getDiet() +
                "\nPublisher:        " + getPublisher();
    }
}
