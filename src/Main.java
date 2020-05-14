import Model.coffees.*;
import Model.singleton.Barista;
import Model.command.Order;
import Model.command.Waiter;
import Repository.CoffeeRepository;
import Repository.OrdersRepository;
import Service.CoffeeShopProxy;
import Service.CoffeeShopService;

import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    DESIGN PATTERNS
    1 creational - Singleton
    2 structural - Decorator, Proxy
    2 behavioral - State, Command
     */
    public static void printAdministratorMenu() {
        System.out.println("Administrator Menu");
        System.out.println("1. See coffee menu");
        System.out.println("2. See today orders");
        System.out.println("0. EXIT");
    }

    public static void printClientMenu() {
        System.out.println("Client Menu");
        System.out.println("1. See coffee menu");
        System.out.println("2. Order coffee");
        System.out.println("0. EXIT");
    }

    public static String login() {
        System.out.println("Are you an administrator or a client?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        if (username.equals("admin")) {
            return "admin";
        } else return "client";
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our coffee shop :)");
        String result = login();

        OrdersRepository ordersRepo = new OrdersRepository();
        Barista ourBarista = Barista.getInstance();
        CoffeeRepository coffeeRepository = new CoffeeRepository();
        CoffeeShopService coffeeShop = new CoffeeShopService(coffeeRepository);
        coffeeShop.populateMenu();

        Order order1 = new Order(ourBarista, new Espresso());
        ordersRepo.addOrder(order1);
        Order order2 = new Order(ourBarista, new Decaf());
        ordersRepo.addOrder(order2);

        switch (result) {
            case ("client"): {
                printClientMenu();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter command here: ");
                String command = scanner.nextLine();
                while (true) {
                    printClientMenu();
                    CoffeeShopProxy service = new CoffeeShopProxy(coffeeShop, "client");

                    switch (command) {
                        case ("1"): {
                            //see menu
                            List<Coffee> menu = service.getMenu();
                            for (Coffee c : menu) {
                                System.out.println("Coffee: " + c.getTitle());
                                System.out.println("Coffee price: " + c.getPrice() + " dollars");
                                System.out.println("Ingredients:");
                                for (Ingredient i : c.getIngredientList()) {
                                    System.out.println(i);
                                }
                                System.out.println("____________________________");
                            }
                            break;
                        }
                        case ("2"): {
                            //order a coffee
                            System.out.println("Enter title");
                            String title = scanner.nextLine();
                            Coffee c = service.getCoffeeByTitle(title);
                            Order order = new Order(ourBarista, c);
                            ordersRepo.addOrder(order);
                            Waiter waiter = new Waiter(order);
                            service.orderCoffee(ourBarista, waiter);
                            break;
                        }
                        case ("0"): {
                            System.exit(0);
                        }
                        default: {
                            System.out.println("invalid command");
                        }
                    }
                    System.out.println("Enter command here: ");
                    command = scanner.nextLine();
                }
            }
            case ("admin"): {
                printAdministratorMenu();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter command here: ");
                String command = scanner.nextLine();
                while (true) {
                    printAdministratorMenu();

                    switch (command) {
                        case ("1"): {
                            //see menu
                            List<Coffee> menu = coffeeShop.getMenu();
                            for (Coffee c : menu) {
                                System.out.println("Coffee: " + c.getTitle());
                                System.out.println("Coffee price: " + c.getPrice() + " dollars");
                                System.out.println("Ingredients:");
                                for (Ingredient i : c.getIngredientList()) {
                                    System.out.println(i);
                                }
                                System.out.println("____________________________");
                            }
                            break;
                        }
                        case ("2"): {
                            //see orders
                            for (Order o : ordersRepo.getOrders()) {
                                System.out.println(o.getCoffee().getTitle() + " " + o.getCoffee().getPrice() + " " + o.getBarista().getName());
                            }
                            break;
                        }
                        case ("0"): {
                            System.exit(0);
                        }
                        default: {
                            System.out.println("invalid command");
                        }
                    }
                    System.out.println("Enter command here: ");
                    command = scanner.nextLine();
                }
            }
            default: {
                System.out.println("Something went wrong");
            }
        }
    }
}
