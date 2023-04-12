/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author joyeuse
 */
@Entity
public class Company {
 @Id
    private String plateNo;
  private String Model;
  private String institution;
  private int manufacturingyear;
  private long purchaseCost;

    public Company() {
    }

    public Company(String plateNo, String Model, String institution, int manufacturingyear, long purchaseCost) {
        this.plateNo = plateNo;
        this.Model = Model;
        this.institution = institution;
        this.manufacturingyear = manufacturingyear;
        this.purchaseCost = purchaseCost;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getManufacturingyear() {
        return manufacturingyear;
    }

    public void setManufacturingyear(int manufacturingyear) {
        this.manufacturingyear = manufacturingyear;
    }

    public long getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(long purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
  
  
    
}
