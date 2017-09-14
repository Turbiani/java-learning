package loja.digital;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenandoPagamentos {

    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        PopulaComDados.getInstance()
                .popularEntidades(customers, payments, products);

        payments.stream()
                .sorted(Comparator.comparing(Payment::getDate))
                .forEach(System.out::println);
    }
}
