package defaults.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lcunha on 30/04/17.
 */
public class UsandoRemoveIf {
    //AQUI IREMOS CHAMAR O removeIf, NOVO METODO DEFAULT DE COLLECTIONS (ASSIM COMO O forEach)
    //O removeIf RECEBE COMO PARAMETRO UM PREDICADO. PARA ENTENDER O QUE CONCEITUALMENTE SERIA ESSE PREDICADO
    //VOU DEIXAR O LINK PARA UM TUTORIAL DE HASKELL, ONDE SE EXPLICA COMPREENSÃO DE LISTAS E O PREDICADO FAZ
    //PARTE DESSE CONTEXTO, POIS ESTAMOS TRABALHANDO AQUI DIRETAMENTE COM TEORIA DOS CONJUNTOS
    //http://haskell.tailorfontela.com.br/starting-out#im-a-list-comprehension

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        //AQUI USAMOS new ArrayList<>() AO INVÉS DE Arrays.asList(user1, user2, user3);
        //PORQUE A SEGUNDA OPCAO GERA UM OBJETO IMUTAVEL, OU SEJA, SEU ESTADO NAO PODE SER ALTERADO
        // E O removeIf IRÁ MUDAR O ESTADO DA LISTA
        List<Usuario> usuarioList1 = new ArrayList<>();
        usuarioList1.add(user1);
        usuarioList1.add(user2);
        usuarioList1.add(user3);

        //USANDO PREDICATE LITERALMENTE - REMOVENDO USUARIOS COM MAIS DE 160 PONTOS
        Predicate<Usuario> usuarioPredicate = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 160;
            }
        };

        usuarioList1.removeIf(usuarioPredicate);
        //usuarioList1.forEach(u -> System.out.println(u));


        //======== AGORA USANDO LAMBDA NO PREDICATE==========//
        List<Usuario> usuarioList2 = new ArrayList<>();
        usuarioList2.add(user1);
        usuarioList2.add(user2);
        usuarioList2.add(user3);

        Predicate<Usuario> usuarioPredicate2 = usuario ->  usuario.getPontos() > 160;

        usuarioList2.removeIf(usuarioPredicate2);
        //usuarioList2.forEach(u -> System.out.println(u));


        //======== AGORA USANDO LAMBDA DIRETO NA COLLECTION==========//
        List<Usuario> usuarioList3 = new ArrayList<>();
        usuarioList3.add(user1);
        usuarioList3.add(user2);
        usuarioList3.add(user3);

        usuarioList3.removeIf(usuario -> usuario.getPontos() > 160);
        usuarioList3.forEach(u -> System.out.println(u));
        
        // Outra possibilidade com o Method Reference
        //usuarioList3.forEach(System.out::println);
        
        

        //======== AGORA USANDO STREAM DIRETO NA COLLECTION==========//
        List<Usuario> usuarioList4 = new ArrayList<>();
        usuarioList4.add(user1);
        usuarioList4.add(user2);
        usuarioList4.add(user3);
        usuarioList4.stream()
        	.filter(user -> user.getPontos() <= 160)
        	.forEach(System.out::println);

    }
}
