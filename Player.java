abstract class Player implements CombatActions {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;

    public Player(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        health -= actualDamage;
        System.out.println(name + " takes " + actualDamage + " damage. Health: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}