import java.util.List;

public class RingOfHealth implements Item, Equippable {
    private final String itemName = "Ring Of Health";
    private List<ItemEffect> itemEffectsList = List.of(new ItemEffect(EffectType.HP_BOOST, 10), new ItemEffect(EffectType.DAMAGE_BOOST, 3));;

    public String getItemName() {
        return itemName;
    }

    @Override
    public SlotType getSlotType() {
        return SlotType.FINGER;
    }

    @Override
    public List<ItemEffect> getItemEffects() {
        return this.itemEffectsList;
    }
}
