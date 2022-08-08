import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> productsList = new ArrayList<>();
        int operation = -1;

        while (operation != 0) {
            operation = getOperation(scanner);

            switch (operation) {
                case 0:
                    break;
                case -1:
                    continue;
                case 1:
                    add(scanner, productsList);
                    break;
                case 2:
                    show(productsList);
                    break;
                case 3:
                    remove(scanner, productsList);
                    break;
            }
        }
    }

    public static int getOperation(Scanner scanner) {
        System.out.println("Выберите операцию (1 - добавить; 2 - показать; 3 - удалить; 0 - выход):");

        String input = scanner.nextLine();
        int operation = 0;

        try {
            operation = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            System.out.println("Нужно ввести число!");
            operation = -1;
        }

        if (operation < 0 || operation > 3) {
            System.out.println("Не верный номер операции!");
            operation = -1;
        }

        return operation;
    }

    public static void add(Scanner scanner, ArrayList<String> productList) {
        System.out.println("Какую покупку хотите добавить?");
        String newProduct = scanner.nextLine();
        productList.add(newProduct);
        System.out.println("Итого покупок в списке: " + productList.size());
    }

    public static void show(ArrayList<String> productList) {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    public static void remove(Scanner scanner, ArrayList<String> productList) {
        System.out.println("Какую покупку хотите удалить?");
        String product = scanner.nextLine();

        try {
            product = productList.remove(Integer.parseInt(product));
        }
        catch (NumberFormatException ex) {
            if (productList.remove(product) == false) {
                System.out.println("Не верное название продукта!");
                return;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Не верный номер продукта!");
            return;
        }

        System.out.println("Покупка \"" + product + "\" удалена, список покупок:");
        show(productList);
    }
}
