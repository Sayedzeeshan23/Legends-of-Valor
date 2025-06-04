class Mage extends Player {
    public Mage(String name) {
        super(name);
        this.health = 80;
        this.attack = 20;
        this.defense = 4; // lowered from 5
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " casts magic bolt!");
        enemy.takeDamage(attack);
    }

    public void defend() {
        System.out.println(name + " casts shield spell!");
        defense += 4;
    }

    public void heal() {
        System.out.println(name + " casts healing light.");
        health += 20;
    }

    public void specialMove(Enemy enemy) {
        System.out.println(name + " casts Fireball!");
        enemy.takeDamage(attack + 15);
    }
}