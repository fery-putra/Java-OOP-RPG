# Module 5: Material Explanation
## Exception Handling, ArrayList Methods, Iterator, Enhanced For Loop

---

## 📘 1. EXCEPTION HANDLING - What is an Exception?

### What is an Exception?
An **exception** is an ERROR that happens while the program is running. Without handling it, the program CRASHES.

### Example Without Exception Handling:

```java
int[] numbers = {1, 2, 3};
System.out.println(numbers[10]);  // CRASH! ArrayIndexOutOfBoundsException
// Program stops here
System.out.println("This never prints");
```

**Output:**
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
	at Game.main(Game.java:5)
[Program crashed]
```

---

## 📘 2. TRY-CATCH

### What is Try-Catch?
**try-catch** lets you CATCH errors and handle them gracefully without crashing.

### Structure:

```java
try {
    // Code that might cause an error
} catch (ExceptionType e) {
    // What to do if error happens
}
```

### In Our Code:

```java
public static void executeBattle(Character attacker, Character defender) {
    try {
        attacker.attack(defender);  // Might throw exception
        System.out.println("✓ Attack successful!");
        
    } catch (CharacterDeadException e) {
        System.out.println("✗ Attack failed: " + e.getMessage());
        
    } catch (InvalidTargetException e) {
        System.out.println("✗ Invalid target: " + e.getMessage());
    }
}
```

### How It Works:

**Scenario 1 - No error:**
```java
try {
    warrior.attack(mage);  // Works fine
    System.out.println("Success!");  // This prints
} catch (CharacterDeadException e) {
    // Skipped - no error
}
// Program continues normally
```

**Scenario 2 - Error occurs:**
```java
try {
    deadWarrior.attack(mage);  // ERROR! Warrior is dead
    System.out.println("Success!");  // SKIPPED
} catch (CharacterDeadException e) {
    System.out.println("Error: " + e.getMessage());  // This prints
}
// Program continues without crashing!
```

---

## 📘 3. FINALLY Block

### What is Finally?
**finally** is a block that ALWAYS executes, whether there's an error or not.

### In Our Code:

```java
try {
    attacker.attack(defender);
    System.out.println("✓ Attack successful!");
} catch (CharacterDeadException e) {
    System.out.println("✗ Attack failed!");
} finally {
    // ALWAYS runs - error or not
    System.out.println("Turn ended.");
    attacker.displayInfo();
    defender.displayInfo();
}
```

### Interactive Exception Handling:

```java
// USER INPUT - Battle with exception handling
Scanner scanner = new Scanner(System.in);

System.out.println("Choose action:");
System.out.println("1. Attack");
System.out.println("2. Cast Spell");
System.out.print("Choice: ");
int action = scanner.nextInt();

// TRY-CATCH-FINALLY demonstration
try {
    if (action == 1) {
        hero.attack(enemy);
        System.out.println("✓ Attack successful!");
        
    } else if (action == 2) {
        System.out.print("Enter mana cost (10-50): ");
        int manaCost = scanner.nextInt();
        
        hero.castSpell(enemy, manaCost);
        System.out.println("✓ Spell cast successful!");
    }
    
} catch (CharacterDeadException e) {
    System.out.println("✗ Error: " + e.getMessage());
    // Example: "Thor is dead and cannot attack!"
    
} catch (InvalidTargetException e) {
    System.out.println("✗ Error: " + e.getMessage());
    // Example: "Goblin is already dead!"
    
} catch (InsufficientManaException e) {
    System.out.println("✗ Error: " + e.getMessage());
    // Example: "Not enough mana! Need: 30, Have: 20"
    
} finally {
    // ALWAYS executes
    System.out.println("\n--- After Action ---");
    hero.displayInfo();
    enemy.displayInfo();
}
```

**Interactive Learning:** Students trigger different exceptions by their choices!

### Scenario Examples:

**Scenario 1 - Success:**
```
User chooses: Attack
Hero is alive, enemy is alive
Output: ✓ Attack successful!
Finally block runs: Shows stats
```

**Scenario 2 - Dead Attacker:**
```
User chooses: Attack
Hero is dead
Throws: CharacterDeadException
Catch block runs: ✗ Error: Thor is dead!
Finally block runs: Shows stats
```

**Scenario 3 - Not Enough Mana:**
```
User chooses: Cast Spell
User enters: 50 (mana cost)
Hero only has: 20 mana
Throws: InsufficientManaException
Catch block runs: ✗ Error: Not enough mana!
Finally block runs: Shows stats
```

### Why Use Finally?

✓ **Cleanup code:**
```java
try {
    // Open file
    // Read file
} catch (IOException e) {
    // Handle error
} finally {
    // ALWAYS close file (even if error)
    file.close();
}
```

---

## 📘 4. THROWS Keyword

### What is Throws?
**throws** declares that a method MIGHT throw an exception. The caller must handle it.

### In Our Code:

```java
public void attack(Character target) 
        throws CharacterDeadException, InvalidTargetException {
    //      ↑ This method might throw these exceptions
    
    if (!this.isAlive()) {
        throw new CharacterDeadException("Dead!");
    }
    
    if (!target.isAlive()) {
        throw new InvalidTargetException("Target dead!");
    }
    
    // Normal attack code...
}
```

### Calling Method with throws:

```java
// Must handle the exception
try {
    warrior.attack(mage);  // Method throws exceptions
} catch (CharacterDeadException e) {
    System.out.println(e.getMessage());
} catch (InvalidTargetException e) {
    System.out.println(e.getMessage());
}
```

---

## 📘 5. THROW Keyword

### What is Throw?
**throw** actually CREATES and THROWS an exception.

### In Our Code:

```java
public void attack(Character target) throws CharacterDeadException {
    if (!this.isAlive()) {
        throw new CharacterDeadException("Character is dead!");
        //  ↑ Throw the exception
    }
    // If we reach here, character is alive
}
```

### Flow:

```java
public void castSpell(Character target, int manaCost) 
        throws InsufficientManaException {
    
    if (mana < manaCost) {
        throw new InsufficientManaException("Not enough mana!");
        // ↑ Execution stops here
        // ↓ This line never runs
    }
    
    // Only runs if enough mana
    mana -= manaCost;
}
```

---

## 📘 6. CUSTOM EXCEPTIONS

### What is a Custom Exception?
A **custom exception** is your own error type for specific situations.

### In Our Code:

```java
// Create custom exception
public class InsufficientManaException extends Exception {
    //                                     ↑ Must extend Exception
    
    public InsufficientManaException(String message) {
        super(message);  // Pass message to Exception class
    }
}
```

### Using Custom Exception:

```java
public void castSpell(int manaCost) throws InsufficientManaException {
    if (mana < manaCost) {
        throw new InsufficientManaException(
            "Not enough mana! Need: " + manaCost + ", Have: " + mana
        );
    }
    
    // Cast spell...
}

// Handling:
try {
    mage.castSpell(100);  // Only has 50 mana
} catch (InsufficientManaException e) {
    System.out.println(e.getMessage());
    // Output: "Not enough mana! Need: 100, Have: 50"
}
```

### All Custom Exceptions from Code:

```java
class InsufficientManaException extends Exception {
    public InsufficientManaException(String message) {
        super(message);
    }
}

class CharacterDeadException extends Exception {
    public CharacterDeadException(String message) {
        super(message);
    }
}

class InventoryFullException extends Exception {
    public InventoryFullException(String message) {
        super(message);
    }
}

class InvalidTargetException extends Exception {
    public InvalidTargetException(String message) {
        super(message);
    }
}
```

---

## 📘 7. ARRAYLIST - What is ArrayList?

### What is ArrayList?
**ArrayList** is a dynamic array that can grow and shrink. Unlike regular arrays, size is flexible!

### Regular Array vs ArrayList:

```java
// Regular array - FIXED size
int[] numbers = new int[5];  // Can only hold 5 items
numbers[5] = 10;  // ERROR! Can't add more

// ArrayList - DYNAMIC size
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(1);   // Size: 1
numbers.add(2);   // Size: 2
numbers.add(3);   // Size: 3
// Can keep adding!
```

### In Our Code:

```java
import java.util.ArrayList;  // Must import!

public class Party {
    private ArrayList<Character> members;
    //      ↑           ↑ Type of elements
    
    public Party() {
        members = new ArrayList<Character>();  // Create empty ArrayList
    }
}
```

---

## 📘 8. ARRAYLIST METHOD: ADD

### What is add()?
**add()** adds an element to the end of the ArrayList.

### In Our Code:

```java
ArrayList<Character> members = new ArrayList<>();

members.add(warrior);   // Add warrior
members.add(mage);      // Add mage
members.add(archer);    // Add archer

// ArrayList: [warrior, mage, archer]
```

### With Exception:

```java
public void addMember(Character character) throws InventoryFullException {
    if (members.size() >= maxSize) {
        throw new InventoryFullException("Party full!");
    }
    
    members.add(character);  // ADD method
}
```

**Visual:**
```
Before: [Warrior, Mage]
members.add(Archer)
After:  [Warrior, Mage, Archer]
         0        1      2
```

---

## 📘 9. ARRAYLIST METHOD: GET

### What is get()?
**get(index)** retrieves an element at a specific position.

### In Our Code:

```java
public Character getMemberAt(int index) {
    if (index >= 0 && index < members.size()) {
        return members.get(index);  // GET method
    }
    return null;
}
```

### Usage:

```java
ArrayList: [Warrior, Mage, Archer]
            0        1      2

Character first = members.get(0);   // Returns Warrior
Character second = members.get(1);  // Returns Mage
Character third = members.get(2);   // Returns Archer
```

---

## 📘 10. ARRAYLIST METHOD: SET

### What is set()?
**set(index, element)** REPLACES an element at a specific position.

### In Our Code:

```java
public void replaceMember(int index, Character newCharacter) {
    if (index >= 0 && index < members.size()) {
        Character old = members.get(index);
        members.set(index, newCharacter);  // SET method
        System.out.println(old.getName() + " replaced by " + 
                          newCharacter.getName());
    }
}
```

### Usage:

```java
Before: [Warrior, Mage, Archer]
         0        1      2

members.set(1, newMage);

After:  [Warrior, NewMage, Archer]
         0        1        2
```

**Note:** set() does NOT add, it REPLACES!

---

## 📘 11. ARRAYLIST METHOD: REMOVE

### What is remove()?
**remove(index)** removes an element and returns it.

### In Our Code:

```java
public boolean removeMemberAt(int index) {
    if (index >= 0 && index < members.size()) {
        Character removed = members.remove(index);  // REMOVE by index
        System.out.println(removed.getName() + " left the party!");
        return true;
    }
    return false;
}
```

### Usage:

```java
Before: [Warrior, Mage, Archer]
         0        1      2

Character removed = members.remove(1);  // Remove Mage

After:  [Warrior, Archer]
         0        1
         
// Elements shift left!
```

**Important:** After removing, indices change!

---

## 📘 12. ARRAYLIST METHOD: SIZE

### What is size()?
**size()** returns the number of elements in the ArrayList.

### In Our Code:

```java
public int getSize() {
    return members.size();  // SIZE method
}
```

### Interactive ArrayList Operations:

```java
// USER INPUT - Party Management Menu
Scanner scanner = new Scanner(System.in);
Party party = new Party("Heroes", 3);

System.out.println("=== Party Management ===");
System.out.println("1. Add Member (ArrayList.add)");
System.out.println("2. Remove Member (ArrayList.remove)");
System.out.println("3. View Member (ArrayList.get)");
System.out.println("4. Replace Member (ArrayList.set)");
System.out.println("5. Check Size (ArrayList.size)");
System.out.println("6. Check Empty (ArrayList.isEmpty)");
System.out.print("Choice: ");
int choice = scanner.nextInt();
scanner.nextLine();

try {
    switch (choice) {
        case 1:  // ADD
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter health: ");
            int health = scanner.nextInt();
            System.out.print("Enter mana: ");
            int mana = scanner.nextInt();
            
            Character newChar = new Character(name, health, mana);
            party.addMember(newChar);  // ArrayList.add()
            System.out.println("✓ Added! Size: " + party.getSize());
            break;
            
        case 2:  // REMOVE
            party.displayParty();
            System.out.print("Enter index (1-" + party.getSize() + "): ");
            int index = scanner.nextInt() - 1;
            party.removeMemberAt(index);  // ArrayList.remove()
            System.out.println("✓ Removed! New size: " + party.getSize());
            break;
            
        case 3:  // GET
            System.out.print("Enter index to view: ");
            int viewIndex = scanner.nextInt() - 1;
            Character c = party.getMemberAt(viewIndex);  // ArrayList.get()
            if (c != null) {
                c.displayInfo();
            }
            break;
            
        case 4:  // SET
            System.out.print("Enter index to replace: ");
            int replaceIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            System.out.print("Enter new character name: ");
            String newName = scanner.nextLine();
            Character replacement = new Character(newName, 100, 80);
            party.replaceMember(replaceIndex, replacement);  // ArrayList.set()
            System.out.println("✓ Replaced!");
            break;
            
        case 5:  // SIZE
            System.out.println("Party size: " + party.getSize());
            break;
            
        case 6:  // ISEMPTY
            System.out.println("Is empty: " + party.isEmpty());
            break;
    }
    
} catch (InventoryFullException e) {
    System.out.println("✗ " + e.getMessage());
}
```

**All ArrayList Methods Interactive:** Students choose which operation to test!

---

## 📘 13. ARRAYLIST METHOD: ISEMPTY

### What is isEmpty()?
**isEmpty()** returns true if ArrayList has no elements.

### In Our Code:

```java
public boolean isEmpty() {
    return members.isEmpty();  // ISEMPTY method
}
```

### Usage:

```java
ArrayList<Character> members = new ArrayList<>();

System.out.println(members.isEmpty());  // true (no elements)

members.add(warrior);
System.out.println(members.isEmpty());  // false (has 1 element)

members.remove(0);
System.out.println(members.isEmpty());  // true (empty again)
```

### In Conditional:

```java
if (members.isEmpty()) {
    System.out.println("Party is empty!");
} else {
    System.out.println("Party has " + members.size() + " members");
}
```

---

## 📘 14. ITERATOR

### What is Iterator?
**Iterator** is a tool to go through a collection and SAFELY remove elements.

**Why needed?** Can't use enhanced for loop to remove!

### The Problem:

```java
// DON'T DO THIS!
for (Character c : members) {
    if (c.getName().equals("Gandalf")) {
        members.remove(c);  // ✗ ERROR! ConcurrentModificationException
    }
}
```

### The Solution - Iterator:

```java
import java.util.Iterator;

Iterator<Character> iterator = members.iterator();
while (iterator.hasNext()) {
    Character c = iterator.next();
    if (c.getName().equals("Gandalf")) {
        iterator.remove();  // ✓ Safe removal
    }
}
```

### In Our Code:

```java
public boolean removeMember(String characterName) {
    Iterator<Character> iterator = members.iterator();
    //         ↑ Create iterator
    
    while (iterator.hasNext()) {
        //      ↑ Check if more elements
        
        Character c = iterator.next();
        //              ↑ Get next element
        
        if (c.getName().equals(characterName)) {
            iterator.remove();  // SAFE removal
            return true;
        }
    }
    return false;
}
```

### Iterator Methods:

| Method | Description |
|--------|-------------|
| `hasNext()` | Returns true if more elements exist |
| `next()` | Returns next element and moves forward |
| `remove()` | Safely removes current element |

---

## 📘 15. ENHANCED FOR LOOP

### What is Enhanced For Loop?
**Enhanced for loop** (or "for-each") is an easier way to iterate through collections.

### Syntax:

```java
for (Type variable : collection) {
    // Use variable
}
```

### In Our Code:

```java
public void displayParty() {
    for (Character c : members) {
        //    ↑         ↑
        // variable  collection
        
        c.displayInfo();  // Use c
    }
}
```

### Interactive Iterator Demonstration:

```java
// USER INPUT - Remove member by name using Iterator
party.displayParty();

System.out.print("Enter name to remove: ");
String removeName = scanner.nextLine();

// Using Iterator for SAFE removal
Iterator<Character> iterator = members.iterator();
boolean found = false;

while (iterator.hasNext()) {
    Character c = iterator.next();
    
    if (c.getName().equals(removeName)) {
        iterator.remove();  // Safe removal during iteration
        System.out.println("✓ Removed: " + removeName);
        found = true;
        break;
    }
}

if (!found) {
    System.out.println("✗ Not found: " + removeName);
}

party.displayParty();  // Show updated list
```

**Why Iterator?** Cannot use enhanced for loop to remove!

```java
// DON'T DO THIS - Will crash!
for (Character c : members) {
    if (c.getName().equals("Gandalf")) {
        members.remove(c);  // ✗ ConcurrentModificationException!
    }
}

// DO THIS - Use Iterator
Iterator<Character> it = members.iterator();
while (it.hasNext()) {
    Character c = it.next();
    if (c.getName().equals("Gandalf")) {
        it.remove();  // ✓ Safe!
    }
}
```

### Interactive Enhanced For Loop:

```java
// USER INPUT - Filter and display alive members
System.out.println("Show alive members only? (yes/no): ");
String filter = scanner.nextLine();

if (filter.equalsIgnoreCase("yes")) {
    System.out.println("\n=== Alive Members ===");
    
    // ENHANCED FOR LOOP - filtering
    for (Character c : members) {
        if (c.isAlive()) {
            c.displayInfo();
        }
    }
    
} else {
    System.out.println("\n=== All Members ===");
    
    // ENHANCED FOR LOOP - display all
    int index = 1;
    for (Character c : members) {
        System.out.print(index + ". ");
        c.displayInfo();
        index++;
    }
}

// ENHANCED FOR LOOP - Calculate total
System.out.println("\nCalculating total health...");
int total = 0;
for (Character c : members) {
    total += c.getHealth();
}
System.out.println("Total party health: " + total);
```

**Enhanced For Loop Uses:**
- ✓ Display all items
- ✓ Filter items (alive members)
- ✓ Sum values (total health)
- ✓ Search for items
- ✗ Cannot remove items (use Iterator)

**Displaying with counter:**
```java
public void displayInventory() {
    int index = 1;
    for (Item item : items) {  // Enhanced for
        System.out.println(index + ". " + item);
        index++;
    }
}
```

### Regular For vs Enhanced For:

```java
// Regular for loop
for (int i = 0; i < members.size(); i++) {
    Character c = members.get(i);
    c.displayInfo();
}

// Enhanced for loop (cleaner!)
for (Character c : members) {
    c.displayInfo();
}
```

### When NOT to Use Enhanced For:

❌ **Don't use when removing:**
```java
for (Character c : members) {
    members.remove(c);  // ERROR! Use Iterator instead
}
```

❌ **Don't use when need index:**
```java
// If you need index, use regular for or counter
for (int i = 0; i < members.size(); i++) {
    System.out.println("Member " + i + ": " + members.get(i).getName());
}
```

---

## 🎯 PUTTING IT ALL TOGETHER

### Complete Example from Code:

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Party {
    private ArrayList<Character> members;
    
    public Party() {
        members = new ArrayList<>();
    }
    
    // ADD
    public void addMember(Character c) throws InventoryFullException {
        if (members.size() >= maxSize) {
            throw new InventoryFullException("Full!");
        }
        members.add(c);  // ADD
    }
    
    // GET
    public Character getMemberAt(int index) {
        return members.get(index);  // GET
    }
    
    // SET
    public void replaceMember(int index, Character c) {
        members.set(index, c);  // SET
    }
    
    // REMOVE
    public void removeMemberAt(int index) {
        members.remove(index);  // REMOVE
    }
    
    // SIZE
    public int getSize() {
        return members.size();  // SIZE
    }
    
    // ISEMPTY
    public boolean isEmpty() {
        return members.isEmpty();  // ISEMPTY
    }
    
    // ITERATOR - Safe removal
    public boolean removeMember(String name) {
        Iterator<Character> it = members.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(name)) {
                it.remove();  // Safe!
                return true;
            }
        }
        return false;
    }
    
    // ENHANCED FOR - Display
    public void displayParty() {
        for (Character c : members) {
            c.displayInfo();
        }
    }
    
    // ENHANCED FOR - Filter
    public ArrayList<Character> getAliveMembers() {
        ArrayList<Character> alive = new ArrayList<>();
        for (Character c : members) {
            if (c.isAlive()) {
                alive.add(c);
            }
        }
        return alive;
    }
    
    // ENHANCED FOR - Sum
    public int getTotalHealth() {
        int total = 0;
        for (Character c : members) {
            total += c.getHealth();
        }
        return total;
    }
}

// EXCEPTION HANDLING
public static void main(String[] args) {
    Party party = new Party("Heroes", 3);
    
    try {
        party.addMember(new Character("Thor", 100, 50));
        party.addMember(new Character("Odin", 100, 50));
        
        Character thor = party.getMemberAt(0);
        thor.attack(enemy);
        
    } catch (InventoryFullException e) {
        System.out.println(e.getMessage());
    } catch (CharacterDeadException e) {
        System.out.println(e.getMessage());
    } finally {
        party.displayParty();
    }
}
```

---

## 💡 KEY TAKEAWAYS

1. **try-catch** = Handle errors without crashing
2. **finally** = Always executes
3. **throws** = Method declares exceptions
4. **throw** = Create and throw exception
5. **Custom Exception** = Your own error types
6. **ArrayList.add()** = Add element
7. **ArrayList.get()** = Get element by index
8. **ArrayList.set()** = Replace element
9. **ArrayList.remove()** = Remove element
10. **ArrayList.size()** = Get count
11. **ArrayList.isEmpty()** = Check if empty
12. **Iterator** = Safe removal while iterating
13. **Enhanced for** = Easy iteration

---

## ❓ COMMON MISTAKES

### Mistake 1: Removing during enhanced for
```java
for (Character c : members) {
    members.remove(c);  // ✗ ERROR! Use Iterator
}
```

### Mistake 2: Forgetting to import
```java
ArrayList<Character> members;  // ✗ ERROR! Need import
// ADD: import java.util.ArrayList;
```

### Mistake 3: Not handling exceptions
```java
party.addMember(hero);  // ✗ ERROR! Method throws exception
// Need try-catch!
```

### Mistake 4: Wrong ArrayList type
```java
ArrayList members = new ArrayList();  // ✗ No type specified
ArrayList<Character> members = new ArrayList<>();  // ✓ Correct
```

Good luck! 🚀
