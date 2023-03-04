package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вариант 5");
        System.out.println("Группа: РИБО-01-21");
        System.out.println("Махаев Артём Сергеевич");

        System.out.println("Введите тип электроники,которую продает магазин");
        String typeOfElectronic = scanner();
        System.out.println("Введите название магазина");
        String nameOfMagazine = scanner();
        System.out.println("Введите адресс магазина");
        String address = scanner();
        System.out.println("Введите количетсво товара на складе");
        int quantityOfGoods = Integer.parseInt(scanner());

        ElectronicStore store = new ElectronicStore(typeOfElectronic,nameOfMagazine,quantityOfGoods,address);

        System.out.println("Введите объем продаж");
        int salesVolume = Integer.parseInt(scanner());
        store.setSalesVolume(salesVolume);

        store.getAll();
        Revisor revisor = new Revisor(store);
        revisor.closeStore();
        revisor.rebrand();
        store.getAll();

    }

    private static String scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}