import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        while (!done) {
            displayList(list);
            displayMenu();
            String choice = SafeInput.getRegExString("Choose [A] for Add, [D] for Delete, [I] for Insert, [P] for Print, [Q]for Quit: ", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem(list);
                    break;
                case "D":
                    deleteItem(list);
                    break;
                case "I":
                    insertItem(list);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm("Quit. (Y/N)");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");

        System.out.println("[A] - Add item");

        System.out.println("[D] - Delete item");

        System.out.println("[I] - Insert item");


        System.out.println("[P] - Print");

        System.out.println("[Q] - Quit.\n");
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");

        if (list.isEmpty()) {

            System.out.println("[The list is empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {



                System.out.printf("%3d: %s\n", i + 1,    list.get(i));
            }


        }

    }

    private static void addItem(ArrayList<String> list) {


        String item = SafeInput.getNonZeroLenString("Item to Add:");
        list.add(item);


        System.out.println("Added.");
    }

    private static void deleteItem(ArrayList<String> list) {
        if (list.isEmpty()) {



            System.out.println("Empty. ");
            return;
        }

        int index = SafeInput.getRangedInt("Enter the item number to delete:", 1, list.size()) - 1;
        String removed = list.remove(index);
        System.out.println("Deleted: " + removed);
    }

    private static void insertItem(ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString("Enter the item to insert:");
        int index = SafeInput.getRangedInt("Enter Position (1 to " + (list.size() + 1) + "):", 1, list.size() + 1) - 1;
        list.add(index, item);

        System.out.println("Inserted.");











    }

    private static void printList(ArrayList<String> list) {
        System.out.println("\n Your List");
        if (list.isEmpty()) {
            System.out.println("[The list is empty]");
        } else {
            for (String item : list) {
                System.out.println(item);
            }
        }
        System.out.println("-------------\n");
    }
}
