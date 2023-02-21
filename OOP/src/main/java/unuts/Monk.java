package unuts;

public class Monk extends Magicans {
    public Monk(String name) {
        super("Монах", name, 45, 15, 3, 5, 10, 10);
    }

    @Override // + enhance (увеличение значения свойства def при лечении)
    public void heal () {
    }
}
