package Assignment4;

public class Chapter {

    private String name;
    private String number;

    public Chapter(String name, String number){

        setName(name);
        this.number = number;
    }

    public String getName(){
        return this.name;
    }

    public String getNumber(){
        return this.number;
    }

    public void setName(String name){

        if(name != null)
            this.name = name;
        else
            throw new IllegalArgumentException("name cannot be null");
    }
}
