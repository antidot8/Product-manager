package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "title1", 100, "author1", 400, 2020);
    private Book book2 = new Book(2, "title1", 110, "author2", 300, 2021);
    private Smartphone smartphone1 = new Smartphone(3, "phone1", 2000, "manufacturer1");
    private Smartphone smartphone2 = new Smartphone(4, "phone2", 2000, "manufacturer1");
    private Product product1 = new Product(5, "item2", 500);

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void getAllIsCorrect() {
        Product[] expected = new Product[]{smartphone2, smartphone1, book2, book1};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithRegister() {
        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy("Title1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNonExist() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Product1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameBook() {
        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy("title1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameSmartphone() {
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("phone1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("author2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacturer() {
        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] actual = manager.searchBy("manufacturer1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchInProduct() {
        Product[] expected = new Product[]{product1};
        manager.add(product1);
        Product[] actual = manager.searchBy("item2");
        assertArrayEquals(expected, actual);
    }
}