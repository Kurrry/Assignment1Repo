public class Cookbook extends Books{
    private String publisher;
    private char diet;


    public Cookbook(long isbn, String callNumber, int availableBooks, int totalBooks,
                    String bookTitle, String publisher, char diet) {
        super(isbn, callNumber, availableBooks, totalBooks, bookTitle);
        this.publisher = publisher;
        this.diet = diet;
    }
    /**
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }
    /**
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    /**
     * @return diet
     */
    public char getDiet() {
        return diet;
    }
    /**
     * @param diet
     */
    public void setDiet(char diet) {
        this.diet = diet;
    }
    
    /**
     * @return string
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
