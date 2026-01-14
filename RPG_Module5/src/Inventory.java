// MODULE 5: COMPLETE SOLUTION - PART 2/2
// Inventory class and Game class with all ArrayList methods demonstrated

import java.util.ArrayList;
import java.util.Iterator;

// ==================== Inventory.java - All ArrayList Methods ====================
class Inventory {
    private ArrayList<Item> items;
    private int maxCapacity;
    private int gold;

    public Inventory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<Item>(); // Create ArrayList
        this.gold = 100;
    }

    // ArrayList: ADD method
    public void addItem(Item item) throws InventoryFullException {
        if (items.size() >= maxCapacity) { // SIZE
            throw new InventoryFullException("Inventory full! Max: " + maxCapacity);
        }
        items.add(item); // ADD
        System.out.println("Added " + item.getName() + " to inventory");
    }

    // ArrayList: GET method
    public Item getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index); // GET
        }
        return null;
    }

    // ArrayList: SET method
    public void replaceItem(int index, Item newItem) {
        if (index >= 0 && index < items.size()) {
            Item old = items.get(index);
            items.set(index, newItem); // SET
            System.out.println("Replaced " + old.getName() + " with " + newItem.getName());
        }
    }

    // ArrayList: REMOVE method (by index)
    public Item removeItemAt(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index); // REMOVE by index
        }
        return null;
    }

    // ITERATOR: Safe removal by name
    public Item removeItem(String itemName) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equals(itemName)) {
                iterator.remove(); // ITERATOR remove
                return item;
            }
        }
        return null;
    }

    // ArrayList: SIZE method
    public int getItemCount() {
        return items.size(); // SIZE
    }

    // ArrayList: ISEMPTY method
    public boolean isEmpty() {
        return items.isEmpty(); // ISEMPTY
    }

    // ENHANCED FOR LOOP with counter
    public void displayInventory() {
        System.out.println("\n--- Inventory ---");
        System.out.println("Gold: " + gold);

        if (isEmpty()) {
            System.out.println("(Empty)");
            return;
        }

        int index = 1;
        for (Item item : items) { // ENHANCED FOR LOOP
            System.out.println(index + ". " + item.toString());
            index++;
        }
        System.out.println("Items: " + getItemCount() + "/" + maxCapacity);
    }

    // ENHANCED FOR LOOP: Sum values
    public int getTotalValue() {
        int total = gold;
        for (Item item : items) { // ENHANCED FOR LOOP
            total += item.getValue();
        }
        return total;
    }

    // ENHANCED FOR LOOP: Search
    public boolean hasItem(String itemName) {
        for (Item item : items) { // ENHANCED FOR LOOP
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    // TRY-CATCH: Use item with exception handling
    public void useItem(String itemName, Character target) throws Exception {
        Item item = removeItem(itemName);

        if (item == null) {
            throw new Exception("Item not found: " + itemName);
        }

        if (item.getName().contains("Potion")) {
            try {
                target.heal(50);
            } catch (CharacterDeadException e) {
                System.out.println("Cannot use potion: " + e.getMessage());
                items.add(item); // Add back if failed
                return;
            }
        }

        System.out.println("Used " + item.getName() + " on " + target.getName());
    }

    public int getGold() { return gold; }
    public void addGold(int amount) { gold += amount; }
}

// ==================== BattleManager.java - Exception Handling ====================


// ==================== Game.java ====================
