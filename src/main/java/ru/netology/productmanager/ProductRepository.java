package ru.netology.productmanager;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product newProduct) {
        if (products.length != 0) {
            if (findById(newProduct.getId()) != null) {
                throw new AlreadyExistsException("Element with id: " + newProduct + "not found");
            }
        }
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;

        products = tmp;
    }

    public void deleteById(int removeId) {
        if (products.length != 0) {
            if (findById(removeId) == null) {
                throw new NotFoundException("Element with id: " + removeId + "not found");
            }
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i].getId() != removeId) {
                    if (copyToIndex + 1 == products.length) { //если id товара не найден, выходим из метода
                        return;
                    }
                    tmp[copyToIndex] = products[i];
                    copyToIndex++;
                }
            }
            products = tmp;
        } else {
            System.out.println("no products to remove");
        }
    }

    public Product findById(int searchId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == searchId) {
                return products[i];
            }
        }
        return null;
    }
}

