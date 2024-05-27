package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    public static int roundNumber = 0;  // Сделал публичным, чтобы использовать в классе Hacker

    public static void startGame() {
        Boss boss = new Boss(1200, 50, "Zeus");
        Warrior warrior1 = new Warrior(270, 20, "Hercules");
        Warrior warrior2 = new Warrior(280, 15, "Achilles");
        Magic magic = new Magic(260, 20, "Merlin", 10);
        Berserk berserk = new Berserk(270, 15, "Guts");
        Medic doc = new Medic(250, 5, "Hendolf", 15);
        Medic assistant = new Medic(300, 5, "Junior", 5);
        Witcher witcher = new Witcher(420, 0, "Witcher");
        Hacker hacker = new Hacker(240, 10, "Hacker", 30);

        Hero[] heroes = {warrior1, doc, berserk, warrior2, magic, assistant, witcher, hacker};
        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
