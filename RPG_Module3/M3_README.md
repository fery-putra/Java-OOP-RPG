# Module 3: Material Explanation
## Inheritance, Constructor, Overriding, Overloading

---

## 📘 1. INHERITANCE (Pewarisan)

### What is Inheritance?
**Inheritance** is when a class (child) gets all the properties and methods from another class (parent). Think of it like a child inheriting traits from parents.

**Keyword:** `extends`

### Why Use Inheritance?
- **Code Reusability** - Don't write the same code again
- **Organization** - Group related classes
- **Polymorphism** - Treat different objects the same way

### In Our Code:

```java
// PARENT CLASS (Base class, Superclass)
public class Character {
    private String name;
    private int health;
    
    public void attack() {
        // Basic attack
    }
}

// CHILD CLASS (Derived class, Subclass)
public class Warrior extends Character {
    //            ↑ extends = inherit from
    
    private int armor;  // Warrior has everything from Character + armor
}
```

### Visual Representation:

```
┌─────────────────────┐
│    Character        │  ← Parent/Superclass
│                     │
│  - name             │
│  - health           │
│  + attack()         │
└──────────┬──────────┘
           │ extends
           │
    ┌──────┴───────────────────┐
    │                          │
┌───┴──────────┐    ┌─────────┴────┐
│   Warrior    │    │     Mage     │  ← Children/Subclasses
│              │    │              │
│  - armor     │    │  - mana      │
│  + shieldBash│    │  + fireball  │
└──────────────┘    └──────────────┘
```

### What Does the Child Inherit?

```java
public class Character {
    private String name;      // Inherited (but access via getter)
    private int health;       // Inherited (but access via getter)
    
    public String getName() { return name; }  // Inherited
    public void attack() { }                  // Inherited
}

public class Warrior extends Character {
    // Warrior automatically has:
    // - getName() method
    // - attack() method
    // Can use them without writing again!
}

// Usage:
Warrior warrior = new Warrior("Thor");
warrior.getName();  // ✓ Can use! Inherited from Character
warrior.attack();   // ✓ Can use! Inherited from Character
```

### Important Rules:

✓ **Child inherits all public/protected members**
```java
public class Character {
    public void publicMethod() { }      // ✓ Inherited
    protected void protectedMethod() { } // ✓ Inherited
    private void privateMethod() { }    // ✗ Not accessible directly
}
```

✓ **Java only allows single inheritance**
```java
public class Warrior extends Character { }  // ✓ OK
public class Warrior extends Character, Mage { }  // ✗ ERROR!
// Can only extend ONE class
```

---

## 📘 2. CONSTRUCTOR and SUPER

### What is a Constructor?
A **constructor** is a special method that runs when you create an object. It initializes the object.

**Rules:**
- Same name as class
- No return type (not even void)
- Called automatically when using `new`

### In Our Code:

```java
public class Character {
    private String name;
    private int maxHealth;
    
    // CONSTRUCTOR
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        System.out.println("Character constructor called");
    }
}
```

### The `super()` Keyword

When a child class is created, it MUST call the parent's constructor using `super()`.

```java
public class Warrior extends Character {
    private int armor;
    
    public Warrior(String name) {
        super(name, 150);  // Call Character's constructor
        //  ↑ MUST be first line in constructor!
        
        this.armor = 25;   // Then initialize Warrior's own stuff
    }
}
```

### What Happens When Creating a Warrior:

```java
Warrior warrior = new Warrior("Thorin");
```

**Execution flow:**
1. Warrior constructor starts
2. `super(name, 150)` - calls Character constructor
3. Character constructor runs - sets name and maxHealth
4. Returns to Warrior constructor
5. Sets armor = 25
6. Object creation complete

**Output:**
```
Character constructor called for: Thorin
Warrior constructor called - Armor set to 25
```

### Constructor Chaining with `this()`

You can call another constructor in the same class using `this()`:

```java
public class Character {
    
    // Constructor 1 - with both parameters
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
    }
    
    // Constructor 2 - with only name
    public Character(String name) {
        this(name, 100);  // Call constructor 1 with default health
        //  ↑ this() calls another constructor in same class
    }
}

// Usage:
Character c1 = new Character("Hero", 150);  // Calls constructor 1
Character c2 = new Character("Hero");       // Calls constructor 2
                                            // which calls constructor 1
```

### Constructor Overloading in Inheritance:

```java
public class Warrior extends Character {
    private int armor;
    
    // Constructor 1
    public Warrior(String name) {
        super(name, 150);
        this.armor = 25;
    }
    
    // Constructor 2 - Overloaded
    public Warrior(String name, int armor) {
        super(name, 150);
        this.armor = armor;  // Custom armor
    }
    
    // Constructor 3 - Overloaded
    public Warrior(String name, int armor, int maxHealth) {
        super(name, maxHealth);  // Custom health
        this.armor = armor;      // Custom armor
    }
}

// Usage:
Warrior w1 = new Warrior("Thor");           // Default armor
Warrior w2 = new Warrior("Odin", 35);       // Custom armor
Warrior w3 = new Warrior("Loki", 30, 130);  // Custom armor & health
```

---

## 📘 3. METHOD OVERRIDING

### What is Overriding?
**Overriding** means a child class provides its OWN implementation of a method that already exists in the parent class.

**Keyword:** `@Override` (optional but recommended)

### In Our Code:

```java
// PARENT
public class Character {
    public int attack() {
        return 10;  // Base damage
    }
}

// CHILD
public class Warrior extends Character {
    @Override  // Annotation (optional but good practice)
    public int attack() {
        return 20;  // Warriors do MORE damage!
    }
}

// Usage:
Character c = new Character();
c.attack();  // Returns 10

Warrior w = new Warrior("Thor");
w.attack();  // Returns 20 - uses Warrior's version!
```

### Interactive Battle Demonstrating Overriding:

```java
// USER INPUT - Battle turn
System.out.println("--- Your Turn ---");
System.out.println("1. Normal Attack");
System.out.println("2. Special Action");
System.out.print("Choose action: ");
int action = scanner.nextInt();

if (action == 1) {
    player.attack(enemy);  // OVERRIDDEN method
    // Warrior: 20 damage + "slashes with great force!"
    // Mage: 30 damage (if mana) + "casts fireball!"
    // Archer: 25 damage (if aiming) + "perfect shot!"
    
} else if (action == 2) {
    // DOWNCASTING to access special methods
    if (player instanceof Warrior) {
        Warrior w = (Warrior) player;
        w.shieldBash(enemy);  // Only Warriors have this!
        
    } else if (player instanceof Mage) {
        Mage m = (Mage) player;
        System.out.print("Enter mana to restore: ");
        int manaAmt = scanner.nextInt();
        m.restoreMana(manaAmt);  // Only Mages have this!
        
    } else if (player instanceof Archer) {
        Archer a = (Archer) player;
        a.aim();  // Only Archers have this!
        System.out.println("Next attack will be critical!");
    }
}
```

**Overriding Behavior Visible:** Each class type attacks differently!

**Downcasting Made Clear:** Students see when and why to cast down!

✓ **Can call parent's method using super**
```java
@Override
public void attack(Character target) {
    super.attack(target);  // Call parent's version first
    System.out.println("Extra warrior message!");
}
```

### Example from Code:

```java
public class Mage extends Character {
    private int mana;
    
    @Override
    public int attack() {
        if (mana >= 20) {
            mana -= 20;
            return 30;  // Powerful spell
        } else {
            return 5;   // Weak staff attack
        }
    }
}
```

**Different behavior:**
```java
Character c = new Character();
c.attack();  // Always returns 10

Mage m = new Mage("Gandalf");
m.attack();  // Returns 30 (with mana) or 5 (without mana)
```

### Calling Parent Method:

```java
public class Warrior extends Character {
    
    @Override
    public void attack(Character target) {
        super.attack(target);  // Do parent's attack first
        //  ↑ calls Character's attack()
        
        System.out.println(getName() + " slashes with great force!");
        // Add extra behavior
    }
}
```

### Common Override Examples:

```java
@Override
public void displayInfo() {
    super.displayInfo();  // Show Character info
    System.out.println("Armor: " + armor);  // Add Warrior info
}

@Override
public void takeDamage(int damage) {
    int blocked = armor / 2;
    int reducedDamage = damage - blocked;
    super.takeDamage(reducedDamage);  // Call parent with reduced damage
}
```

---

## 📘 4. METHOD OVERLOADING vs OVERRIDING

### 🧠 Vocabulary Check: Overloading vs. Overriding
These two terms sound similar but do very different things!

* **Overriding (What we did here!):** Changing the behavior of an *inherited* method.
    * *Example:* The base `Character` has an `attack()` method, but the `Mage` **overrides** it to shoot fireballs instead of punching. Same method name, same parameters, different behavior.
* **Overloading:** Having multiple methods in the *same class* with the same name, but different parameters.
    * *Example:* Having `attack()` (uses fists) and `attack(String weapon)` (uses a weapon). Same method name, different parameters.

### OVERLOADING
- **Same class** (or inherited)
- **Same method name**
- **Different parameters**
- Decided at **compile time**

```java
public class Warrior {
    // All in SAME class
    public int attack() { return 15; }
    public int attack(int bonus) { return 15 + bonus; }
    public int attack(String weapon) { return 20; }
}
```

### OVERRIDING
- **Parent and child classes**
- **Same method name**
- **Same parameters**
- Decided at **runtime**

```java
// PARENT
public class Character {
    public int attack() { return 10; }
}

// CHILD
public class Warrior extends Character {
    @Override
    public int attack() { return 20; }  // Override parent's method
}
```

### Side-by-Side Comparison:

| | OVERLOADING | OVERRIDING |
|---|-------------|------------|
| **Where** | Same class | Parent & child |
| **Parameters** | Different | Same |
| **Return type** | Can be different | Must be same |
| **Keyword** | None | @Override |
| **Purpose** | Multiple ways to call | Change parent behavior |

### Example with BOTH:

```java
public class Character {
    // Overloading in parent
    public int attack() { return 10; }
    public void attack(Character target) {
        target.takeDamage(attack());
    }
}

public class Warrior extends Character {
    // Overriding parent's methods
    @Override
    public int attack() { return 20; }
    
    @Override
    public void attack(Character target) {
        super.attack(target);
        System.out.println("Warrior special!");
    }
    
    // Overloading in child
    public int attack(String weapon) { return 25; }
}
```

**Usage:**
```java
Warrior w = new Warrior("Thor");

w.attack();           // Overridden - returns 20
w.attack(enemy);      // Overridden - calls parent + extra
w.attack("sword");    // Overloaded - new method
```

---

## 🎯 PUTTING IT ALL TOGETHER

### Complete Inheritance Example:

```java
// 1. PARENT CLASS
public class Character {
    private String name;
    private int health;
    
    // CONSTRUCTOR
    public Character(String name, int maxHealth) {
        this.name = name;
        this.health = maxHealth;
    }
    
    // CONSTRUCTOR OVERLOADING
    public Character(String name) {
        this(name, 100);  // Call other constructor
    }
    
    // METHOD
    public int attack() {
        return 10;
    }
    
    // METHOD OVERLOADING
    public void attack(Character target) {
        int damage = this.attack();
        target.takeDamage(damage);
    }
}

// 2. CHILD CLASS
public class Warrior extends Character {
    //            ↑ INHERITANCE
    
    private int armor;
    
    // CONSTRUCTOR with SUPER
    public Warrior(String name) {
        super(name, 150);  // Call parent constructor
        this.armor = 25;
    }
    
    // CONSTRUCTOR OVERLOADING
    public Warrior(String name, int armor) {
        super(name, 150);
        this.armor = armor;
    }
    
    // METHOD OVERRIDING
    @Override
    public int attack() {
        return 20;  // Different from parent's 10
    }
    
    // METHOD OVERRIDING with super
    @Override
    public void attack(Character target) {
        super.attack(target);  // Call parent's version
        System.out.println(getName() + " slashes!");  // Add extra
    }
    
    // METHOD OVERRIDING
    @Override
    public void takeDamage(int damage) {
        int blocked = armor / 2;
        int reduced = damage - blocked;
        System.out.println("Blocked " + blocked + " damage!");
        super.takeDamage(reduced);  // Call parent with reduced damage
    }
}

// 3. USAGE
public class Game {
    public static void main(String[] args) {
        // INHERITANCE - Warrior has everything from Character
        Warrior warrior = new Warrior("Thor");
        warrior.getName();    // ✓ Inherited from Character
        warrior.attack();     // ✓ Overridden - returns 20, not 10
        warrior.takeDamage(30);  // ✓ Overridden - reduces damage
    }
}
```

---

## 💡 KEY TAKEAWAYS

1. **Inheritance (`extends`)** - Child gets parent's properties/methods
2. **`super()`** - Call parent's constructor (MUST be first line)
3. **`this()`** - Call another constructor in same class
4. **Overriding** - Child changes parent's method (same signature)
5. **Overloading** - Multiple methods with same name (different params)
6. **@Override** - Annotation to mark overriding (optional but recommended)
7. **super.method()** - Call parent's version of method

---

## ❓ COMMON MISTAKES

### Mistake 1: Forgetting super()
```java
public class Warrior extends Character {
    public Warrior(String name) {
        // Missing super()!
        this.armor = 25;  // ✗ ERROR! Must call super() first
    }
}
```

### Mistake 2: super() not first
```java
public Warrior(String name) {
    this.armor = 25;
    super(name, 150);  // ✗ ERROR! super() must be FIRST
}
```

### Mistake 3: Confusing overriding and overloading
```java
// Parent
public int attack() { }

// Child - thinks this is overriding, but it's NOT!
public int attack(int bonus) { }  // ✗ Different params = OVERLOADING
```

### Mistake 4: Wrong @Override
```java
// Parent
public void attack() { }

// Child
@Override
public void atack() { }  // ✗ Typo! Not actually overriding
// @Override will show ERROR - good! Catches typos
```

---

## 🎓 PRACTICE EXERCISES

1. Create a `Rogue` class that extends `Character`
2. Give Rogue a `stealth` boolean attribute
3. Override `attack()` to do 2x damage when stealthed
4. Create constructor overloading for Rogue (with/without stealth)
5. Override `displayInfo()` to show stealth status

Good luck! 🚀
