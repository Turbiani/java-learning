package streams.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by lcunha on 25/05/17.
 */
public class UsandoMap3 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        double mediaDosPontosDosUsuarios = usuarioList
            .stream()
            .mapToInt(Usuario::getPontos)
            .average()
            .getAsDouble();

        //PORQUE average() NÃO DEVOLVE UM DOUBLE DIRETO ? PRECISAMOS CHAMAR getAsDouble() PORQUE ?
        //PORQUE AGORA TEMOS UMA API CHAMADA Optional QUE NOS AJUDA A REMOVER MUITOS IFs QUE ANTES COLOCAVAMOS NO FOR
        //SE LIGA NO QUE PODEMOS FAZER AGORA COM O Optional DEVOLVIDO PELO MÉTODO average()

        OptionalDouble optionalDouble = usuarioList
            .stream()
            .mapToInt(Usuario::getPontos)
            .average();

        double pontuacaoMedia = optionalDouble.orElse(0.0);

        //OLHA QUE BEM LOUCO, PODEMOS REALIZAR DE UMA FORMA BEM MAIS SEMÂNTICA A SEGUINTE INSTRUÇÃO
        //CASO A LISTA SEJA VAZIA, DEVOLVA 0.0 LOKO NEH ?
        //E SE EU QUISER LANÇAR EXCEPTION ? TÁ AÍ MLK !

        double pontuacaoMedia2 = optionalDouble.orElseThrow(IllegalAccessError::new);

        //MAS E SE EU QUISER EXECUTAR ALGUMA INSTRUÇÃO ?
        usuarioList.stream()
            .mapToInt(Usuario::getPontos)
            .average()
            .ifPresent(pontos -> System.out.println(pontos));

        //SE EU QUISER O NOME DOS USUARIOS MAIS PONTUADOS ? SÓ PASSAR UM Comparator PRO MÉTODO max() =)
        Optional<String> optionalNomeDoZika = usuarioList
                .stream()
                .max(Comparator.comparingInt(Usuario::getPontos))
                .map(usuario -> usuario.getNome());

        String nomeDoZika = optionalNomeDoZika.orElse("Ninguém é zika");
        System.out.println(nomeDoZika);

        //TESTANDO COM UMA LISTA VAZIA

        Optional<String> optionalNomeDoZika2 = new ArrayList<Usuario>()
                .stream()
                .max(Comparator.comparingInt(Usuario::getPontos))
                .map(usuario -> usuario.getNome());

        String nomeDoZika2 = optionalNomeDoZika2.orElse("Ninguém é zika");
        System.out.println(nomeDoZika2);



    }
}
