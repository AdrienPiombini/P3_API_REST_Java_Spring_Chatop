package com.P3_OpenClassRoomBackEnd.controllers;


import com.P3_OpenClassRoomBackEnd.models.Rental;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalRequest;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalResponse;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="rentals")
@RequiredArgsConstructor
@Tag(name = "Rentals")
public class RentalsController {

    private final RentalServices rentalServices;

    @Operation(
            summary = "Create a rental",
            responses = {
                    @ApiResponse(
                            responseCode = "201"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(implementation = RentalRequest.class)
                    )
            )
    )
    @PostMapping
    public ResponseEntity savingRental(@ModelAttribute RentalRequest rental){
        return rentalServices.registerRental(rental);
    }

    @Operation(
            summary = "Retrieve all rentals"
    )
    @GetMapping
    public List<RentalResponse> retrieveAll(){
        return rentalServices.getAllRentalsDao();
    }


    @Operation(
            summary = "Retrieve one rental"
    )
    @GetMapping("/{id}")
    public ResponseEntity retrieveOneRental(@PathVariable(name = "id") Integer rentalId){
        Optional<Rental> rental = rentalServices.getOneRentalModel(rentalId);
        if(rental.isPresent()){
            return ResponseEntity.ok(rentalServices.getOneRentalDao(rental.get()));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rental not found");
    }

    @Operation(
            summary = "Update a rental",
            description = "Update a rental with id",
            responses = {
                    @ApiResponse(
                            description = "rental updated",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            responseCode = "401"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(implementation = RentalRequest.class)
                    )
            )
    )
    @PutMapping("/{id}")
    public ResponseEntity updateRental(@ModelAttribute RentalRequest request , @PathVariable(name = "id") Integer rentalId){
        Optional<Rental> rental = rentalServices.getOneRentalModel(rentalId);
        if(rental.isPresent()){
            return rentalServices.updateRental(request, rental.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rental not found");
    }
}
