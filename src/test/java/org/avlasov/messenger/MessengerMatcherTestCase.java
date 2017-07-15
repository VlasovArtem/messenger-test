package org.avlasov.messenger;

import java.util.function.Predicate;

/**
 * Created by artemvlasov on 16/07/2017.
 */
public abstract class MessengerMatcherTestCase<T> {

    public MessengerBaseMatcher<T> getMessengerBaseMatcher(Predicate<T> predicate) {
        return new MessengerBaseMatcher<>(predicate);
    }
}
