package Assignment4;

public class Book {

    private String author;
    private String name;

    public Book(String name,String author){

        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
}
