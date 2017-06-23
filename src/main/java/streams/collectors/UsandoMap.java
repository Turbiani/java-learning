package streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by lcunha on 25/05/17.
 */
public class UsandoMap {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //ANTERIORMENTE USAMOS UM FILTER DA API DE STREAM, AGORA VAMOS USAR O MAP
        //A DIFERENÇA ENTRE AMBOS É QUE O FILTER REMOVE OS ITENS QUE NÃO PASSAM NO FILTER
        //O MAP CRIA UMA NOVA COLEÇÃO A PARTIR DA REGRA PASSADA PRA ELE.
        //MAS LEMBRANDO, COMO O FILTER O MAP NÃO DEVOLVERÁ UMA IMPLEMENTAÇÃO DE Collections
        //E SIM Stream<Usuario>, POR ISSO PRECISAREMOS AINDA DO Collect PARA PASSAR ISSO PARA UMA LIST POR EXEMPLO
        List<Integer> pontosDeTodosOsUsuarios = usuarioList
                .stream()
                .map(user -> user.getPontos())
                .collect(Collectors.toList());

        pontosDeTodosOsUsuarios.forEach(System.out::println);

        //PODEMOS USAR METHOD REFERENCES, UMA VEZ QUE MAP RECEBE UMA INTERFACE FUNCIONAL =)
        //NO CASO Function<Usuario, Integer>, POIS RECEBERÁ UM USUÁRIO E DEVOLVERÁ INTEIRO (PONTOS DO MESMO)
        List<Integer> pontosDeTodosOsUsuarios2 = usuarioList
                .stream()
                .map(Usuario::getPontos)
                .collect(Collectors.toList());

        pontosDeTodosOsUsuarios2.forEach(System.out::println);



    }
}
