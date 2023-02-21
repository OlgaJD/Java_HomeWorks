package unuts;

public abstract class Archers extends BaseHeroes{
    protected int darts;
    protected int maxDarts;
    public Archers(String heroType, String name, int hp, int damage, int def, int speed, int darts, int maxDarts) {
        super(heroType, name, hp, damage, def, speed);
        this.darts = darts;
        this.maxDarts = maxDarts;
    }

}
