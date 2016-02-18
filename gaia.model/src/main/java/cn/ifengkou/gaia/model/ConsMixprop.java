package cn.ifengkou.gaia.model;

import java.util.Date;

/**
 * Created by Sloong on 2016/2/9.
 */
public class ConsMixprop {
    private String id;
    private String formulaId;
    private String formulaName;
    private String seasonType;

    private String slump;
    private double weight;
    private double wCRate;
    private double sCRate;

    private boolean auditStatus;
    private String productLineId;


    private String taskId;
    private String contractId;
    private String projectId;
    private String projectName;
    private String constructUnit;
    private String conStrength;
    private String consPos;
    private String castMode;

    private String builder;
    private Date buildTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(String formulaId) {
        this.formulaId = formulaId;
    }

    public String getFormulaName() {
        return formulaName;
    }

    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getwCRate() {
        return wCRate;
    }

    public void setwCRate(double wCRate) {
        this.wCRate = wCRate;
    }

    public double getsCRate() {
        return sCRate;
    }

    public void setsCRate(double sCRate) {
        this.sCRate = sCRate;
    }

    public boolean isAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(String productLineId) {
        this.productLineId = productLineId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getConstructUnit() {
        return constructUnit;
    }

    public void setConstructUnit(String constructUnit) {
        this.constructUnit = constructUnit;
    }

    public String getConStrength() {
        return conStrength;
    }

    public void setConStrength(String conStrength) {
        this.conStrength = conStrength;
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

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }
}
