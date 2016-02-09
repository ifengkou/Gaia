package cn.ifengkou.gaia.model;

import java.util.Date;

/**
 * Created by Sloong on 2016/1/12.
 */
public class Shipping {
    private String id;
    private double signInCube;
    private int isSigned;
    private String exceptionInfo;

    private String custName;
    private String projectName;
    private String conStrength;
    private String consPos;
    private String castMode;
    private String realSlump;
    private double shippingCube;
    private int providedTimes;
    private double provideCube;

    private String modifier;
    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSignInCube() {
        return signInCube;
    }

    public void setSignInCube(double signInCube) {
        this.signInCube = signInCube;
    }

    public int getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(int isSigned) {
        this.isSigned = isSigned;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getConsPos() {
        return consPos;
    }

    public void setConsPos(String consPos) {
        this.consPos = consPos;
    }

    public String getCastMode() {
        return castMode;
    }

    public void setCastMode(String castMode) {
        this.castMode = castMode;
    }

    public String getRealSlump() {
        return realSlump;
    }

    public void setRealSlump(String realSlump) {
        this.realSlump = realSlump;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getConStrength() {
        return conStrength;
    }

    public void setConStrength(String conStrength) {
        this.conStrength = conStrength;
    }

    public double getShippingCube() {
        return shippingCube;
    }

    public void setShippingCube(double shippingCube) {
        this.shippingCube = shippingCube;
    }

    public int getProvidedTimes() {
        return providedTimes;
    }

    public void setProvidedTimes(int providedTimes) {
        this.providedTimes = providedTimes;
    }

    public double getProvideCube() {
        return provideCube;
    }

    public void setProvideCube(double provideCube) {
        this.provideCube = provideCube;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
