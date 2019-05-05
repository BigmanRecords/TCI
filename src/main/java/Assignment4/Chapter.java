package Assignment4;

public class Chapter {

    private String name;
    private String number;

    public Chapter(String name, String number){

        if(name == null)
            throw new IllegalArgumentException("name cannot be null");
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return this.name;
    }

    public String getNumber(){
        return this.number;
    }
}
