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

        // Test SWITCH CASE - skill selection with INPUT
        System.out.println("\n=== Skill Menu ===");
        System.out.println("1. Slash");
        System.out.println("2. Fireball");
        System.out.println("3. Heal");
        System.out.print("Choose a skill (1-3): ");
        int skillChoice = scanner.nextInt();
        hero.useSkill(skillChoice);

        // Test rank promotion with SWITCH and INPUT
        System.out.print("\nEnter hero level (1-10): ");
        int level = scanner.nextInt();
        hero.promoteRank(level);

        // Test WHILE LOOP - practice with INPUT
        System.out.print("\nHow many times to practice? (1-10): ");
        int practiceTimes = scanner.nextInt();
        hero.practice(practiceTimes);

        // Test FOR LOOP - resting
        System.out.print("\nDo you want to rest? (yes/no): ");
        scanner.nextLine(); // Clear buffer
        String restChoice = scanner.nextLine();
        if (restChoice.equalsIgnoreCase("yes")) {
            hero.rest();
        }

        hero.displayInfo();

        // Create monster with INPUT
        System.out.println("\n=== Create Monster ===");
        System.out.print("Enter monster name: ");
        String monsterName = scanner.nextLine();

        System.out.print("Enter monster health (20-60): ");
        int monsterHealth = scanner.nextInt();

        System.out.print("Enter monster damage (5-15): ");
        int monsterDamage = scanner.nextInt();

        Monster monster = new Monster();
        monster.setMonsterData(monsterName, monsterHealth, monsterDamage);

        System.out.println("\n=== Battle Start ===");
        hero.displayInfo();
        monster.displayInfo();

        // Battle loop using WHILE and CONDITION with INPUT
        System.out.print("\nStart battle? (yes/no): ");
        scanner.nextLine(); // Clear buffer
        String battleChoice = scanner.nextLine();

        if (battleChoice.equalsIgnoreCase("yes")) {
            int round = 1;
            while (hero.isAlive && monster.isAlive()) {
                System.out.println("\n--- Round " + round + " ---");
                System.out.println("1. Attack");
                System.out.println("2. Use Skill");
                System.out.println("3. Rest");
                System.out.print("Choose action: ");
                int action = scanner.nextInt();

                // SWITCH for action selection
                int heroDamage = 0;
                switch (action) {
                    case 1:
                        heroDamage = hero.attack();
                        break;
                    case 2:
                        System.out.print("Choose skill (1-3): ");
                        int skill = scanner.nextInt();
                        hero.useSkill(skill);
                        heroDamage = 15; // Base damage for skill
                        break;
                    case 3:
                        hero.rest();
                        break;
                    default:
                        System.out.println("Invalid action! Turn skipped.");
                        break;
                }

                if (action != 3 && heroDamage > 0) {
                    System.out.println(heroName + " deals " + heroDamage + " damage!");
                    monster.takeDamage(heroDamage);
                }

                // Check if monster is defeated - CONDITION
                if (!monster.isAlive()) {
                    System.out.println(monster.name + " has been defeated!");
                    break;
                }

                // Monster attacks
                int monsterDmg = monster.attack();
                System.out.println(monster.name + " attacks for " + monsterDmg + " damage!");
                hero.takeDamage(monsterDmg);

                // Check if hero is defeated - CONDITION
                if (!hero.isAlive) {
                    System.out.println(heroName + " has been defeated!");
                    break;
                }

                // Display status - OUTPUT
                System.out.println(heroName + " HP: " + hero.health + " | Mana: " + hero.mana);
                System.out.println(monster.name + " HP: " + monster.health);

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
                System.out.println("DEFEAT! " + monster.name + " wins!");
            }
        }

        // Final stats - OUTPUT
        System.out.println("\n=== Final Stats ===");
        hero.displayInfo();

        scanner.close();
    }
}