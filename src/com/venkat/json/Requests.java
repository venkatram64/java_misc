package com.venkat.json;

/**
 * Created by Venkatram on 4/28/2017.
 */
import java.util.Date;

public class Requests {

    private String tesseraRequestID;
    private Date requestDate;
    private String tesseraProviderID;
    private String tesseraProviderName;
    private String tesseraProductID;
    private String tesseraProductName;
    private String tesseraProductClassification;
    private String tesseraProductSubClassification;
    private String tesseraReviewType;
    private String tesseraRequestingGroup;
    private String questionnaireUrl;
    private int priority;

    public String getTesseraRequestID() {
        return tesseraRequestID;
    }
    public void setTesseraRequestID(String tesseraRequestID) {
        this.tesseraRequestID = tesseraRequestID;
    }
    public Date getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    public String getTesseraProviderID() {
        return tesseraProviderID;
    }
    public void setTesseraProviderID(String tesseraProviderID) {
        this.tesseraProviderID = tesseraProviderID;
    }
    public String getTesseraProviderName() {
        return tesseraProviderName;
    }
    public void setTesseraProviderName(String tesseraProviderName) {
        this.tesseraProviderName = tesseraProviderName;
    }
    public String getTesseraProductID() {
        return tesseraProductID;
    }
    public void setTesseraProductID(String tesseraProductID) {
        this.tesseraProductID = tesseraProductID;
    }
    public String getTesseraProductName() {
        return tesseraProductName;
    }
    public void setTesseraProductName(String tesseraProductName) {
        this.tesseraProductName = tesseraProductName;
    }
    public String getTesseraProductClassification() {
        return tesseraProductClassification;
    }
    public void setTesseraProductClassification(String tesseraProductClassification) {
        this.tesseraProductClassification = tesseraProductClassification;
    }
    public String getTesseraProductSubClassification() {
        return tesseraProductSubClassification;
    }
    public void setTesseraProductSubClassification(String tesseraProductSubClassification) {
        this.tesseraProductSubClassification = tesseraProductSubClassification;
    }
    public String getTesseraReviewType() {
        return tesseraReviewType;
    }
    public void setTesseraReviewType(String tesseraReviewType) {
        this.tesseraReviewType = tesseraReviewType;
    }
    public String getTesseraRequestingGroup() {
        return tesseraRequestingGroup;
    }
    public void setTesseraRequestingGroup(String tesseraRequestingGroup) {
        this.tesseraRequestingGroup = tesseraRequestingGroup;
    }
    public String getQuestionnaireUrl() {
        return questionnaireUrl;
    }
    public void setQuestionnaireUrl(String questionnaireUrl) {
        this.questionnaireUrl = questionnaireUrl;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }


}
