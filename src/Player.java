import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractPlayer {
    public Player(String name){
        super(10, 10, 20 ,10);
        playerSlotList = setPlayerSlotList();
        setPlayerName(name);
    }

    @Override
    public  List<Slot> setPlayerSlotList() {
        return  List.of(new Slot(SlotType.CHEST, 1), new Slot(SlotType.NECK,1), new Slot(SlotType.HAND,2), new Slot(SlotType.FINGER,10), new Slot(SlotType.LEGS,2));
    }

    @Override
    public int getLevelHP() {
        return levelBonusMap(getLevel(getExperiencePoints())).getHP();
    }

    @Override
    public int getLevelMP() {
        return levelBonusMap(getLevel(getExperiencePoints())).getMP();
    }

    @Override
    public int getLevelInt() {
        return levelBonusMap(getLevel(getExperiencePoints())).getInt();
    }

    @Override
    public int getLevelStr() {
        return levelBonusMap(getLevel(getExperiencePoints())).getStr();
    }

    @Override
    public int getIntelligence() {
        return getBaseIntelligence()+getLevelInt();
    }

    @Override
    public int getStrength() {
        return getBaseStrength()+getLevelInt();
    }

    @Override
    public int getMaxHP() {
        return getHitPoints()+getLevelHP()+getBoostfromEquippedItems(EffectType.HP_BOOST);
    }

    @Override
    public int getMaxMana() {
        return getManaPoints()+getLevelMP()+getBoostfromEquippedItems(EffectType.MANA_BOOST);
    }

    @Override
    public int getAttackDamage() {
        return getBoostfromEquippedItems(EffectType.DAMAGE_BOOST);
    }


}
