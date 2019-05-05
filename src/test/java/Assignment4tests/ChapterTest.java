package Assignment4tests;

import Assignment4.Chapter;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.verify;

public class ChapterTest {

    @Test
    public void whenChapterInstanceCreatedThenNameIsNotNull(){

        //arrange
        Chapter chapter = new Chapter();

        //act
        String name = chapter.getName();

        //assert
        Assert.assertNotEquals("the chapter name cannot be null",name,null);
    }
}
