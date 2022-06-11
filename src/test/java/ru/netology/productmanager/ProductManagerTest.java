package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductManager manager = new ProductManager();

    @Test
    void shouldManagerAddProduct() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "iPhone1", "China");
        Smartphone smartphone2 = new Smartphone(5, "LumiaPhone1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerSearchBy() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "iPhone1", "China");
        Smartphone smartphone2 = new Smartphone(5, "LumiaPhone1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("and");
        ;
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryDeleteById() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "iPhone1", "China");
        Smartphone smartphone2 = new Smartphone(5, "LumiaPhone1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.deleteById(2);
        manager.deleteById(3);
        manager.deleteById(5);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryDeleteByIdZeroArray() {
        manager.deleteById(1);

        Product[] actual = manager.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryDeleteByNullId() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "iPhone1", "China");
        Smartphone smartphone2 = new Smartphone(5, "LumiaPhone1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.deleteById(9);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}
