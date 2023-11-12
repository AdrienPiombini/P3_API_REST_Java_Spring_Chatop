package com.P3_OpenClassRoomBackEnd.services.rental;

import com.P3_OpenClassRoomBackEnd.mappers.RentalsMapper;
import com.P3_OpenClassRoomBackEnd.models.Rental;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.repository.RentalsRepository;
import com.P3_OpenClassRoomBackEnd.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalServices {
    private final RentalsRepository rentalsRepository;
    private final UserService userService;
    private final RentalsMapper rentalsMapper;

    public Optional<Rental> getOneRentalModel(Integer rentalId) {
        return rentalsRepository.findById(rentalId);

    }

    public RentalResponse getOneRentalDao(Rental rental) {
        return rentalsMapper.fromRentalsModel(rental);
    }

    public List<RentalResponse> getAllRentalsDao(){
        var rentalsModels = rentalsRepository.findAll();
        List<RentalResponse> rentalsDao = rentalsModels.stream().map(rentalsModel -> rentalsMapper.fromRentalsModel(rentalsModel)).collect(Collectors.toList());
        return rentalsDao;
    }

    public void registerRental(RentalRequest request){
        User user = userService.retrieveUserByContext();
        Rental rental = Rental.builder()
                .name(request.getName())
                .surface(request.getSurface())
                .price(request.getPrice())
                .description(request.getDescription())
                .created_at(new Date())
                .build();
        rental.setUser(user);

        MultipartFile file = request.getPicture();
        if (file != null && !file.isEmpty()) {
            rental.setPicture(file.getOriginalFilename());
        }
        rentalsRepository.save(rental);
    }

    public ResponseEntity updateRental(RentalRequest request, Rental rental) {
            rental.setName(request.getName());
            rental.setSurface(request.getSurface());
            rental.setPrice(request.getPrice());
            rental.setDescription(request.getDescription());
            rental.setUpdated_at(new Date());

            MultipartFile file = request.getPicture();
            if (file != null && !file.isEmpty()) {
                rental.setPicture(file.getOriginalFilename());
            }
            rentalsRepository.save(rental);
            return ResponseEntity.ok("Rental Updated");
    }

}



