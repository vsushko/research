package com.sva.composite.menu;

/**
 * @author: vsa
 * @date: 18.10.16
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
