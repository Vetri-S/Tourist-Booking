
package com.example.demo.Modal;
import jakarta.persistence.*;

@Entity
@Table(name = "travel")
public class Travel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;                               
    @Column (name = "name")
    private String name;
    @Column(name ="contactno")
    private String contactNo;
    @Column(name ="mail")
    private String mail;
    @Column(name="currentlocation")
    private String currentLocation;
    @Column(name="destinationlocation")
    private String destinationLocation;
    @Column(name="packages")
    private long packages;
	public Object HttpStatus;
    public Travel (long l, String name,String contactNo,String mail,String currentLocation,String destinationLocation,long packages){
        this.id=id;
        this.name=name;
        this.contactNo=contactNo;
        this.mail=mail;
        this.currentLocation=currentLocation;
        this.destinationLocation=destinationLocation;
        this.packages=packages;
    }
    public Travel() {
       
    }
     public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContactNo() {
        return contactNo;
    }
 
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }


    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public long getPackages() {
        return packages;
    }

    public void setPackages(long packages) {
        this.packages = packages;
    }
   
   
}
