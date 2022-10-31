import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().getResultOfDeposit();
    }

    double CalculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return getRound(pay, 2);
    }

    double CalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void getResultOfDeposit() {
        int period;
        int action;

        Scanner sumOfRubles = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount = sumOfRubles.nextInt();

        System.out.println("Введите срок вклада в годах:");

        period = sumOfRubles.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        action = sumOfRubles.nextInt();

        double outVar = 0;

        if (action == 1) {
            outVar = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outVar = CalculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }

}
