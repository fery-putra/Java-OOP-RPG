# Java OOP RPG Game - Interactive Learning Modules

[![Java](https://img.shields.io/badge/Java-8%2B-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Educational](https://img.shields.io/badge/Purpose-Educational-green.svg)]()

> **A complete, interactive RPG game system designed to teach Java Object-Oriented Programming concepts through hands-on gameplay**

Transform Java OOP education from theory to practice! This project contains 5 progressive modules that teach core OOP concepts through an engaging, interactive RPG game. Students learn by building and playing, with every concept demonstrated through real gameplay mechanics.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Module Structure](#module-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Quick Start](#quick-start)
- [Learning Path](#learning-path)
- [Project Structure](#project-structure)
- [Concepts Covered](#concepts-covered)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

---

## 🎯 Overview

This project provides a **complete Java OOP curriculum** disguised as an RPG game. Each module is:

- ✅ **Fully independent** - Can be taught in any order
- ✅ **Interactive** - 41+ user input points across all modules
- ✅ **Progressive** - Builds from basics to advanced concepts
- ✅ **Practical** - Every concept demonstrated through gameplay
- ✅ **Well-documented** - Complete explanations and guides

### Why This Project?

Traditional OOP teaching often struggles with:
- Abstract concepts that are hard to visualize
- Passive learning through reading slides
- Lack of immediate feedback
- Difficulty seeing real-world applications

This project solves these by:
- Making concepts concrete through game mechanics
- Active learning through player choices
- Instant feedback on every action
- Real-world game development context

---

## ✨ Features

### 🎮 Interactive Gameplay
- Character creation and customization
- Turn-based battle system
- Party management
- Inventory system
- Dynamic enemy AI

### 📚 Educational Design
- **5 Progressive Modules** covering all core OOP concepts
- **46+ Concepts** demonstrated through gameplay
- **32 Java Files** with complete implementations
- **Interactive Examples** in every explanation
- **Multiple Scenarios** for each concept

### 🛠️ Technical Features
- Pure Java (no external dependencies for core modules)
- Scanner-based interactive input
- Exception handling throughout
- ArrayList and Collection operations
- Polymorphic design patterns

---

## 📖 Module Structure

### Module 1: Foundations
**Topics:** Class, Method, Input/Output, Data Types, Conditions, Switch Case, Loops

```java
// Create your hero
Enter hero name: Aragorn
Enter starting health (50-150): 120
Enter starting mana (30-100): 80

// Interactive battle system with choices
--- Round 1 ---
1. Attack
2. Use Skill
3. Rest
Choose action: 2
```

**Files:** `Hero.java`, `Monster.java`, `Game.java`  
**Input Points:** 7+  
**Difficulty:** ⭐ Beginner

---

### Module 2: Encapsulation & Static
**Topics:** Encapsulation (public/protected/private), Method Overloading, Getter/Setter, Static Members

```java
// Test method overloading interactively
1. Base attack
2. Attack with bonus damage
3. Attack with weapon type
4. Attack with weapon and bonus
Choose attack type (1-4): 3
Enter weapon type (sword/axe/spear): sword
Attack damage: 20
```

**Files:** `Warrior.java`, `Party.java`, `Game.java`  
**Input Points:** 8+  
**Difficulty:** ⭐⭐ Intermediate

---

### Module 3: Inheritance
**Topics:** Inheritance, Constructor Chaining, Method Overriding, Method Overloading

```java
// Choose your character class
1. Warrior (150 HP, 25 Armor)
2. Mage (80 HP, 100 Mana)
3. Archer (100 HP, 20 Arrows)
Your choice: 1

// Each class has unique abilities
Warrior: Shield Bash
Mage: Restore Mana
Archer: Aim for critical hit
```

**Files:** `Character.java`, `Warrior.java`, `Mage.java`, `Archer.java`, `Game.java`  
**Input Points:** 6+  
**Difficulty:** ⭐⭐⭐ Advanced

---

### Module 4: Advanced OOP
**Topics:** Final (variable/method/class), Enum, Abstract Class/Method, Interface, Polymorphism, Upcasting/Downcasting

```java
// Enum selection with attributes
Choose character class:
1. WARRIOR - Strong melee (DMG: 20, HP: 150)
2. MAGE - Powerful spellcaster (DMG: 30, HP: 80)
3. ARCHER - Ranged attacker (DMG: 15, HP: 100)
4. PALADIN - Holy knight (DMG: 18, HP: 130)

// Element-based spell system
Choose spell element:
1. FIRE (x1.5 damage)
2. ICE (x1.3 damage)
3. LIGHTNING (x1.8 damage)
```

**Files:** 11 files (enums, interfaces, abstract classes, implementations)  
**Input Points:** 5+  
**Difficulty:** ⭐⭐⭐⭐ Advanced

---

### Module 5: Exception Handling & Collections
**Topics:** Try-Catch-Finally, Custom Exceptions, ArrayList (add/get/set/remove/size/isEmpty), Iterator, Enhanced For Loop

```java
// Main menu system
╔════════════════════════════════╗
║         MAIN MENU              ║
╚════════════════════════════════╝
1. Party Management
2. Inventory Management
3. Battle System
4. View Status
5. Exit

// Complete ArrayList operations
=== Party Management ===
1. Add Member (ArrayList.add)
2. Remove Member (ArrayList.remove)
3. View Member (ArrayList.get)
4. Replace Member (ArrayList.set)
5. Check Size (ArrayList.size)
6. Check Empty (ArrayList.isEmpty)
```

**Files:** 10 files (exceptions, collections, management systems)  
**Input Points:** 15+  
**Difficulty:** ⭐⭐⭐⭐ Advanced

---

## 📋 Prerequisites

- **Java JDK 8 or higher**
- **IDE** (IntelliJ IDEA, Eclipse, VS Code, or any Java IDE)
- **Basic understanding** of:
  - Variables and data types
  - If-else statements
  - Basic loops (for, while)

No external libraries required! Pure Java implementation.

---

## 🚀 Installation

### Option 1: Clone Repository

```bash
git clone https://github.com/yourusername/java-oop-rpg-modules.git
cd java-oop-rpg-modules
```

### Option 2: Download ZIP

1. Click the green "Code" button
2. Select "Download ZIP"
3. Extract to your desired location

---

## ⚡ Quick Start

### Using IntelliJ IDEA

1. **Open IntelliJ IDEA**
2. Click **File → New → Project from Existing Sources**
3. Navigate to the module folder (e.g., `Module1`)
4. Select the `src` folder
5. Click **OK**
6. Right-click `Game.java` → **Run 'Game.main()'**

### Using Command Line

```bash
# Navigate to module directory
cd Module1

# Compile all files
javac *.java

# Run the game
java Game
```

### Using Eclipse

1. **File → New → Java Project**
2. Uncheck "Use default location"
3. Browse to module folder
4. Click **Finish**
5. Right-click `Game.java` → **Run As → Java Application**

---

## 📚 Learning Path

### For Students

#### Week 1: Module 1
- Learn class and method basics
- Practice Scanner input
- Understand loops and conditions
- Build simple battles

**Estimated Time:** 3-4 hours

#### Week 2: Module 2
- Master encapsulation
- Implement getter/setter validation
- Practice method overloading
- Understand static members

**Estimated Time:** 4-5 hours

#### Week 3: Module 3
- Build inheritance hierarchies
- Practice constructor chaining
- Implement method overriding
- Create special class abilities

**Estimated Time:** 5-6 hours

#### Week 4-5: Module 4
- Work with enums and switches
- Create abstract classes
- Implement interfaces
- Practice polymorphism and casting

**Estimated Time:** 6-8 hours

#### Week 6-7: Module 5
- Handle exceptions properly
- Master ArrayList operations
- Use Iterator safely
- Build complete game systems

**Estimated Time:** 6-8 hours

**Total Course:** 24-31 hours of hands-on learning

---

### For Instructors

#### Teaching Strategy

1. **Demonstrate First** - Run the complete module
2. **Show Code** - Walk through the implementation
3. **Explain Concepts** - Use the provided explanations
4. **Student Practice** - Have students complete TODO versions
5. **Review** - Discuss different solutions

#### Assessment Ideas

- **Code Completion** - Students fill in TODO sections
- **Feature Addition** - Add new characters/abilities
- **Bug Fixing** - Fix intentionally broken code
- **Extension** - Create new game mechanics
- **Presentation** - Explain their implementation

#### Grading Rubric (per module)

| Criteria | Points | Description |
|----------|--------|-------------|
| Compilation | 20 | Code compiles without errors |
| Functionality | 40 | All methods work correctly |
| Code Quality | 20 | Proper naming, formatting, logic |
| Output Match | 20 | Output matches expected results |
| **Total** | **100** | Per module |

---

## 📁 Project Structure

```
java-oop-rpg-modules/
│
├── Module1_Foundations/
│   ├── src/
│   │   ├── Hero.java
│   │   ├── Monster.java
│   │   └── Game.java
│   ├── README.md
│   └── EXPLANATION.md
│
├── Module2_Encapsulation/
│   ├── src/
│   │   ├── Warrior.java
│   │   ├── Party.java
│   │   └── Game.java
│   ├── README.md
│   └── EXPLANATION.md
│
├── Module3_Inheritance/
│   ├── src/
│   │   ├── Character.java
│   │   ├── Warrior.java
│   │   ├── Mage.java
│   │   ├── Archer.java
│   │   └── Game.java
│   ├── README.md
│   └── EXPLANATION.md
│
├── Module4_Advanced_OOP/
│   ├── src/
│   │   ├── CharacterClass.java (enum)
│   │   ├── Element.java (enum)
│   │   ├── Combatant.java (abstract)
│   │   ├── Magical.java (interface)
│   │   ├── Defensive.java (interface)
│   │   ├── Warrior.java
│   │   ├── Mage.java
│   │   ├── Paladin.java
│   │   ├── Archer.java
│   │   ├── GameMaster.java (final)
│   │   └── Game.java
│   ├── README.md
│   └── EXPLANATION.md
│
├── Module5_Exceptions_Collections/
│   ├── src/
│   │   ├── InsufficientManaException.java
│   │   ├── CharacterDeadException.java
│   │   ├── InventoryFullException.java
│   │   ├── InvalidTargetException.java
│   │   ├── Item.java
│   │   ├── Character.java
│   │   ├── Party.java
│   │   ├── Inventory.java
│   │   ├── BattleManager.java
│   │   └── Game.java
│   ├── README.md
│   └── EXPLANATION.md
│
├── docs/
│   ├── USER_INPUT_GUIDE.md
│   ├── INTELLIJ_SETUP.md
│   ├── QUICK_REFERENCE.md
│   └── TEACHING_GUIDE.md
│
├── LICENSE
└── README.md (this file)
```

---

## 🎓 Concepts Covered

### Module 1 (8 concepts)
- ✅ Class definition
- ✅ Method creation
- ✅ Scanner input
- ✅ System output
- ✅ Data types (int, String, double, boolean, char)
- ✅ If-else conditions
- ✅ Switch-case statements
- ✅ For and while loops

### Module 2 (7 concepts)
- ✅ Encapsulation (private, protected, public)
- ✅ Getter methods
- ✅ Setter methods with validation
- ✅ Method overloading
- ✅ Static attributes
- ✅ Static final constants
- ✅ Static methods

### Module 3 (5 concepts)
- ✅ Inheritance (extends)
- ✅ Constructor chaining (super, this)
- ✅ Constructor overloading
- ✅ Method overriding
- ✅ Calling parent methods (super.method())

### Module 4 (13 concepts)
- ✅ Final variables
- ✅ Static final constants
- ✅ Final methods
- ✅ Final classes
- ✅ Enum types
- ✅ Enum with attributes
- ✅ Enum in switch
- ✅ Abstract classes
- ✅ Abstract methods
- ✅ Concrete methods
- ✅ Interfaces
- ✅ Polymorphism
- ✅ Upcasting and downcasting

### Module 5 (13 concepts)
- ✅ Try-catch blocks
- ✅ Finally blocks
- ✅ Throws keyword
- ✅ Throw keyword
- ✅ Custom exceptions
- ✅ ArrayList.add()
- ✅ ArrayList.get()
- ✅ ArrayList.set()
- ✅ ArrayList.remove()
- ✅ ArrayList.size()
- ✅ ArrayList.isEmpty()
- ✅ Iterator pattern
- ✅ Enhanced for loop

**Total: 46 Core Java OOP Concepts**

---

## 📸 Screenshots

### Module 1: Character Creation
```
=== Create Your Hero ===
Enter hero name: Aragorn
Enter starting health (50-150): 120
Enter starting mana (30-100): 80

========== HERO INFO ==========
Name: Aragorn
HP: 120
Mana: 80
Status: Alive
Attack Power: 15.5
Rank: C
==============================
```

### Module 3: Class Selection
```
Choose character type:
1. Warrior
2. Mage
3. Archer
Your choice: 2

Character constructor called for: Gandalf
Mage constructor called - Mana set to 100

✓ Character created!
```

### Module 4: Element-Based Magic
```
Choose spell element:
1. FIRE (x1.5 damage)
2. ICE (x1.3 damage)
3. LIGHTNING (x1.8 damage)
4. HOLY (x1.4 damage)
Choice: 3

Gandalf prepares spell...
Gandalf casts LIGHTNING spell! Shocks enemies
Enemy takes 54 damage!
```

### Module 5: Party Management
```
╔════════════════════════════════╗
║         MAIN MENU              ║
╚════════════════════════════════╝
1. Party Management
2. Inventory Management
3. Battle System
4. View Status
5. Exit
Choice: 1

=== Party Management ===
1. Add Member (ArrayList.add)
2. Remove Member (ArrayList.remove)
3. View Member (ArrayList.get)
```

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

### Reporting Bugs
- Use the GitHub Issues tab
- Describe the bug clearly
- Include steps to reproduce
- Mention your Java version

### Suggesting Features
- Check existing issues first
- Describe the feature and its benefits
- Explain how it helps learning

### Submitting Pull Requests
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style
- Follow Java naming conventions
- Comment complex logic
- Keep methods focused and small
- Add JavaDoc for public methods

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### MIT License Summary
- ✅ Commercial use
- ✅ Modification
- ✅ Distribution
- ✅ Private use
- ❌ Liability
- ❌ Warranty

---

## 🙏 Acknowledgments

### Inspiration
- Classic RPG games for game mechanics
- Java educational community for teaching insights
- Students who made this project better through feedback

### Tools Used
- **Java** - Programming language
- **IntelliJ IDEA** - Primary IDE for development
- **Git/GitHub** - Version control and hosting

### Special Thanks
- All educators using this project in their classrooms
- Contributors who helped improve the code
- Students who provided valuable feedback

---

## 📞 Contact & Support

- **Issues:** [GitHub Issues](https://github.com/yourusername/java-oop-rpg-modules/issues)
- **Discussions:** [GitHub Discussions](https://github.com/yourusername/java-oop-rpg-modules/discussions)
- **Email:** your.email@example.com

---

## 📊 Statistics

- **Total Files:** 32 Java files
- **Total Lines:** ~1,780 lines of code
- **Documentation:** ~15,000 lines
- **Concepts:** 46 core OOP concepts
- **Input Points:** 41+ interactive prompts
- **Modules:** 5 complete learning modules
- **Difficulty:** Beginner to Advanced
- **Estimated Learning Time:** 24-31 hours

---

## 🗺️ Roadmap

### Version 1.0 (Current)
- ✅ All 5 modules complete
- ✅ Interactive input throughout
- ✅ Complete documentation
- ✅ Educational explanations

### Future Enhancements
- [ ] Video tutorials for each module
- [ ] Unit tests for all modules
- [ ] GUI version using JavaFX
- [ ] Multiplayer battle system
- [ ] Save/Load game state
- [ ] Achievement system
- [ ] Quest system
- [ ] Character progression (XP/Levels)

---

## ⭐ Show Your Support

If this project helped you learn Java OOP, please give it a ⭐️!

**Share with others:**
- Tweet about it
- Blog about your experience
- Use it in your classroom
- Contribute improvements

---

## 📚 Additional Resources

### Java Learning
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Effective Java](https://www.oreilly.com/library/view/effective-java/9780134686097/)

### OOP Concepts
- [OOP Principles](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)
- [Design Patterns](https://refactoring.guru/design-patterns)
- [Clean Code](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)

---

<div align="center">

**Made with ❤️ for Java learners worldwide**

[⬆ Back to Top](#java-oop-rpg-game---interactive-learning-modules)

</div>

---

*Last Updated: January 2026*
