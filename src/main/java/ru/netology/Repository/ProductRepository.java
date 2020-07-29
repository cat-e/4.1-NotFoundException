package ru.netology.Repository;

import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] items = new Product[0];


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return items;
            }
        }
        return null;
    }

    public Product[] removeById(int id){
        if (findById(id) == null) {
            throw new NotFoundException();
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int idx = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[idx] = item;
                idx++;
            }
        }
        items = tmp;
        return tmp;
    }

}