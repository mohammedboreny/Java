package Week7;

import java.util.function.Function;
//t->u->v
public interface CBIFunction<T,U,V> extends Function<T,Function<U,V>> {
}
