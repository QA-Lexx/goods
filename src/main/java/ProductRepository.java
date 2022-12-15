public class ProductRepository {
    private static Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public void removeProductById(int idRemove) {
        Product[] tmp = new Product[products.length - 1];
        int indexInsert = 0;
        for (Product product : products) {
            if (product.getId() != idRemove) {
                tmp[indexInsert] = product;
                indexInsert++;
            }
        }
        products = tmp;
    }

    public static Product[] findAll() {
        return products;
    }
}