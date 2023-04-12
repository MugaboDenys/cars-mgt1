/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.GeneralDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Company;

/**
 *
 * @author joyeuse
 */
 @ManagedBean(name="CarCrud")
public class carcrud {
       
private Company car=new Company();
private GeneralDao<Company> dao=new GeneralDao<>(Company.class);
private List<Company>cars;
 private String action = "Create";

   public String registerCar(){
        FacesContext faces =  FacesContext.getCurrentInstance();
         String massage = Validate();
          if(massage.equals("validated")){
       try {
           if(action.equals("Create")){
               if(dao.findBySTRING_PK(car.getPlateNo())!= null){
                     FacesMessage msg = new FacesMessage("Sorry you are trying to record an existing car will plate no"+car.getPlateNo());
               FacesContext.getCurrentInstance().addMessage(null, msg);
                return "Form";
                }
                
            dao.create(car);
           }
            else if(action.equals("Update")){
                dao.update(car);
            }
        FacesMessage msg = new FacesMessage("you have successfully registered"+car.getInstitution()+""+car.getModel()+""+car.getPlateNo());
               FacesContext.getCurrentInstance().addMessage(null, msg);
           return "List";
            
               
       } catch (Exception e) {
            
             return "Form";
       }
            }else{
            faces.addMessage("joyeuse", new FacesMessage(massage) );
        }
        return "form.xhtml";
                      
   }
   
   public List<Company>getall(){
    return dao.listAll();
   }


   public String update(Company cars){
        this.car = cars;
        this.action = "Update";
        return "Form";
    }
   
   public String Delete(Company cars){
       dao.delete(cars);
      return "List";
   }
   
   
   
    public String Validate(){
  if(!car.getPlateNo().matches("GP[0-9]{3}[A-Z]{1}")&&!car.getPlateNo().matches("GR[0-9]{3}[A-Z]")){
      return "plate should be GR001A or GP001E";
  }
    if(car.getManufacturingyear() < 2000){
       return "this year is wrong";
   }
   else if(car.getPurchaseCost() > 100000000 || car.getPurchaseCost() < 1000000){
            return "The cost of a car should not be less than 1,000,000 FRW or greater than 100,0000,000 FRW";
   }
    else if(car.getPlateNo().length() > 6){
         return "Plate number Should be not greater than 4";
      }
  
  return "validated";
}
    
   

    public Company getCar() {
        return car;
    }

    public void setCar(Company car) {
        this.car = car;
    }

    public GeneralDao<Company> getDao() {
        return dao;
    }

    public void setDao(GeneralDao<Company> dao) {
        this.dao = dao;
    }

    public List<Company> getCars() {
        return cars;
    }

    public void setCars(List<Company> cars) {
        this.cars = cars;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    


}

    

