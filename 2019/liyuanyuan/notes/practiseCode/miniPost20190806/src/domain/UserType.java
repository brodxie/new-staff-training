package domain;

public class UserType {

    public int typeId;

    public String powerIdList;

    public String userType;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getPowerIdList() {
        return powerIdList;
    }

    public void setPowerIdList(String powerIdList) {
        this.powerIdList = powerIdList;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserType(String powerIdList, String userType) {
        this.powerIdList = powerIdList;
        this.userType = userType;
    }

}
