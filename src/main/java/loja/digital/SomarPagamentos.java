package loja.digital;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class SomarPagamentos {

    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        PopulaComDados.getInstance()
                .popularEntidades(customers, payments, products);

        //Na classe SomarPagamento somamos todos os produtos do primeiro pagamento
        //E se precisarmos somar todos os valores de todos os pagamentos da lista de pagamentos ?

        Stream<BigDecimal> pricesStream =
                payments.stream()
                .map(p -> p.getProductList()
                           .stream()
                           .map(Product::getPrice)
                           .reduce(BigDecimal.ZERO, BigDecimal::add));

        //Show de bola né ? Mais ou menos, para conseguir obter o total geral, preciso aplicar mais um reduce
        //Se liga:

        BigDecimal total =
                payments.stream()
                        .map(p -> p.getProductList()
                                .stream()
                                .map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Dá pra resolver Leozao ? Dá sim, usando o flatMap para dar um "Join" nesses Streams (Nos maps)

        Stream<BigDecimal> priceOfEachProduct =
                payments.stream()
                .flatMap(p -> p.getProductList()
                               .stream()
                               .map(Product::getPrice));


        //Show de bola, agora precisamos fazer apenas um reduce
        BigDecimal priceOfEachProductFlat =
                payments.stream()
                        .flatMap(p -> p.getProductList()
                                .stream()
                                .map(Product::getPrice))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Só para entenderem o motivo de chamarmos o flatMap é que o lambda que colocávamos dentro do .map em payments
        //produz um Stream<BigDecimal> (Antes de chamar o primeiro .reduce(BigDecimal.ZERO, BigDecimal::add))
        //Vou mostrar o que o lambda é de verdade nesse nosso caso

        Function<Payment, Stream<BigDecimal>> mapper = p -> p.getProductList().stream().map(Product::getPrice);

        //Esse mapper tem a função de passar por todos os produtos de um payment. Com o flatMap iremos unir isso com
        //o fato que também estamos passando por uma lista de pagamentos, então estamos trabalhando com 2 dimensões aqui
        //E precisamos fazer uma soma total =)
    }
}
