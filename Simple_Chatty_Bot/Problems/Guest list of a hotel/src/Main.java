// Posted from EduTools plugin
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;//put imports you need here

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        list.add(scanner.next());
        list.add(scanner.next());
        list.add(scanner.next());
        list.add(scanner.next());
        list.add(scanner.next());
        list.add(scanner.next());
        list.add(scanner.next());
        list.add(scanner.next());

        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }// put your code here
    }
}