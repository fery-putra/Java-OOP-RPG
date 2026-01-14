import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        // INPUT using Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== RPG Game - Module 1 ===");
        System.out.println("Learn: Class, Method, Input, Output, Data Type, Condition, Switch, Loop\n");

        // INPUT - Get hero information
        System.out.println("=== Create Your Hero ===");
        System.out.print("Enter hero name: ");
        String heroName = scanner.nextLine();

        System.out.print("Enter starting health (50-150): ");
        int heroHealth = scanner.nextInt();

        System.out.print("Enter starting mana (30-100): ");
        int heroMana = scanner.nextInt();

        // Create hero
        Hero hero = new Hero();
        hero.setHeroData(heroName, heroHealth, heroMana);

        // OUTPUT - Display hero info
        hero.displayInfo();

        // Test SWITCH CASE - skill selection
        System.out.println("\n=== Skill Menu ===");
        System.out.println("1. Slash");
        System.out.println("2. Fireball");
        System.out.println("3. Heal");
        System.out.print("Choose a skill (1-3): ");
        int skillChoice = scanner.nextInt();
        hero.useSkill(skillChoice);

        // Test rank promotion with SWITCH
        System.out.print("\nEnter hero level (1-10): ");
        int level = scanner.nextInt();
        hero.promoteRank(level);

        // Test FOR LOOP - practice
        System.out.println("\n=== Training Session ===");
        hero.practice();

        // Test WHILE LOOP - resting
        System.out.println("\n=== Resting ===");
        hero.rest();
        hero.displayInfo();

        // Create monster
        Monster goblin = new Monster();
        goblin.setMonsterData("Goblin", 40, 8);

        System.out.println("\n=== Battle Start ===");
        hero.displayInfo();
        goblin.displayInfo();

        // Battle loop using WHILE and CONDITION
        int round = 1;
        while (hero.isAlive && goblin.isAlive()) {
            System.out.println("\n--- Round " + round + " ---");

            // Hero attacks - using CONDITION
            int heroDamage = hero.attack();
            System.out.println(heroName + " attacks for " + heroDamage + " damage!");
            goblin.takeDamage(heroDamage);

            // Check if monster is defeated - CONDITION
            if (!goblin.isAlive()) {
                System.out.println(goblin.name + " has been defeated!");
                break;
            }

            // Monster attacks
            int monsterDamage = goblin.attack();
            System.out.println(goblin.name + " attacks for " + monsterDamage + " damage!");
            hero.takeDamage(monsterDamage);

            // Check if hero is defeated - CONDITION
            if (!hero.isAlive) {
                System.out.println(heroName + " has been defeated!");
                break;
            }

            // Display status - OUTPUT
            System.out.println(heroName + " HP: " + hero.health + " | Mana: " + hero.mana);
            System.out.println(goblin.name + " HP: " + goblin.health);

            round++;

            // Safety check to prevent infinite loop
            if (round > 20) {
                System.out.println("Battle timeout!");
                break;
            }
        }

        // Battle result using CONDITION
        System.out.println("\n=== Battle End ===");
        if (hero.isAlive) {
            System.out.println("VICTORY! " + heroName + " wins!");
        } else {
            System.out.println("DEFEAT! " + goblin.name + " wins!");
        }

        // Final stats - OUTPUT
        System.out.println("\n=== Final Stats ===");
        hero.displayInfo();

        scanner.close();
    }
}