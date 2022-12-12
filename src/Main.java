import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int magicType = 1;
        int physicType = 2;
        int magic_physic = 3;
        System.out.println("Введите тип урона\n" +
                "1.Магический\n" +
                "2.Физический\n" +
                "3.Физический + магический");
        int dmgType = sc.nextInt();
        System.out.println("Введите урон от вашей первой изученной способности");
        double dmgYourSkill = sc.nextDouble();
        System.out.println("Введите урон от первой изученной способности тиммейта");
        double teammateSkillDmg = sc.nextDouble();
        System.out.println("Введите урон от вашего райтклика");
        double yourRightCl = sc.nextDouble();
        System.out.println("Введите урон с райтклика союзника");
        double teammateRightCl = sc.nextDouble();
        System.out.println("Введите физический резист противника");
        double enemyPhysicalResist = sc.nextDouble();
        double yourRightClDmgWithPhysicalResist = formulaResist(yourRightCl, enemyPhysicalResist);
        double teammateRightClDmgWithPhysicalResist = formulaResist(teammateRightCl, enemyPhysicalResist);
        if (dmgType == magicType){
            System.out.println("Введите магический резист противника");
            double magResist = sc.nextDouble();
            double dmgWithMagResist = formulaResist(dmgYourSkill, magResist);
            double sumDmgWithMagAndPhysicResist = formulaSumDmgWithResist(dmgWithMagResist, yourRightClDmgWithPhysicalResist);
            double teammateSkillDmgWithMagResist = formulaResist(teammateSkillDmg, magResist);
            double sumDmgTeammateWithPhysicalAndMagicalResist = formulaSumDmgWithResist(teammateSkillDmgWithMagResist, teammateRightClDmgWithPhysicalResist);
            double allDmgWithTeammateWithAllResists = sumDmgWithMagAndPhysicResist + sumDmgTeammateWithPhysicalAndMagicalResist;
            System.out.println("Ваш урон с тиммейтом с учетом резистов и нанесении не менее 4 тычек " + allDmgWithTeammateWithAllResists);
        }
        if (dmgType == physicType) {
            double dmgWithPhysicalResist = formulaResist(dmgYourSkill, enemyPhysicalResist);
            double sumDmgWithPhysicResist = formulaSumDmgWithResist(dmgWithPhysicalResist, yourRightClDmgWithPhysicalResist);
            double teammateSkillDmgWithPhysicResist = formulaResist(teammateSkillDmg, enemyPhysicalResist);
            double sumDmgTeammateWithPhysicalResist = formulaSumDmgWithResist(teammateSkillDmgWithPhysicResist, teammateRightClDmgWithPhysicalResist);
            double allDmgWithTeammateWithAllResists = sumDmgWithPhysicResist + sumDmgTeammateWithPhysicalResist;
            System.out.println("Ваш урон с учетом физического резиста " + allDmgWithTeammateWithAllResists);
        }
        if (dmgType == magic_physic) {
            System.out.println("Введите тип урона вашей способности\n" +
                    "1.Магический\n" +
                    "2.Физический");
            int yourSkillDamageTypeMagical = 1;
            int yourSkillDamageTypePhysical = 2;
            double yourSkillDamageType = sc.nextDouble();
                if (yourSkillDamageType == yourSkillDamageTypeMagical) {
                    System.out.println("Введите магический резист противника");
                    double magResist = sc.nextDouble();
                    double teammateSkillDamageWithPhysicalResist = formulaResist(teammateSkillDmg, enemyPhysicalResist);
                    double yourDmgWithMagResist = formulaResist(dmgYourSkill, magResist);
                    double sumYourDmgWithMagAndPhysicResist = formulaSumDmgWithResist(yourDmgWithMagResist, yourRightClDmgWithPhysicalResist);
                    double sumTeammateDmgWithPhysicResist = formulaSumDmgWithResist(teammateSkillDamageWithPhysicalResist, teammateRightClDmgWithPhysicalResist);
                    double allDmgWithTeammateWithAllResists = sumYourDmgWithMagAndPhysicResist + sumTeammateDmgWithPhysicResist;
                    System.out.println("Ваш урон с тиммейтом с учетом всех резистов составит - " + allDmgWithTeammateWithAllResists);
                }
                    if (yourSkillDamageType == yourSkillDamageTypePhysical) {
                        System.out.println("Введите магический резист противника");
                        double magResist = sc.nextDouble();
                        System.out.println("Введите урон первой изученной способности союзника");
                        double teammateSkillDamage = sc.nextDouble();
                        double teammateSkillDamageWithMagicalResist = formulaResist(teammateSkillDamage, magResist);
                        double yourDmgWithPhysicalResist = formulaResist(dmgYourSkill, enemyPhysicalResist);
                        double sumYourDmgWithPhysicResist = formulaSumDmgWithResist(yourDmgWithPhysicalResist, yourRightClDmgWithPhysicalResist);
                        double sumTeammateDmgWithMagicalAndPhysicResist = formulaSumDmgWithResist(teammateSkillDamageWithMagicalResist, teammateRightClDmgWithPhysicalResist);
                        double allDmgWithTeammateWithAllResists = sumYourDmgWithPhysicResist + sumTeammateDmgWithMagicalAndPhysicResist;
                        System.out.println("Ваш урон с тиммейтом с учетом всех резистов составит - " + allDmgWithTeammateWithAllResists);
                }
        }
    }
    public static double formulaResist(double a, double b){
        return a - (a * b / 100);
    }
    public static double formulaSumDmgWithResist(double a, double b) {
        return a + (b * 4);
    }
    }
