package streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by lcunha on 25/05/17.
 */
public class UsandoMap2 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        List<Integer> pontosDeTodosOsUsuarios2 = usuarioList
                .stream()
                .map(Usuario::getPontos)
                .collect(Collectors.toList());

        pontosDeTodosOsUsuarios2.forEach(System.out::println);

        //VAMOS QUEBRAR NOSSO CÓDIGO ACIMA PARA NOS ATENTARMOS EM UM DETALHE
        Stream<Integer> streamDospontosDeTodosOsUsuarios = usuarioList
                .stream()
                .map(Usuario::getPontos);

        //SABEMOS QUE O RETORNO DOS METODOS DA API DE Stream, É UMA INSTÂNCIA DE Stream<T>
        //COMO VIMOS EM DIVERSOS OUTROS PONTOS DO ESTUDO, ISSO VAI GERAR UM AUTOBOXING
        //POIS PARA CADA ITERAÇÃO ESTAMOS CONVERTENDO int PARA Integer, UMA VEZ QUE getPontos DEVOLVE UM int
        //E O apply DA INTERFACE Function QUE O METHOD REFERENCE PASSA PARA O map DEVOLVE Integer.
        //E ISSO PODE DAR UM OVERHEAD PARA LISTAS GRANDES OU MUITAS CHAMADAS A ESSA PARTE DO CODE

        //PARA EVITAR ISSO A API DE STREAM POSSUI IMPLEMENTAÇÕES DO TIPO IntStream, LongStream e DoubleStream
        IntStream intStreamDospontosDeTodosOsUsuarios = usuarioList
                .stream()
                .mapToInt(Usuario::getPontos);

        //AGORA O MAP RECEBERÁ NÃO MAIS Function E SIM ToIntFunction, COMO VIMOS EM EXERCÍCIOS PASSADOS
        //E AINDA GANHAMOS UNS MÉTODOS DE GRAÇA, COMO max, sorted e average

        double mediaDosPontosDosUsuarios = usuarioList
                .stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        System.out.println(mediaDosPontosDosUsuarios);
    }
}
