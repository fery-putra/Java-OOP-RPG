import java.util.ArrayList;
import java.util.Iterator;

class Party {
    private String partyName;
    private ArrayList<Character> members;
    private int maxSize;

    public Party(String partyName, int maxSize) {
        this.partyName = partyName;
        this.maxSize = maxSize;
        this.members = new ArrayList<Character>();
    }

    // ArrayList: ADD
    public void addMember(Character character) throws InventoryFullException {
        if (members.size() >= maxSize) {
            throw new InventoryFullException("Party full! Max: " + maxSize);
        }

        members.add(character);
        System.out.println(character.getName() + " joined the party!");
    }

    // ArrayList: GET
    public Character getMemberAt(int index) {
        if (index >= 0 && index < members.size()) {
            return members.get(index);
        }
        return null;
    }

    // ArrayList: SET
    public void replaceMember(int index, Character newCharacter) {
        if (index >= 0 && index < members.size()) {
            Character old = members.get(index);
            members.set(index, newCharacter);
            System.out.println(old.getName() + " replaced by " + newCharacter.getName());
        }
    }

    // ArrayList: REMOVE by index
    public boolean removeMemberAt(int index) {
        if (index >= 0 && index < members.size()) {
            Character removed = members.remove(index);
            System.out.println(removed.getName() + " left the party!");
            return true;
        }
        return false;
    }

    // ITERATOR - safe removal
    public boolean removeMember(String characterName) {
        Iterator<Character> iterator = members.iterator();
        while (iterator.hasNext()) {
            Character c = iterator.next();
            if (c.getName().equals(characterName)) {
                iterator.remove();
                System.out.println(characterName + " left the party!");
                return true;
            }
        }
        return false;
    }

    // ENHANCED FOR - search
    public Character findMember(String name) {
        for (Character c : members) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    // ArrayList: SIZE
    public int getSize() {
        return members.size();
    }

    // ArrayList: ISEMPTY
    public boolean isEmpty() {
        return members.isEmpty();
    }

    // ENHANCED FOR - display
    public void displayParty() {
        System.out.println("\n=== Party: " + partyName + " ===");
        if (isEmpty()) {
            System.out.println("(Empty party)");
            return;
        }

        int index = 1;
        for (Character c : members) {
            System.out.print(index + ". ");
            c.displayInfo();
            index++;
        }
        System.out.println("Members: " + getSize() + "/" + maxSize);
    }

    // ENHANCED FOR - filter
    public ArrayList<Character> getAliveMembers() {
        ArrayList<Character> alive = new ArrayList<Character>();
        for (Character c : members) {
            if (c.isAlive()) {
                alive.add(c);
            }
        }
        return alive;
    }

    // ENHANCED FOR - sum
    public int getTotalHealth() {
        int total = 0;
        for (Character c : members) {
            total += c.getHealth();
        }
        return total;
    }
}