package loja.digital;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProdutosMaisVendidos {

    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        PopulaComDados.getInstance()
                .popularEntidades(customers, payments, products);

        //Queremos saber nossos produtos mais vendidos =) E para tal usaremos o flatMap novamente
        Stream<Product> productStream = payments.stream().flatMap(p -> p.getProductList().stream());

        //Agora iremos gerar um Map de Product para Long, que indicará quantas vezes o produto foi vendido

        Map<Product, Long> topProducts = payments.stream()
                .flatMap(p -> p.getProductList().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        topProducts.forEach((produto, total) -> System.out.printf("%s: %s \n", produto, total));

        //E se eu quiser pegar o mais vendido ? Que é o Bach Completo ?

        topProducts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(vencedor -> pegaMaisVendido(vencedor.getKey()));
    }

    public static void pegaMaisVendido (Product product) {
        System.out.println("O mais vendido foi " + product.getName());
    }
}

