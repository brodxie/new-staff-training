package domain;

public class PowerInfo {

    public int powerId;

    public String powerTitle;

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public String getPowerTitle() {
        return powerTitle;
    }

    public void setPowerTitle(String powerTitle) {
        this.powerTitle = powerTitle;
    }

    public PowerInfo(String powerTitle) {
        this.powerTitle = powerTitle;
    }

}
