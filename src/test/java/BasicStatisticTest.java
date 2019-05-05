import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStatisticTest {

    @Test
    public void addDoubleToData() {
    }

    @Test
    public void clearData() {
    }

    @Test
    public void numberOfDataItems() {
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

    @Test
    public void sum() {
    }
}