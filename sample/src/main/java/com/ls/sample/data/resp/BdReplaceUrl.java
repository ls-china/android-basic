package com.ls.sample.data.resp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class BdReplaceUrl implements Serializable, Parcelable {
    public String ObjURL;
    public String FromURL;

    public BdReplaceUrl() {

    }

    protected BdReplaceUrl(Parcel in) {
        ObjURL = in.readString();
        FromURL = in.readString();
    }

    public static final Creator<BdReplaceUrl> CREATOR = new Creator<BdReplaceUrl>() {
        @Override
        public BdReplaceUrl createFromParcel(Parcel in) {
            return new BdReplaceUrl(in);
        }

        @Override
        public BdReplaceUrl[] newArray(int size) {
            return new BdReplaceUrl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ObjURL);
        dest.writeString(FromURL);
    }
}
