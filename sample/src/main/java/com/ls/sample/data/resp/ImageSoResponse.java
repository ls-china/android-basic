package com.ls.sample.data.resp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class ImageSoResponse implements Serializable, Parcelable {


    /**
     * total : 1500
     * end : false
     * sid : a247c38f67b2204340d79f56a0639054
     * lastindex : 99
     * ceg : 181317798
     * list :
     * boxresult : null
     * wordguess : null
     */

    public int total;
    public boolean end;
    public String sid;
    public int lastindex;
    public int ceg;
    public Object boxresult;
    public Object wordguess;
    public List<ImageSoPicture> list;

    public ImageSoResponse() {

    }

    protected ImageSoResponse(Parcel in) {
        total = in.readInt();
        end = in.readByte() != 0;
        sid = in.readString();
        lastindex = in.readInt();
        ceg = in.readInt();
        list = in.createTypedArrayList(ImageSoPicture.CREATOR);
    }

    public static final Creator<ImageSoResponse> CREATOR = new Creator<ImageSoResponse>() {
        @Override
        public ImageSoResponse createFromParcel(Parcel in) {
            return new ImageSoResponse(in);
        }

        @Override
        public ImageSoResponse[] newArray(int size) {
            return new ImageSoResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(total);
        dest.writeByte((byte) (end ? 1 : 0));
        dest.writeString(sid);
        dest.writeInt(lastindex);
        dest.writeInt(ceg);
        dest.writeTypedList(list);
    }

    @Override
    public String toString() {
        return "ImageSoResponse{" +
                "total=" + total +
                ", end=" + end +
                ", sid='" + sid + '\'' +
                ", lastindex=" + lastindex +
                ", ceg=" + ceg +
                ", boxresult=" + boxresult +
                ", wordguess=" + wordguess +
                ", list=" + (null == list ? 0 : list.size()) +
                '}';
    }
}
