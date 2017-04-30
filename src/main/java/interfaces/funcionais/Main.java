package interfaces.funcionais;

/**
 * Created by lcunha on 30/04/17.
 */
public class Main {
    public static void main(String[] args) {
        Validador<String> validadorCEP = valor ->
          valor.matches("[0-9]{5}-[0-9]{3}");

        System.out.println(validadorCEP.valida("02473-080"));
    }
}
