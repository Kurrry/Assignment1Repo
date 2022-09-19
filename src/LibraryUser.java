import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LibraryUser {
	Scanner userInput = new Scanner(System.in);
	public Scanner userInput2 = new Scanner(System.in);
	ArrayList<Books> bookList = new ArrayList<>();
	
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
		/*LibraryUser newUser = new LibraryUser();
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
		}*/
	}
	
	public void loadDoc() throws Exception {
		File bookFile = new File("C:\\Users\\User\\Desktop\\CRPG251\\books.txt");
		Scanner reader = new Scanner(bookFile);
		while (reader.hasNext()) {
			String currentLine = reader.nextLine();
			Scanner parser = new Scanner(currentLine).useDelimiter(";");
			String stringISBN = parser.next();
			long iSBN = Long.parseLong(stringISBN);
			long bookType = iSBN % 10;
			String callNum = parser.next();
			String stringAvailable = parser.next();
			int available = Integer.parseInt(stringAvailable);
			String stringTotal = parser.next();
			int total = Integer.parseInt(stringTotal);
			String title = parser.next();
			if (bookType == 0 || bookType == 1) {
				String authors = parser.next();
				char format = parser.next().charAt(0);
				bookList.add(new ChildrensBook(iSBN, callNum, available, total, title, authors, format));
			}
			else if (bookType == 2 || bookType == 3) {
				String publisher = parser.next();
				char diet = parser.next().charAt(0);
				bookList.add(new Cookbook(iSBN, callNum, available, total, title, publisher, diet));
			}
			else if (bookType == 8 || bookType == 9) {
				char frequency = parser.next().charAt(0);
				bookList.add(new Periodical(iSBN, callNum, available, total, title, frequency));
			}
			else {
				String authors = parser.next();
				String stringYear = parser.next();
				int year = Integer.parseInt(stringYear);
				char genre = parser.next().charAt(0);
				bookList.add(new Paperback(iSBN, callNum, available, total, title, authors, year, genre));
			}
		}
	}
	
	public void checkoutBook() {
		System.out.println("Enter ISBN of book:");
		long iSBN = userInput2.nextLong();
		boolean found = false;
		for (Books books : bookList) {
			if (books.getIsbn() == iSBN) {
				int quantity = books.getTotalBooks();
				if (quantity > 0) {
					found = true;
					books.setTotalBooks(quantity - 1);
					System.out.println("The book " + books.getBookTitle() + " has been checked out.\nIt can be located using a call number: " + books.getCallNumber());
				} else {
					System.out.println("There are no more copies of " + books.getBookTitle() + " available to rent.");
				}
			}
			if (!found) {
				System.out.println("There are no books in our entries which match the given ISBN:\n" + iSBN);
			}
		}
	}
	
	public void findBook() {
		System.out.println("Enter title to search for:");
		String title = userInput.next().toLowerCase();
		System.out.println("Matching books:");
		for (Books books : bookList) {
			if (books.getBookTitle().toLowerCase().contains(title)) {
				System.out.println(books);
			}
		}
	}
	
	public void bookByType() {
		System.out.println("#\tType\n1\tChildren's Books\n2\tCookbooks\n3\tPaperbacks\n4\tPeriodicals\n\nEnter type of book:");
		int choice = userInput.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter a format (P for Picture book, E for Early readers, or C for Chapter book):");
			char format = userInput.next().toUpperCase().charAt(0);
			System.out.println("Matching books:");
			ArrayList<ChildrensBook> cbList = new ArrayList<>();

			for (Books b : bookList) {
				if (b instanceof ChildrensBook) {
					cbList.add((ChildrensBook) b);
				}
			}
			for (ChildrensBook cb : cbList) {
				if (cb.getFormat() == format) {
					System.out.println(cb);
				}
			}
			break;
		case 2:
			System.out.println("Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None):");
			char diet = userInput.next().toUpperCase().charAt(0);
			System.out.println("Matching books:");
			ArrayList<Cookbook> cookList = new ArrayList<>();

			for (Books b : bookList) {
				if (b instanceof Cookbook) {
					cookList.add((Cookbook) b);
				}
			}

			for (Cookbook cook : cookList) {
				if (cook.getDiet() == diet) {
					System.out.println(cook);
				}
			}
			break;
		
		case 3:
			System.out.println("Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction):");
			char genre = userInput.next().toUpperCase().charAt(0);
			System.out.println("Matching books:");

			ArrayList<Paperback> pbList = new ArrayList<>();
			for (Books b : bookList){
				if (b instanceof Paperback) {
					pbList.add((Paperback) b);
				}
			}
			for (Paperback pb : pbList) {
				if (pb.getGenre() == genre) {
					System.out.println(pb);
				}
			}
			break;
		case 4:
			System.out.println("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, or Q for Quarterly):");
			char frequency = userInput.next().toUpperCase().charAt(0);
			System.out.println("Matching books:");

			ArrayList<Periodical> pdList = new ArrayList<>();
			for (Books b : bookList) {
				if (b instanceof Periodical) {
					pdList.add((Periodical) b);
				}
			}
			for (Periodical pd : pdList) {
				if (pd.getFrequency() == frequency) {
					System.out.println(pd);
				}
			}
			break;
		}
	}
	
	public void randomBookList() {
		System.out.println("Enter number of books:");
		int numOfBooks = userInput.nextInt();
		System.out.println("Random books:");
		Collections.shuffle(bookList);
		for (int i = 0; i < numOfBooks; i++) {
			System.out.println(bookList.get(i).toString());
		}
	}
	
	public void saveBookList() throws IOException {
		File bookFile = new File("C:\\Users\\User\\Desktop\\CRPG251\\books.txt");
		PrintWriter scribe = new PrintWriter(bookFile);
		for (Books books : bookList) {
			long iSBN = books.getIsbn();
			long bookType = iSBN % 10;
			String callNum = books.getCallNumber();
			int available = books.getAvailableBooks();
			int total = books.getTotalBooks();
			String title = books.getBookTitle();
			if (bookType == 0 || bookType == 1) {
				String authors = ((ChildrensBook) books).getAuthors();
				char format = ((ChildrensBook) books).getFormat();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + authors + ";" + format);
			} else if (bookType == 2 || bookType == 3) {
				String publisher = ((Cookbook) books).getPublisher();
				char diet = ((Cookbook) books).getDiet();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + publisher + ";" + diet);
			} else if (bookType == 8 || bookType == 9) {
				char frequency = ((Periodical) books).getFrequency();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + frequency);
			} else {
				String authors = ((Paperback) books).getAuthors();
				short year = (short) ((Paperback) books).getYear();
				char genre = ((Paperback) books).getGenre();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + authors + ";" + year + ";" + genre);
			}
		}
		scribe.close();
	}
}