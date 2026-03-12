// ============================================================================
// MODULE 4 VERSION - Element.java (ENUM)
// ============================================================================
// ⚠️ IMPORTANT: This file is specific to MODULE 4
//
// Module 4 Focus: ENUM for spell elements
// ============================================================================

/**
 * Element enum - MODULE 4 VERSION
 *
 * This ENUM demonstrates:
 * - Spell elements with different multipliers
 * - Using enum in switch statements
 * - Type-safe constants (no typos like "Fier" or "Iice")
 *
 * Used by Magical interface for spell casting.
 */
enum Element {
    FIRE(1.5, "Burns enemies"),
    ICE(1.3, "Freezes enemies"),
    LIGHTNING(1.8, "Shocks enemies"),
    HOLY(1.4, "Damages undead"),
    NONE(1.0, "No element");

    private final double damageMultiplier;  // FINAL - damage multiplier
    private final String effect;             // FINAL - description

    Element(double damageMultiplier, String effect) {
        this.damageMultiplier = damageMultiplier;
        this.effect = effect;
    }

    public double getDamageMultiplier() { return damageMultiplier; }
    public String getEffect() { return effect; }
}