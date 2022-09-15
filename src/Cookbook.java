public class Cookbook extends Book{
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
}
