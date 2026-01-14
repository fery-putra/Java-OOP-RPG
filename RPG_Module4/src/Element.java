enum Element {
    FIRE(1.5, "Burns enemies"),
    ICE(1.3, "Freezes enemies"),
    LIGHTNING(1.8, "Shocks enemies"),
    HOLY(1.4, "Damages undead"),
    NONE(1.0, "No element");

    private final double damageMultiplier;
    private final String effect;

    Element(double damageMultiplier, String effect) {
        this.damageMultiplier = damageMultiplier;
        this.effect = effect;
    }

    public double getDamageMultiplier() { return damageMultiplier; }
    public String getEffect() { return effect; }
}