import unuts.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Peasant peasant = new Peasant("Фродо");
        System.out.println(peasant.getName());

        ArrayList<BaseHeroes> teamWhite = new ArrayList<>();
        ArrayList<BaseHeroes> teamBlack = new ArrayList<>();

        teamWhite.add(new Arbalester("Леголас"));
        teamWhite.add(new Spearman("Арагорн"));
        teamWhite.add(new Monk("Гэндальф"));

        teamBlack.add(new Sniper("Маухур"));
        teamBlack.add(new Bandit("Луртц"));
        teamBlack.add(new Sorcerer("Саурон"));

        System.out.println("Команда White");
        teamWhite.forEach(n -> System.out.println(n.toString()));

        System.out.println("Команда Black");
        teamBlack.forEach(n -> System.out.println(n.toString()));


    }

}
