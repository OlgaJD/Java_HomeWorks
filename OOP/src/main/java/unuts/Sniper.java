package unuts;


public class Sniper extends Archers{
    boolean luck;
    public Sniper(String name) {
        super("Снайпер", name, 50, 10, 3, 5, 10, 10);
    }

    @Override // + дополнительный разовый damage при выпадении значения luck (Random)
    public void Attack() {
    }
}
