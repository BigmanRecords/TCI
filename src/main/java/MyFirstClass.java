public class MyFirstClass {

    private int number;
    private String name;
    private Long id;
    private int secondnumber;

    public MyFirstClass(int number, String name, Long id, int secondnumber){
        this.number = number;
        this.name = name;
        this.id = id;
        this.secondnumber = secondnumber;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getSecondnumber() {
        return secondnumber;
    }
}
