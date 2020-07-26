import java.util.List;

public class RingOfDestruction implements Item,Equippable {
    private final String itemName = "Ring Of Destruction";
    private List<ItemEffect> itemEffectsList = List.of( new ItemEffect(EffectType.DAMAGE_BOOST, 12));;

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
