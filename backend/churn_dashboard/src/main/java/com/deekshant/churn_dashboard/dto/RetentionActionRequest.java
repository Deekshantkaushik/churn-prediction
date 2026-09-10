package com.deekshant.churn_dashboard.dto;

public class RetentionActionRequest {
    private String actionType;
    private String notes;

    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
