package com.tk.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`flyway_schema_history`")
public class FlywaySchemaHistory extends BaseEntity {
    @Id
    @Column(name = "`installed_rank`")
    private Integer installedRank;

    @Column(name = "`version`")
    private String version;

    @Column(name = "`description`")
    private String description;

    @Column(name = "`type`")
    private String type;

    @Column(name = "`script`")
    private String script;

    @Column(name = "`checksum`")
    private Integer checksum;

    @Column(name = "`installed_by`")
    private String installedBy;

    @Column(name = "`installed_on`")
    private Date installedOn;

    @Column(name = "`execution_time`")
    private Integer executionTime;

    @Column(name = "`success`")
    private Boolean success;

    /**
     * @return installed_rank
     */
    public Integer getInstalledRank() {
        return installedRank;
    }

    /**
     * @param installedRank
     */
    public void setInstalledRank(Integer installedRank) {
        this.installedRank = installedRank;
    }

    /**
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return script
     */
    public String getScript() {
        return script;
    }

    /**
     * @param script
     */
    public void setScript(String script) {
        this.script = script;
    }

    /**
     * @return checksum
     */
    public Integer getChecksum() {
        return checksum;
    }

    /**
     * @param checksum
     */
    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    /**
     * @return installed_by
     */
    public String getInstalledBy() {
        return installedBy;
    }

    /**
     * @param installedBy
     */
    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    /**
     * @return installed_on
     */
    public Date getInstalledOn() {
        return installedOn;
    }

    /**
     * @param installedOn
     */
    public void setInstalledOn(Date installedOn) {
        this.installedOn = installedOn;
    }

    /**
     * @return execution_time
     */
    public Integer getExecutionTime() {
        return executionTime;
    }

    /**
     * @param executionTime
     */
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * @return success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}