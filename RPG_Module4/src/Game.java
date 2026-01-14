class Game {
    public static void main(String[] args) {
        System.out.println("=== RPG Game - Module 4 ===");
        System.out.println("Learn: Final, Enum, Abstract, Interface, Polymorphism, Casting\n");

        // Test ENUM
        System.out.println("=== Testing ENUM ===");
        System.out.println("Character Classes:");
        for (CharacterClass cc : CharacterClass.values()) {
            System.out.println(cc + " - Damage: " + cc.getBaseDamage() +
                    ", Health: " + cc.getBaseHealth());
        }

        System.out.println("\nElements:");
        for (Element e : Element.values()) {
            System.out.println(e + " - " + e.getEffect() +
                    " (x" + e.getDamageMultiplier() + ")");
        }

        // Create characters (concrete implementations of abstract class)
        System.out.println("\n=== Creating Characters ===");
        Warrior warrior = new Warrior("Thorin");
        Mage mage = new Mage("Gandalf");
        Paladin paladin = new Paladin("Uther");
        Archer archer = new Archer("Legolas");

        // POLYMORPHISM - All are Combatants (abstract class reference)
        System.out.println("\n=== Testing POLYMORPHISM (Abstract Class) ===");
        Combatant[] party = {warrior, mage, paladin, archer};

        System.out.println("Party Members (polymorphic array):");
        for (Combatant c : party) {
            c.displayInfo(); // Polymorphic call - different implementation for each
            System.out.println();
        }

        // Test FINAL METHOD (cannot be overridden)
        System.out.println("=== Testing FINAL METHOD ===");
        warrior.displayStats(); // Final method in Combatant class
        System.out.println();

        // POLYMORPHISM with Interface - Magical
        System.out.println("=== Testing POLYMORPHISM (Interface: Magical) ===");
        Magical[] spellcasters = {mage, paladin}; // Both implement Magical

        System.out.println("Spellcasters:");
        for (Magical m : spellcasters) {
            Combatant c = (Combatant)m; // Downcast to access Combatant methods
            System.out.println(c.getName() + " - Mana: " + m.getMana());
        }

        // POLYMORPHISM with Interface - Defensive
        System.out.println("\n=== Testing POLYMORPHISM (Interface: Defensive) ===");
        Defensive[] defenders = {warrior, paladin}; // Both implement Defensive

        System.out.println("Defenders:");
        for (Defensive d : defenders) {
            System.out.println("Armor: " + d.getArmor());
        }

        // UPCASTING - Automatic (subclass to superclass/interface)
        System.out.println("\n=== Testing UPCASTING (Automatic) ===");
        Combatant c1 = warrior;     // Warrior -> Combatant (automatic)
        Combatant c2 = mage;        // Mage -> Combatant (automatic)
        Magical m1 = paladin;       // Paladin -> Magical (automatic)
        Defensive d1 = warrior;     // Warrior -> Defensive (automatic)

        System.out.println("Upcasted successfully:");
        System.out.println("warrior (Warrior) -> c1 (Combatant)");
        System.out.println("mage (Mage) -> c2 (Combatant)");
        System.out.println("paladin (Paladin) -> m1 (Magical)");
        System.out.println("warrior (Warrior) -> d1 (Defensive)");

        // DOWNCASTING - Manual (superclass to subclass)
        System.out.println("\n=== Testing DOWNCASTING (Manual) ===");

        Combatant genericCombatant = new Mage("Saruman"); // Upcasting

        // Check type before downcasting
        if (genericCombatant instanceof Mage) {
            Mage specificMage = (Mage) genericCombatant; // Downcasting
            System.out.println("Successfully downcast Combatant to Mage");
            System.out.println("Can now access Mage-specific methods:");
            System.out.println("Mana: " + specificMage.getMana());
            specificMage.castSpell(warrior, Element.FIRE);
        }

        System.out.println("\nSafe downcasting with instanceof:");
        for (Combatant c : party) {
            System.out.print(c.getName() + " is a ");

            if (c instanceof Warrior) {
                System.out.println("Warrior");
                Warrior w = (Warrior)c; // Safe downcast
                System.out.println("  Armor: " + w.getArmor());
            } else if (c instanceof Mage) {
                System.out.println("Mage");
                Mage mg = (Mage)c; // Safe downcast
                System.out.println("  Mana: " + mg.getMana());
            } else if (c instanceof Paladin) {
                System.out.println("Paladin");
                Paladin p = (Paladin)c; // Safe downcast
                System.out.println("  Mana: " + p.getMana() + ", Armor: " + p.getArmor());
            } else if (c instanceof Archer) {
                System.out.println("Archer");
            }
        }

        // Test FINAL CLASS and ENUM IN SWITCH
        System.out.println("\n=== Testing FINAL CLASS & ENUM in SWITCH ===");
        GameMaster gm = new GameMaster(); // Final class - cannot be extended

        System.out.println("Class Descriptions:");
        for (CharacterClass cc : CharacterClass.values()) {
            gm.describeClass(cc); // ENUM in SWITCH
        }

        System.out.println("\nElement Descriptions:");
        for (Element e : Element.values()) {
            gm.describeElement(e); // ENUM in SWITCH
        }

        // Test STATIC FINAL constants
        System.out.println("\n=== Testing STATIC FINAL Constants ===");
        System.out.println("MIN_DAMAGE: " + Combatant.MIN_DAMAGE);
        System.out.println("MAX_LEVEL: " + Combatant.MAX_LEVEL);

        // Combat demonstration with polymorphism
        gm.startBattle(warrior, mage);

        System.out.println("=== Round 1 ===");
        gm.executeTurn(warrior, mage); // Polymorphism
        gm.executeTurn(mage, warrior); // Polymorphism

        System.out.println("\n=== Round 2 ===");
        gm.activateDefense(warrior); // Interface polymorphism
        gm.executeTurn(mage, warrior);

        System.out.println("\n=== Round 3 ===");
        gm.castMagicSpell(mage, warrior, Element.FIRE); // Interface + Enum

        System.out.println("\n=== Round 4 ===");
        gm.castMagicSpell(paladin, mage, Element.HOLY); // Paladin implements both interfaces
        gm.activateDefense(paladin);
        gm.executeTurn(archer, paladin);

        // Final status
        System.out.println("\n=== Final Status ===");
        for (Combatant c : party) {
            c.displayStats(); // FINAL method
            System.out.println();
        }
    }
}