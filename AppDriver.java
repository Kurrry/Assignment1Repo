import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args) throws Exception {
		Scanner userInputer = new Scanner(System.in);
		LibraryUser lu1 = new LibraryUser();
		lu1.loadDoc();
		lu1.loadMenu();
		int userInput = userInputer.nextInt();
		while (userInput != 5) {
			switch (userInput) {
				case 1:
					lu1.checkoutBook();
					break;
				case 2:
					lu1.findBook();
					break;
				case 3:
					lu1.bookByType();
					break;
				case 4:
					lu1.randomBookList();
					break;
			}
			lu1.loadMenu();
			userInput = userInputer.nextInt();
		}
		if (userInput == 5) {
			lu1.saveBookList();
			userInputer.close();
			System.out.println("Have a great rest of your day!");
			System.exit(0);
		}
	}

}
