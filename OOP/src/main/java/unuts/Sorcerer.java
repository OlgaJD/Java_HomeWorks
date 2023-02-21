package unuts;

public class Sorcerer extends Magicans {
    public Sorcerer(String name) {
        super("Колдун", name, 45, 17, 4, 5, 10, 10);
    }

    @Override   // + curse (уменьшение значения свойства def при атаке)
    public void Attack() {
    }

}
