package com.example.demo.Controller;

// import java.util.ArrayList;
// import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Modal.Travel;
import com.example.demo.repository.Travelrep;

@RestController
@RequestMapping("/api")
public class Travelcon {
    @Autowired
    Travelrep travelrep;

    @GetMapping("/travels/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable("id") Long id){
        Optional<Travel> travelData = travelrep.findById(id);

        if(travelData.isPresent()){
            return new ResponseEntity<>(travelData.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
     @PostMapping("/travels")
    public ResponseEntity<Travel> createTravel(@RequestBody Travel travel){
        try{
            Travel newtravel = new Travel(travel.getId(),travel.getName(),travel.getContactNo(),travel.getMail(),travel.getCurrentLocation(), travel.getDestinationLocation(), travel.getPackages());

            Travel sTravel = travelrep.save(newtravel);

            return new ResponseEntity<>( sTravel, HttpStatus.CREATED);
        }
        catch(Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     @PutMapping("/trvaels/{id}")
     public ResponseEntity<Travel> updateTravel(@PathVariable("id") long id){
         Optional<Travel> travelData = travelrep.findById(null);

         if(travelData.isPresent()){
            Travel travel = travelData.get();
            travel.setName(travel.getName());
            travel.setContactNo(travel.getContactNo());
            travel.setMail(travel.getMail());
            travel.setCurrentLocation(travel.getCurrentLocation());
            travel.setDestinationLocation(travel.getDestinationLocation());
            travel.setPackages(travel.getPackages());

            return new ResponseEntity<>(travelrep.save(travel), HttpStatus.OK);
         }
         else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }

    //  @DeleteMapping("/travels/{id}")
    //  public ResponseEntity<HttpStatus> deleteTravel(@PathVariable("id") long id){

    //     try{
    //         travelrep.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    //     catch (Exception e){
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    //  }

    //  @DeleteMapping("/travels")
    //  public ResponseEntity<HttpStatus> deleteAllTravel(){
    //     try{
    //         travelrep.deleteAll();
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    //     catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    //  }

    // @GetMapping("/travels")
    // public ResponseEntity<List<Travel>> getAllTravels(@RequestParam(required = false) String name){
    //     try{
    //         List<Travel> travels = new ArrayList<Travel>();
    //         if(name == null){
    //             travelrep.findAll().forEach(travels::add);
    //         }
    //         else{
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         }
    //         return new ResponseEntity<>(travels, HttpStatus.OK);
    //     }
    //     catch (Exception e){
    //     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("/travels/published")
    // public ResponseEntity<List<Travel>> findByPublished(){
    //     try{
    //         List<Travel> travels = travelrep.findAll();
    //         if(travels.isEmpty()){
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         }
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     }
    //     catch(Exception e){
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }


}
