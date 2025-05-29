class Battle {
    private Player player;
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void start() {
        System.out.println("\nA wild " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nChoose your action:");
            System.out.println("1. Attack\n2. Defend\n3. Heal\n4. Special Move");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> player.attack(enemy);
                case 2 -> player.defend();
                case 3 -> player.heal();
                case 4 -> player.specialMove(enemy);
                default -> System.out.println("Invalid choice!");
            }

            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            System.out.println("\nYou defeated the " + enemy.getName() + "!");
        } else {
            System.out.println("\nYou were defeated. Game Over.");
        }
    }
}