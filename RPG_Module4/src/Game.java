import java.util.Scanner;

class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== RPG Game - Module 4 ===");
        System.out.println("Learn: Final, Enum, Abstract, Interface, Polymorphism, Casting\n");

        // Show all character classes (ENUM)
        System.out.println("=== Available Character Classes ===");
        int idx = 1;
        for (CharacterClass cc : CharacterClass.values()) {
            System.out.println(idx + ". " + cc + " - " + cc.getDescription() +
                    " (DMG: " + cc.getBaseDamage() + ", HP: " + cc.getBaseHealth() + ")");
            idx++;
        }

        // Create player character with INPUT
        System.out.print("\nChoose your class (1-4): ");
        int classChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine();

        Combatant player = createCharacter(classChoice, playerName);
        System.out.println("\n✓ Character created!");
        player.displayStats(); // FINAL method

        // Create enemy with INPUT
        System.out.println("\n=== Create Enemy ===");
        System.out.print("Choose enemy class (1-4): ");
        int enemyClass = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter enemy name: ");
        String enemyName = scanner.nextLine();

        Combatant enemy = createCharacter(enemyClass, enemyName);
        System.out.println("\n✓ Enemy created!");
        enemy.displayInfo();

        // Demonstrate POLYMORPHISM
        System.out.println("\n=== Polymorphism Demo ===");
        Combatant[] combatants = {player, enemy};
        System.out.println("Both stored in Combatant array:");
        for (Combatant c : combatants) {
            System.out.println("- " + c.getName() + " (" + c.getCharacterClass() + ")");
        }

        // Show element options (ENUM)
        System.out.println("\n=== Element Types ===");
        idx = 1;
        for (Element e : Element.values()) {
            System.out.println(idx + ". " + e + " - " + e.getEffect() +
                    " (x" + e.getDamageMultiplier() + ")");
            idx++;
        }

        // Battle system with INPUT
        System.out.print("\nStart battle? (yes/no): ");
        String startBattle = scanner.nextLine();

        if (startBattle.equalsIgnoreCase("yes")) {
            GameMaster gm = new GameMaster();
            gm.startBattle(player, enemy);

            int round = 1;
            while (player.isAlive() && enemy.isAlive() && round <= 10) {
                System.out.println("\n━━━ Round " + round + " ━━━");

                // Player turn with POLYMORPHISM and CASTING
                playerTurn(player, enemy, gm);

                if (!enemy.isAlive()) {
                    System.out.println("\n🏆 " + enemy.getName() + " defeated!");
                    break;
                }

                // Enemy turn (simple AI)
                System.out.println("\n--- Enemy Turn ---");
                enemyTurn(enemy, player, gm);

                if (!player.isAlive()) {
                    System.out.println("\n💀 " + player.getName() + " defeated!");
                    break;
                }

                // Show status
                System.out.println("\n--- Status ---");
                player.displayInfo();
                enemy.displayInfo();

                round++;
            }

            // Battle results
            System.out.println("\n╔════════════════════════════════╗");
            if (player.isAlive() && !enemy.isAlive()) {
                System.out.println("║         VICTORY!               ║");
            } else if (!player.isAlive() && enemy.isAlive()) {
                System.out.println("║         DEFEAT!                ║");
            } else {
                System.out.println("║         DRAW!                  ║");
            }
            System.out.println("╚════════════════════════════════╝");
        }

        // Final stats
        System.out.println("\n=== Final Stats ===");
        player.displayStats();
        enemy.displayStats();

        // Demonstrate UPCASTING and DOWNCASTING
        System.out.println("\n=== Casting Demonstration ===");
        demonstrateCasting(player);

        scanner.close();
    }

    // Helper method to create character based on choice
    private static Combatant createCharacter(int choice, String name) {
        switch (choice) {
            case 1: return new Warrior(name);
            case 2: return new Mage(name);
            case 3: return new Archer(name);
            case 4: return new Paladin(name);
            default:
                System.out.println("Invalid choice! Creating Warrior.");
                return new Warrior(name);
        }
    }

    // Player turn with INPUT and POLYMORPHISM
    private static void playerTurn(Combatant player, Combatant enemy, GameMaster gm) {
        System.out.println("\n--- Your Turn ---");
        System.out.println("1. Basic Attack");
        System.out.println("2. Special Action");
        System.out.println("3. View Stats");
        System.out.print("Choose action: ");
        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 1:
                gm.executeTurn(player, enemy);
                break;

            case 2:
                // DOWNCASTING to access specific methods
                if (player instanceof Magical) {
                    System.out.println("\nChoose element:");
                    System.out.println("1. FIRE  2. ICE  3. LIGHTNING  4. HOLY");
                    System.out.print("Choice: ");
                    int elemChoice = scanner.nextInt();
                    scanner.nextLine();

                    Element elem = getElement(elemChoice);
                    Magical mage = (Magical) player; // DOWNCASTING
                    gm.castMagicSpell(mage, enemy, elem);

                } else if (player instanceof Defensive) {
                    Defensive def = (Defensive) player; // DOWNCASTING
                    gm.activateDefense(def);

                } else {
                    System.out.println("No special action available!");
                    gm.executeTurn(player, enemy);
                }
                break;

            case 3:
                player.displayStats();
                enemy.displayStats();
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
                break;

            default:
                System.out.println("Invalid action!");
        }
    }

    // Simple enemy AI
    private static void enemyTurn(Combatant enemy, Combatant player, GameMaster gm) {
        // 50% chance to use special if available
        if (Math.random() < 0.5) {
            if (enemy instanceof Magical) {
                Magical mage = (Magical) enemy;
                Element elem = Element.values()[(int)(Math.random() * 4)];
                gm.castMagicSpell(mage, player, elem);
                return;
            } else if (enemy instanceof Defensive) {
                Defensive def = (Defensive) enemy;
                gm.activateDefense(def);
                return;
            }
        }

        // Default: basic attack
        gm.executeTurn(enemy, player);
    }

    // Get element from choice
    private static Element getElement(int choice) {
        switch (choice) {
            case 1: return Element.FIRE;
            case 2: return Element.ICE;
            case 3: return Element.LIGHTNING;
            case 4: return Element.HOLY;
            default: return Element.NONE;
        }
    }

    // Demonstrate UPCASTING and DOWNCASTING
    private static void demonstrateCasting(Combatant character) {
        System.out.println("Original type: " + character.getClass().getSimpleName());

        // UPCASTING (automatic)
        Combatant upcasted = character;
        System.out.println("After upcasting to Combatant: " + upcasted.getClass().getSimpleName());

        // DOWNCASTING with instanceof check
        if (character instanceof Warrior) {
            Warrior w = (Warrior) character;
            System.out.println("✓ Successfully downcast to Warrior");
            System.out.println("  Armor: " + w.getArmor());
        } else if (character instanceof Mage) {
            Mage m = (Mage) character;
            System.out.println("✓ Successfully downcast to Mage");
            System.out.println("  Mana: " + m.getMana());
        } else if (character instanceof Paladin) {
            Paladin p = (Paladin) character;
            System.out.println("✓ Successfully downcast to Paladin");
            System.out.println("  Mana: " + p.getMana() + ", Armor: " + p.getArmor());
        } else if (character instanceof Archer) {
            System.out.println("✓ Successfully downcast to Archer");
        }
    }
}