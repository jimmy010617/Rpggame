import java.util.Scanner;

public class Main {
    
    static String[] jobArr = {"전사", "마법사", "궁수", "도적", "해적"};
    static String jobName;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("캐릭터 이름을 입력하세요 : ");
        String name = sc.nextLine();
        

        for (int i = 0; i < jobArr.length; i++) {
            System.out.println((i+1) + ". " + jobArr[i]);
        }

        jobSelectNumber(sc);

        Solider solider = soliderInfo(name);
        Monster monster = new Monster();
        Fight fight = new Fight(solider, monster);

        while(true) {
            System.out.println(fight.getMonsterLv() + "레벨 몬스터를 만났다!");
            fight(sc, solider, fight);
        }
    }

    private static void jobSelectNumber(Scanner sc) {
        System.out.print("직업 선택 : ");
        int jobSelectNumber = Integer.parseInt(sc.nextLine());
        switch (jobSelectNumber) {
            case 1:
                jobName = jobArr[Cons.Knight];  //전사
                break;
            case 2:
                jobName = jobArr[Cons.Wizard];  //마법사
                break;
            case 3:
                jobName = jobArr[Cons.Archer];  //궁수
                break;
            case 4:
                jobName = jobArr[Cons.Thief];  //도적
                break;
            case 5:
                jobName = jobArr[Cons.Pirate];  //해적
                break;
        }
    }

    private static Solider soliderInfo(String name) {
        Solider solider = new Solider(name, jobName);
        System.out.println("이름 :  " + solider.getName());
        System.out.println("직업 :  " + solider.getJob());
        System.out.println("레벨 : " + solider.getLv());
        System.out.println("체력 : " + solider.getHp());
        System.out.println("마력 : " + solider.getMp());
        System.out.println("경험치 : " + solider.getExp());
        return solider;
    }

    private static void fight(Scanner sc, Solider solider, Fight fight) {
        while (true) {
            System.out.println("1. 공격");
            System.out.println("2. 스킬");
            System.out.println("3. 회복");
            System.out.println("4. 그만");

            if (fightEnd(solider, fight)) break;

            int select = Integer.parseInt(sc.nextLine());
            if (select >= 5) {
                System.out.println("다시 입력하세요");
            }

            if (selectFightMenu(solider, fight, select)) break;
        }
    }

    private static boolean selectFightMenu(Solider solider, Fight fight, int select) {
        switch (select) {
            case 1:
                //공격
                fight.fight();
                System.out.println(solider.getName() + " 체력 : (" + fight.getSoliderHp() + " / 100");
                System.out.println("몬스터 체력 : " + fight.getMonsterHp());
                System.out.println();
                break;

            case 2:
                //스킬
                fight.soliderSkillAttack();
                System.out.println(solider.getName() + "체력 : " + fight.getSoliderHp());
                System.out.println(solider.getName() + "마력 : " + fight.getSoliderMp());
                System.out.println("몬스터 체력 : " + fight.getMonsterHp());
                System.out.println();
                break;
        
            case 3:
                //회복
                fight.soliderHealing();
                System.out.println(solider.getName() + " 체력 : " + fight.getSoliderHp() + " 회복되었습니다. ");
                System.out.println(solider.getName() + " 마력 : " + fight.getSoliderMp() + " 회복되었습니다. ");
                System.out.println();
                break;
        }
        if (select == 4) {
            //게임 종료
            System.out.println("게임을 종료합니다. ");
            System.exit(0);
            return true;
        }
        return false;
    }

    private static boolean fightEnd(Solider solider, Fight fight) {
        if (fight.isMonsterDie()) {
            fight.fightEnd();
            System.out.println("몬스터가 죽었습니다");
            fight.monsterLvUp();

            fight.soliderExpUp();
            System.out.println(solider.getName() + "의 경험치 : " + fight.getSoliderExp());

            fight.soliderMoneySum();
            System.out.println("총 획득한 돈 : " + fight.getSoliderMoney());
            return true;
            
        } else if (fight.isSoliderDie()) {
            fight.fightEnd();
            System.out.println(solider.getName() + "가 죽었습니다. 최종 레벨 : " + solider.getLv());
            System.out.println("게임을 종료합니다. ");
            System.exit(0);
            return true;
        }
        return false;
    }
}
