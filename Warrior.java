class Warrior extends Player {
    public Warrior(String name) {
        super(name);
        this.health = 100;
        this.attack = 15;
        this.defense = 7; // lowered from 10
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " swings a sword!");
        enemy.takeDamage(attack);
    }

    public void defend() {
        System.out.println(name + " raises shield!");
        defense += 5;
    }

    public void heal() {
        System.out.println(name + " drinks health potion.");
        health += 15;
    }

    public void specialMove(Enemy enemy) {
        System.out.println(name + " uses Power Slash!");
        enemy.takeDamage(attack + 10);
    }
}