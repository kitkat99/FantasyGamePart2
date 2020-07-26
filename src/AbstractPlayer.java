import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class
AbstractPlayer {
    private int hitPoints;
    private int manaPoints;
    private int baseStrength;
    private int baseIntelligence;
    private int experiencePoints;
    private List<Item> Inventory = new ArrayList<>();

    public int getHitPoints() {
        return hitPoints;
    }

    public int getBaseIntelligence() {
        return baseIntelligence;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public AbstractPlayer(int baseStrength, int baseIntelligence, int hitPoints, int manaPoints) {
        this.baseIntelligence = baseIntelligence;
        this.baseStrength = baseStrength;
        this.hitPoints = hitPoints;
        this.manaPoints = manaPoints;
    }

    public int getLevel(int experiencePoints) {
        int[] levelArray = new int[]{0, 299, 899, 2699, 6499};
        int counter = 1;
        if (experiencePoints > 6499) {
            return 5;
        }
        for (int i = 0; i < levelArray.length; i++) {

            if (levelArray[i] < experiencePoints && experiencePoints < levelArray[i + 1]) {

                counter = i + 1;
            }
        }
        return counter;
    }

    public LevelBonus levelBonusMap(int level) {
        Map<Integer, LevelBonus> bonusMap = new HashMap<>() {{
            put(1, new LevelBonus(0, 0, 0, 0));
            put(2, new LevelBonus(10, 10, 20, 16));
            put(3, new LevelBonus(15, 15, 40, 24));
            put(4, new LevelBonus(20, 18, 60, 40));
            put(5, new LevelBonus(25, 20, 80, 40));
        }};
        return bonusMap.get(level);
    }

    public abstract List<Slot> createPlayerSlotList();

    public void pickUp(Item item) {
        Inventory.add(item);
    }

    public void drop(Item item) {
        if (!isItemEquipped(item))
            Inventory.remove(item);
        else {
            System.out.println("Cannot drop the item, it is equipped");
        }
    }

    public boolean isItemEquipped(Item item) {
        List<Item> equippedItems = new ArrayList<>();
        this.createPlayerSlotList().forEach(e -> equippedItems.addAll(e.getListOfItems()));
        return equippedItems.stream().anyMatch(x -> x.equals(item));
    }

    public List<Item> getEquippedItems() {
        List<Item> equippedItems = new ArrayList<>();
        this.createPlayerSlotList().forEach(e -> equippedItems.addAll(e.getListOfItems()));
        return equippedItems;
    }

    public List<ItemEffect> getEquippedItemEffect() {
        List<ItemEffect> equippedItemEffect = new ArrayList<>();
        getEquippedItems().forEach(e -> equippedItemEffect.addAll(e.getItemEffects()));
        return equippedItemEffect;
    }

    public int getBoostfromEquippedItems(EffectType effectType) {
        Integer acc = 0;
        for (ItemEffect e : getEquippedItemEffect()) {
            if (e.getEffectType() == effectType) {
                Integer amountEffect = e.getAmountEffect();
                acc = acc + amountEffect;
            }
        }
        return acc;
    }

    public abstract int getLevelHP();

    public abstract int getLevelMP();

    public abstract int getLevelInt();

    public abstract int getLevelStr();

    public abstract int getIntelligence();

    public abstract int getStrength();

    public abstract int getMaxHP();

    public abstract int getMaxMana();

    public abstract int getAttackDamage();

    public void addXP(int XPoints) {
        experiencePoints += XPoints;
    }

    public void removeXP(int XPoints) {
        experiencePoints -= XPoints;
    }
}
