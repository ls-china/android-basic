/*
 *
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 * Copyright (C) 2015 GuDong <maoruibin9035@gmail.com>
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ls.basic.mvp;

import android.support.annotation.NonNull;

import com.ls.basic.utils.RxUtils;
import com.ls.basic.utils.schedulers.BaseSchedulerProvider;

import rx.subscriptions.CompositeSubscription;


public abstract class AbsPresenter<V extends BaseView> implements BasePresenter {
    protected final V mView;

    @NonNull
    protected final BaseSchedulerProvider mSchedulerProvider;
    @NonNull
    protected CompositeSubscription mSubscriptions;

    public AbsPresenter(@NonNull V mView, @NonNull BaseSchedulerProvider schedulerProvider) {
        this.mView = mView;
        mSchedulerProvider = schedulerProvider;
        mSubscriptions = RxUtils.getNewCompositeSubIfUnsubscribed(mSubscriptions);
        this.mView.setPresenter(this);
    }

    @Override
    public void unsubscribe() {
        if (null != mSubscriptions) {
            mSubscriptions.clear();
        }
        RxUtils.unsubscribeIfNotNull(mSubscriptions);
    }
}
