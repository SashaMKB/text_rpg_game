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
}
