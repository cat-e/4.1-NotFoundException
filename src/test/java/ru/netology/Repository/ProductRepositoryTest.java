package ru.netology.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(1, "Core Java", 1000, "Author", 851, 2011);
    private TShirt tShirt = new TShirt(2, "Moe", 520, "White", "XL");

    @BeforeEach
    public void setUp() {
        repository.save(coreJava);
        repository.save(tShirt);
    }

    @Test
    public void shouldRemoveProduct() {
        repository.removeById(1);
        Product[] expected = new Product[]{tShirt};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowException() {
        int id = 3;
        String message = "Element with id: " + id + " not found";

        assertThrows(NotFoundException.class, () -> repository.removeById(id), message);
    }

}