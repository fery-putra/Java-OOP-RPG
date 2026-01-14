
// Encapsulation (public, protected, private), Method Overloading, Getter/Setter, Static

class Game {
    public static void main(String[] args) {
        System.out.println("=== RPG Game - Module 2 ===");
        System.out.println("Learn: Encapsulation, Getter/Setter, Method Overloading, Static\n");

        // Test ENCAPSULATION and STATIC
        System.out.println("=== Testing Encapsulation & Static ===");
        Warrior warrior1 = new Warrior("Thorin");
        Warrior warrior2 = new Warrior("Gimli");
        Warrior warrior3 = new Warrior("Boromir");

        warrior1.displayInfo();
        warrior2.displayInfo();
        warrior3.displayInfo();

        // Access STATIC method without object
        System.out.println("\nTotal Warriors Created: " + Warrior.getTotalWarriors());
        System.out.println("Health gained per level: " + Warrior.getHealthPerLevel());

        // Test GETTER methods
        System.out.println("\n=== Testing Getter Methods ===");
        System.out.println("Thorin's name: " + warrior1.getName());
        System.out.println("Thorin's health: " + warrior1.getHealth());
        System.out.println("Thorin's armor: " + warrior1.getArmor());
        System.out.println("Thorin's level: " + warrior1.getLevel());

        // Test SETTER methods with validation
        System.out.println("\n=== Testing Setter Methods ===");
        warrior1.setArmor(30);      // Valid
        warrior1.setArmor(60);      // Invalid - should show error
        warrior1.setName("Thorin Oakenshield");
        warrior1.setName("");       // Invalid - should show error
        warrior1.displayInfo();

        // Test METHOD OVERLOADING - attack()
        System.out.println("\n=== Testing Method Overloading (Attack) ===");
        System.out.println("1. Base attack: " + warrior1.attack());
        System.out.println("2. Attack with bonus (10): " + warrior1.attack(10));
        System.out.println("3. Attack with sword: " + warrior1.attack("sword"));
        System.out.println("4. Attack with axe: " + warrior1.attack("axe"));
        System.out.println("5. Attack with spear: " + warrior1.attack("spear"));
        System.out.println("6. Attack with dagger: " + warrior1.attack("dagger"));
        System.out.println("7. Attack with axe + bonus (15): " + warrior1.attack("axe", 15));

        // Test takeDamage (uses PRIVATE armor)
        System.out.println("\n=== Testing Combat (Private Attributes) ===");
        warrior1.displayInfo();
        warrior1.takeDamage(30);
        warrior1.displayInfo();

        // Test levelUp (uses STATIC FINAL constant)
        System.out.println("\n=== Testing Level Up (Static Final) ===");
        warrior1.levelUp();
        warrior1.displayInfo();
        warrior1.levelUp();
        warrior1.displayInfo();

        // Test STATIC comparison method
        System.out.println("\n=== Testing Static Method (Compare) ===");
        Warrior stronger = Warrior.compareWarriors(warrior1, warrior2);
        System.out.println("Stronger warrior: " + stronger.getName());

        // Test Party with METHOD OVERLOADING
        System.out.println("\n=== Testing Party & Method Overloading ===");
        Party party1 = new Party("Fellowship");

        // Overloaded addWarrior - version 1 (existing warrior)
        party1.addWarrior(warrior1);

        // Overloaded addWarrior - version 2 (create with name)
        party1.addWarrior("Aragorn");

        // Overloaded addWarrior - version 3 (create with name and armor)
        party1.addWarrior("Legolas", 15);

        party1.displayParty();

        // Try to add 4th warrior
        System.out.println("\nTrying to add 4th warrior:");
        party1.addWarrior("Gandalf");

        // Test Party GETTER/SETTER
        System.out.println("\n=== Testing Party Getter/Setter ===");
        System.out.println("Current party name: " + party1.getPartyName());
        party1.setPartyName("Heroes of Light");
        party1.setPartyName(""); // Should show error
        party1.displayParty();

        // Test STATIC party counter
        Party party2 = new Party("Avengers");
        Party party3 = new Party("Justice League");
        System.out.println("\nTotal Parties Created: " + Party.getTotalParties());

        // Final warrior count
        System.out.println("Total Warriors Created: " + Warrior.getTotalWarriors());

        // Demonstrate PUBLIC vs PRIVATE access
        System.out.println("\n=== Access Modifiers Demo ===");
        System.out.println("Can access public level: " + warrior1.level);
        // System.out.println(warrior1.name); // ERROR - private
        // System.out.println(warrior1.health); // ERROR - private
        System.out.println("Must use getter for private name: " + warrior1.getName());
        System.out.println("Can access protected armor in same package: " + warrior1.armor);
    }
}
