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
        } else if (Objects.equals(race, "shifter")) {
            hp += 90;
            damage += 60;
        } else if (Objects.equals(race, "human")) {
            hp += 75;
            damage +=75;
        }
        if (Objects.equals(prof, "archer")) {
            hp += 50;
            damage += 100;
        } else if (Objects.equals(prof, "warrior")) {
            hp += 100;
            damage += 50;
        } else if (Objects.equals(prof, "robber")) {
            hp += 75;
            damage += 90;
        } else if (Objects.equals(prof, "shaman")) {
            hp += 65;
            damage += 60;
        }
    }
    public boolean hero_attack(Enemy enemy) {
        enemy.hp -= this.damage;
        if (enemy.hp <= 0) {
            System.out.printf("Gratz, %s disabled", enemy.name);
            return false;
        } else {
            System.out.printf("Enemy not disabled, he has %d health-point", enemy.hp);
        }
        return true;
    }
}
