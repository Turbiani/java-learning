package mais.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by lcunha on 25/05/17.
 */
public class Reducao {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //AGORA VAMOS FALAR DE reduce, SEGUE UMA DEFINIÇÃO QUE GOSTEI EM UM BLOG DE JAVASCRIPT
        //Use reduce quando é preciso encontrar um valor cumulativo ou concatenado com base em elementos de todo o array
        //SE EU QUISER A SOMA DE TODOS OS PONTOS DOS USUÁRIOS ?
        int totalPontosUsuarios = usuarioList
                .stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, (p1, p2) ->  p1 + p2);
        //ACIMA ESTAMOS CHAMANDO A SEGUINTE ASSINATURA //T reduce(T var1, BinaryOperator<T> var2);
        //MAS JÁ NÃO TÍNHAMOS A FUNÇÃO sum() ? SIM, A sum() REALIZA UM reduce NO ARRAY =)
        //OUTRO EXEMPLO
        int totalPontosUsuarios2 = usuarioList
                .stream()
                .reduce(0, (pontoAcumlado, usuarioCorrente) -> pontoAcumlado + usuarioCorrente.getPontos(),
                        (a, b) -> a + b);
        //JÁ AQUI ESSA <U> U reduce(U var1, BiFunction<U, ? super T, U> var2, BinaryOperator<U> var3);

        //OUTRO EXEMPLO
        int multiplicacao = usuarioList
                .stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, (p1, p2) ->  p1 * p2);
    }
}
