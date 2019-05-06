package Assignment4;

public class Book {

    private String author;
    private String name;

    public Book(String name,String author){

        setAuthor(author);
        setName(name);
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {

        if(author == null){
            throw new IllegalArgumentException("author cannot be null");
        }

        this.author = author;
    }

    public void setName(String name) {

        if(name == null){
            throw new IllegalArgumentException("name cannot be null");
        }

        this.name = name;
    }
}
