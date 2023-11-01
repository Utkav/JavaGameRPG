public class Wizard extends Unit{
    protected int mana = 100;
    protected int health = 70;
    protected int power = 25;

//    public Wizard(String name){
//        super(name);
//    }
    protected String name = "W";

    @Override
    public void attack(Unit unit) {
        if (mana >= 10){
            super.attack(unit);
        }
        mana -= 10;
    }

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

    @Override
    public String toString() {
        return "wizard {" +
                "mana = " + mana +
                '}';
    }
}