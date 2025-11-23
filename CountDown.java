package miniprojects;

import java.util.Scanner;

public class CountDown {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the count down number: ");
        int num = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter the message you would like to say: ");
        String msg = sc.nextLine();

        System.out.print("Press \"Enter\" to Start:");
        sc.nextLine();

        for (int i = num; i >= 1; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println(msg);
        
        sc.close();
    }
}