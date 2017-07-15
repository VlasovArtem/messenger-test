package org.avlasov.messenger;

import org.hamcrest.BaseMatcher;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by artemvlasov on 16/07/2017.
 */
public abstract class MessengerAbstractMatcher<T> extends BaseMatcher<T> {

    private Predicate<T> matcher;

    MessengerAbstractMatcher(Predicate<T> matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Object item) {
        return Objects.nonNull(item) && matcher.test((T) item);
    }
}
