package com.abdolphininfratech.Model;

public class UserRewardModel {
    private String Reward;
    private String status;
    private String Target;
    private int image;

    public UserRewardModel(String reward, String status, String target, int image) {
        Reward = reward;
        this.status = status;
        Target = target;
        this.image = image;
    }

    public String getReward() {
        return Reward;
    }

    public void setReward(String reward) {
        Reward = reward;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
