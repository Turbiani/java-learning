package interfaces.funcionais;

/**
 * Created by lcunha on 30/04/17.
 */
@FunctionalInterface
interface Validador<T> {
    boolean valida(T t);
}
