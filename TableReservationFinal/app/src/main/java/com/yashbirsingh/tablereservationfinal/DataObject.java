package com.yashbirsingh.tablereservationfinal;

/**
 * Created by yashbir on 25/10/15.
 */
public class DataObject {
    private String mText1;
    private String mThumbnail;

    DataObject(String text1, String thumbnail){
        mText1 = text1;
        mThumbnail = thumbnail;
    }

    public String getmThumbnail(){
        return mThumbnail;
    }

    public void setmThumbnail(String thumbnail){
        this.mThumbnail = thumbnail;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

}
