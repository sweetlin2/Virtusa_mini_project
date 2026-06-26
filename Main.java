import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library lib = new Library();

        lib.addBook("Book A", "Abel");
        lib.addBook("Book B", "Robert");
        lib.addBook("Book C", "Joel");

        lib.addUser("Rahul");
        lib.addUser("Priya");

        int ch;

        do {
 
            System.out.println("\n1.Show Books");
            System.out.println("2.Add Book");
            System.out.println("3.Show Users");
            System.out.println("4.Add User");
            System.out.println("5.Issue Book");
            System.out.println("6.Return Book");
            System.out.println("7.Search Book");
            System.out.println("8.Show Records");
            System.out.println("0.Exit");

            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    lib.showBooks();
                    break;

                case 2:
                    System.out.print("Title : ");
                    String t = sc.nextLine();

                    System.out.print("Author : ");
                    String a = sc.nextLine();

                    lib.addBook(t, a);
                    break;

                case 3:
                    lib.showUsers();
                    break;

                case 4:
                    System.out.print("Name : ");
                    lib.addUser(sc.nextLine());
                    break;

                case 5:
                    lib.issueBook();
                    break;

                case 6:
                    lib.returnBook();
                    break;

                case 7:
                    lib.searchBook();
                    break;

                case 8:
                    lib.showRecords();
                    break;

                case 0:
                    System.out.println("Thank You");
                    break;
            }

        } while (ch != 0);
    }
}
