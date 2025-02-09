public class Knight extends Unit {
    protected int power = 20;
    protected String name = "K";

    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }
    public void getdamage(int damage){
        this.health-=damage;
    }

    @Override
    public int getHealth() {
        return health;
    }
}
