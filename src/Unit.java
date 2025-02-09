public class Unit {
//    private final String name;
    protected int health = 100;
    protected int defence = 100;
    protected int power = 10;

    protected String name = "";
    protected float ParryChance = 0.1f;

//    public Unit(){
//        this.name = "";
//    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int Health){
        this.health = health;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getParryChance() {
        return ParryChance;
    }

    public void setParryChance(float parryChance) {
        ParryChance = parryChance;
    }

    public void attack(Unit unit){
        unit.getdamage(power);
    }
    public void getdamage(int damage){
        this.health-=damage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "unit{" +
                "Health = " + health +
                ", defence = " + defence +
                ", power = " + power +
                '}';
    }


//    public void print(){
//        System.out.println(this);
//
//    }
//    public void print(String str){
//        System.out.println(str + " " + this);
//    }

}