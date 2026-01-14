class Game {
public static void main(String[] args) {
    System.out.println("=== RPG Game - Module 3 ===");
    System.out.println("Learn: Inheritance, Constructor, Overriding, Overloading\n");

    // Test INHERITANCE and CONSTRUCTOR
    System.out.println("=== Testing Constructors & Inheritance ===\n");

    // Different constructor versions
    Warrior warrior1 = new Warrior("Thorin");
    System.out.println();

    Warrior warrior2 = new Warrior("Gimli", 35);
    System.out.println();

    Warrior warrior3 = new Warrior("Boromir", 30, 130);
    System.out.println();

    Mage mage1 = new Mage("Gandalf");
    System.out.println();

    Mage mage2 = new Mage("Saruman", 150);
    System.out.println();

    Archer archer1 = new Archer("Legolas");
    System.out.println();

    Archer archer2 = new Archer("Robin", 30);
    System.out.println();

    // Display all characters
    System.out.println("\n=== All Characters ===");
    warrior1.displayInfo();
    System.out.println();
    warrior2.displayInfo();
    System.out.println();
    mage1.displayInfo();
    System.out.println();
    archer1.displayInfo();
    System.out.println();

    // Test METHOD OVERRIDING - attack()
    System.out.println("=== Testing Method Overriding (Damage) ===");
    System.out.println("Base Character attack: 10");
    System.out.println("Warrior attack (overridden): " + warrior1.attack());
    System.out.println("Mage attack with mana (overridden): " + mage1.attack());
    System.out.println("Archer attack (overridden): " + archer1.attack());

    // Test METHOD OVERLOADING - attack(Character)
    System.out.println("\n=== Testing Method Overloading ===");
    System.out.println("Warrior attacks Mage:");
    warrior1.attack(mage1);
    System.out.println();

    System.out.println("Mage attacks Warrior:");
    mage1.attack(warrior1);
    System.out.println();

    System.out.println("Archer aims and attacks:");
    archer1.aim();
    archer1.attack(warrior1);
    System.out.println();

    // Test OVERRIDDEN takeDamage
    System.out.println("=== Testing Overridden takeDamage ===");
    Mage enemy = new Mage("Dark Wizard");
    System.out.println("\nWarrior takes damage (with armor reduction):");
    warrior1.takeDamage(30);

    System.out.println("\nMage takes damage (no armor):");
    enemy.takeDamage(30);
    System.out.println();

    // Demonstrate INHERITANCE hierarchy
    System.out.println("=== Demonstrating Inheritance Hierarchy ===");
    Character[] party = {warrior1, mage2, archer1};
    System.out.println("All inherit from Character class:");
    for (Character c : party) {
        c.displayInfo(); // Polymorphic call
        System.out.println();
    }

    // Test unique methods (not inherited)
    System.out.println("=== Unique Class Methods ===");
    warrior1.shieldBash(enemy);
    System.out.println();

    mage1.restoreMana(50);
    System.out.println();

    // Battle simulation
    System.out.println("=== Battle Simulation ===");
    Warrior hero = new Warrior("Hero", 40);
    Mage boss = new Mage("Evil Sorcerer", 90, 120);

    System.out.println("\nBattle Start!");
    hero.displayInfo();
    System.out.println();
    boss.displayInfo();
    System.out.println();

    int round = 1;
    while (hero.isAlive() && boss.isAlive() && round <= 5) {
        System.out.println("--- Round " + round + " ---");
        hero.attack(boss);
        if (boss.isAlive()) {
            System.out.println();
            boss.attack(hero);
        }
        System.out.println();
        round++;
    }

    System.out.println("Battle End!");
    hero.displayInfo();
    System.out.println();
    boss.displayInfo();

    if (hero.isAlive() && !boss.isAlive()) {
        System.out.println("\n✓ " + hero.getName() + " is victorious!");
    } else if (!hero.isAlive() && boss.isAlive()) {
        System.out.println("\n✗ " + boss.getName() + " wins!");
    } else {
        System.out.println("\nBattle continues...");
    }
}
}