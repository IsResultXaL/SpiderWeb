package com.caogen.spiderWeb.entity;

import java.util.Date;

public class UserByJiaYuan {

    private long userId;            //用户Id

    private long realUid;           //世纪佳缘Uid

    private String nickName;        //昵称

    private String sex;             //性别

    private int age;                //年龄

    private String marriage;        //婚否

    private String height;          //身高

    private String education;       //教育

    private String localhost;       //居住地

    private String image;           //头像Url

    private String randTag;         //标签1

    private String randListTag;     //标签2

    private String shortnote;       //介绍

    private String matchCondition;  //择偶条件

    private String helloUrl;        //打招呼Url

    private Date createTime;        //创建时间

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRealUid() {
        return realUid;
    }

    public void setRealUid(long realUid) {
        this.realUid = realUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLocalhost() {
        return localhost;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRandTag() {
        return randTag;
    }

    public void setRandTag(String randTag) {
        this.randTag = randTag;
    }

    public String getRandListTag() {
        return randListTag;
    }

    public void setRandListTag(String randListTag) {
        this.randListTag = randListTag;
    }

    public String getShortnote() {
        return shortnote;
    }

    public void setShortnote(String shortnote) {
        this.shortnote = shortnote;
    }

    public String getMatchCondition() {
        return matchCondition;
    }

    public void setMatchCondition(String matchCondition) {
        this.matchCondition = matchCondition;
    }

    public String getHelloUrl() {
        return helloUrl;
    }

    public void setHelloUrl(String helloUrl) {
        this.helloUrl = helloUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserByJiaYuan{" +
                "userId=" + userId +
                ", realUid=" + realUid +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", marriage='" + marriage + '\'' +
                ", height='" + height + '\'' +
                ", education='" + education + '\'' +
                ", localhost='" + localhost + '\'' +
                ", image='" + image + '\'' +
                ", randTag='" + randTag + '\'' +
                ", randListTag='" + randListTag + '\'' +
                ", shortnote='" + shortnote + '\'' +
                ", matchCondition='" + matchCondition + '\'' +
                ", helloUrl='" + helloUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
