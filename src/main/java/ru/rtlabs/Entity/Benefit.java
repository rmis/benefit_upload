package ru.rtlabs.Entity;

import java.sql.Date;

/**
 * Created by leon4uk on 20.12.16.
 */
public class Benefit {
    private Integer id;
    private String npp;
    private String benefitCode;
    private String benefitName;
    private String benefitSer;
    private String benefitNumber;
    private String benefitIssuer;
    private Date benefitGiven;
    private Date benefitStarDate;
    private Date benefitEndDate;

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

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public String getBenefitSer() {
        return benefitSer;
    }

    public void setBenefitSer(String benefitSer) {
        this.benefitSer = benefitSer;
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

    public Date getBenefitGiven() {
        return benefitGiven;
    }

    public void setBenefitGiven(Date benefitGiven) {
        this.benefitGiven = benefitGiven;
    }

    public Date getBenefitStarDate() {
        return benefitStarDate;
    }

    public void setBenefitStarDate(Date benefitStarDate) {
        this.benefitStarDate = benefitStarDate;
    }

    public Date getBenefitEndDate() {
        return benefitEndDate;
    }

    public void setBenefitEndDate(Date benefitEndDate) {
        this.benefitEndDate = benefitEndDate;
    }

    @Override
    public String toString() {
        return "id "+ this.id + " Код льготы " + this.benefitCode + " Серия документа льготы " + this.benefitSer + " Номер документа льготы " + this.benefitNumber + " Наименование организации, выдавшей документ на льготу "+ this.benefitIssuer+  " Дата выдачи документа на льготу " + this.benefitGiven+ " Дата начала льготы " +this.benefitStarDate+ " Дата окончания льгот " + this.benefitEndDate + " Наименование документа на льготу " + this.benefitName;
    }
}
