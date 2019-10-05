package com.twu.biblioteca;

public abstract class Item {
    protected int id;
    protected boolean checkedOut;

    public Item(int id, boolean checkedOut) {
        this.id = id;
        this.checkedOut = checkedOut;
    }

    public int getId() {
        return id;
    }

    public boolean getCheckedOut()
    {
        return checkedOut;
    }

    public void checkOut()
    {
        checkedOut = true;
    }

    public void checkIn()
    {
        checkedOut = false;
    }

    public abstract String getDetails();
}
