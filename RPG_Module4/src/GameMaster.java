// MODULE 4: COMPLETE SOLUTION - PART 2/2
// GameMaster (Final Class) and Game with Polymorphism, Upcasting, Downcasting

// ==================== GameMaster.java (FINAL CLASS) ====================
// FINAL CLASS - cannot be extended/inherited
final class GameMaster {
    private static final String VERSION = "1.0"; // STATIC FINAL

    // FINAL METHOD - cannot be overridden (but class is already final)
    public final void startBattle(Combatant c1, Combatant c2) {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║      BATTLE START v" + VERSION + "       ║");
        System.out.println("╚════════════════════════════════╝");
        c1.displayInfo();
        c2.displayInfo();
        System.out.println();
    }

    // POLYMORPHISM - accepts any Combatant
    public void executeTurn(Combatant attacker, Combatant defender) {
        int damage = attacker.attack();
        System.out.println(attacker.getName() + " attacks for " + damage + " damage!");
        defender.takeDamage(damage);
    }

    // POLYMORPHISM with interface - accepts any Magical
    public void castMagicSpell(Magical caster, Combatant target, Element element) {
        System.out.println(((Combatant)caster).getName() + " prepares spell...");
        caster.castSpell(target, element);
    }

    // POLYMORPHISM with interface - accepts any Defensive
    public void activateDefense(Defensive defender) {
        defender.defend();
        System.out.println("Defense activated! Armor: " + defender.getArmor());
    }

    // ENUM IN SWITCH CASE
    public void describeClass(CharacterClass cc) {
        System.out.print(cc + ": ");
        switch(cc) {
            case WARRIOR:
                System.out.println(cc.getDescription() + " with high armor");
                break;
            case MAGE:
                System.out.println(cc.getDescription() + " with powerful magic");
                break;
            case ARCHER:
                System.out.println(cc.getDescription() + " with ranged attacks");
                break;
            case PALADIN:
                System.out.println(cc.getDescription() + " with holy powers");
                break;
            default:
                System.out.println("Unknown class");
                break;
        }
    }

    // ENUM IN SWITCH CASE
    public void describeElement(Element element) {
        System.out.print(element + " element: ");
        switch(element) {
            case FIRE:
                System.out.println(element.getEffect() + " - Multiplier: " + element.getDamageMultiplier());
                break;
            case ICE:
                System.out.println(element.getEffect() + " - Multiplier: " + element.getDamageMultiplier());
                break;
            case LIGHTNING:
                System.out.println(element.getEffect() + " - Multiplier: " + element.getDamageMultiplier());
                break;
            case HOLY:
                System.out.println(element.getEffect() + " - Multiplier: " + element.getDamageMultiplier());
                break;
            case NONE:
                System.out.println(element.getEffect());
                break;
            default:
                System.out.println("Unknown element");
                break;
        }
    }
}

