import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void searchTestWhenFewProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Potter1", 1000, "QA");
        Book book2 = new Book(2, "Potter2", 1500, "QA");
        Book book3 = new Book(3, "Potter3", 2000, "QA");

        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Potter");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSeveralProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Tor1", 1000, "QA");
        Book book2 = new Book(2, "Tor2", 1500, "QA");
        Book book3 = new Book(3, "Tor3", 2000, "QA");

        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Tor");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Suffering", 1000, "QA");

        manager.addProduct(book1);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Suffering");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testZeroProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Torment", 1000, "QA");

        manager.addProduct(book1);

        Product[] expected = {};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repositoryTestFindAll() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book = new Book(1, "Java", 1000, "QA");
        Smartphone smartphone = new Smartphone(1, "Telephone", 5000, "Alex");

        manager.addProduct(book);
        manager.addProduct(smartphone);

        Product[] expected = {book, smartphone};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}