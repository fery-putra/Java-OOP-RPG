class Archer extends Character {
    private int arrows;
    private boolean isAiming;

    // Constructor with name
    public Archer(String name) {
        super(name, 100);
        this.arrows = 20;
        this.isAiming = false;
        System.out.println("Archer constructor called - Arrows set to 20");
    }

    // Constructor Overloading - with custom arrows
    public Archer(String name, int arrows) {
        super(name, 100);
        this.arrows = arrows;
        this.isAiming = false;
        System.out.println("Archer constructor called - Custom arrows: " + arrows);
    }

    // Constructor Overloading - with custom health and arrows
    public Archer(String name, int maxHealth, int arrows) {
        super(name, maxHealth);
        this.arrows = arrows;
        this.isAiming = false;
        System.out.println("Archer constructor called - Custom health and arrows");
    }

    public int getArrows() {
        return arrows;
    }

    public void aim() {
        isAiming = true;
        System.out.println(getName() + " takes careful aim...");
    }

    // OVERRIDING - Use arrows, bonus damage if aiming
    @Override
    public int attack() {
        if (arrows > 0) {
            arrows--;
            if (isAiming) {
                isAiming = false;
                return 25; // Critical hit
            } else {
                return 15; // Normal shot
            }
        } else {
            System.out.println("Out of arrows! Using melee attack!");
            return 3; // Punch
        }
    }

    // OVERRIDING - Special message for aimed shots
    @Override
    public void attack(Character target) {
        boolean wasAiming = isAiming;
        super.attack(target);
        if (wasAiming && arrows >= 0) {
            System.out.println(getName() + " shoots a PERFECT SHOT! Critical hit!");
        }
    }

    // OVERRIDING - Add arrows and aiming status
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Arrows: " + arrows + " | Aiming: " + (isAiming ? "Yes" : "No"));
    }
}