import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NotebookMain {
    public static void main(String[] args) {

        Notebook notebook1 = new Notebook(8, 256, "Windows", "black");
        Notebook notebook2 = new Notebook(8, 512, "Windows", "white");
        Notebook notebook3 = new Notebook(16, 1024, "Windows", "gray");
        Notebook notebook4 = new Notebook(16, 1024, "Windows", "black");
        Notebook notebook5 = new Notebook(32, 1024, "Linux", "black");
        Notebook notebook6 = new Notebook(16, 1024, "Linux", "black");
        Notebook notebook7 = new Notebook(12, 512, "Linux", "white");
        Notebook notebook8 = new Notebook(8, 512, "Linux", "gray");

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3,
                notebook4, notebook5, notebook6, notebook7, notebook8));
        // for (Notebook notebook : notebooks) {
        // System.out.println(notebook);
        // System.out.println();
        // }

        Map<Integer, String> complectationMap = new HashMap<>();
        complectationMap.put(1, "ram");
        complectationMap.put(2, "hdd");
        complectationMap.put(3, "operSystem");
        complectationMap.put(4, "color");

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        System.out.println("Choose filter criteria: ");
        System.out.println("1 - RAM");
        System.out.println("2 - HDD");
        System.out.println("3 - Operation System");
        System.out.println("4 - Color");

        while (true) {
            int criteria = scanner.nextInt();
            String criteriaKey = complectationMap.get(criteria);
            if (complectationMap.containsKey(criteria)) {
                if (criteria == 3) {
                    System.out.println("Choose Operation System:");
                    System.err.println("1 - Windows");
                    System.out.println("2 - Linux");
                    String chooseOpSys = scanner.next();
                    if (chooseOpSys.equals("1")) {
                        String value = "Windows";
                        filters.put(criteriaKey, value);
                    }
                    if (chooseOpSys.equals("2")) {
                        String value = "Linux";
                        filters.put(criteriaKey, value);
                    }
                }
                if (criteria == 4) {
                    System.out.println("Choose Color:");
                    System.err.println("1 - Black");
                    System.out.println("2 - White");
                    System.out.println("3 - Gray");
                    String chooseColor = scanner.next();
                    if (chooseColor.equals("1")) {
                        String value = "Black";
                        filters.put(criteriaKey, value);
                    }
                    if (chooseColor.equals("2")) {
                        String value = "White";
                        filters.put(criteriaKey, value);
                    }
                    if (chooseColor.equals("3")) {
                        String value = "Gray";
                        filters.put(criteriaKey, value);
                    }
                }
                if (criteria == 1 || criteria == 2) {
                    System.out.println("Input min for " + criteriaKey + ":");
                    String value = scanner.next();
                    filters.put(criteriaKey, value);
                }
            } else {
                System.out.println("Wrong criteria, please input again.");
            }
            System.out.println("Continue input? (yes/no)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("yes")) {
                System.out.println("Choose filter criteria: ");
                System.out.println("1 - RAM");
                System.out.println("2 - HDD");
                System.out.println("3 - Operation System");
                System.out.println("4 - Color");
            }
            if (input.equalsIgnoreCase("no")) {
                break;
            }
        }

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);
        if (filteredNotebooks.isEmpty()) {
            System.out.println("No such a notebook");
        } else {
            System.out.println("Notebooks mach you parameters: ");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook);
            }
        }
        scanner.close();
    }
    

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, String> filters) {

        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<String, String> filter : filters.entrySet()) {
            String key = filter.getKey();
            String value = filter.getValue();

            switch (key) {
                case "ram":
                    int minRam = Integer.parseInt(value);
                    filteredNotebooks.removeIf(notebook -> notebook.ram < minRam);
                    break;

                case "hdd":
                    int minHdd = Integer.parseInt(value);
                    filteredNotebooks.removeIf(notebook -> notebook.hdd < minHdd);
                    break;

                case "operSystem":
                    filteredNotebooks.removeIf(notebook -> !notebook.operSystem.equalsIgnoreCase(value));
                    break;

                case "color":
                    filteredNotebooks.removeIf(notebook -> !notebook.color.equalsIgnoreCase(value));
                    break;
            }
        }
        return filteredNotebooks;
    }
}
