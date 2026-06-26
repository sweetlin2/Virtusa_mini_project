class Book {

    int id;
    String title;
    String author;
    boolean available; 

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        available = true;
    }

    void display() {
        System.out.println(id + " " + title + " " + author + " " +
                (available ? "Available" : "Issued"));
    }
}
