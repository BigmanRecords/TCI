package Assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    private String author;
    private String name;
    private List<Chapter> chapters = new ArrayList<>();

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

        chapters.add(new Chapter(name,number));
    }

    public List<Chapter> getTableOfContents(){
        return Collections.emptyList();
    }
}
