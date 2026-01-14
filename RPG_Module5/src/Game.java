import java.util.ArrayList;
import java.util.Scanner;

class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Party party;
    private static Inventory inventory;

    public static void main(String[] args) {
        System.out.println("=== RPG Game - Module 5 ===");
        System.out.println("Learn: Exception Handling, ArrayList, Iterator, Enhanced For\n");

        // Setup party with INPUT
        System.out.print("Enter party name: ");
        String partyName = scanner.nextLine();

        System.out.print("Enter max party size (2-5): ");
        int maxSize = scanner.nextInt();
        scanner.nextLine();

        party = new Party(partyName, maxSize);
        inventory = new Inventory(10);

        System.out.println("\n✓ Party '" + partyName + "' created with max size: " + maxSize);

        // Main game loop
        boolean playing = true;
        while (playing) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║         MAIN MENU              ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("1. Party Management");
            System.out.println("2. Inventory Management");
            System.out.println("3. Battle System");
            System.out.println("4. View Status");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    partyManagement();
                    break;
                case 2:
                    inventoryManagement();
                    break;
                case 3:
                    battleSystem();
                    break;
                case 4:
                    viewStatus();
                    break;
                case 5:
                    playing = false;
                    System.out.println("\nThanks for playing!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    // Party Management with ArrayList methods
    private static void partyManagement() {
        System.out.println("\n=== Party Management ===");
        System.out.println("1. Add Member (ArrayList.add)");
        System.out.println("2. Remove Member by Index (ArrayList.remove)");
        System.out.println("3. Remove Member by Name (Iterator)");
        System.out.println("4. View Member (ArrayList.get)");
        System.out.println("5. Replace Member (ArrayList.set)");
        System.out.println("6. Display Party");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case 1: // ADD
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter max health (50-200): ");
                    int health = scanner.nextInt();
                    System.out.print("Enter max mana (30-150): ");
                    int mana = scanner.nextInt();
                    scanner.nextLine();

                    Character newChar = new Character(name, health, mana);
                    party.addMember(newChar); // May throw InventoryFullException
                    break;

                case 2: // REMOVE by index
                    party.displayParty();
                    System.out.print("Enter index to remove (1-" + party.getSize() + "): ");
                    int index = scanner.nextInt() - 1;
                    party.removeMemberAt(index);
                    break;

                case 3: // REMOVE with Iterator
                    party.displayParty();
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    boolean removed = party.removeMember(removeName);
                    if (!removed) {
                        System.out.println(removeName + " not found!");
                    }
                    break;

                case 4: // GET
                    party.displayParty();
                    System.out.print("Enter index to view (1-" + party.getSize() + "): ");
                    int viewIndex = scanner.nextInt() - 1;
                    Character c = party.getMemberAt(viewIndex);
                    if (c != null) {
                        c.displayInfo();
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5: // SET
                    party.displayParty();
                    System.out.print("Enter index to replace (1-" + party.getSize() + "): ");
                    int replaceIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.print("Enter new character name: ");
                    String newName = scanner.nextLine();
                    Character replacement = new Character(newName, 100, 80);
                    party.replaceMember(replaceIndex, replacement);
                    break;

                case 6:
                    party.displayParty();
                    System.out.println("\nTotal Health: " + party.getTotalHealth());
                    System.out.println("Is Empty: " + party.isEmpty());
                    System.out.println("Size: " + party.getSize());
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } catch (InventoryFullException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // Inventory Management with ArrayList methods
    private static void inventoryManagement() {
        System.out.println("\n=== Inventory Management ===");
        System.out.println("1. Add Item (ArrayList.add)");
        System.out.println("2. Remove Item (Iterator)");
        System.out.println("3. Use Item (Exception Handling)");
        System.out.println("4. View Item (ArrayList.get)");
        System.out.println("5. Replace Item (ArrayList.set)");
        System.out.println("6. Display Inventory");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case 1: // ADD
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item value: ");
                    int value = scanner.nextInt();
                    scanner.nextLine();

                    Item item = new Item(itemName, value);
                    inventory.addItem(item); // May throw InventoryFullException
                    break;

                case 2: // REMOVE with Iterator
                    inventory.displayInventory();
                    System.out.print("Enter item name to remove: ");
                    String removeName = scanner.nextLine();
                    Item removed = inventory.removeItem(removeName);
                    if (removed != null) {
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 3: // USE with exception handling
                    if (party.isEmpty()) {
                        System.out.println("No party members to use item on!");
                        break;
                    }

                    inventory.displayInventory();
                    System.out.print("Enter item name to use: ");
                    String useName = scanner.nextLine();

                    party.displayParty();
                    System.out.print("Choose target (1-" + party.getSize() + "): ");
                    int targetIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    Character target = party.getMemberAt(targetIndex);
                    if (target != null) {
                        inventory.useItem(useName, target);
                    }
                    break;

                case 4: // GET
                    inventory.displayInventory();
                    System.out.print("Enter index to view (1-" + inventory.getItemCount() + "): ");
                    int viewIndex = scanner.nextInt() - 1;
                    Item viewItem = inventory.getItem(viewIndex);
                    if (viewItem != null) {
                        System.out.println(viewItem);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5: // SET
                    inventory.displayInventory();
                    System.out.print("Enter index to replace (1-" + inventory.getItemCount() + "): ");
                    int replaceIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.print("Enter new item name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new item value: ");
                    int newValue = scanner.nextInt();
                    scanner.nextLine();

                    Item newItem = new Item(newName, newValue);
                    inventory.replaceItem(replaceIndex, newItem);
                    break;

                case 6:
                    inventory.displayInventory();
                    System.out.println("\nTotal Value: " + inventory.getTotalValue() + "g");
                    System.out.println("Is Empty: " + inventory.isEmpty());
                    System.out.println("Item Count: " + inventory.getItemCount());
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } catch (InventoryFullException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // Battle System with Exception Handling
    private static void battleSystem() {
        if (party.getSize() < 2) {
            System.out.println("Need at least 2 party members to battle!");
            return;
        }

        ArrayList<Character> alive = party.getAliveMembers();
        if (alive.size() < 2) {
            System.out.println("Need at least 2 alive members to battle!");
            return;
        }

        System.out.println("\n=== Battle System ===");
        party.displayParty();

        System.out.print("\nChoose attacker (1-" + party.getSize() + "): ");
        int attackerIndex = scanner.nextInt() - 1;

        System.out.print("Choose defender (1-" + party.getSize() + "): ");
        int defenderIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Character attacker = party.getMemberAt(attackerIndex);
        Character defender = party.getMemberAt(defenderIndex);

        if (attacker == null || defender == null) {
            System.out.println("Invalid character selection!");
            return;
        }

        System.out.println("\n1. Basic Attack");
        System.out.println("2. Cast Spell");
        System.out.print("Choice: ");
        int actionChoice = scanner.nextInt();
        scanner.nextLine();

        // TRY-CATCH-FINALLY demonstration
        try {
            if (actionChoice == 1) {
                attacker.attack(defender);
                System.out.println("✓ Attack successful!");
            } else if (actionChoice == 2) {
                System.out.print("Enter mana cost (10-50): ");
                int manaCost = scanner.nextInt();
                scanner.nextLine();

                attacker.castSpell(defender, manaCost);
                System.out.println("✓ Spell cast successful!");
            }
        } catch (CharacterDeadException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (InvalidTargetException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (InsufficientManaException e) {
            System.out.println("✗ " + e.getMessage());
        } finally {
            System.out.println("\n--- After Action ---");
            attacker.displayInfo();
            defender.displayInfo();
        }
    }

    // View Status
    private static void viewStatus() {
        System.out.println("\n=== Current Status ===");
        party.displayParty();
        inventory.displayInventory();

        System.out.println("\n--- Statistics ---");
        System.out.println("Total Party Health: " + party.getTotalHealth());
        System.out.println("Alive Members: " + party.getAliveMembers().size());
        System.out.println("Total Inventory Value: " + inventory.getTotalValue() + "g");
    }
}