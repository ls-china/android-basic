package com.ls.sample.data.resp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class BdPicture implements Serializable, Parcelable {
    /**
     * adType : 0
     * hasAspData : 0
     * thumbURL : https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1045247041,2507312279&fm=23&gp=0.jpg
     * middleURL : https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1045247041,2507312279&fm=21&gp=0.jpg
     * largeTnImageUrl :
     * hasLarge : 0
     * hoverURL : https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1045247041,2507312279&fm=23&gp=0.jpg
     * pageNum : 600
     * objURL : ippr_z2C$qAzdH3FAzdH3F3q_z&e3Brrb1_z&e3Bv54AzdH3F7rs5w1fAzdH3Fwsst42AzdH3Fv8ma98nAzdH3F89mac9ancddF-9clcm_z&e3B3r2
     * fromURL : ippr_z2C$qAzdH3FAzdH3F3q_z&e3Brrb1_z&e3Bv54AzdH3FjgpAzdH3FpvAzdH3Fda8mAzdH3Fa98nAzdH3F8980d0_9_z&e3Bip4s
     * fromURLHost : jq.pp8d.com
     * currentIndex :
     * width : 377
     * height : 480
     * type : jpg
     * filesize :
     * bdSrcType : 0
     * di : 18017900120
     * pi : 0
     * is : 0,0
     * replaceUrl : [{"ObjURL":"http://img1.imgtn.bdimg.com/it/u=1045247041,2507312279&fm=214&gp=0.jpg","FromURL":"http://pic.yesky.com/30/101786530_2.shtml"},{"ObjURL":"http://dynamic-image.yesky.com/740x-/uploadimages/2016/218/38/75444qd2vv8f.jpg","FromURL":"http://pic.yesky.com/279/104144779_14.shtml"}]
     * hasThumbData : 0
     * bdSetImgNum : 0
     * spn : 0
     * bdImgnewsDate : 1970-01-01 08:00
     * fromPageTitle : 日本<strong>美臀</strong>女王秋山莉奈性感大片
     * fromPageTitleEnc : 日本美臀女王秋山莉奈性感大片
     * bdSourceName :
     * bdFromPageTitlePrefix :
     * isAspDianjing : 0
     * token :
     * imgType :
     * cs : 1045247041,2507312279
     * os : 1436877351,816924461
     * simid : 3455845395,322445658
     * personalized : 0
     * simid_info : null
     * face_info : null
     * xiangshi_info : null
     * adPicId : 0
     * source_type :
     */

    public String adType;
    public String hasAspData;
    public String thumbURL;
    public String middleURL;
    public String largeTnImageUrl;
    public int hasLarge;
    public String hoverURL;
    public int pageNum;
    public String objURL;
    public String fromURL;
    public String fromURLHost;
    public String currentIndex;
    public int width;
    public int height;
    public String type;
    public String filesize;
    public String bdSrcType;
    public String di;
    public String pi;
    public String is;
    public String hasThumbData;
    public int bdSetImgNum;
    public int spn;
    public String bdImgnewsDate;
    public String fromPageTitle;
    public String fromPageTitleEnc;
    public String bdSourceName;
    public String bdFromPageTitlePrefix;
    public int isAspDianjing;
    public String token;
    public String imgType;
    public String cs;
    public String os;
    public String simid;
    public String personalized;
    public Object simid_info;
    public Object face_info;
    public Object xiangshi_info;
    public String adPicId;
    public String source_type;
    public List<BdReplaceUrl> replaceUrl;

    public BdPicture() {

    }

    protected BdPicture(Parcel in) {
        adType = in.readString();
        hasAspData = in.readString();
        thumbURL = in.readString();
        middleURL = in.readString();
        largeTnImageUrl = in.readString();
        hasLarge = in.readInt();
        hoverURL = in.readString();
        pageNum = in.readInt();
        objURL = in.readString();
        fromURL = in.readString();
        fromURLHost = in.readString();
        currentIndex = in.readString();
        width = in.readInt();
        height = in.readInt();
        type = in.readString();
        filesize = in.readString();
        bdSrcType = in.readString();
        di = in.readString();
        pi = in.readString();
        is = in.readString();
        hasThumbData = in.readString();
        bdSetImgNum = in.readInt();
        spn = in.readInt();
        bdImgnewsDate = in.readString();
        fromPageTitle = in.readString();
        fromPageTitleEnc = in.readString();
        bdSourceName = in.readString();
        bdFromPageTitlePrefix = in.readString();
        isAspDianjing = in.readInt();
        token = in.readString();
        imgType = in.readString();
        cs = in.readString();
        os = in.readString();
        simid = in.readString();
        personalized = in.readString();
        adPicId = in.readString();
        source_type = in.readString();
        replaceUrl = in.createTypedArrayList(BdReplaceUrl.CREATOR);
    }

    public static final Creator<BdPicture> CREATOR = new Creator<BdPicture>() {
        @Override
        public BdPicture createFromParcel(Parcel in) {
            return new BdPicture(in);
        }

        @Override
        public BdPicture[] newArray(int size) {
            return new BdPicture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adType);
        dest.writeString(hasAspData);
        dest.writeString(thumbURL);
        dest.writeString(middleURL);
        dest.writeString(largeTnImageUrl);
        dest.writeInt(hasLarge);
        dest.writeString(hoverURL);
        dest.writeInt(pageNum);
        dest.writeString(objURL);
        dest.writeString(fromURL);
        dest.writeString(fromURLHost);
        dest.writeString(currentIndex);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(type);
        dest.writeString(filesize);
        dest.writeString(bdSrcType);
        dest.writeString(di);
        dest.writeString(pi);
        dest.writeString(is);
        dest.writeString(hasThumbData);
        dest.writeInt(bdSetImgNum);
        dest.writeInt(spn);
        dest.writeString(bdImgnewsDate);
        dest.writeString(fromPageTitle);
        dest.writeString(fromPageTitleEnc);
        dest.writeString(bdSourceName);
        dest.writeString(bdFromPageTitlePrefix);
        dest.writeInt(isAspDianjing);
        dest.writeString(token);
        dest.writeString(imgType);
        dest.writeString(cs);
        dest.writeString(os);
        dest.writeString(simid);
        dest.writeString(personalized);
        dest.writeString(adPicId);
        dest.writeString(source_type);
        dest.writeTypedList(replaceUrl);
    }
}
