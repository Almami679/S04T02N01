package cat.itacademy.s04.t02.n01.exception.custom;

public class DuplicateFruitException extends RuntimeException {
    public DuplicateFruitException(String message) {
        super(message);
    }
}
