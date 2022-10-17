import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Main {
    static String[] race_list = {"elf","dwarf","shifter","human"};
    static String[] profession_list = {"archer","warrior","robber","shaman"};
    static String[] enemy_list = {"Dark elf", "Orc"};

    static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        System.out.println("Enter name for your hero:");
        String hero_name = buf.readLine();

        System.out.print("Available race:");
        System.out.println(Arrays.toString(race_list));
        System.out.println("Enter your race:");
        String hero_race = (buf.readLine()).toLowerCase();

        System.out.print("Available profession:");
        System.out.println(Arrays.toString(profession_list));
        System.out.println("Enter your profession:");
        String hero_prof = (buf.readLine()).toLowerCase();

        Hero my_hero = new Hero(hero_name, hero_race, hero_prof);
        my_hero.create_hero();
        while (true) {
            Random rand = new Random();
            int event = rand.nextInt(2);
            if (event == 0) {
                System.out.println("You meet nobody");
            } else {
                int rnd = new Random().nextInt(enemy_list.length);
                Enemy enemy = new Enemy(enemy_list[rnd]);
                enemy.create_enemy();System.out.printf("You meet %s. HP: %d. Damage: %d\n", enemy.name, enemy.hp, enemy.damage);
                System.out.printf("Now, you have HP: %d and Damage:%d\n", my_hero.hp, my_hero.damage);
                fight_choice(my_hero, enemy);
            }
    }
    }
    public static void fight_choice(Hero hero, Enemy enemy) throws IOException {
            System.out.printf("Do you want to fight %s? (yes or no)\n", enemy.name);
            String answer = buf.readLine();
            if (Objects.equals(answer.toLowerCase(), "yes")) {
                boolean result = hero.hero_attack(enemy);
                if (result) {
                    enemy.enemy_attack(hero);
                    fight_choice(hero,enemy);
                }
            } else if (Objects.equals(answer.toLowerCase(), "no")) {
                System.out.printf("You run away from %s\n", enemy.name);
            } else {
                System.out.println("What?\n");
                fight_choice(hero,enemy);
            }
    }
}