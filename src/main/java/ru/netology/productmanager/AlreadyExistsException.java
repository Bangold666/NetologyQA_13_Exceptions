package ru.netology.productmanager;

public class AlreadyExistsException  extends RuntimeException{

    public AlreadyExistsException (String s){
        super(s);
    }
}
