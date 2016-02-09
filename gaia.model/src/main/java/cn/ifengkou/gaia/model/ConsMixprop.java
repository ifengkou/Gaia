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
    private String conStrength;
    private String slump;
    private double weight;
    private double wCRate;
    private double sCRate;

    private String productLineId;
    private String builder;
    private Date buildTime;

    //private List<ConsMixpropItem> consMixpropItems;

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

    public String getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(String productLineId) {
        this.productLineId = productLineId;
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

    /*public List<ConsMixpropItem> getConsMixpropItems() {
        return consMixpropItems;
    }

    public void setConsMixpropItems(List<ConsMixpropItem> consMixpropItems) {
        this.consMixpropItems = consMixpropItems;
    }*/
}
