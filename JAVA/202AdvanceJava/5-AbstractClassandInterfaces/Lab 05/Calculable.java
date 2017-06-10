package MoneyTime;

/**
 The way this Interface works is you take 2 objects either add or subtract total money or time objects
 */
public interface Calculable<E> {

    public E add(E o);

    public E subtract(E o);

}
