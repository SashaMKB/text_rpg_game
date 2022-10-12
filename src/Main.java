import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static String[] race_list = {"elf","dwarf"};
    static String[] profession_list = {"archer","warrior"};
    static String[] enemy_list = {"Dark elf", "Orc"};
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter name for your hero:");
        String hero_name  = buf.readLine();

        System.out.print("Available race:");
        System.out.println(Arrays.toString(race_list));
        System.out.println("Enter your race:");
        String hero_race = (buf.readLine()).toLowerCase();

        System.out.print("Available profession:");
        System.out.println(Arrays.toString(profession_list));
        System.out.println("Enter your profession:");
        String hero_prof = (buf.readLine()).toLowerCase();

        Hero my_hero = new Hero(hero_name, hero_race,hero_prof);
        my_hero.create_hero();

        int rnd = new Random().nextInt(enemy_list.length);
        Enemy enemy = new Enemy(enemy_list[rnd]);
        enemy.create_enemy();
        System.out.println(enemy.hp);
    }
}