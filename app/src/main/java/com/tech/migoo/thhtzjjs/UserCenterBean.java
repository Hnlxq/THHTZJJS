package com.tech.migoo.thhtzjjs;

/**
 * Created by migoo_houhh on 16/6/15.
 */
public class UserCenterBean {

    private int centreIcon; //用户中心的icon
    private String centreName; //用户中心名字

    public UserCenterBean(int icon, String name){
        this.centreIcon = icon;
        this.centreName = name;
    }

    public int getCentreIcon() {
        return centreIcon;
    }

    public void setCentreIcon(int centreIcon) {
        this.centreIcon = centreIcon;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }
}
