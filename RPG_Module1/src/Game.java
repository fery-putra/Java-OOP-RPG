// ============================================================================
// MODULE 1: Main Game Class - Demonstrates INPUT, OUTPUT, and program flow
// ============================================================================

import java.util.Scanner;  // MUST import Scanner to get user INPUT

/**
 * Game class - The MAIN class that runs the program
 *
 * This class ties everything together by:
 * 1. Getting INPUT from the user (Scanner)
 * 2. Creating objects (Hero, Monster)
 * 3. Using methods from those objects
 * 4. Showing OUTPUT to the user
 * 5. Controlling game flow with loops and conditions
 */
class Game {

    /**
     * main method - The STARTING POINT of every Java program
     *
     * When you run "java Game", Java automatically calls this main method.
     * It MUST be: public static void main(String[] args)
     */
    public static void main(String[] args) {

        // ====================================================================
        // SCANNER - Used for getting INPUT from the user (Module 1 concept)
        // ====================================================================
        // System.in = standard input (keyboard)
        Scanner scanner = new Scanner(System.in);

        // ====================================================================
        // OUTPUT - Displaying information to the user
        // ====================================================================
        System.out.println("=== RPG Game - Module 1 ===");
        System.out.println("Learn: Class, Method, Input, Output, Data Type, Condition, Switch, Loop\n");

        // ====================================================================
        // INPUT DEMONSTRATION - Getting data from the user (Module 1 concept)
        // ====================================================================
        System.out.println("=== Create Your Hero ===");

        // INPUT: Get String from user
        System.out.print("Enter hero name: ");
        String heroName = scanner.nextLine();  // nextLine() reads entire line as String

        // INPUT: Get int from user
        System.out.print("Enter starting health (50-150): ");
        int heroHealth = scanner.nextInt();    // nextInt() reads integer

        // INPUT: Get another int
        System.out.print("Enter starting mana (30-100): ");
        int heroMana = scanner.nextInt();      // Reads integer for mana

        // ====================================================================
        // OBJECT CREATION - Creating an instance of the Hero class
        // ====================================================================
        // 'new Hero()' creates a new Hero object in memory
        // 'hero' is a variable that references (points to) that object
        Hero hero = new Hero();

        // Call method to initialize hero with user input
        hero.setHeroData(heroName, heroHealth, heroMana);

        // ====================================================================
        // OUTPUT - Display hero information
        // ====================================================================
        hero.displayInfo();  // Calls the displayInfo() method from Hero class

        // ====================================================================
        // SWITCH CASE demonstration with user INPUT
        // ====================================================================
        System.out.println("\n=== Skill Menu ===");
        System.out.println("1. Slash");      // Display menu options
        System.out.println("2. Fireball");
        System.out.println("3. Heal");
        System.out.print("Choose a skill (1-3): ");

        int skillChoice = scanner.nextInt();  // Get user choice (INPUT)
        hero.useSkill(skillChoice);           // Method uses SWITCH to handle choice

        // ====================================================================
        // Another SWITCH example - rank promotion
        // ====================================================================
        System.out.print("\nEnter hero level (1-10): ");
        int level = scanner.nextInt();
        hero.promoteRank(level);  // Uses SWITCH with fall-through

        // ====================================================================
        // WHILE LOOP demonstration - practice attacks
        // ====================================================================
        System.out.print("\nHow many times to practice? (1-10): ");
        int practiceTimes = scanner.nextInt();
        hero.practice(practiceTimes);  // Method uses WHILE loop

        // ====================================================================
        // FOR LOOP demonstration - resting
        // ====================================================================
        System.out.print("\nDo you want to rest? (yes/no): ");

        // ============================================================
        // SCANNER BUFFER CLEARING (Very Common Beginner Issue!)
        // ============================================================
        // Problem: nextInt() reads the NUMBER but leaves the ENTER key (\n) in the buffer!
        //
        // What happens WITHOUT this line:
        //   User types: 5[ENTER]
        //   nextInt() reads: 5
        //   Buffer still has: \n (the ENTER key leftover)
        //   Next nextLine() immediately reads that \n as empty string ""
        //   Result: Program skips asking for input!
        //
        // Solution: Call nextLine() ONCE to consume that leftover \n
        //
        // Visual flow:
        //   User input:  5[ENTER]           → "5\n"
        //   nextInt():   reads 5            → buffer has "\n"
        //   nextLine():  reads "\n"         → buffer now empty ✓
        //   nextLine():  waits for input    → now works correctly!
        //
        // Without the clearing line:
        //   User input:  5[ENTER]           → "5\n"
        //   nextInt():   reads 5            → buffer has "\n"
        //   nextLine():  reads "\n" as ""   → restChoice becomes empty! ✗
        //
        // Remember: nextInt(), nextDouble() leave \n in buffer
        //           nextLine() consumes everything including \n
        // ============================================================
        scanner.nextLine();  // Consume the leftover newline from nextInt()

        String restChoice = scanner.nextLine();  // NOW this will work correctly!

        // CONDITION: Check user's choice
        if (restChoice.equalsIgnoreCase("yes")) {  // equalsIgnoreCase ignores case (YES, yes, Yes all work)
            hero.rest();  // Method uses FOR loop
        }

        // Display updated hero stats after practice and rest
        hero.displayInfo();

        // ====================================================================
        // Create SECOND object - Monster (demonstrates multiple objects)
        // ====================================================================
        System.out.println("\n=== Create Monster ===");

        // INPUT: Get monster data from user
        System.out.print("Enter monster name: ");
        String monsterName = scanner.nextLine();

        System.out.print("Enter monster health (20-60): ");
        int monsterHealth = scanner.nextInt();

        System.out.print("Enter monster damage (5-15): ");
        int monsterDamage = scanner.nextInt();

        // Create Monster object (different class than Hero!)
        Monster monster = new Monster();
        monster.setMonsterData(monsterName, monsterHealth, monsterDamage);

        // ====================================================================
        // Display both objects' information before battle
        // ====================================================================
        System.out.println("\n=== Battle Start ===");
        hero.displayInfo();     // Hero's displayInfo()
        monster.displayInfo();  // Monster's displayInfo()

        // ====================================================================
        // BATTLE SYSTEM - Combines WHILE loop, SWITCH, CONDITION, INPUT
        // This is where all Module 1 concepts come together!
        // ====================================================================
        System.out.print("\nStart battle? (yes/no): ");
        scanner.nextLine();  // Clear buffer
        String battleChoice = scanner.nextLine();

        // CONDITION: Only start battle if user says yes
        if (battleChoice.equalsIgnoreCase("yes")) {

            int round = 1;  // Track which round we're on

            // ================================================================
            // WHILE LOOP: Battle continues while BOTH are alive
            // ================================================================
            // This demonstrates complex condition: two things must be true
            while (hero.isAlive && monster.isAlive()) {

                // Display round number
                System.out.println("\n--- Round " + round + " ---");

                // Show action menu
                System.out.println("1. Attack");
                System.out.println("2. Use Skill");
                System.out.println("3. Rest");
                System.out.print("Choose action: ");
                int action = scanner.nextInt();  // INPUT: Get player choice

                // ============================================================
                // SWITCH: Handle different actions
                // ============================================================
                int heroDamage = 0;  // Track damage dealt this turn

                switch (action) {
                    case 1:  // Attack
                        heroDamage = hero.attack();  // Method returns damage value
                        break;

                    case 2:  // Use Skill
                        System.out.print("Choose skill (1-3): ");
                        int skill = scanner.nextInt();  // Nested INPUT!
                        hero.useSkill(skill);           // Nested SWITCH inside this method!
                        heroDamage = 15;                // Base damage for skill
                        break;

                    case 3:  // Rest
                        hero.rest();  // FOR loop inside this method!
                        break;

                    default:  // Invalid choice
                        System.out.println("Invalid action! Turn skipped.");
                        break;
                }

                // ========================================================
                // Apply damage if hero attacked (not if rested)
                // ========================================================
                // CONDITION: action != 3 means "not resting"
                // && means AND (both conditions must be true)
                if (action != 3 && heroDamage > 0) {
                    System.out.println(heroName + " deals " + heroDamage + " damage!");
                    monster.takeDamage(heroDamage);  // Apply damage to monster
                }

                // ========================================================
                // CONDITION: Check if monster died
                // ========================================================
                // ! means NOT (if monster is NOT alive)
                if (!monster.isAlive()) {
                    System.out.println(monster.name + " has been defeated!");
                    break;  // Exit the while loop - battle over!
                }

                // ========================================================
                // Monster's turn to attack
                // ========================================================
                int monsterDmg = monster.attack();  // Get damage amount
                System.out.println(monster.name + " attacks for " + monsterDmg + " damage!");
                hero.takeDamage(monsterDmg);  // Apply to hero

                // ========================================================
                // CONDITION: Check if hero died
                // ========================================================
                if (!hero.isAlive) {
                    System.out.println(heroName + " has been defeated!");
                    break;  // Exit the while loop
                }

                // ========================================================
                // OUTPUT: Display current battle status
                // ========================================================
                System.out.println(heroName + " HP: " + hero.health + " | Mana: " + hero.mana);
                System.out.println(monster.name + " HP: " + monster.health);

                round++;  // Increment round counter for next loop

                // ========================================================
                // Safety check - prevent infinite battle
                // ========================================================
                if (round > 20) {
                    System.out.println("Battle timeout!");
                    break;
                }
            }
            // End of WHILE loop - one side is dead or timeout reached

            // ============================================================
            // Battle result - Final CONDITION check
            // ============================================================
            System.out.println("\n=== Battle End ===");
            if (hero.isAlive) {
                System.out.println("VICTORY! " + heroName + " wins!");
            } else {
                System.out.println("DEFEAT! " + monster.name + " wins!");
            }
        }
        // End of battle IF block

        // ====================================================================
        // Final OUTPUT - Show ending stats
        // ====================================================================
        System.out.println("\n=== Final Stats ===");
        hero.displayInfo();

        // ====================================================================
        // IMPORTANT: Close scanner to free resources
        // ====================================================================
        scanner.close();  // Good practice - close when done
    }
    // End of main method
}
// End of Game class