package unuts;

public class Peasant extends BaseHeroes {
    public Peasant(String name) {
        super("Крестьянин", name, 30, 1, 0, 1);
    }

    @Override
    public String toString() {
        return "Крестьянин " + name;
    }

    public void help() {  // пополнение значения свойств mp для магов, darts для лучников, hp для персонажей ближнего боя
    }

}
