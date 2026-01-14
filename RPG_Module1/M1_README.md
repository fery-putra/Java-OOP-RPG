# Module 1: Material Explanation
## Class, Method, Input, Output, Data Type, Condition, Switch Case, Loop

---

## 📘 1. CLASS (Kelas)

### What is a Class?
A **class** is a blueprint or template for creating objects. It's like a recipe that defines what properties (attributes) and behaviors (methods) an object will have.

### In Our Code:
```java
public class Hero {
    // This is a class named "Hero"
    // It defines what a hero is and what a hero can do
}
```

**Real-world analogy:** 
- Class = Cookie cutter (the template)
- Object = The actual cookie made from the cutter

### Example from Code:
```java
public class Hero {
    String name;
    int health;
    // ... attributes
}

// Creating an object from the class:
Hero hero = new Hero();  // 'hero' is an object of class Hero
```

---

## 📘 2. METHOD (Metode)

### What is a Method?
A **method** is a function inside a class that defines what an object can DO. It's the behavior or action.

### In Our Code:
```java
public void setHeroData(String name, int health, int mana) {
    this.name = name;
    this.health = health;
    this.mana = mana;
    // This method SETS the hero's data
}

public void displayInfo() {
    System.out.println("Name: " + name);
    // This method DISPLAYS information
}

public int attack() {
    return damage;
    // This method ATTACKS and RETURNS damage value
}
```

### Method Components:
1. **Return Type:** What the method gives back (`void`, `int`, `String`, etc.)
2. **Method Name:** What we call it (`attack`, `rest`, etc.)
3. **Parameters:** What we give to it (inputs)
4. **Method Body:** What it does (the code inside)

**Example:**
```java
public int attack() {
    //  ↑     ↑
    // type  name
    
    if (mana >= 10) {
        return 31;  // Returns an integer
    }
}
```

---

## 📘 3. INPUT (Scanner)

### What is Input?
**Input** is data that we receive FROM the user while the program is running.

### In Our Code:
```java
import java.util.Scanner;  // MUST import Scanner

Scanner scanner = new Scanner(System.in);  // Create scanner object

System.out.print("Enter hero name: ");
String heroName = scanner.nextLine();  // READ INPUT from user
```

### Scanner Methods:
| Method | Reads | Example |
|--------|-------|---------|
| `nextLine()` | String (whole line) | "Aragorn" |
| `nextInt()` | Integer | 100 |
| `nextDouble()` | Double | 15.5 |
| `next()` | String (one word) | "Fire" |

### Example Flow:
```
Program: Enter hero name: 
User types: Aragorn
Program stores: heroName = "Aragorn"
```

---

## 📘 4. OUTPUT (System.out)

### What is Output?
**Output** is data that we SHOW to the user on the screen.

### In Our Code:
```java
// Simple output
System.out.println("Hello!");  // Prints and goes to new line

// Output with variables
System.out.println("Hero: " + name);

// Formatted output
System.out.println("HP: " + health + " | Mana: " + mana);
```

### Output Examples:
```java
String name = "Aragorn";
int health = 100;

System.out.println(name);  
// Output: Aragorn

System.out.println("Name: " + name);  
// Output: Name: Aragorn

System.out.println("HP: " + health + "/100");  
// Output: HP: 100/100
```

---

## 📘 5. DATA TYPES (Tipe Data)

### What are Data Types?
**Data types** define what KIND of data a variable can store.

### In Our Code:
```java
String name;           // Text/words
int health;            // Whole numbers
int mana;              // Whole numbers
boolean isAlive;       // true or false
double attackPower;    // Decimal numbers
char rank;             // Single character
```

### Common Data Types:

| Type | Stores | Example | Size |
|------|--------|---------|------|
| `int` | Whole numbers | 100, -5, 0 | 4 bytes |
| `double` | Decimals | 15.5, 3.14 | 8 bytes |
| `String` | Text | "Aragorn" | variable |
| `boolean` | true/false | true, false | 1 bit |
| `char` | Single character | 'A', 'S' | 2 bytes |

### Example from Code:
```java
String name = "Aragorn";        // Text
int health = 100;               // Integer
double attackPower = 15.5;      // Decimal
boolean isAlive = true;         // Boolean
char rank = 'S';                // Character (single quotes!)
```

**Important:** 
- String uses `"double quotes"`
- char uses `'single quotes'`

---

## 📘 6. CONDITION (If-Else)

### What is a Condition?
A **condition** lets the program make decisions and do different things based on whether something is true or false.

### In Our Code:
```java
public int attack() {
    if (mana >= 10) {
        // If TRUE: mana is enough
        int damage = (int)(attackPower * 2);
        mana -= 10;
        return damage;
    } else {
        // If FALSE: not enough mana
        return (int)attackPower;
    }
}
```

### Condition Structure:
```java
if (condition) {
    // Do this if TRUE
} else {
    // Do this if FALSE
}
```

### Comparison Operators:
| Operator | Meaning | Example |
|----------|---------|---------|
| `==` | Equal to | `health == 100` |
| `!=` | Not equal | `health != 0` |
| `>` | Greater than | `mana > 10` |
| `<` | Less than | `health < 50` |
| `>=` | Greater or equal | `mana >= 10` |
| `<=` | Less or equal | `health <= 0` |

### Real Example:
```java
public void takeDamage(int damage) {
    health -= damage;
    
    if (health <= 0) {          // CONDITION
        health = 0;
        isAlive = false;
        System.out.println(name + " has been defeated!");
    }
}
```

**Flow:**
1. Reduce health by damage
2. Check: Is health <= 0?
3. If YES: Set health to 0, set isAlive to false, print message
4. If NO: Do nothing, continue

---

## 📘 7. SWITCH CASE

### What is Switch Case?
**Switch case** is used when you have MULTIPLE choices and want to do different things based on a value. It's cleaner than many if-else statements.

### In Our Code:
```java
public void useSkill(int skillNumber) {
    switch (skillNumber) {       // Check the value of skillNumber
        case 1:                  // If skillNumber is 1
            System.out.println("SLASH!");
            break;               // Exit switch
        case 2:                  // If skillNumber is 2
            System.out.println("FIREBALL!");
            break;
        case 3:                  // If skillNumber is 3
            System.out.println("HEAL!");
            break;
        default:                 // If none of the above
            System.out.println("Invalid skill!");
            break;
    }
}
```

### Switch vs If-Else:

**Using If-Else (verbose):**
```java
if (skillNumber == 1) {
    System.out.println("SLASH!");
} else if (skillNumber == 2) {
    System.out.println("FIREBALL!");
} else if (skillNumber == 3) {
    System.out.println("HEAL!");
} else {
    System.out.println("Invalid!");
}
```

**Using Switch (cleaner):**
```java
switch (skillNumber) {
    case 1: System.out.println("SLASH!"); break;
    case 2: System.out.println("FIREBALL!"); break;
    case 3: System.out.println("HEAL!"); break;
    default: System.out.println("Invalid!"); break;
}
```

### Important Rules:
1. Must have `break;` or cases will "fall through"
2. `default:` is optional (like final `else`)
3. Can only switch on: int, char, String, enum

### Example with Multiple Cases:
```java
public void promoteRank(int level) {
    switch (level) {
        case 1:
        case 2:
        case 3:
            rank = 'D';  // Levels 1-3 get rank D
            break;
        case 4:
        case 5:
        case 6:
            rank = 'C';  // Levels 4-6 get rank C
            break;
        case 7:
        case 8:
            rank = 'B';  // Levels 7-8 get rank B
            break;
        case 9:
            rank = 'A';  // Level 9 gets rank A
            break;
        case 10:
            rank = 'S';  // Level 10 gets rank S
            break;
        default:
            rank = 'F';  // Other levels get rank F
            break;
    }
}
```

---

## 📘 8. LOOP (Perulangan)

### What is a Loop?
A **loop** repeats code multiple times without writing it again and again.

### FOR LOOP

Used when you know HOW MANY times to repeat.

**In Our Code:**
```java
public void rest() {
    for (int i = 1; i <= 4; i++) {
        //    ↑start  ↑condition  ↑increment
        
        mana += 5;
        System.out.println("Rest phase " + i);
    }
}
```

**How it works:**
1. Start: `i = 1`
2. Check: Is `i <= 4`? If yes, run code
3. Run the code inside { }
4. Increment: `i++` (increase i by 1)
5. Repeat from step 2

**Execution:**
```
Loop 1: i = 1, mana += 5, print "Rest phase 1"
Loop 2: i = 2, mana += 5, print "Rest phase 2"
Loop 3: i = 3, mana += 5, print "Rest phase 3"
Loop 4: i = 4, mana += 5, print "Rest phase 4"
Stop: i = 5, condition false (5 <= 4 is false)
```

### WHILE LOOP

Used when you DON'T know how many times, but have a CONDITION.

**In Our Code:**
```java
public void practice() {
    int attackCount = 1;
    
    while (attackCount <= 5) {  // Keep going while condition is true
        int damage = (int)attackPower;
        System.out.println("Training attack " + attackCount);
        attackCount++;  // MUST increment or infinite loop!
    }
}
```

**How it works:**
1. Check condition: Is `attackCount <= 5`?
2. If TRUE: Run code inside { }
3. Repeat from step 1
4. If FALSE: Stop loop

**Battle Loop Example:**
```java
int round = 1;
while (hero.isAlive && goblin.isAlive()) {
    // Keep fighting while BOTH are alive
    
    hero.attack(goblin);
    goblin.attack(hero);
    
    round++;
}
```

This loop continues UNTIL one of them dies.

### Loop Comparison:

| Loop Type | When to Use | Example |
|-----------|-------------|---------|
| **for** | Know exact count | "Rest 4 times" |
| **while** | Unknown count, has condition | "Fight until someone dies" |

### Common Loop Patterns:

**Count up:**
```java
for (int i = 1; i <= 5; i++) {
    // Runs 5 times: 1, 2, 3, 4, 5
}
```

**Count down:**
```java
for (int i = 5; i >= 1; i--) {
    // Runs 5 times: 5, 4, 3, 2, 1
}
```

**Infinite loop (dangerous!):**
```java
while (true) {
    // Never stops! Need 'break' to exit
}
```

**Safe loop with limit:**
```java
int round = 1;
while (hero.isAlive && goblin.isAlive()) {
    // ... battle code ...
    
    round++;
    
    if (round > 20) {
        System.out.println("Battle timeout!");
        break;  // Exit loop after 20 rounds
    }
}
```

---

## 🎯 PUTTING IT ALL TOGETHER

### Complete Example from Code:

```java
public static void main(String[] args) {
    // 1. INPUT
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter hero name: ");
    String heroName = scanner.nextLine();
    
    // 2. CREATE OBJECT (Class)
    Hero hero = new Hero();
    
    // 3. CALL METHOD
    hero.setHeroData(heroName, 100, 50);
    
    // 4. OUTPUT
    hero.displayInfo();
    
    // 5. SWITCH CASE
    System.out.print("Choose skill (1-3): ");
    int skillChoice = scanner.nextInt();
    
    switch (skillChoice) {
        case 1: hero.useSkill(1); break;
        case 2: hero.useSkill(2); break;
        case 3: hero.useSkill(3); break;
        default: System.out.println("Invalid"); break;
    }
    
    // 6. FOR LOOP
    hero.practice();  // Loops 5 times
    
    // 7. WHILE LOOP + CONDITION
    Monster goblin = new Monster();
    goblin.setMonsterData("Goblin", 40, 8);
    
    while (hero.isAlive && goblin.isAlive()) {  // CONDITION
        int heroDamage = hero.attack();
        goblin.takeDamage(heroDamage);
        
        if (!goblin.isAlive()) {  // CONDITION
            System.out.println("Victory!");
            break;
        }
        
        // Goblin attacks back...
    }
}
```

---

## 💡 KEY TAKEAWAYS

1. **Class** = Blueprint for objects (Hero, Monster)
2. **Method** = Actions objects can perform (attack, rest)
3. **Input** = Get data from user (Scanner)
4. **Output** = Show data to user (println)
5. **Data Types** = int, double, String, boolean, char
6. **Condition** = Make decisions (if-else)
7. **Switch** = Multiple choices (cleaner than many if-else)
8. **Loop** = Repeat code (for = count, while = condition)

---

## ❓ COMMON MISTAKES

### Mistake 1: Forgetting break in switch
```java
switch (x) {
    case 1:
        System.out.println("One");
        // Missing break! Will continue to case 2!
    case 2:
        System.out.println("Two");
        break;
}
// If x=1, prints BOTH "One" and "Two"!
```

### Mistake 2: Infinite loop
```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    // Forgot i++; - loops forever!
}
```

### Mistake 3: Wrong quotes
```java
String name = "Aragorn";   // ✓ Correct
char rank = 'S';           // ✓ Correct

String name = 'Aragorn';   // ✗ Wrong! String needs "
char rank = "S";           // ✗ Wrong! char needs '
```

### Mistake 4: Scanner input mismatch
```java
Scanner sc = new Scanner(System.in);
int age = sc.nextInt();     // Reads number
String name = sc.nextLine(); // Reads empty line!

// FIX:
int age = sc.nextInt();
sc.nextLine();  // Clear the newline
String name = sc.nextLine();  // Now works!
```

---

## 🎓 PRACTICE EXERCISES

Try modifying the code to:

1. Add a new skill (case 4) in the switch statement
2. Create a loop that attacks 10 times instead of 5
3. Add a new data type: `float defense = 12.5f;`
4. Create an input for monster health
5. Add a condition to check if health is below 30 (low health warning)

Good luck! 🚀
