package Assignment4tests;

import Assignment4.Chapter;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.verify;

public class ChapterTest {

    @Test
    public void whenChapterInstanceCreatedThenNameIsNotNull(){

        //arrange
        String name = null;
        String number = "2.3.4";

        //act
        Chapter chapter = new Chapter(name,number);

        //assert
        Assert.assertNotEquals("the chapter should not be null",chapter.getName(),null);
    }
}
