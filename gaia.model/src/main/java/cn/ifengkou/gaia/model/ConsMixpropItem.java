package cn.ifengkou.gaia.model;

import java.util.Date;

/**
 * Created by Sloong on 2016/2/9.
 */
public class ConsMixpropItem {
    private String id;
    private String siloId;
    private String siloName;
    private String stuffId;
    private String stuffName;

    private String stuffSpec;

    private double amount;

    private String builder;
    private Date buildTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiloId() {
        return siloId;
    }

    public void setSiloId(String siloId) {
        this.siloId = siloId;
    }

    public String getSiloName() {
        return siloName;
    }

    public void setSiloName(String siloName) {
        this.siloName = siloName;
    }

    public String getStuffId() {
        return stuffId;
    }

    public void setStuffId(String stuffId) {
        this.stuffId = stuffId;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public String getStuffSpec() {
        return stuffSpec;
    }

    public void setStuffSpec(String stuffSpec) {
        this.stuffSpec = stuffSpec;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
