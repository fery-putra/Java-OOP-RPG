import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== RPG Game - Module 2 ===");
        System.out.println("Learn: Encapsulation, Getter/Setter, Method Overloading, Static\n");

        // Test ENCAPSULATION and STATIC with INPUT
        System.out.println("=== Creating Warriors ===");
        System.out.print("Enter first warrior name: ");
        String name1 = scanner.nextLine();
        Warrior warrior1 = new Warrior(name1);

        System.out.print("Enter second warrior name: ");
        String name2 = scanner.nextLine();
        Warrior warrior2 = new Warrior(name2);

        System.out.print("Enter third warrior name: ");
        String name3 = scanner.nextLine();
        Warrior warrior3 = new Warrior(name3);

        warrior1.displayInfo();
        warrior2.displayInfo();
        warrior3.displayInfo();

        // Access STATIC method without object
        System.out.println("\nTotal Warriors Created: " + Warrior.getTotalWarriors());
        System.out.println("Health gained per level: " + Warrior.getHealthPerLevel());

        // Test GETTER methods
        System.out.println("\n=== Testing Getter Methods ===");
        System.out.println(warrior1.getName() + "'s health: " + warrior1.getHealth());
        System.out.println(warrior1.getName() + "'s armor: " + warrior1.getArmor());
        System.out.println(warrior1.getName() + "'s level: " + warrior1.getLevel());

        // Test SETTER methods with validation and INPUT
        System.out.println("\n=== Testing Setter Methods ===");
        System.out.print("Set armor for " + warrior1.getName() + " (0-50): ");
        int armorValue = scanner.nextInt();
        warrior1.setArmor(armorValue);

        scanner.nextLine(); // Clear buffer
        System.out.print("Change name for " + warrior2.getName() + ": ");
        String newName = scanner.nextLine();
        warrior2.setName(newName);

        warrior1.displayInfo();
        warrior2.displayInfo();

        // Test METHOD OVERLOADING - attack() with INPUT
        System.out.println("\n=== Testing Method Overloading (Attack) ===");
        System.out.println("1. Base attack");
        System.out.println("2. Attack with bonus damage");
        System.out.println("3. Attack with weapon type");
        System.out.println("4. Attack with weapon and bonus");
        System.out.print("Choose attack type (1-4): ");
        int attackType = scanner.nextInt();

        int damage = 0;
        switch (attackType) {
            case 1:
                damage = warrior1.attack();
                System.out.println("Base attack damage: " + damage);
                break;
            case 2:
                System.out.print("Enter bonus damage: ");
                int bonus = scanner.nextInt();
                damage = warrior1.attack(bonus);
                System.out.println("Attack with bonus damage: " + damage);
                break;
            case 3:
                scanner.nextLine(); // Clear buffer
                System.out.print("Enter weapon type (sword/axe/spear): ");
                String weapon = scanner.nextLine();
                damage = warrior1.attack(weapon);
                System.out.println("Attack with " + weapon + ": " + damage);
                break;
            case 4:
                scanner.nextLine(); // Clear buffer
                System.out.print("Enter weapon type (sword/axe/spear): ");
                String weapon2 = scanner.nextLine();
                System.out.print("Enter bonus damage: ");
                int bonus2 = scanner.nextInt();
                damage = warrior1.attack(weapon2, bonus2);
                System.out.println("Attack with " + weapon2 + " + bonus: " + damage);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        // Test takeDamage (uses PRIVATE armor)
        System.out.println("\n=== Testing Combat (Private Attributes) ===");
        warrior1.displayInfo();
        System.out.print("Enter damage amount: ");
        int damageAmount = scanner.nextInt();
        warrior1.takeDamage(damageAmount);
        warrior1.displayInfo();

        // Test levelUp (uses STATIC FINAL constant) with INPUT
        System.out.println("\n=== Testing Level Up (Static Final) ===");
        System.out.print("How many times to level up? (1-5): ");
        int levelUps = scanner.nextInt();
        for (int i = 0; i < levelUps; i++) {
            warrior1.levelUp();
        }
        warrior1.displayInfo();

        // Test STATIC comparison method
        System.out.println("\n=== Testing Static Method (Compare) ===");
        Warrior stronger = Warrior.compareWarriors(warrior1, warrior2);
        System.out.println("Stronger warrior: " + stronger.getName());

        // Test Party with METHOD OVERLOADING and INPUT
        System.out.println("\n=== Testing Party & Method Overloading ===");
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter party name: ");
        String partyName = scanner.nextLine();
        Party party1 = new Party(partyName);

        System.out.println("\nAdding warriors to party:");
        System.out.println("1. Add existing warrior");
        System.out.println("2. Create new warrior with name only");
        System.out.println("3. Create new warrior with name and armor");

        for (int i = 0; i < 3; i++) {
            System.out.print("\nChoice for member " + (i+1) + ": ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    if (i == 0) party1.addWarrior(warrior1);
                    else if (i == 1) party1.addWarrior(warrior2);
                    else party1.addWarrior(warrior3);
                    break;
                case 2:
                    System.out.print("Enter warrior name: ");
                    String wName = scanner.nextLine();
                    party1.addWarrior(wName);
                    break;
                case 3:
                    System.out.print("Enter warrior name: ");
                    String wName2 = scanner.nextLine();
                    System.out.print("Enter armor value (0-50): ");
                    int wArmor = scanner.nextInt();
                    party1.addWarrior(wName2, wArmor);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        party1.displayParty();

        // Test Party GETTER/SETTER with INPUT
        System.out.println("\n=== Testing Party Getter/Setter ===");
        System.out.println("Current party name: " + party1.getPartyName());
        System.out.print("Enter new party name: ");
        String newPartyName = scanner.nextLine();
        party1.setPartyName(newPartyName);
        party1.displayParty();

        // Demonstrate PUBLIC vs PRIVATE access
        System.out.println("\n=== Access Modifiers Demo ===");
        System.out.println("Can access public level: " + warrior1.level);
        System.out.println("Must use getter for private name: " + warrior1.getName());
        System.out.println("Can access protected armor in same package: " + warrior1.armor);

        // Final statistics
        System.out.println("\n=== Final Statistics ===");
        System.out.println("Total Warriors Created: " + Warrior.getTotalWarriors());
        System.out.println("Total Parties Created: " + Party.getTotalParties());

        scanner.close();
    }
}