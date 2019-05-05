package Assignment4;

public class Chapter {

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
}
