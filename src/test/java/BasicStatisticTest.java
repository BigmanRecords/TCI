import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStatisticTest {

    @Test
    public void afterAddingXDataItemsThenXAmountOfDataItemsInList(){

        //arrange
        BasicStatistic basicStatistic = new BasicStatistic();
        int initial = basicStatistic.numberOfDataItems();
        int expected = 2;

        //act
        basicStatistic.addDoubleToData(2.0);
        basicStatistic.addDoubleToData(3.0);
        int after = basicStatistic.numberOfDataItems();
        int result = after - initial;

        //assert
        Assert.assertEquals("the wrong amount of data items returned",expected,result);
    }

    @Test
    public void afterClearDataThenTheNumberOfItemsIsZero(){

        //arrange
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(2.0);
        int expected = 0;

        //act
        basicStatistic.clearData();
        int result = basicStatistic.numberOfDataItems();

        //assert
        Assert.assertEquals("after clear data still items in list",expected,result);
    }

    @Test
    public void afterAddingDoubleThenNumberOfItemsIsNotZero(){

        //arrange
        BasicStatistic basicStatistic = new BasicStatistic();
        int notExpected = 0;
        double added = 2;
        basicStatistic.addDoubleToData(added);

        //act
        int result = basicStatistic.numberOfDataItems();

        //assert
        Assert.assertNotEquals("the number of items was zero after adding",notExpected,result);
    }

    @Test
    public void whenNoDataItemsPresentThenTheNumberOfDataItemsIsZero(){

        //arrange
        BasicStatistic basicStatistic = new BasicStatistic();
        int expected = 0;

        //act
        int result = basicStatistic.numberOfDataItems();

        //assert
        Assert.assertEquals("no data items should be present yet",expected,result);
    }

}