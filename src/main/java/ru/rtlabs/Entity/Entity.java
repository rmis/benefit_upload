package ru.rtlabs.Entity;


import java.sql.Date;

public class Entity {
    private Integer id;
    private String npp;
    private String snils;
    private String docSeries;
    private String number;
    private String surname;
    private String name;
    private String patrName;
    private String gender;
    private String citizenShip;
    private String benefitType;
    private String benefitCode;
    private String benefitSer;
    private String benefitNumber;
    private String benefitIssuer;
    private Date bdate;
    private Date issuerDate;
    private Date benefitFederalStartDate;
    private Date benefitFederalEndDate;
    private Date benefitOblStartDate;
    private Date benefitOblEndDate;
    private Date benefitDenialDate;
    private String docType;
    private Date benefitGiveDate;
    private Date benefitStartDate;
    private Date benefitEndDate;
    private String benefitName;
    private Integer snilsCodeId;

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getDocSeries() {
        return docSeries;
    }

    public void setDocSeries(String docSeries) {
        this.docSeries = docSeries;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatrName() {
        return patrName;
    }

    public void setPatrName(String patrName) {
        this.patrName = patrName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenShip() {
        return citizenShip;
    }

    public void setCitizenShip(String citizenShip) {
        this.citizenShip = citizenShip;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitSer() {
        return benefitSer;
    }

    public void setBenefitSer(String benefitSer) {
        this.benefitSer = benefitSer;
    }

    public Date getBenefitGiveDate() {
        return benefitGiveDate;
    }

    public void setBenefitGiveDate(Date benefitGiveDate) {
        this.benefitGiveDate = benefitGiveDate;
    }

    public Date getBenefitStartDate() {
        return benefitStartDate;
    }

    public void setBenefitStartDate(Date benefitStartDate) {
        this.benefitStartDate = benefitStartDate;
    }

    public String getBenefitNumber() {
        return benefitNumber;
    }

    public void setBenefitNumber(String benefitNumber) {
        this.benefitNumber = benefitNumber;
    }

    public String getBenefitIssuer() {
        return benefitIssuer;
    }

    public void setBenefitIssuer(String benefitIssuer) {
        this.benefitIssuer = benefitIssuer;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getIssuerDate() {
        return issuerDate;
    }

    public void setIssuerDate(Date issuerDate) {
        this.issuerDate = issuerDate;
    }

    public Date getBenefitFederalStartDate() {
        return benefitFederalStartDate;
    }

    public void setBenefitFederalStartDate(Date benefitFederalStartDate) {
        this.benefitFederalStartDate = benefitFederalStartDate;
    }

    public Date getBenefitFederalEndDate() {
        return benefitFederalEndDate;
    }

    public void setBenefitFederalEndDate(Date benefitFederalEndDate) {
        this.benefitFederalEndDate = benefitFederalEndDate;
    }

    public Date getBenefitOblStartDate() {
        return benefitOblStartDate;
    }

    public void setBenefitOblStartDate(Date benefitOblStartDate) {
        this.benefitOblStartDate = benefitOblStartDate;
    }

    public Date getBenefitOblEndDate() {
        return benefitOblEndDate;
    }

    public void setBenefitOblEndDate(Date benefitOblEndDate) {
        this.benefitOblEndDate = benefitOblEndDate;
    }

    public Date getBenefitDenialDate() {
        return benefitDenialDate;
    }

    public void setBenefitDenialDate(Date benefitDenialDate) {
        this.benefitDenialDate = benefitDenialDate;
    }

    public Date getBenefitEndDate() {
        return benefitEndDate;
    }

    public void setBenefitEndDate(Date benefitEndDate) {
        this.benefitEndDate = benefitEndDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNpp() {
        return npp;
    }

    public void setNpp(String npp) {
        this.npp = npp;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public Integer getSnilsCodeId() {
        return snilsCodeId;
    }

    public void setSnilsCodeId(Integer snilsCodeId) {
        this.snilsCodeId = snilsCodeId;
    }

    @Override
    public String toString() {
        return "id "+ this.id +" Cнилс " + this.snils + " Фамилия " + this.surname + " Имя " + this.name + " Отчество " + this.patrName + " Дата Рождения " + this.bdate + " Серия документа УЛ " + this.docSeries + " Номер документа " + this.number + " Код льготы " + this.benefitCode + " Дата выдачи документа, удостоверяющего личность " + this.issuerDate + " Дата включения в (федеральный) регистр льготников " + this.benefitFederalStartDate + " Дата исключения из (федерального) регистра льготников " + this.benefitFederalEndDate + " Дата включения в (областной) регистр льготников " + this.benefitOblStartDate + " Дата исключения из (областного) регистра льготников " + this.benefitOblEndDate + " Дата отказа от льгот " + this.benefitDenialDate +" Серия документа льготы " + this.benefitSer + " Номер документа льготы " + this.benefitNumber + " Наименование организации, выдавшей документ на льготу "+ this.benefitIssuer+  " Дата выдачи документа на льготу " + this.benefitGiveDate+ " Дата начала льготы " +this.benefitStartDate+ " Дата окончания льгот " + this.benefitEndDate + " Наименование документа на льготу " + this.benefitName;
    }
}
