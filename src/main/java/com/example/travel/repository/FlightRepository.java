// package com.example.travel.repository;

// import com.example.travel.model.Flight;
// import java.util.List;

// public interface FlightRepository {
//     List<Flight> findAll();
//     List<Flight> findByRoute(String departure, String arrival);
//     Flight findById(String id);
//     void save(Flight flight);
// }

package com.example.travel.repository;

import com.example.travel.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByDepartureAndArrival(String departure, String arrival);
}
