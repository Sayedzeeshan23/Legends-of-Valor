
class Game {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Legends of Valor: Turn-Based Chronicles!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Choose your class:");
        System.out.println("1. Warrior\n2. Mage\n3. Archer");
        int choice = scanner.nextInt();

        if (choice == 1)
            player = new Warrior(name);
        else if (choice == 2)
            player = new Mage(name);
        else if (choice == 3)
            player = new Archer(name);
        else {
            System.out.println("Invalid choice. Defaulting to Warrior.");
            player = new Warrior(name);
        }

        System.out.println("Choose your enemy:");
        System.out.println("1. Goblin\n2. Dragon");
        int enemyChoice = scanner.nextInt();
        Enemy enemy = (enemyChoice == 2) ? new Dragon() : new Goblin();

        Battle battle = new Battle(player, enemy);
        battle.start();
    }
}
