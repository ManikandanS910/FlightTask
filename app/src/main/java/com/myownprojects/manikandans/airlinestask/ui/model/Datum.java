package com.myownprojects.manikandans.airlinestask.ui.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.myownprojects.manikandans.airlinestask.utility.DateConverter;

@Entity(tableName = "flight_list_db")
public class Datum {
    @SerializedName("id")
    @Expose
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "taskScheduleId")
    @SerializedName("taskScheduleId")
    @Expose
    private Integer taskScheduleId;
    @ColumnInfo(name ="flightSchedulesId")
    @SerializedName("flightSchedulesId")
    @Expose
    private Integer flightSchedulesId;
    @ColumnInfo(name ="flightSchedulesDate")
    @SerializedName("flightSchedulesDate")
    @Expose
    private Long flightSchedulesDate;
    @ColumnInfo(name ="arrFlightNumber")
    @SerializedName("arrFlightNumber")
    @Expose
    private String arrFlightNumber;
    @ColumnInfo(name ="depFlightNumber")
    @SerializedName("depFlightNumber")
    @Expose
    private String depFlightNumber;
    @ColumnInfo(name ="standardArrivalTime")
    @SerializedName("standardArrivalTime")
    @Expose
    private Long standardArrivalTime;
    @ColumnInfo(name ="standardDepartureTime")
    @SerializedName("standardDepartureTime")
    @Expose
    private Long standardDepartureTime;
    @ColumnInfo(name ="estimatedArrivalTime")
    @SerializedName("estimatedArrivalTime")
    @Expose
    private Long estimatedArrivalTime;
    @ColumnInfo(name ="estimatedDepartureTime")
    @SerializedName("estimatedDepartureTime")
    @Expose
    private Long estimatedDepartureTime;
    @ColumnInfo(name ="flightType")
    @SerializedName("flightType")
    @Expose
    private Integer flightType;
    @ColumnInfo(name ="userId")
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @ColumnInfo(name ="resourceMappingId")
    @SerializedName("resourceMappingId")
    @Expose
    private Integer resourceMappingId;
    @ColumnInfo(name ="name")
    @SerializedName("name")
    @Expose
    private String name;
    @ColumnInfo(name ="taskScheduleDetailId")
    @SerializedName("taskScheduleDetailId")
    @Expose
    private Integer taskScheduleDetailId;
    @ColumnInfo(name ="taskId")
    @SerializedName("taskId")
    @Expose
    private Integer taskId;
    @ColumnInfo(name ="taskName")
    @SerializedName("taskName")
    @Expose
    private String taskName;
    @ColumnInfo(name ="taskDuration")
    @SerializedName("taskDuration")
    @Expose
    private Integer taskDuration;
    @ColumnInfo(name ="taskSequenceNumber")
    @SerializedName("taskSequenceNumber")
    @Expose
    private Integer taskSequenceNumber;
    @ColumnInfo(name ="arrivalDepartureType")
    @SerializedName("arrivalDepartureType")
    @Expose
    private Integer arrivalDepartureType;
    @ColumnInfo(name ="activityStartTime")
    @SerializedName("activityStartTime")
    @Expose
    private Integer activityStartTime;
    @ColumnInfo(name ="optional")
    @SerializedName("optional")
    @Expose
    private Integer optional;
    @ColumnInfo(name ="taskStatusId")
    @SerializedName("taskStatusId")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskStatusId;
    @ColumnInfo(name ="taskActualStartTime")
    @SerializedName("taskActualStartTime")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskActualStartTime;
    @ColumnInfo(name ="taskActualEndTime")
    @SerializedName("taskActualEndTime")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskActualEndTime;
    @ColumnInfo(name ="taskModifiedStartTime")
    @SerializedName("taskModifiedStartTime")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskModifiedStartTime;
    @ColumnInfo(name ="taskModifiedEndTime")
    @SerializedName("taskModifiedEndTime")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskModifiedEndTime;
    @ColumnInfo(name ="taskDelayCodeId")
    @SerializedName("taskDelayCodeId")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskDelayCodeId;
    @ColumnInfo(name ="taskDelayNumericCode")
    @SerializedName("taskDelayNumericCode")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskDelayNumericCode;
    @ColumnInfo(name ="taskDelayAlphabeticCode")
    @SerializedName("taskDelayAlphabeticCode")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskDelayAlphabeticCode;
    @ColumnInfo(name ="taskDelayCodeDescription")
    @SerializedName("taskDelayCodeDescription")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskDelayCodeDescription;
    @ColumnInfo(name ="taskDelayReason")
    @SerializedName("taskDelayReason")
    @Expose
    @TypeConverters(DateConverter.class)
    private String taskDelayReason;
    @ColumnInfo(name ="actualArrivalTime")
    @SerializedName("actualArrivalTime")
    @Expose
    private Long actualArrivalTime;
    @ColumnInfo(name ="actualDepartureTime")
    @SerializedName("actualDepartureTime")
    @Expose
    private Long actualDepartureTime;
    @ColumnInfo(name ="taskSkipped")
    @SerializedName("taskSkipped")
    @Expose
    private Boolean taskSkipped;
    @SerializedName("ataWeb")
    @ColumnInfo(name ="ataWeb")
    @Expose
    @TypeConverters(DateConverter.class)
    private String ataWeb;
    @ColumnInfo(name ="atdWeb")
    @SerializedName("atdWeb")
    @Expose
    @TypeConverters(DateConverter.class)
    private String atdWeb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTaskScheduleId() {
        return taskScheduleId;
    }

    public void setTaskScheduleId(Integer taskScheduleId) {
        this.taskScheduleId = taskScheduleId;
    }

    public Integer getFlightSchedulesId() {
        return flightSchedulesId;
    }

    public void setFlightSchedulesId(Integer flightSchedulesId) {
        this.flightSchedulesId = flightSchedulesId;
    }

    public Long getFlightSchedulesDate() {
        return flightSchedulesDate;
    }

    public void setFlightSchedulesDate(Long flightSchedulesDate) {
        this.flightSchedulesDate = flightSchedulesDate;
    }

    public String getArrFlightNumber() {
        return arrFlightNumber;
    }

    public void setArrFlightNumber(String arrFlightNumber) {
        this.arrFlightNumber = arrFlightNumber;
    }

    public String getDepFlightNumber() {
        return depFlightNumber;
    }

    public void setDepFlightNumber(String depFlightNumber) {
        this.depFlightNumber = depFlightNumber;
    }

    public Long getStandardArrivalTime() {
        return standardArrivalTime;
    }

    public void setStandardArrivalTime(Long standardArrivalTime) {
        this.standardArrivalTime = standardArrivalTime;
    }

    public Long getStandardDepartureTime() {
        return standardDepartureTime;
    }

    public void setStandardDepartureTime(Long standardDepartureTime) {
        this.standardDepartureTime = standardDepartureTime;
    }

    public Long getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Long estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public Long getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Long estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public Integer getFlightType() {
        return flightType;
    }

    public void setFlightType(Integer flightType) {
        this.flightType = flightType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResourceMappingId() {
        return resourceMappingId;
    }

    public void setResourceMappingId(Integer resourceMappingId) {
        this.resourceMappingId = resourceMappingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTaskScheduleDetailId() {
        return taskScheduleDetailId;
    }

    public void setTaskScheduleDetailId(Integer taskScheduleDetailId) {
        this.taskScheduleDetailId = taskScheduleDetailId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(Integer taskDuration) {
        this.taskDuration = taskDuration;
    }

    public Integer getTaskSequenceNumber() {
        return taskSequenceNumber;
    }

    public void setTaskSequenceNumber(Integer taskSequenceNumber) {
        this.taskSequenceNumber = taskSequenceNumber;
    }

    public Integer getArrivalDepartureType() {
        return arrivalDepartureType;
    }

    public void setArrivalDepartureType(Integer arrivalDepartureType) {
        this.arrivalDepartureType = arrivalDepartureType;
    }

    public Integer getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Integer activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Integer getOptional() {
        return optional;
    }

    public void setOptional(Integer optional) {
        this.optional = optional;
    }

    public String getTaskStatusId() {
        return taskStatusId;
    }

    public void setTaskStatusId(String taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    public String getTaskActualStartTime() {
        return taskActualStartTime;
    }

    public void setTaskActualStartTime(String taskActualStartTime) {
        this.taskActualStartTime = taskActualStartTime;
    }

    public String getTaskActualEndTime() {
        return taskActualEndTime;
    }

    public void setTaskActualEndTime(String taskActualEndTime) {
        this.taskActualEndTime = taskActualEndTime;
    }

    public String getTaskModifiedStartTime() {
        return taskModifiedStartTime;
    }

    public void setTaskModifiedStartTime(String taskModifiedStartTime) {
        this.taskModifiedStartTime = taskModifiedStartTime;
    }

    public String getTaskModifiedEndTime() {
        return taskModifiedEndTime;
    }

    public void setTaskModifiedEndTime(String taskModifiedEndTime) {
        this.taskModifiedEndTime = taskModifiedEndTime;
    }

    public String getTaskDelayCodeId() {
        return taskDelayCodeId;
    }

    public void setTaskDelayCodeId(String taskDelayCodeId) {
        this.taskDelayCodeId = taskDelayCodeId;
    }

    public String getTaskDelayNumericCode() {
        return taskDelayNumericCode;
    }

    public void setTaskDelayNumericCode(String taskDelayNumericCode) {
        this.taskDelayNumericCode = taskDelayNumericCode;
    }

    public String getTaskDelayAlphabeticCode() {
        return taskDelayAlphabeticCode;
    }

    public void setTaskDelayAlphabeticCode(String taskDelayAlphabeticCode) {
        this.taskDelayAlphabeticCode = taskDelayAlphabeticCode;
    }

    public String getTaskDelayCodeDescription() {
        return taskDelayCodeDescription;
    }

    public void setTaskDelayCodeDescription(String taskDelayCodeDescription) {
        this.taskDelayCodeDescription = taskDelayCodeDescription;
    }

    public String getTaskDelayReason() {
        return taskDelayReason;
    }

    public void setTaskDelayReason(String taskDelayReason) {
        this.taskDelayReason = taskDelayReason;
    }

    public Long getActualArrivalTime() {
        return actualArrivalTime;
    }

    public void setActualArrivalTime(Long actualArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
    }

    public Long getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(Long actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public Boolean getTaskSkipped() {
        return taskSkipped;
    }

    public void setTaskSkipped(Boolean taskSkipped) {
        this.taskSkipped = taskSkipped;
    }

    public String getAtaWeb() {
        return ataWeb;
    }

    public void setAtaWeb(String ataWeb) {
        this.ataWeb = ataWeb;
    }

    public String getAtdWeb() {
        return atdWeb;
    }

    public void setAtdWeb(String atdWeb) {
        this.atdWeb = atdWeb;
    }
}
