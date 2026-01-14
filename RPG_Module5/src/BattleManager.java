class BattleManager {

    // TRY-CATCH-FINALLY demonstration
    public static void executeBattle(Character attacker, Character defender) {
        System.out.println("\n--- Battle Turn ---");
        try {
            attacker.attack(defender);
            System.out.println("✓ Attack successful!");

        } catch (CharacterDeadException e) {
            System.out.println("✗ Attack failed: " + e.getMessage());

        } catch (InvalidTargetException e) {
            System.out.println("✗ Invalid target: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Turn ended.");
            attacker.displayInfo();
            defender.displayInfo();
        }
    }

    // TRY-CATCH with multiple exception types
    public static void executeSpellCast(Character caster, Character target, int manaCost) {
        System.out.println("\n--- Spell Cast ---");
        try {
            caster.castSpell(target, manaCost);
            System.out.println("✓ Spell cast successful!");

        } catch (CharacterDeadException e) {
            System.out.println("✗ " + e.getMessage());

        } catch (InvalidTargetException e) {
            System.out.println("✗ " + e.getMessage());

        } catch (InsufficientManaException e) {
            System.out.println("✗ " + e.getMessage());

        } finally {
            System.out.println("Cast ended.");
        }
    }

    // TRY-CATCH for healing
    public static void attemptHealing(Character character, int amount) {
        System.out.println("\n--- Healing Attempt ---");
        try {
            character.heal(amount);
            System.out.println("✓ Healing successful!");

        } catch (CharacterDeadException e) {
            System.out.println("✗ " + e.getMessage());

        } finally {
            character.displayInfo();
        }
    }
}