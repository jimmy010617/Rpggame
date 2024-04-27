public class Fight {
    private static final int FULL_HP = 100;
    private static final int FULL_MP = 100;

    private boolean isFight;
    private int monsterHp;
    public int monsterLv;
    private int soliderHp;
    private int soliderMp; 
    private int soliderExp; 
    private int soliderMoney;


    public Fight(Solider solider, Monster monster) {
        isFight = true;

        soliderHp = solider.getHp();
        soliderMp = solider.getMp();
        soliderExp = solider.getExp();
        soliderMoney = solider.getMoney();

        monsterHp = monster.getHp();
        monsterLv = monster.getLv();
    }

    public boolean isFight() {
        return isFight;
    }

    public void fight() {
        monsterHp -= 15;
        soliderHp -= 5;
        monsterRandomHealing();
    }

    public void soliderSkillAttack() {
        if (soliderMp == 0) {
            System.out.println("마력이 부족해요");
        } else {
            soliderMp -= 10;
            soliderHp -= 25;
            monsterAttack();
            monsterRandomHealing();
        }
    }

    public void monsterRandomHealing() {
        if (monsterHp <= 25) {
            int rnd = (int) (Math.random() * 5);
            switch (rnd) {
                case 1:
                    monsterHp *= 0.25;
                    System.out.println("몬스터 체력 25 회복!");
                    System.out.println("몬스터 체력 : ");
                    break;
            }
        }
    }

    public void monsterAttack() {
        soliderHp -= 15;
    }

    public boolean isMonsterDie() {
        if (monsterHp <= 0) return true;
        return false;
    }

    public boolean isSoliderDie() {
        if (soliderHp <= 0) return true;
        return false;
    }

    public void soliderHealing() {
        int healingHp = FULL_HP - soliderHp;
        int healingMp = FULL_MP - soliderMp;

        if (soliderHp == FULL_HP) {
            System.out.println("체력이 다 꽉찼습니다.");
        } else if (soliderMp == FULL_MP) {
            System.out.println("마나가 다 꽉찼습니다.");
        }

        if (soliderHp == FULL_HP && soliderMp == FULL_MP) {
            System.out.println("체력과 마나가 다 꽉찼습니다.");
        }

        soliderHp += healingHp;
        soliderMp += healingMp;
    }

    public void soliderExpUp() {
        soliderExp *= 12;
    }

    public void monsterLvUp() {
        int i = 1;
        i++;
        monsterLv++;
        monsterHp *= i;
    }

    public void soliderMoneySum() {
        soliderMoney *= 13;
    }

    public void fightEnd() {
        isFight = false;
    }

    public int getMonsterHp() {
        return monsterHp;
    }

    public int getSoliderHp() {
        return soliderHp;
    }

    public int getSoliderExp() {
        return soliderExp;
    }

    public int getSoliderMoney() {
        return soliderMoney;
    }

    public int getSoliderMp() {
        return soliderMp;
    }

    public int getMonsterLv() {
        return monsterLv;
    }
}
