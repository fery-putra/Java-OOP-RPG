import java.util.ArrayList;

class Game {
    public static void main(String[] args) {
        System.out.println("=== RPG Game - Module 5 ===");
        System.out.println("Learn: Exception Handling, ArrayList Methods, Iterator, Enhanced For\n");

        // Create characters
        Character warrior = new Character("Conan", 150, 50);
        Character mage = new Character("Merlin", 100, 120);
        Character cleric = new Character("Anna", 110, 100);

        // ========== ARRAYLIST METHODS ==========
        System.out.println("=== ArrayList Methods Demo ===\n");

        // Create Party - uses ArrayList
        Party party = new Party("Heroes", 3);

        // Method: ADD and SIZE
        try {
            System.out.println("-- ADD Method --");
            party.addMember(warrior);    // add()
            party.addMember(mage);       // add()
            party.addMember(cleric);     // add()
            System.out.println("Party size: " + party.getSize()); // size()

            // Try to exceed capacity
            Character extra = new Character("Extra", 100, 50);
            party.addMember(extra); // Should throw exception

        } catch (InventoryFullException e) {
            System.out.println("✗ " + e.getMessage());
        }

        // Method: GET
        System.out.println("\n-- GET Method --");
        Character first = party.getMemberAt(0); // get(0)
        if (first != null) {
            System.out.println("First member: " + first.getName());
        }

        // Method: SET
        System.out.println("\n-- SET Method --");
        Character replacement = new Character("Aragorn", 140, 60);
        party.replaceMember(1, replacement); // set(1, newMember)

        // Method: ISEMPTY
        System.out.println("\n-- ISEMPTY Method --");
        System.out.println("Is party empty? " + party.isEmpty()); // isEmpty()

        party.displayParty();

        // ========== ITERATOR ==========
        System.out.println("\n=== Iterator Demo ===");
        System.out.println("-- Removing member with Iterator --");
        party.removeMember("Aragorn"); // Uses Iterator for safe removal
        party.displayParty();

        // ========== ENHANCED FOR LOOP ==========
        System.out.println("\n=== Enhanced For Loop Demo ===");

        // Find member
        System.out.println("-- Searching with Enhanced For --");
        Character found = party.findMember("Conan");
        if (found != null) {
            System.out.println("Found: " + found.getName());
        }

        // Get alive members
        System.out.println("\n-- Filtering with Enhanced For --");
        ArrayList<Character> alive = party.getAliveMembers();
        System.out.println("Alive members: " + alive.size());
        for (Character c : alive) {
            System.out.println("  " + c.getName());
        }

        // Sum health
        System.out.println("\n-- Summing with Enhanced For --");
        System.out.println("Total party health: " + party.getTotalHealth());

        // ========== INVENTORY - All ArrayList Methods ==========
        System.out.println("\n=== Inventory (ArrayList Methods) ===");
        Inventory inventory = new Inventory(5);

        try {
            // ADD
            inventory.addItem(new Item("Health Potion", 50));
            inventory.addItem(new Item("Mana Potion", 40));
            inventory.addItem(new Item("Sword", 200));

            // GET
            Item firstItem = inventory.getItem(0);
            System.out.println("First item: " + firstItem);

            // SIZE and ISEMPTY
            System.out.println("Item count: " + inventory.getItemCount());
            System.out.println("Is empty? " + inventory.isEmpty());

            inventory.displayInventory();

            // Enhanced For: Total value
            System.out.println("\nTotal value: " + inventory.getTotalValue() + "g");

            // SET - Replace item
            System.out.println("\n-- SET Method --");
            inventory.replaceItem(1, new Item("Super Potion", 80));
            inventory.displayInventory();

            // REMOVE by index
            System.out.println("\n-- REMOVE Method (by index) --");
            Item removed = inventory.removeItemAt(2);
            System.out.println("Removed: " + removed);
            inventory.displayInventory();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ========== EXCEPTION HANDLING ==========
        System.out.println("\n=== Exception Handling Demo ===");

        // TRY-CATCH: Normal attack
        BattleManager.executeBattle(warrior, mage);

        // TRY-CATCH: Spell with enough mana
        BattleManager.executeSpellCast(mage, warrior, 30);

        // TRY-CATCH: Spell without enough mana (throws exception)
        BattleManager.executeSpellCast(mage, warrior, 150);

        // Create dead character to test exceptions
        System.out.println("\n--- Testing Dead Character Exceptions ---");
        mage.takeDamage(200); // Kill mage

        // TRY-CATCH: Dead attacker
        BattleManager.executeBattle(mage, warrior);

        // TRY-CATCH: Dead target
        BattleManager.executeBattle(warrior, mage);

        // TRY-CATCH: Heal dead character
        BattleManager.attemptHealing(mage, 50);

        // ========== ITERATOR - Remove from Inventory ==========
        System.out.println("\n=== Iterator - Remove Item ===");
        inventory.displayInventory();
        Item removedItem = inventory.removeItem("Health Potion");
        System.out.println("Removed with Iterator: " + removedItem);
        inventory.displayInventory();

        // ========== ENHANCED FOR - Search ==========
        System.out.println("\n=== Enhanced For - Search ===");
        System.out.println("Has Super Potion? " + inventory.hasItem("Super Potion"));
        System.out.println("Has Magic Scroll? " + inventory.hasItem("Magic Scroll"));

        // Final Summary
        System.out.println("\n=== Final Summary ===");
        System.out.println("Party members: " + party.getSize());
        System.out.println("Total party health: " + party.getTotalHealth());
        System.out.println("Inventory items: " + inventory.getItemCount());
        System.out.println("Inventory empty? " + inventory.isEmpty());
    }
}
