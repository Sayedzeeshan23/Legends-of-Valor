class Archer extends Player {
    public Archer(String name) {
        super(name);
        this.health = 90;
        this.attack = 18;
        this.defense = 6; // lowered from 7
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " shoots an arrow!");
        enemy.takeDamage(attack);
    }

    public void defend() {
        System.out.println(name + " swiftly dodges!");
        defense += 6;
    }

    public void heal() {
        System.out.println(name + " applies first-aid.");
        health += 10;
    }

    public void specialMove(Enemy enemy) {
        System.out.println(name + " fires Rapid Shot!");
        enemy.takeDamage(attack + 12);
    }
}
