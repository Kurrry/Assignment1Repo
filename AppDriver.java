import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args) throws Exception {
		Scanner userInputer = new Scanner(System.in);
		LibraryUser lu1 = new LibraryUser();
		lu1.loadDoc();
		lu1.loadMenu();
		userInputer.close();
		System.out.println("Have a great rest of your day!");
		System.exit(0);
		}
	}

}
