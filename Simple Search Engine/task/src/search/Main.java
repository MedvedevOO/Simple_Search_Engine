package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

                    File file = new File(args[1]);
            Scanner scanner = new Scanner(file);
            ArrayList<String> people = new ArrayList<>();

            while(scanner.hasNextLine()) {
                String human = scanner.nextLine();
                people.add(human);
            }
            scanner.close();
            int areWeRunning = 1;
            while (areWeRunning == 1) {
                System.out.println("=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit\n");
                Scanner scanner2 = new Scanner(System.in);
                int menuNumber = Integer.parseInt(scanner2.nextLine());

                switch (menuNumber) {
                    case 1:
                        System.out.println("Enter a name or email to search all suitable people.");
                        String query = scanner2.nextLine();
                        ArrayList<String> result = new ArrayList<>();
                        for (String man : people) {
                            if (man.toLowerCase().contains(query.toLowerCase())) {
                                result.add(man);
                            }
                        }
                        if (result.size() > 0) {

                            for (String person : result) {
                                System.out.println(person);
                            }
                        } else {
                            System.out.println("No matching people found.");
                        }
                        break;
                    case 2:
                        for (String man : people) {
                            System.out.println(man);
                        }
                        break;
                    case 0:
                        System.out.println("Bye!");
                        areWeRunning = 0;
                        break;
                }


            }
        }
    }

