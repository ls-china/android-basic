package com.ls.sample.data.resp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class ImageSoPicture implements Serializable, Parcelable {

    /**
     * id : 0eb75bdb795cfcfe866d4581cacac93f
     * qqface_down_url : false
     * downurl : false
     * grpmd5 : false
     * type : 0
     * src : 5
     * index : 50
     * title : 完美无瑕的清纯<em>美女</em>
     * litetitle :
     * width : 700
     * height : 1000
     * imgsize : 97KB
     * imgtype : JPEG
     * key : 76a411011b
     * dspurl : pic.yesky.com
     * link : http://pic.yesky.com/173/36888173.shtml
     * source : 2
     * img : http://image.tianjimedia.com/uploadImages/2014/112/25/99RSQ0573CQ0.jpg
     * thumb_bak : http://p2.so.qhmsg.com/t015fefa32e2bf46597.jpg
     * thumb : http://p2.so.qhmsg.com/t015fefa32e2bf46597.jpg
     * _thumb_bak : http://p2.so.qhmsg.com/sdr/_240_/t015fefa32e2bf46597.jpg
     * _thumb : http://p2.so.qhmsg.com/sdr/_240_/t015fefa32e2bf46597.jpg
     * thumbWidth : 168
     * dsptime :
     * thumbHeight : 240
     * grpcnt : 6
     * fixedSize : false
     */

    public String id;
    public boolean qqface_down_url;
    public boolean downurl;
    public boolean grpmd5;
    public int type;
    public String src;
    public int index;
    public String title;
    public String litetitle;
    public String width;
    public String height;
    public String imgsize;
    public String imgtype;
    public String key;
    public String dspurl;
    public String link;
    public int source;
    public String img;
    public String thumb_bak;
    public String thumb;
    public String _thumb_bak;
    public String _thumb;
    public int thumbWidth;
    public String dsptime;
    public int thumbHeight;
    public String grpcnt;
    public boolean fixedSize;

    public ImageSoPicture() {

    }

    protected ImageSoPicture(Parcel in) {
        id = in.readString();
        qqface_down_url = in.readByte() != 0;
        downurl = in.readByte() != 0;
        grpmd5 = in.readByte() != 0;
        type = in.readInt();
        src = in.readString();
        index = in.readInt();
        title = in.readString();
        litetitle = in.readString();
        width = in.readString();
        height = in.readString();
        imgsize = in.readString();
        imgtype = in.readString();
        key = in.readString();
        dspurl = in.readString();
        link = in.readString();
        source = in.readInt();
        img = in.readString();
        thumb_bak = in.readString();
        thumb = in.readString();
        _thumb_bak = in.readString();
        _thumb = in.readString();
        thumbWidth = in.readInt();
        dsptime = in.readString();
        thumbHeight = in.readInt();
        grpcnt = in.readString();
        fixedSize = in.readByte() != 0;
    }

    public static final Creator<ImageSoPicture> CREATOR = new Creator<ImageSoPicture>() {
        @Override
        public ImageSoPicture createFromParcel(Parcel in) {
            return new ImageSoPicture(in);
        }

        @Override
        public ImageSoPicture[] newArray(int size) {
            return new ImageSoPicture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeByte((byte) (qqface_down_url ? 1 : 0));
        dest.writeByte((byte) (downurl ? 1 : 0));
        dest.writeByte((byte) (grpmd5 ? 1 : 0));
        dest.writeInt(type);
        dest.writeString(src);
        dest.writeInt(index);
        dest.writeString(title);
        dest.writeString(litetitle);
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(imgsize);
        dest.writeString(imgtype);
        dest.writeString(key);
        dest.writeString(dspurl);
        dest.writeString(link);
        dest.writeInt(source);
        dest.writeString(img);
        dest.writeString(thumb_bak);
        dest.writeString(thumb);
        dest.writeString(_thumb_bak);
        dest.writeString(_thumb);
        dest.writeInt(thumbWidth);
        dest.writeString(dsptime);
        dest.writeInt(thumbHeight);
        dest.writeString(grpcnt);
        dest.writeByte((byte) (fixedSize ? 1 : 0));
    }
}
