# Module 2: Material Explanation
## Encapsulation (public, protected, private), Method Overloading, Getter/Setter, Static

---

## 📘 1. ENCAPSULATION (Enkapsulasi)

### What is Encapsulation?
**Encapsulation** means HIDING data inside a class and controlling access to it. Think of it like a capsule - the contents are protected inside.

**Why?** To protect data from being changed incorrectly from outside.

### The Three Access Modifiers:

```java
public class Warrior {
    private String name;      // PRIVATE - only this class
    protected int armor;      // PROTECTED - this class + subclasses
    public int level;         // PUBLIC - everyone
}
```

### Visual Representation:

```
┌─────────────────────────────┐
│    Warrior Class            │
│                             │
│  🔴 private String name     │ ← Only inside Warrior
│  🟡 protected int armor     │ ← Warrior + child classes
│  🟢 public int level        │ ← Anywhere!
│                             │
└─────────────────────────────┘
```

### In Our Code - What CAN and CANNOT be accessed:

```java
// Inside Game.java
Warrior warrior = new Warrior("Thorin");

// ✓ CAN access public
System.out.println(warrior.level);  // OK!
warrior.level = 5;                  // OK!

// ✗ CANNOT access private
System.out.println(warrior.name);   // ERROR! Compile error
warrior.name = "Thor";              // ERROR! Compile error

// ✓ CAN access protected (in same package)
System.out.println(warrior.armor);  // OK in same package

// ✓ MUST use methods for private
System.out.println(warrior.getName());  // OK! Using getter
warrior.setName("Thor");                // OK! Using setter
```

### Why Use Private?

**Without encapsulation (bad):**
```java
public class Warrior {
    public int health;
    public int maxHealth;
}

// In main:
Warrior w = new Warrior();
w.health = 999999;     // Cheating! Can set any value
w.maxHealth = -50;     // Nonsense! Negative max health
```

**With encapsulation (good):**
```java
public class Warrior {
    private int health;
    private int maxHealth;
    
    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;  // Can't exceed max
        } else if (health < 0) {
            this.health = 0;          // Can't be negative
        } else {
            this.health = health;
        }
    }
}

// In main:
Warrior w = new Warrior();
w.setHealth(999999);   // Automatically corrected to maxHealth
w.setHealth(-50);      // Automatically set to 0
```

**Benefit:** Data is VALIDATED before being set!

---

## 📘 2. GETTER and SETTER Methods

### What are Getters and Setters?
- **Getter** = Method to READ private data (get the value)
- **Setter** = Method to WRITE private data (set the value)

### Pattern:

```java
private int health;  // Private attribute

// GETTER - returns the value
public int getHealth() {
    return health;
}

// SETTER - sets the value
public void setHealth(int health) {
    this.health = health;
}
```

### In Our Code:

```java
public class Warrior {
    private String name;     // Can't access directly
    
    // GETTER
    public String getName() {
        return name;
    }
    
    // SETTER with VALIDATION
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty!");
        }
    }
}
```

### Why Not Just Make It Public?

**Public (no control):**
```java
public String name;

// In main:
warrior.name = "";        // Empty name allowed!
warrior.name = null;      // Null allowed! Could crash program
```

**Getter/Setter (with control):**
```java
private String name;

public void setName(String name) {
    if (name != null && !name.isEmpty()) {
        this.name = name;
    } else {
        System.out.println("Error: Name cannot be empty!");
    }
}

// In main:
warrior.setName("");      // Rejected! Error message shown
warrior.setName(null);    // Rejected! Error message shown
warrior.setName("Thor");  // Accepted! Valid name
```

### Getter/Setter Examples from Code:

```java
// Simple getter (just return)
public int getArmor() {
    return armor;
}

// Setter with range validation
public void setArmor(int armor) {
    if (armor >= 0 && armor <= 50) {
        this.armor = armor;
        System.out.println("Armor set to " + armor);
    } else {
        System.out.println("Error: Armor must be between 0 and 50!");
    }
}

// Usage:
warrior.setArmor(30);   // ✓ OK - "Armor set to 30"
warrior.setArmor(100);  // ✗ Error - "Armor must be between 0 and 50!"
```

---

## 📘 3. METHOD OVERLOADING

### What is Method Overloading?
**Method overloading** means having MULTIPLE methods with the SAME NAME but DIFFERENT PARAMETERS.

**Key Rule:** Same name, different parameters (number or type).

### In Our Code:

```java
// Version 1: No parameters
public int attack() {
    return 15;
}

// Version 2: One int parameter
public int attack(int bonusDamage) {
    return 15 + bonusDamage;
}

// Version 3: One String parameter
public int attack(String weaponType) {
    if (weaponType.equals("sword")) {
        return 20;
    } else if (weaponType.equals("axe")) {
        return 25;
    } else {
        return 15;
    }
}

// Version 4: String AND int parameters
public int attack(String weaponType, int bonusDamage) {
    int baseDamage = attack(weaponType);  // Call version 3
    return baseDamage + bonusDamage;
}
```

### How Java Chooses Which Method:

```java
warrior.attack();              // Calls version 1 (no params)
warrior.attack(10);            // Calls version 2 (int param)
warrior.attack("sword");       // Calls version 3 (String param)
warrior.attack("axe", 5);      // Calls version 4 (String + int)
```

Java looks at:
1. **Number of parameters** - 0, 1, or 2?
2. **Type of parameters** - int or String?

### Real-World Example from Code:

```java
public class Party {
    
    // Version 1: Add existing warrior object
    public void addWarrior(Warrior w) {
        warrior1 = w;
        System.out.println(w.getName() + " joined!");
    }
    
    // Version 2: Create new warrior from name
    public void addWarrior(String name) {
        Warrior newWarrior = new Warrior(name);
        addWarrior(newWarrior);  // Call version 1
    }
    
    // Version 3: Create warrior with name and armor
    public void addWarrior(String name, int armor) {
        Warrior newWarrior = new Warrior(name);
        newWarrior.setArmor(armor);
        addWarrior(newWarrior);  // Call version 1
    }
}

// Usage:
Party party = new Party("Heroes");

Warrior thorin = new Warrior("Thorin");
party.addWarrior(thorin);           // Version 1

party.addWarrior("Aragorn");        // Version 2

party.addWarrior("Legolas", 15);    // Version 3
```

### Why Use Overloading?

**Without overloading (confusing):**
```java
public int attackNormal()
public int attackWithBonus(int bonus)
public int attackWithWeapon(String weapon)
public int attackWithWeaponAndBonus(String weapon, int bonus)

// Usage - hard to remember names!
warrior.attackNormal();
warrior.attackWithBonus(10);
```

**With overloading (clean):**
```java
public int attack()
public int attack(int bonus)
public int attack(String weapon)
public int attack(String weapon, int bonus)

// Usage - easy! Same name!
warrior.attack();
warrior.attack(10);
```

### Rules for Overloading:

✓ **Valid - Different number of parameters:**
```java
void method()
void method(int x)
void method(int x, int y)
```

✓ **Valid - Different types of parameters:**
```java
void method(int x)
void method(String x)
void method(double x)
```

✗ **Invalid - Only return type different:**
```java
int method()
void method()  // ERROR! Same parameters
```

✗ **Invalid - Only parameter names different:**
```java
void method(int x)
void method(int y)  // ERROR! Same type and number
```

---

## 📘 4. STATIC ATTRIBUTES

### What is Static?
**Static** means the variable belongs to the CLASS, not to individual objects. ALL objects share the same value.

### In Our Code:

```java
public class Warrior {
    private String name;              // Each warrior has own name
    private static int totalWarriors = 0;  // Shared by ALL warriors
    
    public Warrior(String name) {
        this.name = name;
        totalWarriors++;  // Increment shared counter
    }
}
```

### Visual Representation:

```
Individual (non-static):
┌─────────────┐  ┌─────────────┐  ┌─────────────┐
│ Warrior 1   │  │ Warrior 2   │  │ Warrior 3   │
│ name:"Thor" │  │ name:"Odin" │  │ name:"Loki" │
└─────────────┘  └─────────────┘  └─────────────┘

Shared (static):
┌───────────────────────────────────────┐
│    totalWarriors = 3                  │
│    (shared by all Warrior objects)    │
└───────────────────────────────────────┘
```

### Example:

```java
Warrior w1 = new Warrior("Thorin");  // totalWarriors = 1
Warrior w2 = new Warrior("Gimli");   // totalWarriors = 2
Warrior w3 = new Warrior("Boromir"); // totalWarriors = 3

System.out.println(w1.getName());  // "Thorin" (individual)
System.out.println(w2.getName());  // "Gimli" (individual)

// All warriors share the same totalWarriors
System.out.println(Warrior.getTotalWarriors());  // 3
```

### Static vs Non-Static:

| | Non-Static | Static |
|---|------------|--------|
| **Belongs to** | Each object | The class |
| **Access via** | `object.variable` | `ClassName.variable` |
| **Memory** | Created for each object | Only ONE copy |
| **Example** | `warrior.name` | `Warrior.totalWarriors` |

---

## 📘 5. STATIC FINAL

### What is Static Final?
**Static final** = A constant that belongs to the class and CANNOT be changed.

### In Our Code:

```java
public class Warrior {
    private static final int HEALTH_PER_LEVEL = 20;
    //       ↑      ↑
    //    static  final
    
    // static = belongs to class
    // final = cannot change
}
```

### Usage:

```java
public void levelUp() {
    level++;
    maxHealth += HEALTH_PER_LEVEL;  // Use the constant
}
```

### Why Static Final?

```java
// Without constant (bad - magic number):
public void levelUp() {
    maxHealth += 20;  // What is 20? Why 20?
}

// With constant (good - meaningful name):
public void levelUp() {
    maxHealth += HEALTH_PER_LEVEL;  // Clear meaning!
}

// Try to change it:
HEALTH_PER_LEVEL = 30;  // ERROR! Cannot change final
```

### Naming Convention:
Static final constants use UPPERCASE_WITH_UNDERSCORES:
```java
private static final int MAX_HEALTH = 200;
private static final int MIN_DAMAGE = 1;
private static final String GAME_NAME = "RPG";
```

---

## 📘 6. STATIC METHODS

### What is a Static Method?
A **static method** belongs to the CLASS, not to objects. You can call it WITHOUT creating an object.

### In Our Code:

```java
public class Warrior {
    private static int totalWarriors = 0;
    
    // STATIC METHOD
    public static int getTotalWarriors() {
        return totalWarriors;
    }
    
    // STATIC METHOD
    public static Warrior compareWarriors(Warrior w1, Warrior w2) {
        if (w1.getLevel() >= w2.getLevel()) {
            return w1;
        } else {
            return w2;
        }
    }
}
```

### Calling Static Methods:

```java
// Don't need to create object!
int total = Warrior.getTotalWarriors();
//          ↑ClassName.methodName

// Compare two warriors
Warrior w1 = new Warrior("Thor");
Warrior w2 = new Warrior("Odin");
Warrior stronger = Warrior.compareWarriors(w1, w2);
//                 ↑ ClassName.methodName
```

### Static vs Non-Static Methods:

| | Non-Static Method | Static Method |
|---|-------------------|---------------|
| **Call via** | `object.method()` | `ClassName.method()` |
| **Access to** | Can access everything | Only static things |
| **Need object?** | Yes | No |

### Example:

```java
public class Warrior {
    private String name;               // Non-static
    private static int totalWarriors;  // Static
    
    // NON-STATIC method
    public void displayInfo() {
        System.out.println(name);           // ✓ Can access name
        System.out.println(totalWarriors);  // ✓ Can access totalWarriors
    }
    
    // STATIC method
    public static void printTotal() {
        // System.out.println(name);        // ✗ ERROR! Can't access non-static
        System.out.println(totalWarriors);  // ✓ Can access static
    }
}
```

---

## 🎯 PUTTING IT ALL TOGETHER

### Complete Example from Code:

```java
public class Warrior {
    // ENCAPSULATION - Different access levels
    private String name;         // Private - most restricted
    protected int armor;         // Protected - moderate
    public int level;           // Public - least restricted
    
    // STATIC - Shared by all
    private static int totalWarriors = 0;
    private static final int HEALTH_PER_LEVEL = 20;  // Constant
    
    // Constructor
    public Warrior(String name) {
        this.name = name;
        this.armor = 20;
        this.level = 1;
        totalWarriors++;  // Increment shared counter
    }
    
    // GETTER
    public String getName() {
        return name;
    }
    
    // SETTER with validation
    public void setArmor(int armor) {
        if (armor >= 0 && armor <= 50) {
            this.armor = armor;
        } else {
            System.out.println("Error!");
        }
    }
    
    // METHOD OVERLOADING - 4 versions
    public int attack() { return 15; }
    public int attack(int bonus) { return 15 + bonus; }
    public int attack(String weapon) { 
        return weapon.equals("sword") ? 20 : 15; 
    }
    public int attack(String weapon, int bonus) { 
        return attack(weapon) + bonus; 
    }
    
    // STATIC METHOD
    public static int getTotalWarriors() {
        return totalWarriors;
    }
}

// Usage:
public class Game {
    public static void main(String[] args) {
        Warrior w = new Warrior("Thor");
        
        // Public - direct access
        w.level = 5;  // ✓ OK
        System.out.println(w.level);  // ✓ OK
        
        // Private - must use getter/setter
        // w.name = "Odin";  // ✗ ERROR
        w.setName("Odin");  // ✓ OK - setter
        System.out.println(w.getName());  // ✓ OK - getter
        
        // Method overloading
        System.out.println(w.attack());          // 15
        System.out.println(w.attack(10));        // 25
        System.out.println(w.attack("sword"));   // 20
        System.out.println(w.attack("axe", 5));  // 30
        
        // Static method - no object needed
        System.out.println(Warrior.getTotalWarriors());
    }
}
```

---

## 💡 KEY TAKEAWAYS

1. **Private** = Hidden, only in this class
2. **Protected** = This class + child classes
3. **Public** = Accessible everywhere
4. **Getter** = Read private data (getName())
5. **Setter** = Write private data with validation
6. **Method Overloading** = Same name, different parameters
7. **Static** = Belongs to class, shared by all objects
8. **Static Final** = Class constant that can't change

---

## ❓ COMMON MISTAKES

### Mistake 1: Accessing private directly
```java
Warrior w = new Warrior("Thor");
System.out.println(w.name);  // ✗ ERROR! private
System.out.println(w.getName());  // ✓ Correct
```

### Mistake 2: Overloading only with return type
```java
public int attack() { }
public void attack() { }  // ✗ ERROR! Same parameters
```

### Mistake 3: Accessing non-static from static
```java
private String name;

public static void method() {
    System.out.println(name);  // ✗ ERROR! Can't access non-static
}
```

### Mistake 4: Trying to change final
```java
private static final int MAX = 100;
MAX = 200;  // ✗ ERROR! Cannot change final
```

---

## 🎓 PRACTICE EXERCISES

1. Add a private `int experience` with getter/setter (validate: 0-1000)
2. Create overloaded constructors for Warrior
3. Add static variable `totalBattles` and increment it
4. Create static method `getAverageLevel()` for all warriors
5. Make a protected variable and test accessing it

Good luck! 🚀
