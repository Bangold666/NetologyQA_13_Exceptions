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
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
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
    void shouldManagerSearchByBookName() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("and");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryDeleteById() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
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
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.deleteById(8);
        });
    }

    @Test
    void shouldManagerSearchBySmartName() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("ack");

        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerSearchBySmartphoneManufacturer() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("USA");

        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerSearchByBookAuthor() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Ivan");

        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerSearchByNotFound() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(3, "Fathers and Sons", "Ivan Turgenev");
        Smartphone smartphone1 = new Smartphone(4, "Xiaomi", "China");
        Smartphone smartphone2 = new Smartphone(5, "BlackBerry1", "USA");
        Smartphone smartphone3 = new Smartphone(6, "NexusPhone1", "Vietnam");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Sergey");

        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerAlreadyAddProduct() {
        Book book1 = new Book(1, "War and Peace", "Lev Tolstoy");
        Book book2 = new Book(2, "Oblomov", "Ivan Goncharov");
        Book book3 = new Book(1, "Fathers and Sons", "Ivan Turgenev");

        manager.add(book1);
        manager.add(book2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(book3);
        });
    }


}
