package Assignment2Tests;

import Assignment2.BasicStatistic;
import org.junit.Assert;
import org.junit.Test;

public class BasicStatisticTest {

    @Test
    public void whenItemsAddedThenReturnTheSumOfTheItems(){

        //arrange
        BasicStatistic basicStatistic = new BasicStatistic();
        Double item1 = 2.0;
        Double item2 = 3.0;
        Double expected = 5.0;

        //act
        basicStatistic.addDoubleToData(item1);
        basicStatistic.addDoubleToData(item2);
        Double result = basicStatistic.sum();

        //assert
        Assert.assertEquals("the items added do not return the correct sum",expected,result);
    }

    @Test
    public void whenNoItemsAddedThenReturnZero(){

        //arrange
        BasicStatistic basicStatistic = new BasicStatistic();
        Double expected = 0.0;

        //act
        Double result = basicStatistic.sum();

        //assert
        Assert.assertEquals("the sum returned should have equalled 0",expected,result);
    }

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