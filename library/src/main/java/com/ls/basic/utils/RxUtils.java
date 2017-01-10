package com.ls.basic.utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.utils
 */

public class RxUtils {
    public static void unsubscribeIfNotNull(Subscription subscription) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public static CompositeSubscription getNewCompositeSubIfUnsubscribed(CompositeSubscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return new CompositeSubscription();
        }

        return subscription;
    }
}
