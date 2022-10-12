import java.util.Objects;

public class Hero {
    String name, race, prof;
    int hp = 0, damage = 0, exp, lvl;

    public Hero(String name,String race,String prof) {
        this.name = name;
        this.race = race;
        this.prof = prof;
    }


    public void create_hero() {
        if (Objects.equals(race, "elf")) {
            hp += 100;
            damage += 50;
        } else if (Objects.equals(race, "dwarf")) {
            hp += 50;
            damage += 100;
        }
        if (Objects.equals(prof, "archer")) {
            hp += 100;
            damage += 50;
        } else if (Objects.equals(prof, "warrior")) {
            hp += 50;
            damage += 100;
        }
    }
}
