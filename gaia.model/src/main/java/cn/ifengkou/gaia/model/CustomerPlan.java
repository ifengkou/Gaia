package cn.ifengkou.gaia.model;

import java.util.Date;

/**
 * Created by Sloong on 2015/12/17.
 */
public class CustomerPlan {
    private String customerPlanID;
    private String contractID;
    private String constructUnit;
    private String projectName;
    private String projectAddr;
    private String consPos;
    private String conStrength;
    private String slump;
    private String castMode;
    private double planCube;
    private String needDate;
    private Date planDate;
    private String tel;
    private String linkMan;

    private boolean auditStatus;

    private String builder;
    private String modifier;
    private Date buildTime;
    private Date modifyTime;



    public String getCustomerPlanID() {
        return customerPlanID;
    }

    public void setCustomerPlanID(String customerPlanID) {
        this.customerPlanID = customerPlanID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getConstructUnit() {
        return constructUnit;
    }

    public void setConstructUnit(String constructUnit) {
        this.constructUnit = constructUnit;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAddr() {
        return projectAddr;
    }

    public void setProjectAddr(String projectAddr) {
        this.projectAddr = projectAddr;
    }

    public String getConsPos() {
        return consPos;
    }

    public void setConsPos(String consPos) {
        this.consPos = consPos;
    }

    public String getConStrength() {
        return conStrength;
    }

    public void setConStrength(String conStrength) {
        this.conStrength = conStrength;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public String getCastMode() {
        return castMode;
    }

    public void setCastMode(String castMode) {
        this.castMode = castMode;
    }

    public double getPlanCube() {
        return planCube;
    }

    public void setPlanCube(double planCube) {
        this.planCube = planCube;
    }

    public String getNeedDate() {
        return needDate;
    }

    public void setNeedDate(String needDate) {
        this.needDate = needDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public boolean isAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(boolean auditStatus) {
        this.auditStatus = auditStatus;
    }
}
