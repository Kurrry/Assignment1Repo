/*
 * @author Avery Johnson-Dhillon // Eric Gagne // John Holloway
 * @version September 28, 2022
 * 
 * Subclass of Books
 */

package problemdomain;
public class Cookbook extends Books{
    private String publisher;
    private char diet;


    /**
     * Constructor of Cookbook class
     * 
     *@param isbn ISBN of book
     * @param callNumber Call number of book 
     * @param availableBooks Number of book available now
     * @param totalBooks Total number of a book in inventory
     * @param bookTitle Title of book
     * @param publisher Book publisher
     * @param diet Diet of book
     */
    public Cookbook(long isbn, String callNumber, int availableBooks, int totalBooks,
                    String bookTitle, String publisher, char diet) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.publisher = publisher;
        this.diet = diet;
    }
    /**
     * Returns the book publisher of a Cookbook object
     * 
     * @return Book publisher
     */
    public String getPublisher() {
        return publisher;
    }
    /**
     * Sets the book publisher of a Cookbook object
     * 
     * @param publisher Book publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    /**
     * Returns the diet of a Cookbook object
     * 
     * @return Diet of book
     */
    public char getDiet() {
        return diet;
    }
    /**
     * Sets the diet of a Cookbook object
     * 
     * @param diet Diet of book
     */
    public void setDiet(char diet) {
        this.diet = diet;
    }
    
    /**
     * @return Formatted String displaying all the data fields of a Cookbook object
     */
    @Override
    public String toString() {
        String temp = "";
        switch (getDiet()) {
            case 'D':
                temp = "Diabetic";
                break;

            case 'V':
                temp = "Vegetarian";
                break;

            case 'G':
                temp = "Gluten-free";
                break;

            case 'I':
                temp = "International";
                break;

            case 'N':
                temp = "None";
                break;
        }

           return super.toString() +
                "\nDiet:             " + temp +
                "\nPublisher:        " + getPublisher() + "\n";
    }
}
