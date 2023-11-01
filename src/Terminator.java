public class Terminator extends Unit{

    protected int health = 150;
    protected String name = "T";

    public String getName() {
        return name;
    }

    public void getdamage(int damage){
        this.health-=damage;
    }

    @Override
    public int getHealth() {
        return health;
    }
}
