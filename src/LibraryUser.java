package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibraryUser {
	Scanner userInput = new Scanner(System.in);
	ArrayList<Books> bookList = new ArrayList<Books>();
	
	public LibraryUser() {
	}
	
	public void loadMenu() {
		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1\tCheckout Book");
		System.out.println("2\tFind Books by Title");
		System.out.println("3\tDisplay Books by Type");
		System.out.println("4\tProduce Random Book List");
		System.out.println("5\tSave and Exit");
		System.out.println("\nEnter option");
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
				String stringFormat = parser.nextLine();
				char format = stringFormat.charAt(0);
				Books book = new ChildrensBook(iSBN, callNum, available, total, title, authors, format);
				bookList.add(book);
			}
			else if (bookType == 2 || bookType == 3) {
				String publisher = parser.nextLine();
				String stringDiet = parser.nextLine();
				char diet = stringDiet.charAt(0);
				Books book = new Cookbook(iSBN, callNum, available, total, title, publisher, diet);
				bookList.add(book);
			}
			else if (bookType == 8 || bookType == 9) {
				String stringFrequency = parser.nextLine();
				char frequency = stringFrequency.charAt(0);
				Books book = new Periodical(iSBN, callNum, available, total, title, frequency);
				bookList.add(book);
			}
			else {
				String authors = parser.nextLine();
				String stringYear = parser.nextLine();
				short year = Short.parseShort(stringYear);
				String stringGenre = parser.nextLine();
				char genre = stringGenre.charAt(0);
				Books book = new Paperback(iSBN, callNum, available, total, title, authors, year, genre);
				bookList.add(book);
			}
			parser.close();
		}
		reader.close();
	}
	
	public void checkoutBook() {
		System.out.println("Enter ISBN of book:");
		long iSBN = Long.parseLong(userInput.nextLine());
		boolean found = false;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getIsbn() == iSBN) {
				int quantity = bookList.get(i).getAvailableBooks();
				if (quantity > 0) {
					found = true;
					bookList.get(i).setTotalBooks(quantity - 1);
					System.out.println("The book " + bookList.get(i).getBookTitle() + " has been checked out.\nIt can be located using a call number: " + bookList.get(i).getCallNumber());
				}
				else {
					System.out.println("There are no more copies of " + bookList.get(i).getBookTitle() + " available to rent.");
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
			if (bookList.get(i).getBookTitle().toLowerCase().contains(title)) {
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
			String stringFormat = userInput.nextLine().toLowerCase();
			char format = stringFormat.charAt(0);
			format = Character.toUpperCase(format);
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (((ChildrensBook)bookList.get(i)).getFormat() == format) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		case 2:
			System.out.println("Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None):");
			String stringDiet = userInput.nextLine().toLowerCase();
			char diet = stringDiet.charAt(0);
			diet = Character.toUpperCase(diet);
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (((Cookbook)bookList.get(i)).getDiet() == diet) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		
		case 3:
			System.out.println("Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction):");
			String stringGenre = userInput.nextLine().toLowerCase();
			char genre = stringGenre.charAt(0);
			genre = Character.toUpperCase(genre);
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (((Paperback)bookList.get(i)).getGenre() == genre) {
					System.out.println(bookList.get(i).toString());
				}
			}
			break;
		case 4:
			System.out.println("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, or Q for Quarterly):");
			String stringFrequency = userInput.nextLine().toLowerCase();
			char frequency = stringFrequency.charAt(0);
			frequency = Character.toUpperCase(frequency);
			System.out.println("Matching books:");
			for (int i = 0; i < bookList.size(); i++) {
				if (((Periodical)bookList.get(i)).getFrequency() == frequency) {
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
			String callNum = bookList.get(i).getCallNumber();
			int available = bookList.get(i).getAvailableBooks();
			int total = bookList.get(i).getTotalBooks();
			String title = bookList.get(i).getBookTitle();
			if (bookType == 0 || bookType == 1) {
				String authors = ((ChildrensBook)bookList.get(i)).getAuthors();
				char format = ((ChildrensBook)bookList.get(i)).getFormat();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + authors + ";" + format);
			}
			else if (bookType == 2 || bookType == 3) {
				String publisher = ((Cookbook)bookList.get(i)).getPublisher();
				char diet = ((Cookbook)bookList.get(i)).getDiet();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + publisher + ";" + diet);
			}
			else if (bookType == 8 || bookType == 9) {
				char frequency = ((Periodical)bookList.get(i)).getFrequency();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + frequency);
			}
			else {
				String authors = ((Paperback)bookList.get(i)).getAuthors();
				short year = ((Paperback)bookList.get(i)).getYear();
				char genre = ((Paperback)bookList.get(i)).getGenre();
				scribe.println(iSBN + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + authors + ";" + year + ";" + genre);
			}
		}
		scribe.close();
	}
}
