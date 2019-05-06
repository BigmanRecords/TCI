package Assignment4;

public class Book {

    private String author;
    private String name;

    public Book(String name,String author){

        if(name == null || author == null){
            throw new IllegalArgumentException("name or author cannot be null");
        }

        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }
}
