package Assignment4tests;

import Assignment4.Book;
import org.junit.Test;

public class BookTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNameOrAuthorIsNullThenThrowIllegalArgumentException(){

        Book book = new Book(null,"author");
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenNameOrAuthorIsEmptyStringThenThrowIllegalArgumentException(){

        Book book = new Book("name","");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidNameOrNumberOfChapterThenThrowIllegalArgumentException(){

        Book book = new Book("name","author");

        book.addChapter("name","2.2.2");
    }
}
