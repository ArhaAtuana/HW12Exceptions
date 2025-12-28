package ru.netology.productShop;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(8, "Bag", 12);
    Product item2 = new Product(9, "Backpack", 16);
    Product item3 = new Product(10, "Shopper", 4);
    Product item4 = new Product(11, "Box", 3);
    Product item5 = new Product(12, "Package", 2);
    Product item6 = new Product(12, "Purse", 22);
    Product item7 = new Product(13, "Purse2", 24);


    @Test

    public void shouldRemoveByIdExistingId() {

        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);

        repo.removeById(10);

        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldThrowExceptionRemoveById() {

        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(20);
        });

    }

    @Test

    public void shouldThrowExceptionAddToArray() {

        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item6);
        });

    }

    @Test

    public void shouldAddToArray() {

        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item7);

        Product[] expected = {item1, item2, item3, item4, item5, item7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
