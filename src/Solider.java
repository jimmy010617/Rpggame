public class Solider {
    private int lv = 1;
    private int hp = 100;
    private int mp = 100;
    private int exp = 0;
    private int money = 0;
    private String name;
    private String job;

    public Solider(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getExp() {
        return exp;
    }

    public int getLv() {
        return lv;
    }

    public int getMp() {
        return mp;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }
}
