package com.company;

public class Main {

    public static void main(String[] args) {
        SushiRestaurant.Info.printMenu();
        VeganRestaurant.Info.printMenu();
    }
}

//###################### RESTAURANT CLASSES ##########################
class SuperRestaurant {
    static class InfoRestaurant {
        static void print(double menuPrice, double specialMenuPrice) {
                         //Cделать правельные выравнивания !!!
            System.out.printf("MENU \t\t\tx 1\t\tportions  \t\t\t%.2f MDL\n", Menu.getPriceMenu(1, Menu.getDiscount(1), menuPrice));
            System.out.printf("MENU \t\t\tx 5\t\tportions(- %d%%)\t\t%.2f MDL\n", Menu.getDiscount(5), Menu.getPriceMenu(5, Menu.getDiscount(5),menuPrice));
            System.out.printf("SPECIAL MENU \tx 1\t\tportion \t\t\t%.2f MDL\n", Menu.getPriceMenu(1, Menu.getDiscount(1), specialMenuPrice));
            System.out.printf("SPECIAL MENU \tx 10\tportions(-%d%%)\t\t%.2f MDL\n" , Menu.getDiscount(10), Menu.getPriceMenu(10, Menu.getDiscount(10),specialMenuPrice));
        }
    }
}

class Menu {
    static int getDiscount(int portions) {
        int discount = 0;
        if(portions%5 == 0)
            discount = 10 * portions/5;
        return discount;
    }

    static double getPriceMenu(int portions,int discount, double price) {
        double toPay =portions * price - portions * price*discount/100;
        return toPay;
    }
}

class VeganRestaurant extends SuperRestaurant {
    static class Info extends InfoRestaurant {
        static void printName() {
            System.out.printf("############## Vegan Pure Restaurant #############\n");
        }
        static void printAddress() {
            System.out.printf("--UpTown Str 77/B, Maxicity\t\t\t\t\t\t\t--\n");
        }

        static void printMenu() {
            printName();
            printAddress();
            print(Menu.getPrice(), SpecialMenu.getPrice());
        }
    }

    static class Menu {
        static double getPrice() {
            return 100.00;
        }
    }

    static class SpecialMenu {
        static double getPrice() {
            return 1000.00;
        }
    }
}
class SushiRestaurant extends SuperRestaurant {
    static class Info extends InfoRestaurant {
        static void printName() {
            System.out.printf("############## Sushi Mini Restaurant ##############\n");
        }
        static void printAddress() {
            System.out.printf("--DownTown Str 88/A, Minicity\t\t\t\t\t\t\t--\n");
        }
        static void printMenu() {
            printName();
            printAddress();
            print(Menu.getPrice(), SpecialMenu.getPrice());
        }
    }

    static class Menu {
        static double getPrice() {
            return 200.00;
        }
    }

    static class SpecialMenu {
        static double getPrice() {
            return 300.00;
        }
    }
}
