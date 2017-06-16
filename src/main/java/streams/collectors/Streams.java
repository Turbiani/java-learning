package streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by lcunha on 25/05/17.
 */
public class Streams {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //USANDO STREAMS COM FILTER (ESSE RECEBE UM PREDICADO)
        Stream<Usuario> soOsFodoes = usuarioList.stream().filter(user -> user.getPontos() > 150);

        //O filter da API de Stream funciona da mesma maneira do filter do JavaScript
        //Não altera a lista original, e sim cria uma nova (Mas Stream não é uma collection ! É quase um iterator)
        //Para realizar outras operações, deve invocar o stream() em cima da lista original novamente
        //AGORA EXIBO A LISTA CRIADA A PARTIR DO FILTRO EM usuarioList

        soOsFodoes.forEach(System.out::println);

        //Posso também adicionar comportamentos de forma fluente após a chamada stream()
        usuarioList
                .stream()
                .filter(u -> u.getPontos() >= 150)
                .forEach(Usuario::tornaModerador);

        //Aqui em cima eu tornei moderador apenas os usuários com mais de 150 pontos =)
        //Vamos ver se é verdade ?

        usuarioList
                .stream()
                .filter(usuario -> usuario.isModerador())
                .forEach(System.out::println);

    }
}
