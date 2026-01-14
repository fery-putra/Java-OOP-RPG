import java.util.ArrayList;
import java.util.Iterator;

class Party {
    private String partyName;
    private ArrayList<Character> members;
    private int maxSize;

    public Party(String partyName, int maxSize) {
        this.partyName = partyName;
        this.maxSize = maxSize;
        this.members = new ArrayList<Character>(); // Create ArrayList
    }

    // ArrayList method: ADD
    public void addMember(Character character) throws InventoryFullException {
        if (members.size() >= maxSize) { // SIZE method
            throw new InventoryFullException("Party full! Max: " + maxSize);
        }

        members.add(character); // ADD method
        System.out.println(character.getName() + " joined the party!");
    }

    // ArrayList method: GET
    public Character getMemberAt(int index) {
        if (index >= 0 && index < members.size()) {
            return members.get(index); // GET method
        }
        return null;
    }

    // ArrayList method: SET
    public void replaceMember(int index, Character newCharacter) {
        if (index >= 0 && index < members.size()) {
            Character old = members.get(index);
            members.set(index, newCharacter); // SET method
            System.out.println(old.getName() + " replaced by " + newCharacter.getName());
        }
    }

    // ArrayList method: REMOVE
    public boolean removeMemberAt(int index) {
        if (index >= 0 && index < members.size()) {
            Character removed = members.remove(index); // REMOVE by index
            System.out.println(removed.getName() + " left the party!");
            return true;
        }
        return false;
    }

    // ITERATOR - safe removal
    public boolean removeMember(String characterName) {
        Iterator<Character> iterator = members.iterator(); // ITERATOR
        while (iterator.hasNext()) {
            Character c = iterator.next();
            if (c.getName().equals(characterName)) {
                iterator.remove(); // ITERATOR remove
                System.out.println(characterName + " left the party!");
                return true;
            }
        }
        return false;
    }

    // ENHANCED FOR LOOP - search
    public Character findMember(String name) {
        for (Character c : members) { // ENHANCED FOR LOOP
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    // ArrayList method: SIZE
    public int getSize() {
        return members.size(); // SIZE method
    }

    // ArrayList method: ISEMPTY
    public boolean isEmpty() {
        return members.isEmpty(); // ISEMPTY method
    }

    // ENHANCED FOR LOOP - display all
    public void displayParty() {
        System.out.println("\n=== Party: " + partyName + " ===");
        if (isEmpty()) {
            System.out.println("(Empty party)");
            return;
        }

        for (Character c : members) { // ENHANCED FOR LOOP
            c.displayInfo();
        }
        System.out.println("Members: " + getSize() + "/" + maxSize);
    }

    // ENHANCED FOR LOOP - filter
    public ArrayList<Character> getAliveMembers() {
        ArrayList<Character> alive = new ArrayList<Character>();
        for (Character c : members) { // ENHANCED FOR LOOP
            if (c.isAlive()) {
                alive.add(c);
            }
        }
        return alive;
    }

    // ENHANCED FOR LOOP - sum
    public int getTotalHealth() {
        int total = 0;
        for (Character c : members) { // ENHANCED FOR LOOP
            total += c.getHealth();
        }
        return total;
    }
}