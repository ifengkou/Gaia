package cn.ifengkou.gaia.model;

import java.util.Date;

/**
 * Created by Sloong on 2015/12/17.
 */
public class CustomerPlan {
    private String customerPlanID;
    private String ContractID;
    private String ConstructUnit;
    private String ProjectID;
    private String ProjectName;
    private String ProjectAddr;
    private String ConsPos;
    private String ConStrength;
    private String Slump;
    private String CastMode;
    private double PlanCube;
    private String NeedDate;
    private Date PlanDate;
    private String Tel;
    private String LinkMan;

    private boolean auditStatus;

    private Project project;


    public String getCustomerPlanID() {
        return customerPlanID;
    }

    public void setCustomerPlanID(String customerPlanID) {
        this.customerPlanID = customerPlanID;
    }

    public String getContractID() {
        return ContractID;
    }

    public void setContractID(String contractID) {
        ContractID = contractID;
    }

    public String getConstructUnit() {
        return ConstructUnit;
    }

    public void setConstructUnit(String constructUnit) {
        ConstructUnit = constructUnit;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectAddr() {
        return ProjectAddr;
    }

    public void setProjectAddr(String projectAddr) {
        ProjectAddr = projectAddr;
    }

    public String getConsPos() {
        return ConsPos;
    }

    public void setConsPos(String consPos) {
        ConsPos = consPos;
    }

    public String getConStrength() {
        return ConStrength;
    }

    public void setConStrength(String conStrength) {
        ConStrength = conStrength;
    }

    public String getSlump() {
        return Slump;
    }

    public void setSlump(String slump) {
        Slump = slump;
    }

    public String getCastMode() {
        return CastMode;
    }

    public void setCastMode(String castMode) {
        CastMode = castMode;
    }

    public double getPlanCube() {
        return PlanCube;
    }

    public void setPlanCube(double planCube) {
        PlanCube = planCube;
    }

    public String getNeedDate() {
        return NeedDate;
    }

    public void setNeedDate(String needDate) {
        NeedDate = needDate;
    }

    public Date getPlanDate() {
        return PlanDate;
    }

    public void setPlanDate(Date planDate) {
        PlanDate = planDate;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getLinkMan() {
        return LinkMan;
    }

    public void setLinkMan(String linkMan) {
        LinkMan = linkMan;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(boolean auditStatus) {
        this.auditStatus = auditStatus;
    }
}
