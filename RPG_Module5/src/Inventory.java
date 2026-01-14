import java.util.ArrayList;
import java.util.Iterator;

class Inventory {
    private ArrayList<Item> items;
    private int maxCapacity;
    private int gold;

    public Inventory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<Item>();
        this.gold = 100;
    }

    // ArrayList: ADD
    public void addItem(Item item) throws InventoryFullException {
        if (items.size() >= maxCapacity) {
            throw new InventoryFullException("Inventory full! Max: " + maxCapacity);
        }
        items.add(item);
        System.out.println("Added " + item.getName() + " to inventory");
    }

    // ArrayList: GET
    public Item getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    // ArrayList: SET
    public void replaceItem(int index, Item newItem) {
        if (index >= 0 && index < items.size()) {
            Item old = items.get(index);
            items.set(index, newItem);
            System.out.println("Replaced " + old.getName() + " with " + newItem.getName());
        }
    }

    // ArrayList: REMOVE by index
    public Item removeItemAt(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    // ITERATOR: Safe removal by name
    public Item removeItem(String itemName) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                return item;
            }
        }
        return null;
    }

    // ArrayList: SIZE
    public int getItemCount() {
        return items.size();
    }

    // ArrayList: ISEMPTY
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // ENHANCED FOR with counter
    public void displayInventory() {
        System.out.println("\n--- Inventory ---");
        System.out.println("Gold: " + gold);

        if (isEmpty()) {
            System.out.println("(Empty)");
            return;
        }

        int index = 1;
        for (Item item : items) {
            System.out.println(index + ". " + item.toString());
            index++;
        }
        System.out.println("Items: " + getItemCount() + "/" + maxCapacity);
    }

    // ENHANCED FOR: Sum values
    public int getTotalValue() {
        int total = gold;
        for (Item item : items) {
            total += item.getValue();
        }
        return total;
    }

    // ENHANCED FOR: Search
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    // Try-catch: Use item
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
                items.add(item);
                return;
            }
        }

        System.out.println("Used " + item.getName() + " on " + target.getName());
    }

    public int getGold() { return gold; }
    public void addGold(int amount) { gold += amount; }
}