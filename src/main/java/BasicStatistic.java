import java.util.ArrayList;
import java.util.List;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    private List<Double> dataItems;

    public BasicStatistic(){

        this.dataItems = new ArrayList<>();
    }

    @Override
    public void addDoubleToData(Double valueToAdd){

        this.dataItems.add(valueToAdd);
    }

    @Override
    public void clearData(){

        this.dataItems.clear();
    }

    @Override
    public int numberOfDataItems(){

        return this.dataItems.size();
    }

    @Override
    public Double sum(){

        double result = 0.0;

        for (Double d:dataItems) {

            result += d;
        }

        return result;
    }

}
