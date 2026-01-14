import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== RPG Game - Module 3 ===");
        System.out.println("Learn: Inheritance, Constructor, Overriding, Overloading\n");

        // Test INHERITANCE and CONSTRUCTOR with INPUT
        System.out.println("=== Character Creation ===");
        System.out.println("Choose character type:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Your choice: ");
        int charType = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Character player = null;
        System.out.print("Enter character name: ");
        String playerName = scanner.nextLine();

        switch (charType) {
            case 1:
                System.out.print("Use default armor? (yes/no): ");
                String useDefault = scanner.nextLine();
                if (useDefault.equalsIgnoreCase("yes")) {
                    player = new Warrior(playerName);
                } else {
                    System.out.print("Enter custom armor (10-50): ");
                    int customArmor = scanner.nextInt();
                    player = new Warrior(playerName, customArmor);
                }
                break;
            case 2:
                System.out.print("Use default mana? (yes/no): ");
                String useManaDefault = scanner.nextLine();
                if (useManaDefault.equalsIgnoreCase("yes")) {
                    player = new Mage(playerName);
                } else {
                    System.out.print("Enter custom mana (50-150): ");
                    int customMana = scanner.nextInt();
                    player = new Mage(playerName, customMana);
                }
                break;
            case 3:
                System.out.print("Use default arrows? (yes/no): ");
                String useArrowDefault = scanner.nextLine();
                if (useArrowDefault.equalsIgnoreCase("yes")) {
                    player = new Archer(playerName);
                } else {
                    System.out.print("Enter custom arrows (10-40): ");
                    int customArrows = scanner.nextInt();
                    player = new Archer(playerName, customArrows);
                }
                break;
            default:
                System.out.println("Invalid choice! Creating default Warrior.");
                player = new Warrior(playerName);
        }

        System.out.println("\n=== Your Character ===");
        player.displayInfo();

        // Create enemy with INPUT
        System.out.println("\n=== Create Enemy ===");
        System.out.println("Choose enemy type:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Your choice: ");
        int enemyType = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Character enemy = null;
        System.out.print("Enter enemy name: ");
        String enemyName = scanner.nextLine();

        switch (enemyType) {
            case 1:
                enemy = new Warrior(enemyName);
                break;
            case 2:
                enemy = new Mage(enemyName);
                break;
            case 3:
                enemy = new Archer(enemyName);
                break;
            default:
                enemy = new Warrior(enemyName);
        }

        System.out.println("\n=== Enemy Created ===");
        enemy.displayInfo();

        // Battle simulation with INPUT
        System.out.println("\n=== Battle Start ===");
        System.out.print("Start battle? (yes/no): ");
        String startBattle = scanner.nextLine();

        if (startBattle.equalsIgnoreCase("yes")) {
            int round = 1;
            while (player.isAlive() && enemy.isAlive() && round <= 10) {
                System.out.println("\n--- Round " + round + " ---");
                System.out.println("Your turn!");
                System.out.println("1. Normal Attack");
                System.out.println("2. Special Action");
                System.out.println("3. View Stats");
                System.out.print("Choose action: ");
                int action = scanner.nextInt();

                switch (action) {
                    case 1:
                        player.attack(enemy);
                        break;
                    case 2:
                        // Special actions based on class
                        if (player instanceof Warrior) {
                            ((Warrior)player).shieldBash(enemy);
                        } else if (player instanceof Mage) {
                            System.out.print("Enter mana to restore: ");
                            int manaAmt = scanner.nextInt();
                            ((Mage)player).restoreMana(manaAmt);
                        } else if (player instanceof Archer) {
                            ((Archer)player).aim();
                            System.out.println("Next attack will be critical!");
                        }
                        break;
                    case 3:
                        System.out.println("\n=== Current Stats ===");
                        player.displayInfo();
                        enemy.displayInfo();
                        continue; // Don't let enemy attack
                    default:
                        System.out.println("Invalid action!");
                }

                if (!enemy.isAlive()) {
                    System.out.println("\n" + enemy.getName() + " has been defeated!");
                    break;
                }

                // Enemy attacks
                System.out.println("\nEnemy's turn:");
                enemy.attack(player);

                if (!player.isAlive()) {
                    System.out.println("\n" + player.getName() + " has been defeated!");
                    break;
                }

                round++;
            }

            System.out.println("\n=== Battle End ===");
            if (player.isAlive() && !enemy.isAlive()) {
                System.out.println("✓ VICTORY! " + player.getName() + " wins!");
            } else if (!player.isAlive() && enemy.isAlive()) {
                System.out.println("✗ DEFEAT! " + enemy.getName() + " wins!");
            } else {
                System.out.println("Battle timeout or draw!");
            }
        }

        // Final stats
        System.out.println("\n=== Final Stats ===");
        player.displayInfo();
        enemy.displayInfo();

        scanner.close();
    }
}