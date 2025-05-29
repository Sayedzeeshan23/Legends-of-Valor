abstract class Enemy {
    protected String name;
    protected int health;
    protected int attack;

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage. Health: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Player player) {
        System.out.println(name + " attacks!");
        player.takeDamage(attack);
    }

    public String getName() {
        return name;
    }
}