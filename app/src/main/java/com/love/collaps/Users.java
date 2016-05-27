package com.love.collaps;

/**
 * 作者：zf on 2016/5/26 15:49
 * 邮箱：initzf@126.com
 */
public class Users {
    private int imageUrl;
    private String name;

    public Users(int imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "imageUrl=" + imageUrl +
                ", name='" + name + '\'' +
                '}';
    }
}
