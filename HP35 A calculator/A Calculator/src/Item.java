public class Item {
    private ItemType type;
    private int value = 0;

    public Item(int val, ItemType typ) {
        this.value = val;
        this.type = typ;
    }

    public int getValue(){
        return value;
    }

    public ItemType getType(){
        return type;
    }
}
