package com.sva.iterator.dinnermergeri;

import java.util.ArrayList;

/**
 * @author vsa
 * @created 10/15/16
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        ArrayList<Menu> menus = new ArrayList<>();
        menus.add((Menu) pancakeHouseMenu);
        menus.add((Menu) dinerMenu);

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
