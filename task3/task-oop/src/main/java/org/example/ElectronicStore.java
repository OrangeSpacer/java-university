package org.example;

public class ElectronicStore extends Store {
    String typeOfElectronic;
    int salesVolume;
    public ElectronicStore(String typeOfElectronic,String name,int quantityOfGoods,String address) {
        super(name,quantityOfGoods,address);
        this.typeOfElectronic = typeOfElectronic;
    }

    public String getTypeOfElectronic() {
        return typeOfElectronic;
    }

    public int getSalesVolume() {
        return salesVolume;
    }



    public void setSalesVolume(int salesVolume) {
        if(salesVolume >= 0){
            this.salesVolume = salesVolume;
        }
    }

    public Boolean checkOfGoodsOrder() {
        if(getQuantityOfGoods() - this.salesVolume < 0){
            System.out.println("Требуется закупить больше товара");
            return true;
        }else{
            System.out.println("Закупка товара не требуется");
            return false;
        }
    }

    public void getAll() {
        System.out.println("Название магазина: "+getName());
        System.out.println("Количество товара: "+getQuantityOfGoods());
        System.out.println("Адресс: "+getAddress());
        System.out.println("Тип продаваемого товара: "+getTypeOfElectronic());
        System.out.println("Объем продаж: "+ getSalesVolume());
        System.out.println("Статус закупки товара: "+checkOfGoodsOrder());
    }
}
