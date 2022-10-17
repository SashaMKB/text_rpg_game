import java.util.Objects;

public class Hero {
    String name, race, prof;
    int hp = 0, damage = 0, exp, lvl;

    public Hero(String name,String race,String prof) {
        this.name = name;
        this.race = race;
        this.prof = prof;
    }


    public void createHero() {
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
    public boolean heroAttack(Enemy enemy) {
        int maxexp = this.lvl *100;
        enemy.hp -= this.damage;
        if (enemy.hp <= 0) {
            System.out.printf("Gratz, %s disabled. +20 experience\n", enemy.name);
            this.exp += 20;
            if (this.exp > maxexp) {
                levelUp(maxexp);
            }
            return false;
        } else {
            System.out.printf("Enemy not disabled, he has %d health-point\n", enemy.hp);
        }
        return true;
    }
    public void levelUp(int maxexp) {
        this.exp -= maxexp;
        this.lvl += 1;
        this.damage += this.lvl * 5;
        this.hp += this.lvl *10;
        System.out.printf("Nice, your level was update. Now you %d lvl\n", this.lvl);

    }
}
