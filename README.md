# 🎮 RPG Learning Project - Java OOP Fundamentals

**A Progressive, Hands-On Java Learning Experience Through RPG Game Development**

---

## 📚 **Project Overview**

This is a comprehensive Java programming tutorial project designed to teach Object-Oriented Programming (OOP) concepts through the development of a text-based RPG game. The project is structured into **5 progressive modules**, each building upon the previous one and introducing new Java concepts in an interactive, practical way.

### **Target Audience**
- **Beginner Java programmers** learning OOP concepts
- **Students** taking introductory programming courses
- **Self-learners** who prefer hands-on, project-based learning

### **Learning Approach**
- ✅ **Interactive**: User input drives the examples
- ✅ **Progressive**: Each module builds on previous concepts
- ✅ **Practical**: Learn by building a real game
- ✅ **Visual**: Clear explanations with diagrams and examples
- ✅ **Comprehensive**: Detailed README files for each module

---

## 🗺️ **Module Roadmap**

```
Module 1: Basics
    ↓
Module 2: Encapsulation
    ↓
Module 3: Inheritance
    ↓
Module 4: Advanced OOP
    ↓
Module 5: Collections & Exceptions
```

### **Module 1: Java Fundamentals**
📂 `RPG_Module1/`

**Topics Covered:**
- Classes and Objects
- Methods
- Input/Output (Scanner)
- Data Types (int, String, boolean, double, char)
- Conditionals (if-else)
- Switch Statements
- Loops (for, while)

**What You'll Build:**
- `Hero` class with attributes and methods
- `Monster` class for combat
- Interactive battle system with user choices

**README:** [M1_README.md](RPG_Module1/M1_README.md)

---

### **Module 2: Encapsulation & Static**
📂 `RPG_Module2/`

**Topics Covered:**
- Encapsulation (public, protected, private)
- Getter and Setter methods
- Method Overloading
- Static attributes and methods
- Static final constants

**What You'll Build:**
- `Warrior` class with protected attributes
- `Party` class managing multiple warriors
- Validation through setters

**README:** [M2_README.md](RPG_Module2/M2_README.md)

---

### **Module 3: Inheritance & Polymorphism**
📂 `RPG_Module3/`

**Topics Covered:**
- Inheritance (extends)
- Constructor chaining (super)
- Method Overriding
- Method Overloading vs Overriding
- Polymorphism basics

**What You'll Build:**
- Base `Character` class
- Specialized classes: `Warrior`, `Mage`, `Archer`
- Battle system demonstrating polymorphism

**README:** [M3_README.md](RPG_Module3/M3_README.md)

---

### **Module 4: Advanced OOP Concepts**
📂 `RPG_Module4/`

**Topics Covered:**
- Final (variables, methods, classes)
- Enumerations (enum)
- Abstract classes and methods
- Interfaces
- Polymorphism (advanced)
- Upcasting and Downcasting

**What You'll Build:**
- Abstract `Combatant` class
- `CharacterClass` enum (WARRIOR, MAGE, ARCHER, PALADIN)
- `Element` enum for spell effects
- `Magical` and `Defensive` interfaces
- `GameMaster` final class
- Advanced character system with class-specific abilities

**README:** [M4_README.md](RPG_Module4/M4_README.md)

---

### **Module 5: Collections & Exception Handling**
📂 `RPG_Module5/`

**Topics Covered:**
- Exception Handling (try-catch-finally)
- Throwing exceptions (throw, throws)
- Custom exceptions
- ArrayList and its methods (add, get, set, remove, size, isEmpty)
- Iterator for safe removal
- Enhanced for loop (for-each)

**What You'll Build:**
- `Party` class with ArrayList of characters
- `Inventory` class with ArrayList of items
- Custom exceptions: `CharacterDeadException`, `InsufficientManaException`, `InventoryFullException`, `InvalidTargetException`
- `BattleManager` with exception handling
- Interactive menu system

**README:** [M5_README.md](RPG_Module5/M5_README.md)

---

## 🚀 **Getting Started**

### **Prerequisites**
- **Java JDK** 8 or higher installed
- **IDE** (IntelliJ IDEA, Eclipse, VS Code, or any Java IDE)
- Basic understanding of programming concepts (variables, basic logic)

### **Installation**

1. **Clone or download this project**
   ```bash
   git clone <repository-url>
   cd RPG_26
   ```

2. **Open in your IDE**
   - Open the entire `RPG_26` folder in your IDE
   - Each module is a separate IntelliJ module

---

## 📖 **How to Use This Project**

### **For Students**

#### **Option 1: Sequential Learning (Recommended)**
Follow the modules in order for a structured learning experience:

1. **Start with Module 1**
   - Read `RPG_Module1/M1_README.md` thoroughly
   - Study the code in `RPG_Module1/src/`
   - Run `Game.java` and interact with the program
   - Try the practice exercises at the end of the README

2. **Progress to Module 2**
   - Read `RPG_Module2/M2_README.md`
   - Compare with Module 1 to see what's new
   - Run and experiment with the code
   - Complete the exercises

3. **Continue through Modules 3, 4, and 5**

#### **Option 2: Topic-Based Learning**
Jump to specific modules based on what you need to learn:
- Need to understand **classes and methods**? → Module 1
- Learning about **encapsulation**? → Module 2
- Studying **inheritance**? → Module 3
- Working on **interfaces and abstract classes**? → Module 4
- Learning **ArrayList and exceptions**? → Module 5

---

## 🎯 **How to Run Each Module**

### **Running Module 1**
```bash
cd RPG_Module1/src
javac Game.java Hero.java Monster.java
java Game
```

Or in your IDE:
1. Open `RPG_Module1/src/Game.java`
2. Right-click and select "Run"
3. Follow the interactive prompts in the console

### **Running Module 2**
```bash
cd RPG_Module2/src
javac Game.java Warrior.java Party.java
java Game
```

### **Running Module 3**
```bash
cd RPG_Module3/src
javac *.java
java Game
```

### **Running Module 4**
```bash
cd RPG_Module4/src
javac *.java
java Game
```

### **Running Module 5**
```bash
cd RPG_Module5/src
javac *.java
java Game
```

---

## 📝 **Expected Output Examples**

### **Module 1 Output:**
```
=== RPG Game - Module 1 ===
Learn: Class, Method, Input, Output, Data Type, Condition, Switch, Loop

=== Create Your Hero ===
Enter hero name: Aragorn
Enter starting health (50-150): 100
Enter starting mana (30-100): 50

========== HERO INFO ==========
Name: Aragorn
HP: 100
Mana: 50
Status: Alive
Attack Power: 15.5
Rank: C
==============================
...
```

### **Module 5 Output:**
```
=== RPG Game - Module 5 ===
Learn: Exception Handling, ArrayList, Iterator, Enhanced For

Enter party name: Fellowship
Enter max party size (2-5): 4

✓ Party 'Fellowship' created with max size: 4

╔════════════════════════════════╗
║         MAIN MENU              ║
╚════════════════════════════════╝
1. Party Management
2. Inventory Management
3. Battle System
4. View Status
5. Exit
Choice:
```

---

## 🛠️ **Troubleshooting**

### **Common Issues:**

#### **1. "Cannot find symbol" or "Class not found"**
- **Solution**: Make sure all `.java` files in the module are compiled together
  ```bash
  javac *.java
  ```

#### **2. "Scanner not found"**
- **Solution**: Add import at the top of the file:
  ```java
  import java.util.Scanner;
  ```

#### **3. "ArrayList cannot be resolved"**
- **Solution**: Add import (Module 5):
  ```java
  import java.util.ArrayList;
  ```

#### **4. Program crashes when entering input**
- **Solution**: Check that you're entering the correct data type
  - If it asks for a number, enter a number (not text)
  - If it asks for text, enter text

#### **5. "Package does not exist" errors**
- **Solution**: Make sure you're compiling all files in the module together, not individually

---

## 📚 **Concept Quick Reference**

### **Key Concepts by Module**

| Concept | Module | Key Classes/Files |
|---------|--------|------------------|
| Classes & Objects | 1 | `Hero.java`, `Monster.java` |
| Methods | 1 | `attack()`, `displayInfo()` |
| Scanner Input | 1 | `Game.java` |
| Conditionals | 1 | `attack()`, `takeDamage()` |
| Switch | 1 | `useSkill()`, `promoteRank()` |
| Loops | 1 | `rest()`, `practice()` |
| Private/Public | 2 | `Warrior.java` |
| Getters/Setters | 2 | `getName()`, `setArmor()` |
| Static | 2 | `totalWarriors` |
| Inheritance | 3 | `Character.java`, `Warrior.java`, `Mage.java` |
| Constructor | 3 | `Warrior(String name)` |
| Overriding | 3 | `attack()` in child classes |
| Final | 4 | `GameMaster.java` |
| Enum | 4 | `CharacterClass.java`, `Element.java` |
| Abstract | 4 | `Combatant.java` |
| Interface | 4 | `Magical.java`, `Defensive.java` |
| Polymorphism | 4 | Arrays of `Combatant` |
| Try-Catch | 5 | `Game.java` battle system |
| Custom Exceptions | 5 | `CharacterDeadException.java` |
| ArrayList | 5 | `Party.java`, `Inventory.java` |
| Iterator | 5 | `removeMember()` methods |
| Enhanced For | 5 | `displayParty()`, `getAliveMembers()` |

---

## 🎓 **Learning Tips**

### **For Maximum Learning Effectiveness:**

1. **Read First, Code Later**
   - Read the module README completely before looking at code
   - Understand the concepts theoretically first

2. **Run and Experiment**
   - Run the code and interact with it
   - Try different inputs to see what happens
   - Intentionally cause errors to understand them

3. **Modify the Code**
   - Change values and see the effects
   - Add print statements to understand flow
   - Try the practice exercises

4. **Take Notes**
   - Write down key concepts in your own words
   - Create your own examples
   - Draw diagrams if helpful

5. **Compare Modules**
   - See how concepts evolve from Module 1 to Module 5
   - Notice how code becomes more sophisticated
   - Understand why OOP principles improve code organization

6. **Ask Questions**
   - If something doesn't make sense, re-read the explanations
   - Look for the "Common Mistakes" sections
   - Try debugging the code yourself

---

## 🔄 **Progression Path**

```
Week 1: Module 1
├── Day 1-2: Read README, understand basics
├── Day 3-4: Run and modify code
└── Day 5-7: Complete exercises, experiment

Week 2: Module 2
├── Day 1-2: Encapsulation concepts
├── Day 3-4: Getter/Setter practice
└── Day 5-7: Static members, exercises

Week 3: Module 3
├── Day 1-3: Inheritance and constructors
└── Day 4-7: Override vs Overload, practice

Week 4: Module 4
├── Day 1-2: Final and Enum
├── Day 3-4: Abstract classes
└── Day 5-7: Interfaces and polymorphism

Week 5: Module 5
├── Day 1-3: Exception handling
├── Day 4-5: ArrayList methods
└── Day 6-7: Iterator and enhanced for loop
```

---

## 📂 **Project Structure**

```
RPG_26/
│
├── README.md (this file)
│
├── RPG_Module1/
│   ├── M1_README.md
│   ├── RPG_Module1.iml
│   └── src/
│       ├── Game.java
│       ├── Hero.java
│       └── Monster.java
│
├── RPG_Module2/
│   ├── M2_README.md
│   ├── RPG_Module2.iml
│   └── src/
│       ├── Game.java
│       ├── Warrior.java
│       └── Party.java
│
├── RPG_Module3/
│   ├── M3_README.md
│   ├── RPG_Module3.iml
│   └── src/
│       ├── Game.java
│       ├── Character.java
│       ├── Warrior.java
│       ├── Mage.java
│       └── Archer.java
│
├── RPG_Module4/
│   ├── M4_README.md
│   ├── RPG_Module4.iml
│   └── src/
│       ├── Game.java
│       ├── Combatant.java (abstract)
│       ├── CharacterClass.java (enum)
│       ├── Element.java (enum)
│       ├── Magical.java (interface)
│       ├── Defensive.java (interface)
│       ├── Warrior.java
│       ├── Mage.java
│       ├── Archer.java
│       ├── Paladin.java
│       └── GameMaster.java (final)
│
└── RPG_Module5/
    ├── M5_README.md
    ├── RPG_Module5.iml
    └── src/
        ├── Game.java
        ├── Character.java
        ├── Party.java
        ├── Inventory.java
        ├── Item.java
        ├── BattleManager.java
        ├── CharacterDeadException.java
        ├── InsufficientManaException.java
        ├── InventoryFullException.java
        └── InvalidTargetException.java
```

---

## 🎯 **Practice Exercise Suggestions**

After completing all modules, try these comprehensive exercises:

1. **Add a New Character Class**
   - Create a `Rogue` class with stealth mechanics
   - Implement special abilities
   - Test in the battle system

2. **Enhance the Inventory System**
   - Add item categories (weapons, potions, armor)
   - Implement equipment slots
   - Create item effects

3. **Build a Quest System**
   - Create `Quest` class
   - Track quest progress with ArrayList
   - Handle quest completion with exceptions

4. **Add Save/Load Functionality**
   - Save party data to file
   - Load party from file
   - Handle file exceptions

5. **Create a Level System**
   - Experience points
   - Level up mechanics
   - Stat increases on level up

---

## 🤝 **Contributing**

If you're an instructor using this project:
- Feel free to modify modules for your course
- Add additional exercises
- Create supplementary materials
- Share improvements

---

## 📄 **License**

This project is created for educational purposes.

---

## ✨ **Acknowledgments**

This project was designed to teach Java OOP concepts in an engaging, interactive way. The RPG theme makes learning programming more enjoyable and helps students see practical applications of abstract concepts.

---

## 📞 **Support**

If you encounter issues or have questions:
1. Check the **Troubleshooting** section above
2. Review the **Common Mistakes** section in each module's README
3. Re-read the concept explanations
4. Try running the code step-by-step with print statements

---

**Happy Learning! 🚀**

*May your code compile on the first try!*
