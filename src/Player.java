import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractPlayer {
    public Player(){
        super(10, 10, 20 ,10);
    }

    @Override
    public List<Slot> playerSlotList() {
        return List.of(new Slot(SlotType.CHEST), new Slot(SlotType.NECK), new Slot(SlotType.HAND), new Slot(SlotType.FINGER), new Slot(SlotType.LEGS));
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
