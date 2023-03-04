package org.example;

public class Revisor{
    private Store storeName;

    public Revisor(Store storeName) {
        this.storeName = storeName;
    }

    public void closeStore(){
        if(this.storeName.getName().equals("IKEA")){
            this.storeName.setName(null);
        }
    }

    public void rebrand() {
        if (this.storeName.getName() == null) {
            System.out.println("Магазин закрыт");
        } else if (this.storeName.getName().equals("MacDonalds")){
            this.storeName.setName("Вкусно и точка");
        } else {
            String name = this.storeName.getName().substring(1);
            this.storeName.setName(name);
        }
    }

}
