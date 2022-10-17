public class Enemy {
    String name;
    int hp, damage;

    public Enemy(String name) {
        this.name = name;
    }

    public  void createEnemy() {
        hp = (int) (10 + Math.random()*40);
        damage = (int) (30 + Math.random()*40);
    }

    public  void  enemyAttack(Hero hero) throws InterruptedException {
        hero.hp -= this.damage;
        if (hero.hp <= 0) {
            System.out.println("You dead.");
            System.exit(0);
        } else {
            System.out.println("Enemy hit you.");
            Thread.sleep(2000);
        }
    }
}
