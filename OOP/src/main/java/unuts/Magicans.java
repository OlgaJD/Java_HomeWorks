package unuts;

public abstract class Magicans extends BaseHeroes {
    protected int mp;
    protected int maxMp;
    public Magicans(String heroType, String name, int hp, int damage, int def, int speed, int mp, int maxMp) {
        super(heroType, name, hp, damage, def, speed);
        this.mp = mp;
        this.maxMp = maxMp;
    }

    public void heal () {
    }

}
