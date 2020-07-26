import java.util.List;

public interface Usable {
    public abstract int usesLeft();
    public abstract List<ItemEffect> use();
}
