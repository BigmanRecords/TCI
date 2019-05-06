package Assignment4tests;

import Assignment4.Book;
import org.junit.Test;

public class BookTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNameOrAuthorIsNullThenThrowIllegalArgumentException(){

        Book book = new Book(null,"author");
    }
}
