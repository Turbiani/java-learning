package ordenando.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * Created by lcunha on 08/05/17.
 */
public class Autoboxings {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3);

        //ESSE CODIGO CRIA UM AUTOBOXING DE int PARA Integer TODA ITERAÇÃO QUE COMPARING FOR CHAMADO, DESEMPENHO RUIM
        //MUITO TRAMPO PARA jvm
        Function<Usuario, Integer> extraiPontosDoUsuario = u -> u.getPontos();
        Comparator<Usuario> comparatorPontos = Comparator.comparing(extraiPontosDoUsuario);
        usuarioList.sort(comparatorPontos);

        //ENTAO DEVEMOS USAR METODOS ESPECÍFICOS PARA TAL
        ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
        Comparator<Usuario> comparator = Comparator.comparingInt(extraiPontos);
        usuarioList.sort(comparator);

        //VERSAO LAMBDA MAIS SIMPLES
        usuarioList.sort(Comparator.comparingInt(u -> u.getPontos()));

        usuarioList.stream()
                .forEach(System.out::println);
    }
}
