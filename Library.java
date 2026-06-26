import java.util.Scanner;

class Library {

    Book[] books = new Book[100];
    String[] users = new String[100];
    int[][] records = new int[100][3];

    int bookCount = 0;
    int userCount = 0; 
    int recordCount = 0;

    Scanner sc = new Scanner(System.in);

    void addBook(String title, String author) {
        books[bookCount] = new Book(bookCount + 1, title, author);
        bookCount++;
        System.out.println("Book Added");
    }

    void addUser(String name) {
        users[userCount++] = name;
        System.out.println("User Added");
    }

    void showBooks() {
        for (int i = 0; i < bookCount; i++)
            books[i].display();
    }

    void showUsers() {
        for (int i = 0; i < userCount; i++)
            System.out.println((i + 1) + " " + users[i]);
    }

    void issueBook() {

        showBooks();
        showUsers();

        System.out.print("Book ID : ");
        int b = sc.nextInt() - 1;

        System.out.print("User ID : ");
        int u = sc.nextInt() - 1;

        if (!books[b].available) {
            System.out.println("Already Issued");
            return;
        }

        books[b].available = false;

        records[recordCount][0] = b;
        records[recordCount][1] = u;
        records[recordCount][2] = -1;

        recordCount++;

        System.out.println("Book Issued");
    }

    void returnBook() {

        System.out.print("Book ID : ");
        int b = sc.nextInt() - 1;

        System.out.print("User ID : ");
        int u = sc.nextInt() - 1;

        for (int i = 0; i < recordCount; i++) {

            if (records[i][0] == b &&
                    records[i][1] == u &&
                    records[i][2] == -1) {

                System.out.print("Days Late : ");
                int d = sc.nextInt();

                books[b].available = true;
                records[i][2] = d;

                System.out.println("Fine = Rs." + (d * 2));

                return;
            }
        }

        System.out.println("Record Not Found");
    }

    void searchBook() {

        sc.nextLine();

        System.out.print("Keyword : ");

        String key = sc.nextLine().toLowerCase();

        for (int i = 0; i < bookCount; i++) {

            if (books[i].title.toLowerCase().contains(key) ||
                    books[i].author.toLowerCase().contains(key))

                books[i].display();
        }
    }

    void showRecords() {

        for (int i = 0; i < recordCount; i++) {

            System.out.println(
                    books[records[i][0]].title + " | " +
                            users[records[i][1]] + " | Fine Rs." +
                            (records[i][2] * 2));
        }
    }
}
