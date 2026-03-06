
// ============================================================================
// MODULE 1: Demonstrates Class, Method, Input, Output, Data Type,
//           Condition, Switch Case, Loop
// ============================================================================

/**
 * Hero class - Demonstrates the concept of a CLASS (Module 1)
 *
 * A class is a blueprint/template for creating objects. This Hero class
 * defines what properties (attributes) a hero has and what actions (methods)
 * a hero can perform.
 *
 * Think of it like a cookie cutter - the class is the cutter, and objects
 * created from it are the actual cookies.
 */
public class Hero {

    // ========================================================================
    // ATTRIBUTES - Demonstrate different DATA TYPES (Module 1 concept)
    // ========================================================================
    // These are PUBLIC to allow direct access for educational purposes
    // In Module 2, you'll learn about PRIVATE and ENCAPSULATION

    String name;           // String - stores text/words
    int health;            // int - stores whole numbers (hero's hit points)
    int mana;              // int - stores magical energy points
    boolean isAlive;       // boolean - stores true/false (alive or dead)
    double attackPower;    // double - stores decimal numbers (precise damage)
    char rank;             // char - stores a single character (S, A, B, C, D, F)

    // ========================================================================
    // METHODS - Functions that define what a Hero can DO (Module 1 concept)
    // ========================================================================

    /**
     * METHOD example - Sets the hero's initial data
     *
     * This demonstrates:
     * - Method with PARAMETERS (name, health, mana are inputs)
     * - void return type (doesn't return anything)
     * - this keyword (refers to THIS specific hero object)
     *
     * Why use 'this'? When parameter names match attribute names,
     * 'this.name' refers to the object's attribute, while 'name' refers
     * to the parameter.
     */
    public void setHeroData(String name, int health, int mana) {
        this.name = name;           // Store the parameter 'name' into the object's 'name' attribute
        this.health = health;       // Initialize health from user input
        this.mana = mana;           // Initialize mana from user input
        this.isAlive = true;        // Hero starts alive (boolean value)
        this.attackPower = 15.5;    // Fixed attack power (double value with decimal)
        this.rank = 'C';            // Default rank (char value - single quotes!)
    }

    /**
     * Demonstrates OUTPUT - displaying information to the user
     *
     * System.out.println() is how we OUTPUT data to the console.
     * The '+' operator concatenates (joins) strings together.
     *
     * Notice the ternary operator: (isAlive ? "Alive" : "Dead")
     * This is a shorthand if-else - if isAlive is true, show "Alive", else "Dead"
     */
    public void displayInfo() {
        System.out.println("========== HERO INFO ==========");
        System.out.println("Name: " + name);                    // String output
        System.out.println("HP: " + health);                    // int output
        System.out.println("Mana: " + mana);                    // int output
        System.out.println("Status: " + (isAlive ? "Alive" : "Dead"));  // boolean with ternary operator
        System.out.println("Attack Power: " + attackPower);     // double output
        System.out.println("Rank: " + rank);                    // char output
        System.out.println("==============================");
    }

    /**
     * Demonstrates CONDITION (if-else) - making decisions (Module 1 concept)
     *
     * The program checks IF mana is enough for a special attack.
     * - If TRUE (mana >= 10): perform special attack
     * - If FALSE: perform normal attack
     *
     * Also demonstrates:
     * - Return type 'int' - this method gives back an integer value
     * - Type casting (int) - converting double to int
     * - Compound operator -= (same as: mana = mana - 10)
     */
    public int attack() {
        // CONDITION: Check if hero has enough mana for special attack
        if (mana >= 10) {
            // TRUE branch - enough mana
            int damage = (int)(attackPower * 2);  // Cast double to int, deal double damage
            mana -= 10;                            // Consume 10 mana (compound assignment)
            System.out.println(name + " uses SPECIAL ATTACK!");
            return damage;                         // Return the damage value to caller
        } else {
            // FALSE branch - not enough mana
            System.out.println(name + " uses normal attack (low mana)");
            return (int)attackPower;               // Return normal damage (cast to int)
        }
    }

    /**
     * Demonstrates SWITCH CASE - choosing between multiple options (Module 1 concept)
     *
     * Switch is used when you have MULTIPLE fixed choices (like a menu).
     * It's cleaner than writing many if-else statements.
     *
     * Important rules:
     * - 'break' is required to exit the switch (prevents fall-through)
     * - 'default' handles any value not matched by cases (like final 'else')
     * - Can switch on: int, char, String, enum (learn enum in Module 4)
     */
    public void useSkill(int skillNumber) {
        System.out.println("\n--- Using Skill ---");

        // SWITCH: Check which skill number the user chose
        switch (skillNumber) {
            case 1:  // If skillNumber is 1
                System.out.println(name + " uses SLASH! Damage: 20");
                break;  // MUST break or it continues to case 2!

            case 2:  // If skillNumber is 2
                // Nested condition inside switch case
                if (mana >= 15) {
                    System.out.println(name + " uses FIREBALL! Damage: 30");
                    mana -= 15;  // Fireball costs 15 mana
                } else {
                    System.out.println("Not enough mana for Fireball!");
                }
                break;

            case 3:  // If skillNumber is 3
                System.out.println(name + " uses HEAL! Restored 25 HP");
                health += 25;
                // Cap health at 100 (can't exceed maximum)
                if (health > 100) health = 100;
                break;

            default:  // If skillNumber is anything else (4, 5, 100, etc.)
                System.out.println("Invalid skill number!");
                break;
        }
        // When attackCount > times, condition becomes false, loop stops
    }

    /**
     * Another CONDITION example - checking for death
     *
     * This shows practical use of conditions in game logic:
     * - Reduce health
     * - Check IF health drops to 0 or below
     * - If dead, set health to exactly 0 and mark as not alive
     */
    public void takeDamage(int damage) {
        health -= damage;  // Reduce health by damage amount

        // CONDITION: Check if hero died from this damage
        if (health <= 0) {
            health = 0;           // Prevent negative health (looks weird in UI)
            isAlive = false;      // Mark hero as dead
            System.out.println(name + " has been defeated!");
        }
        // If health > 0, nothing happens - hero survives
    }

    /**
     * Demonstrates FOR LOOP - repeating code a specific number of times (Module 1 concept)
     *
     * FOR loops are used when you know EXACTLY how many times to repeat.
     *
     * Structure: for (initialization; condition; increment)
     * - initialization: int i = 1 (start at 1)
     * - condition: i <= 4 (keep going while i is 1, 2, 3, or 4)
     * - increment: i++ (add 1 to i after each loop)
     *
     * This loop runs EXACTLY 4 times.
     */
    public void rest() {
        System.out.println("\n" + name + " is resting...");

        // FOR LOOP: Rest 4 times (i goes from 1 to 4)
        for (int i = 1; i <= 4; i++) {
            //   ↑start  ↑condition  ↑increment

            mana += 5;  // Restore 5 mana each phase

            // Cap mana at 100 (maximum)
            if (mana > 100) {
                mana = 100;
            }

            // Show which phase we're in (i tells us: 1, 2, 3, or 4)
            System.out.println("Rest phase " + i + " - Mana restored to: " + mana);
        }
        // After loop: i becomes 5, condition (5 <= 4) is false, loop stops
    }

    /**
     * Demonstrates WHILE LOOP - repeating based on a condition (Module 1 concept)
     *
     * WHILE loops are used when you DON'T know exactly how many times,
     * but you have a CONDITION to check.
     *
     * Structure: while (condition) { code }
     * - Keeps running AS LONG AS the condition is true
     * - Stops when condition becomes false
     *
     * IMPORTANT: Must increment attackCount++ or loop runs forever!
     */
    public void practice(int times) {
        System.out.println("\n" + name + " is practicing...");

        int attackCount = 1;  // Start counting from 1

        // WHILE LOOP: Keep practicing while attackCount <= times
        while (attackCount <= times) {
            // Loop body - this code repeats
            int damage = (int)attackPower;
            System.out.println("Training attack " + attackCount + ": " + damage + " damage");

            // CRITICAL: Increment counter or infinite loop!
            attackCount++;  // Move to next attack (1→2→3→etc)
        }
        // When attackCount > times, condition becomes false, loop stops
    }

    /**
     * Demonstrates SWITCH with FALL-THROUGH (advanced switch technique)
     *
     * Notice how cases 1, 2, 3 don't have 'break' until after rank = 'D'.
     * This is intentional! It's called "fall-through".
     *
     * If level is 1, 2, OR 3 → rank becomes 'D'
     * If level is 4, 5, OR 6 → rank becomes 'C'
     * And so on...
     *
     * This demonstrates assigning a char value based on int ranges.
     */
    public void promoteRank(int level) {
        // SWITCH with fall-through for range handling
        switch (level) {
            case 1:   // Falls through (no break)
            case 2:   // Falls through (no break)
            case 3:   // Finally executes this
                rank = 'D';  // Levels 1-3 get rank 'D'
                break;
            case 4:
            case 5:
            case 6:
                rank = 'C';  // Levels 4-6 get rank 'C'
                break;
            case 7:
            case 8:
                rank = 'B';  // Levels 7-8 get rank 'B'
                break;
            case 9:
                rank = 'A';  // Level 9 gets rank 'A'
                break;
            case 10:
                rank = 'S';  // Level 10 gets rank 'S' (highest!)
                break;
            default:
                rank = 'F';  // Invalid levels get rank 'F' (fail)
                break;
        }
        System.out.println(name + " has been promoted to rank " + rank);
    }
}


