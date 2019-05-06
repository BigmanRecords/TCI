package Assignment4tests;

import Assignment4.Book;
import Assignment4.Chapter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void whenGetTableOfContentsThenAListWithAllChaptersIsReturned(){

        //arrange
        Chapter ch1 = new Chapter("ch1","1");
        Chapter ch2 = new Chapter("ch2","2");
        Chapter ch3 = new Chapter("ch3","3");
        int expected = 3;

        Book book = new Book("name","author");

        book.addChapter("ch2","2");
        book.addChapter("ch1","1");
        book.addChapter("ch3","3");

        //act
        List<Chapter> chapters = book.getTableOfContents();
        int result = chapters.size();

        //assert
        Assert.assertEquals("not all elements were in the list as expected",expected,result);
    }
}
