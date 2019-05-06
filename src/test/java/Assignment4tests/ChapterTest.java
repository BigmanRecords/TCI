package Assignment4tests;

import Assignment4.Chapter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test(expected = IllegalArgumentException.class)
    public void whenChapterNameIsNullThrowIllegalArgumentException(){

        //arrange
        String number = "2.2";

        //act
        Chapter chapter = new Chapter(null,number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenChapterNumberHasTooManyLevelsThenThrowIllegalArgumentException(){

        //arrange
        String name = "name";
        String number = "23.3.3";

        //act
        Chapter chapter = new Chapter(name,number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenChapterNumberIsNullThenThrowIllegalArgumentException(){

        //arrange
        String name = "name";

        //act
        Chapter chapter = new Chapter(name,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenChapterNumberContainsOtherThanNumbersAndFullStopThenThrowIllegalArgumentException(){

        //arrange
        String name = "name";
        String number = "one.2";

        //act
        Chapter chapter = new Chapter(name,number);
    }

    @Test
    public void whenChaptersAreSortedThenChaptersAreInOrderByNumberAndThenName(){

        //arrange
        Chapter chapterTwo = new Chapter("bbbbb", "2");
        Chapter chapterOne = new Chapter("aaaaa", "1");

        List<Chapter> chapters = new ArrayList<>();
        chapters.add(chapterTwo);
        chapters.add(chapterOne);

        //act
        Collections.sort(chapters);

        //assert
        Assert.assertEquals("the list was not sorted correctly",chapterOne,chapters.get(0));
    }
}
