package loja.digital;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SomarPagamento {

    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        PopulaComDados.getInstance()
                .popularEntidades(customers, payments, products);

        BigDecimal total = payments.get(0).getProductList().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }
}
