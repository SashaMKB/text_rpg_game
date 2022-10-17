public class Enemy {
    String name;
    int hp, damage;

    public Enemy(String name) {
        this.name = name;
    }

    public  void create_enemy() {
        hp = (int) (10 + Math.random()*40);
        damage = (int) (30 + Math.random()*40);
    }

    public  void  enemy_attack(Hero hero) {
        hero.hp -= this.damage;
        if (hero.hp <= 0) {
            System.out.println("You dead.");
        } else {
            System.out.println("Enemy hit you.");
        }
    }
}
