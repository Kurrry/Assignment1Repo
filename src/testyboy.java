import java.util.Scanner;

public class testyboy {
    public static void main(String[] args) throws Exception {

        LibraryUser newUser = new LibraryUser();

        newUser.loadDoc();
        newUser.loadMenu();
        Scanner input = new Scanner(System.in);
        short userChoice = input.nextShort();

        switch (userChoice) {
            case 1:

        }


    }
}
