package com.myownprojects.manikandans.airlinestask.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "flight_table")
public class FlightListTableResponse {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "taskScheduleId")
    private Integer taskScheduleId;


    @ColumnInfo(name ="flightSchedulesId")
    
    private Integer flightSchedulesId;
    @ColumnInfo(name ="flightSchedulesDate")
    
    private Long flightSchedulesDate;
    @ColumnInfo(name ="arrFlightNumber")
    
    private String arrFlightNumber;
    @ColumnInfo(name ="depFlightNumber")
    
    private String depFlightNumber;
    @ColumnInfo(name ="standardArrivalTime")
    
    private Long standardArrivalTime;
    @ColumnInfo(name ="standardDepartureTime")
    
    private Long standardDepartureTime;
    @ColumnInfo(name ="estimatedArrivalTime")
    
    private Long estimatedArrivalTime;
    @ColumnInfo(name ="estimatedDepartureTime")
    
    private Long estimatedDepartureTime;
    @ColumnInfo(name ="flightType")
    
    private Integer flightType;
    @ColumnInfo(name ="userId")
    
    private Integer userId;
    @ColumnInfo(name ="resourceMappingId")
    
    private Integer resourceMappingId;
    @ColumnInfo(name ="name")
    
    private String name;
    @ColumnInfo(name ="taskScheduleDetailId")
    
    private Integer taskScheduleDetailId;
    @ColumnInfo(name ="taskId")
    
    private Integer taskId;
    @ColumnInfo(name ="taskName")
    
    private String taskName;
    @ColumnInfo(name ="taskDuration")
    
    private Integer taskDuration;
    @ColumnInfo(name ="taskSequenceNumber")
    
    private Integer taskSequenceNumber;
    @ColumnInfo(name ="arrivalDepartureType")
    
    private Integer arrivalDepartureType;
    @ColumnInfo(name ="activityStartTime")
    
    private Integer activityStartTime;
    @ColumnInfo(name ="optional")
    
    private Integer optional;
    @ColumnInfo(name ="taskStatusId")
    
    private Object taskStatusId;
    @ColumnInfo(name ="taskActualStartTime")
    
    private Object taskActualStartTime;
    @ColumnInfo(name ="taskActualEndTime")
    
    private Object taskActualEndTime;
    @ColumnInfo(name ="taskModifiedStartTime")
    
    private Object taskModifiedStartTime;
    @ColumnInfo(name ="taskModifiedEndTime")
    
    private Object taskModifiedEndTime;
    @ColumnInfo(name ="taskDelayCodeId")
    
    private Object taskDelayCodeId;
    @ColumnInfo(name ="taskDelayNumericCode")
    
    private Object taskDelayNumericCode;
    @ColumnInfo(name ="taskDelayAlphabeticCode")
    
    private Object taskDelayAlphabeticCode;
    @ColumnInfo(name ="taskDelayCodeDescription")
    
    private Object taskDelayCodeDescription;
    @ColumnInfo(name ="taskDelayReason")
    
    private Object taskDelayReason;
    @ColumnInfo(name ="actualArrivalTime")
    
    private Long actualArrivalTime;
    @ColumnInfo(name ="actualDepartureTime")
    
    private Long actualDepartureTime;
    @ColumnInfo(name ="taskSkipped")
    
    private Boolean taskSkipped;
    @ColumnInfo(name ="ataWeb")
    
    private Object ataWeb;
    @ColumnInfo(name ="atdWeb")
    
    private Object atdWeb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
