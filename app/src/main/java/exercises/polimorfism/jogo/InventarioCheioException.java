package exercises.polimorfism.jogo;

public class InventarioCheioException extends RuntimeException {
    public InventarioCheioException() {
        super("Reserva invalida.");
    }
}