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

        if(author == null || author.equals("")){
            throw new IllegalArgumentException("author cannot be null");
        }

        this.author = author;
    }

    public void setName(String name) {

        if(name == null || name.equals("")){
            throw new IllegalArgumentException("name cannot be null");
        }

        this.name = name;
    }


    public void addChapter(String name,String number){

    }
}
