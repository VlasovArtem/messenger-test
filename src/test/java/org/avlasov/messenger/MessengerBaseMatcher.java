package org.avlasov.messenger;

import org.hamcrest.Description;

import java.util.function.Predicate;

/**
 * Created by artemvlasov on 16/07/2017.
 */
public class MessengerBaseMatcher<T> extends MessengerAbstractMatcher<T> {

    public MessengerBaseMatcher(Predicate<T> matcher) {
        super(matcher);
    }

    @Override
    public void describeTo(Description description) {

    }
}
