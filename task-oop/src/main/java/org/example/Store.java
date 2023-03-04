package org.example;

public class Store {
    private String name;
    private int quantityOfGoods;
    private String address;

    public Store(String name, int quantityOfGoods, String address) {
        this.name = name;
        this.address = address;
        this.quantityOfGoods = quantityOfGoods;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOfGoods() {
        return quantityOfGoods;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityOfGoods(int quantityOfGoods) {
        if(quantityOfGoods > 0){
            this.quantityOfGoods = quantityOfGoods;
        }else{
            System.out.print("Количетсво товара должно быть больше 0");
        }

    }

    public void setTypesOfGoods(String typesOfGoods) {
        this.address = typesOfGoods;
    }

    public void orderOfProduct(int quantityOfGoods) {
        if(quantityOfGoods > 0){
            this.quantityOfGoods += quantityOfGoods;
        }else{
            System.out.print("Нельзя заказать меньше 1 товара");
        }
    }

    public void writeOffTheMarriage (int quantityOfMarriage) {
        if(quantityOfMarriage > 0 && quantityOfMarriage < this.quantityOfGoods) {
            this.quantityOfGoods -= quantityOfMarriage;
        }else{
            System.out.println("Неподходящее значение");
        }
    }
}
