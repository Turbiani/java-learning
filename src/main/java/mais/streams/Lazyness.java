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
public class Lazyness {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //AGORA QUERO APENAS MOSTRAR QUE Stream É LAZY, OU SEJA, SÓ EXECUTA O MÍNIMO NECESSÁRIO E QUANDO NECESSÁRIO
        //POR EXEMPLO, ABAIXO EU FILTRO E ORDENO A LISTA DE USUÁRIOS. MAS ESSAS OPERAÇÕES SÓ SERÃO REALIZADAS
        //QUANDO UMA OPERAÇÃO TERMINAL FOR EXECUTADA, COMO O collect QUE GERA UMA LISTA A PARTIR DA Stream
        Stream<Usuario> usuarioOrdenadosStream = usuarioList
                .stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome));

        List<Usuario> usuariosOrdenadosViaStream = usuarioOrdenadosStream.collect(Collectors.toList());

        //O STREAM TEM ALGUNS RECURSOS BACANAS QUE TAMBÉM SÃO LAZY. VAMOS DIZER QUE EU QUEIRA O PRIMEIRO OU QUALQUER
        //USUARIO COM MAIS DE 100 PONTOS. A FORMA COMUM SERIA PEGAR A LISTA usuariosOrdenadosViaStream E PEGAR UMA
        //POSIÇÃO QUAQUER COM usuariosOrdenadosViaStream.get(indice). CERTO ?
        //MAS PODEMOS FAZER DE FORMA MAIS SEMÂNTICA
        Optional<Usuario> qualquerUsuarioOrdenadosStream = usuarioList
                .stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .findAny();

        //OU

        Optional<Usuario> primeiroUsuarioOrdenadosStream = usuarioList
                .stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .findFirst();

        //System.out.println(primeiroUsuarioOrdenadosStream.get());

        //AO USARMOS findFirst() E O findAny() IREMOS ITERAR NA LISTA O PREDICADO PASSADO EM filter ATÉ ACHARMOS
        //O PRIMEIRO USUÁRIO QUE ATENDE O PREDICADO NO CASO DE findFirst(). E QUALQUER USUÁRIO QUE ATENDA O PREDICADO
        //NO CASO DE findAny().
        //SÓ IREMOS REALIZAR UM "FULL SCAM" POR CAUSA DO SORTED, POIS ELE ALÉM DE SER UM MÉTODO INTERMEDIÁRIO COMO
        //findAny e FindFirst, ELE TAMBÉM É STATEFULL. E OPERAÇÕES STATEFULL PODEM PRECISAR VARRER TODA COLLECTION
        //MESMO QUE UMA OPERAÇÃO TERMINAL NÃO TENHA SIDO INVOCADA. VAMOS VER ISSO NA PRÁTICA ?

        Optional<Usuario> andoAteAcharAlgumUsuarioMaiorQue100 = usuarioList
                .stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .peek(System.out::println)
                .findAny();

        Optional<Usuario> andoPorQuaseTodosPorquePrecisoOrdenar = usuarioList
                .stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println)
                .findAny();

    }
}
