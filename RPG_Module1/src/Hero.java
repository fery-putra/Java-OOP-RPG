
//Class, Method, Input, Output, Data Type, Condition, Switch Case, Loop

public class Hero {
    // Attributes with different data types
    String name;           // String
    int health;            // int
    int mana;              // int
    boolean isAlive;       // boolean
    double attackPower;    // double
    char rank;             // char (e.g., 'S', 'A', 'B', 'C')

    // Method to set hero data with input
    public void setHeroData(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.isAlive = true;
        this.attackPower = 15.5;
        this.rank = 'C'; // Default rank
    }

    // Method to display hero information (OUTPUT)
    public void displayInfo() {
        System.out.println("========== HERO INFO ==========");
        System.out.println("Name: " + name);
        System.out.println("HP: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Status: " + (isAlive ? "Alive" : "Dead"));
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Rank: " + rank);
        System.out.println("==============================");
    }

    // Method using CONDITION (if-else)
    public int attack() {
        if (mana >= 10) {
            int damage = (int)(attackPower * 2);
            mana -= 10;
            System.out.println(name + " uses SPECIAL ATTACK!");
            return damage;
        } else {
            System.out.println(name + " uses normal attack (low mana)");
            return (int)attackPower;
        }
    }

    // Method using SWITCH CASE
    public void useSkill(int skillNumber) {
        System.out.println("\n--- Using Skill ---");
        switch (skillNumber) {
            case 1:
                System.out.println(name + " uses SLASH! Damage: 20");
                break;
            case 2:
                System.out.println(name + " uses FIREBALL! Damage: 30");
                if (mana >= 15) {
                    mana -= 15;
                } else {
                    System.out.println("Not enough mana!");
                }
                break;
            case 3:
                System.out.println(name + " uses HEAL! Restored 25 HP");
                health += 25;
                if (health > 100) health = 100;
                break;
            default:
                System.out.println("Invalid skill number!");
                break;
        }
    }

    // Method with CONDITION
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isAlive = false;
            System.out.println(name + " has been defeated!");
        }
    }

    // Method using FOR LOOP
    public void rest() {
        System.out.println("\n" + name + " is resting...");
        for (int i = 1; i <= 4; i++) {
            mana += 5;
            if (mana > 100) {
                mana = 100;
            }
            System.out.println("Rest phase " + i + " - Mana restored to: " + mana);
        }
    }

    // Method using WHILE LOOP
    public void practice() {
        System.out.println("\n" + name + " is practicing...");
        int attackCount = 1;
        while (attackCount <= 5) {
            int damage = (int)attackPower;
            System.out.println("Training attack " + attackCount + ": " + damage + " damage");
            attackCount++;
        }
    }

    // Method to set rank using SWITCH
    public void promoteRank(int level) {
        switch (level) {
            case 1:
            case 2:
            case 3:
                rank = 'D';
                break;
            case 4:
            case 5:
            case 6:
                rank = 'C';
                break;
            case 7:
            case 8:
                rank = 'B';
                break;
            case 9:
                rank = 'A';
                break;
            case 10:
                rank = 'S';
                break;
            default:
                rank = 'F';
                break;
        }
        System.out.println(name + " has been promoted to rank " + rank);
    }
}
