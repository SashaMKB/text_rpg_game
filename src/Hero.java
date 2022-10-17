import java.util.Objects;
import java.util.Random;

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
    public boolean heroAttack(Enemy enemy) throws InterruptedException {
        int maxexp = this.lvl *100;
        Random rnd = new Random();
        int evt = rnd.nextInt(3);
        if (evt == 0) {
            enemy.hp -= this.damage;
        } else if (evt == 1) {
            enemy.hp -= (this.damage * 0.5);
        } else {
            enemy.hp -= (this.damage * 0.1);
        }
        if (enemy.hp <= 0) {
            System.out.printf("Gratz, %s disabled. +20 experience\n", enemy.name);
            Thread.sleep(2000);
            this.exp += 20;
            if (this.exp > maxexp) {
                levelUp(maxexp);
            }
            int thing = new Random().nextInt(3);
            if (thing == 0) {
                String wpn = createWeapon();
                System.out.printf("You have %s now", wpn);
                Thread.sleep(2000);
            } if (thing == 1) {
                String arm = createArmor();
                System.out.printf("You have %s now", arm);
                Thread.sleep(2000);
            } if (thing == 2) {
                System.out.printf("....");
            }
            return false;
        } else {
            System.out.printf("Enemy not disabled, he has %d health-point\n", enemy.hp);
            Thread.sleep(2000);
        }
        return true;
    }
    public void levelUp(int maxexp) throws InterruptedException {
        this.exp -= maxexp;
        this.lvl += 1;
        this.damage += this.lvl * 5;
        this.hp += this.lvl *10;
        System.out.printf("Nice, your level was update. Now you %d lvl\n", this.lvl);
        Thread.sleep(2000);
    }
    public String createWeapon() {
        int rnd = new Random().nextInt(Main.weapon_type_list.length);
        String wpn_type = Main.weapon_type_list[rnd];

        int rare_rnd = new Random().nextInt(Main.rare_dict.length);
        int rare = Main.rare_dict[rare_rnd];

        if (Objects.equals(wpn_type, Main.weapon_type_list[0])){
            this.damage += 4*rare;
        } else if (Objects.equals(wpn_type, Main.weapon_type_list[1])){
            this.damage += 5*rare;
        } else if (Objects.equals(wpn_type, Main.weapon_type_list[2])){
            this.damage += 6*rare;
        }
        return wpn_type;
    }
    public String createArmor() {
        int rnd = new Random().nextInt(Main.armor_type_list.length);
        String arm_type = Main.armor_type_list[rnd];

        int rare_rnd = new Random().nextInt(Main.rare_dict.length);
        int rare = Main.rare_dict[rare_rnd];

        if (Objects.equals(arm_type, Main.armor_type_list[0])){
            this.hp += 4*rare;
        } else if (Objects.equals(arm_type, Main.armor_type_list[1])){
            this.hp += 5*rare;
        } else if (Objects.equals(arm_type, Main.armor_type_list[2])){
            this.hp += 6*rare;
        }
        return arm_type;
    }
}
