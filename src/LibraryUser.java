import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibraryUser {
	Scanner userInput = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<>();
	
	public LibraryUser() {
	}
	
	public void loadMenu() throws IOException {
		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1\tCheckout Book");
		System.out.println("2\tFind Books by Title");
		System.out.println("3\tDisplay Books by Type");
		System.out.println("4\tProduce Random Book List");
		System.out.println("5\tSave and Exit");
		System.out.println("\nEnter option");
		LibraryUser newUser = new LibraryUser();
		short choice = userInput.nextShort();

		switch (choice) {
			case 1:
				newUser.checkoutBook();
				break;

			case 2:
				newUser.findBook();
				break;

			case 3:
				newUser.bookByType();
				break;

			case 4:
				newUser.randomBookList();
				break;

			case 5:
				newUser.saveBookList();
				break;
		}
	}
	
	public void loadDoc() throws Exception {
		File bookFile = new File("A7_Gagne_Holloway_Johnson-Dhillon\books.txt");
		Scanner reader = new Scanner(bookFile);
		while (reader.hasNext()) {
			String currentLine = reader.nextLine();
			Scanner parser = new Scanner(currentLine).useDelimiter(";");
			String stringISBN = parser.nextLine();
			long iSBN = Long.parseLong(stringISBN);
			long bookType = iSBN % 10;
			String callNum = parser.nextLine();
			String stringAvailable = parser.nextLine();
			int available = Integer.parseInt(stringAvailable);
			String stringTotal = parser.nextLine();
			int total = Integer.parseInt(stringTotal);
			String title = parser.nextLine();
			if (bookType == 0 || bookType == 1) {
				String authors = parser.nextLine();
				String format = parser.nextLine();
				Book temp = new ChildrensBook(iSBN, callNum, available, total, title, authors, format);
				bookList.add(new ChildrensBook(iSBN, callNum, available, total, title, authors, format));
			}
			else if (bookType == 2 || bookType == 3) {
				String publisher = parser.nextLine();
				String diet = parser.next();
				bookList.add(new Cookbook(iSBN, callNum, available, total, title, publisher, diet));
			}
			else if (bookType == 8 || bookType == 9) {
				String frequency = parser.nextLine();
				bookList.add(new Periodical(iSBN, callNum, available, total, title, frequency));
			}
			else {
				String authors = parser.nextLine();
				String stringYear = parser.nextLine();
				int year = Integer.parseInt(stringYear);
				String genre = parser.nextLine();
				bookList.add(new Paperback(iSBN, callNum, available, total, title, authors, year, genre));
			}
		}
	}
	
	public void checkoutBook() {
		System.out.println("Enter ISBN of book:");
		int iSBN = Integer.parseInt(userInput.nextLine());
		boolean found = false;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getISBN() == iSBN) {
				int quantity = bookList.get(i).getQuantity();
				if (quantity > 0) {
					found = true;
					bookList.get(i).setQuantity(quantity - 1);
					System.out.println("The book " + bookList.get(i).getTitle() + " has been checked out.\nIt can be located using a call number: " + bookList.get(i).getCallNumber());
				}
				else {
					System.out.println("There are no more copies of " + bookList.get(i).getTitle() + " available to rent.");
				}
			}
			if (!found) {
				System.out.println("There are no books in our entries which match the given ISBN:\n" + iSBN);
			}
		}
	}
	
	public void findBook() {
		System.out.println("Enter title to search for:");
		String title = userInput.nextLine().toLowerCase();
		System.out.println("Matching books:");
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().toLowerCase().contains(title)) {
				System.out.println(bookList.get(i).toString());
			}
		}
	}
	
	public void bookByType() {
		System.out.println("#\tType\n1\tChildren's Books\n2\tCookbooks\n3\tPaperbacks\n4\tPeriodicals\n\nEnter type of book:");
		int choice = Integer.parseInt(userInput.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter a format (P for Picture book, E for Early readers, or C for Chapter book):");
			String format = userInput.nextLine().toLowerCase();
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getFormat().toLowerCase() == format) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		case 2:
			System.out.println("Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None):");
			String diet = userInput.nextLine().toLowerCase();
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getDiet().toLowerCase() == diet) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		
		case 3:
			System.out.println("Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction):");
			String genre = userInput.nextLine().toLowerCase();
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getGenre().toLowerCase() == genre) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		case 4:
			System.out.println("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, or Q for Quarterly):");
			String frequency = userInput.nextLine().toLowerCase();
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getFrequency().toLowerCase() == frequency) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		}
	}
	
	public void randomBookList() {
		System.out.println("Enter number of books:");
		int numOfBooks = Integer.parseInt(userInput.nextLine());
		System.out.println("Random books:");
		Collections.shuffle(bookList);
		for (int i = 0; i < numOfBooks; i++) {
			System.out.println(bookList.get(i).toString());
		}
	}
	
	public void saveBookList() throws IOException {
		File bookFile = new File("A7_Gagne_Holloway_Johnson-Dhillon\\books.txt");
		PrintWriter scribe = new PrintWriter(bookFile);
		for (int i = 0; i < bookList.size(); i++) {
			long iSBN = bookList.get(i).getIsbn();
			long bookType = iSBN % 10;
			String callNum = bookList.get(i).getCallNum();
			int available = bookList.get(i).getAvailable();
			int total = bookList.get(i).getTotal();
			String title = bookList.get(i).getTitle();
			if (bookType == 0 || bookType == 1) {
				String authors = bookList.get(i).getAuthors();
				String format = bookList.get(i).getFormat();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + authors + ";" + format);
			}
			else if (bookType == 2 || bookType == 3) {
				String publisher = bookList.get(i).getPublisher();
				String diet = bookList.get(i).getDiet();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + publisher + ";" + diet);
			}
			else if (bookType == 8 || bookType == 9) {
				String frequency = bookList.get(i).getFrequency();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + frequency);
			}
			else {
				String authors = parser.nextLine();
				int year = bookList.get(i).getYear();
				String genre = bookList.get(i).getGenre();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + authors + ";" + year + ";" + genre);
			}
		}
		scribe.close();
	}
}