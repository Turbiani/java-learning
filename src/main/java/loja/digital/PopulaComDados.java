package loja.digital;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class PopulaComDados {
    private static PopulaComDados INSTANCE = new PopulaComDados();

    public static PopulaComDados getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PopulaComDados();

        return INSTANCE;
    }

    void popularEntidades(final List<Customer> customerList, final List<Payment> paymentList, final List<Product> productList) {
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilherme Silveira");
        Customer adriano = new Customer("Adriano Almeida");

        customerList.add(paulo);
        customerList.add(guilherme);
        customerList.add(rodrigo);
        customerList.add(adriano);

        Product bach = new Product("Bach Completo",
                Paths.get("/music/bach.mp3"), new BigDecimal(100));
        Product poderosas = new Product("Poderosas Anita",
                Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
        Product bandeira = new Product("Bandeira Brasil",
                Paths.get("/images/brasil.jpg"), new BigDecimal(50));
        Product beauty = new Product("Beleza Americana",
                Paths.get("beauty.mov"), new BigDecimal(150));
        Product vingadores = new Product("Os Vingadores",
                Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
        Product amelie = new Product("Amelie Poulain",
                Paths.get("/movies/amelie.mov"), new BigDecimal(100));

        productList.add(bach);
        productList.add(poderosas);
        productList.add(bandeira);
        productList.add(beauty);
        productList.add(vingadores);
        productList.add(amelie);

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime lastMonth = today.minusMonths(1);

        Payment payment1 =
                new Payment(asList(bach, poderosas), today, paulo);
        Payment payment2 =
                new Payment(asList(bach, bandeira, amelie), yesterday, rodrigo);
        Payment payment3 =
                new Payment(asList(beauty, vingadores, bach), today, adriano);
        Payment payment4 =
                new Payment(asList(bach, poderosas, amelie), lastMonth, guilherme);
        Payment payment5 =
                new Payment(asList(beauty, amelie), yesterday, paulo);

        paymentList.add(payment1);
        paymentList.add(payment2);
        paymentList.add(payment3);
        paymentList.add(payment4);
        paymentList.add(payment5);

    }
}
