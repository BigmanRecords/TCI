package Assignment4tests;

import Assignment4.Chapter;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.verify;

public class ChapterTest {

    @Test
    public void whenChapterInstanceCreatedThenNameIsNotNull(){

        //arrange
        String name = "name";
        String number = "2.2";
        Chapter chapter = new Chapter(name,number);

        //act
        String result = chapter.getName();

        //assert
        Assert.assertNotEquals("the chapter name cannot be null",result,null);
    }
}
