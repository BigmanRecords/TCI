package Assignment4;

import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;

public class Chapter implements Comparable<Chapter> {

    private String name;
    private String number;

    public Chapter(String name, String number){

        setName(name);
        setNumber(number);
    }

    public String getName(){
        return this.name;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String number){

        throwException("number cannot be null",number == null);

        int count = 0;

        for(int i = 0; i < number.length(); i++){

            if(number.charAt(i) == '.') {
                count++;
                throwException("chapter number can only have a maximum of two levels",count > 1);
            }
            else{
                throwException("chapter number can only have a maximum of two levels",!Character.isDigit(number.charAt(i)));
            }
        }

        this.number = number;
    }

    public void setName(String name){

        throwException("name cannot be null",name == null);

        this.name = name;
    }

    public void throwException(String message, Boolean value){

        if(value)
            throw new IllegalArgumentException(message);
    }

    @Override
    public int compareTo(Chapter o) {

        int check = this.number.compareTo(o.getNumber());

        if(check == 0)
            return this.name.compareTo(o.getName());
        else
            return check;
    }

    @Override
    public boolean equals(Object o){

        Chapter temp;

        if(o instanceof Chapter) {
            temp = (Chapter) o;
        }
        else{
            return false;
        }

        return this.name.equals(temp.name) && this.number.equals(temp.number);
    }

    @Override
    public int hashCode(){

        return this.number.hashCode() * this.name.hashCode();
    }
}
