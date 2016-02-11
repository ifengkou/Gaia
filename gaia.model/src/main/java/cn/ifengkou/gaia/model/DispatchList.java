package cn.ifengkou.gaia.model;

/**
 * 生产进度
 * Created by Sloong on 2016/2/11.
 */
public class DispatchList {
    /*
    select d.DispatchID id,d.taskId,d.productLineId
   ,l.productLineName
   ,t.projectName,t.constructUnit,t.conStrength,t.castMode,t.consPos,t.slump
from DispatchList d ,ProduceTasks t ,ProductLine l
where 1=1
	and d.TaskID = t.TaskID
  and d.ProductLineID = l.AutoID
	AND d.IsCompleted = 1
	and d.IsRunning = 1
	and d.buildtime>'2015-05-01'
     */
    private String id;
    private String taskId;
    private String productLineId;
    private String productLineName;
    private String projectName;
    private String constructUnit;
    private String castMode;
    private String consPos;
    private String slump;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(String productLineId) {
        this.productLineId = productLineId;
    }

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
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

    public String getCastMode() {
        return castMode;
    }

    public void setCastMode(String castMode) {
        this.castMode = castMode;
    }

    public String getConsPos() {
        return consPos;
    }

    public void setConsPos(String consPos) {
        this.consPos = consPos;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }
}
