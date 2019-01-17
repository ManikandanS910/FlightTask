package com.myownprojects.manikandans.airlinestask.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("taskScheduleId")
    @Expose
    private Integer taskScheduleId;
    @SerializedName("flightSchedulesId")
    @Expose
    private Integer flightSchedulesId;
    @SerializedName("flightSchedulesDate")
    @Expose
    private Long flightSchedulesDate;
    @SerializedName("arrFlightNumber")
    @Expose
    private String arrFlightNumber;
    @SerializedName("depFlightNumber")
    @Expose
    private String depFlightNumber;
    @SerializedName("standardArrivalTime")
    @Expose
    private Long standardArrivalTime;
    @SerializedName("standardDepartureTime")
    @Expose
    private Long standardDepartureTime;
    @SerializedName("estimatedArrivalTime")
    @Expose
    private Long estimatedArrivalTime;
    @SerializedName("estimatedDepartureTime")
    @Expose
    private Long estimatedDepartureTime;
    @SerializedName("flightType")
    @Expose
    private Integer flightType;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("resourceMappingId")
    @Expose
    private Integer resourceMappingId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("taskScheduleDetailId")
    @Expose
    private Integer taskScheduleDetailId;
    @SerializedName("taskId")
    @Expose
    private Integer taskId;
    @SerializedName("taskName")
    @Expose
    private String taskName;
    @SerializedName("taskDuration")
    @Expose
    private Integer taskDuration;
    @SerializedName("taskSequenceNumber")
    @Expose
    private Integer taskSequenceNumber;
    @SerializedName("arrivalDepartureType")
    @Expose
    private Integer arrivalDepartureType;
    @SerializedName("activityStartTime")
    @Expose
    private Integer activityStartTime;
    @SerializedName("optional")
    @Expose
    private Integer optional;
    @SerializedName("taskStatusId")
    @Expose
    private Object taskStatusId;
    @SerializedName("taskActualStartTime")
    @Expose
    private Object taskActualStartTime;
    @SerializedName("taskActualEndTime")
    @Expose
    private Object taskActualEndTime;
    @SerializedName("taskModifiedStartTime")
    @Expose
    private Object taskModifiedStartTime;
    @SerializedName("taskModifiedEndTime")
    @Expose
    private Object taskModifiedEndTime;
    @SerializedName("taskDelayCodeId")
    @Expose
    private Object taskDelayCodeId;
    @SerializedName("taskDelayNumericCode")
    @Expose
    private Object taskDelayNumericCode;
    @SerializedName("taskDelayAlphabeticCode")
    @Expose
    private Object taskDelayAlphabeticCode;
    @SerializedName("taskDelayCodeDescription")
    @Expose
    private Object taskDelayCodeDescription;
    @SerializedName("taskDelayReason")
    @Expose
    private Object taskDelayReason;
    @SerializedName("actualArrivalTime")
    @Expose
    private Long actualArrivalTime;
    @SerializedName("actualDepartureTime")
    @Expose
    private Long actualDepartureTime;
    @SerializedName("taskSkipped")
    @Expose
    private Boolean taskSkipped;
    @SerializedName("ataWeb")
    @Expose
    private Object ataWeb;
    @SerializedName("atdWeb")
    @Expose
    private Object atdWeb;

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

    public Object getTaskStatusId() {
        return taskStatusId;
    }

    public void setTaskStatusId(Object taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    public Object getTaskActualStartTime() {
        return taskActualStartTime;
    }

    public void setTaskActualStartTime(Object taskActualStartTime) {
        this.taskActualStartTime = taskActualStartTime;
    }

    public Object getTaskActualEndTime() {
        return taskActualEndTime;
    }

    public void setTaskActualEndTime(Object taskActualEndTime) {
        this.taskActualEndTime = taskActualEndTime;
    }

    public Object getTaskModifiedStartTime() {
        return taskModifiedStartTime;
    }

    public void setTaskModifiedStartTime(Object taskModifiedStartTime) {
        this.taskModifiedStartTime = taskModifiedStartTime;
    }

    public Object getTaskModifiedEndTime() {
        return taskModifiedEndTime;
    }

    public void setTaskModifiedEndTime(Object taskModifiedEndTime) {
        this.taskModifiedEndTime = taskModifiedEndTime;
    }

    public Object getTaskDelayCodeId() {
        return taskDelayCodeId;
    }

    public void setTaskDelayCodeId(Object taskDelayCodeId) {
        this.taskDelayCodeId = taskDelayCodeId;
    }

    public Object getTaskDelayNumericCode() {
        return taskDelayNumericCode;
    }

    public void setTaskDelayNumericCode(Object taskDelayNumericCode) {
        this.taskDelayNumericCode = taskDelayNumericCode;
    }

    public Object getTaskDelayAlphabeticCode() {
        return taskDelayAlphabeticCode;
    }

    public void setTaskDelayAlphabeticCode(Object taskDelayAlphabeticCode) {
        this.taskDelayAlphabeticCode = taskDelayAlphabeticCode;
    }

    public Object getTaskDelayCodeDescription() {
        return taskDelayCodeDescription;
    }

    public void setTaskDelayCodeDescription(Object taskDelayCodeDescription) {
        this.taskDelayCodeDescription = taskDelayCodeDescription;
    }

    public Object getTaskDelayReason() {
        return taskDelayReason;
    }

    public void setTaskDelayReason(Object taskDelayReason) {
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

    public Object getAtaWeb() {
        return ataWeb;
    }

    public void setAtaWeb(Object ataWeb) {
        this.ataWeb = ataWeb;
    }

    public Object getAtdWeb() {
        return atdWeb;
    }

    public void setAtdWeb(Object atdWeb) {
        this.atdWeb = atdWeb;
    }
}
