import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;
import ru.netology.repo.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(2, "Baudolino", 100_000, "Eco");
    Product smartphone1 = new Smartphone(1, "iphone", 70_000, "Apple");
    Product book2 = new Book(3, "Bubbleheads", 10_032_300, "Oruell");

    @Test
    public void shouldSaveProduct() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.removeById(book1.getId());

        Product[] expected = {smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProducts() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
