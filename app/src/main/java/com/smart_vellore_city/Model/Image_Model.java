package com.smart_vellore_city.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Image_Model {
    private int avatar;
    private String nickname;
    private int background;
    private List<String> interests = new ArrayList<>();

    public Image_Model(int avatar, String nickname, int background, String... interest) {
        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
        interests.addAll(Arrays.asList(interest));
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public int getBackground() {
        return background;
    }

    public List<String> getInterests() {
        return interests;
    }
}
