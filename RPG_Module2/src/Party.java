class Party {
    // ENCAPSULATION
    private Warrior warrior1;     // PRIVATE
    private Warrior warrior2;     // PRIVATE
    private Warrior warrior3;     // PRIVATE
    protected String partyName;   // PROTECTED

    // STATIC attribute
    private static int totalParties = 0;

    // Constructor
    public Party(String partyName) {
        this.partyName = partyName;
        this.warrior1 = null;
        this.warrior2 = null;
        this.warrior3 = null;
        totalParties++;
    }

    // GETTER
    public String getPartyName() {
        return partyName;
    }

    // SETTER with validation
    public void setPartyName(String partyName) {
        if (partyName != null && !partyName.isEmpty()) {
            this.partyName = partyName;
        } else {
            System.out.println("Error: Party name cannot be empty!");
        }
    }

    // METHOD OVERLOADING - addWarrior

    // Version 1: Add existing warrior object
    public void addWarrior(Warrior w) {
        if (warrior1 == null) {
            warrior1 = w;
            System.out.println(w.getName() + " joined the party!");
        } else if (warrior2 == null) {
            warrior2 = w;
            System.out.println(w.getName() + " joined the party!");
        } else if (warrior3 == null) {
            warrior3 = w;
            System.out.println(w.getName() + " joined the party!");
        } else {
            System.out.println("Party is full! Cannot add " + w.getName());
        }
    }

    // Version 2: Create new warrior with name
    public void addWarrior(String name) {
        Warrior newWarrior = new Warrior(name);
        addWarrior(newWarrior); // Call the other overloaded method
    }

    // Version 3: Create warrior with name and armor
    public void addWarrior(String name, int armor) {
        Warrior newWarrior = new Warrior(name);
        newWarrior.setArmor(armor);
        addWarrior(newWarrior);
    }

    // Method using PRIVATE attributes
    public int getTotalHealth() {
        int total = 0;
        if (warrior1 != null) total += warrior1.getHealth();
        if (warrior2 != null) total += warrior2.getHealth();
        if (warrior3 != null) total += warrior3.getHealth();
        return total;
    }

    public void displayParty() {
        System.out.println("\n========== PARTY: " + partyName + " ==========");
        if (warrior1 != null) warrior1.displayInfo();
        if (warrior2 != null) warrior2.displayInfo();
        if (warrior3 != null) warrior3.displayInfo();
        if (warrior1 == null && warrior2 == null && warrior3 == null) {
            System.out.println("(Empty party)");
        }
        System.out.println("Total HP: " + getTotalHealth());
        System.out.println("====================================");
    }

    // STATIC method
    public static int getTotalParties() {
        return totalParties;
    }
}