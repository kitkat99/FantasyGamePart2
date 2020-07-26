import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class Slot {
    private SlotType slotType;
    private int capacity;
    private Set<Item> listOfItems;

    public Set<Item> getListOfItems() {
        return listOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public Slot(SlotType slotType) {
        this.slotType = slotType;
    }

    public boolean equip(Item item) throws IllegalArgumentException {
        try {
            if (!(item instanceof Equippable))
                throw new IllegalArgumentException("The Item is not Equippable");
            else if ((((Equippable) item).getSlotType() != slotType))
                throw new IllegalArgumentException("Slot doesn't fit");
            else {
                if (capacity == 0) {
                    System.out.println("Max capacity reached for this slot");
                    return false;
                } else {
                    if (doesDuplicateExist(item))
                        throw new IllegalArgumentException("Item already exists");
                    else {
                        listOfItems.add(item);
                        capacity--;
                        return true;
                    }

                }
            }
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
            return false;
        }

    }

    public boolean remove(Item item) throws IllegalArgumentException {
        try {
            capacity++;
            return listOfItems.remove(item);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

    }

    private boolean doesDuplicateExist(Item item) {
        boolean isDuplicate = false;
        Item[] listofItems = listOfItems.toArray(new Item[listOfItems.size()]);
        for (int i = 1; i < listofItems.length; i++) {
            if (listofItems[i].getItemName() == item.getItemName()) {
                isDuplicate = true;
            }
        }
        return isDuplicate;

    }
}
