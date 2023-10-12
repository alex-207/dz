public class Toy {

    private int id;
    private String name;
    private int odds;
    private int count;

    public Toy(int id, String name, int odds) {
        this.id = id;
        this.name = name;
        this.odds = odds;
        this.count = odds;  // количество = шансу (для заполнения списка)
    }

    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Toy(int id) {
        this.id = id;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public int getOdds() {
        return odds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return odds;
    }

    public void getInfoToy(){
        System.out.println("name=" + this.name);
    }

    @Override
    public String toString() {
        return String.format("id=%d; name=%s; odds=%d%%; remains=%d", this.id, this.name, this.odds, this.odds -= 1);
    }
}
