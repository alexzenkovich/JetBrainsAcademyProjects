import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        while (a!=0){
            list.add(a);
            a = scanner.nextInt();
        }
        for (int i = 0; i < list.size(); i++){
            if (list.get(i)%2==0){
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}