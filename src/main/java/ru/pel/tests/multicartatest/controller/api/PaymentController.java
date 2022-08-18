package ru.pel.tests.multicartatest.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pel.tests.multicartatest.entity.Payment;
import ru.pel.tests.multicartatest.service.PaymentService;

import java.util.List;

@SecurityRequirement(name = "basicAuth")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Operation(summary = "Get list of all payments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payments get", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Payment.class)))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content()}),
            @ApiResponse(responseCode = "404", description = "Did not fount any payments", content = {@Content()})
    })
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(service.getAllPayments());
    }

    @Operation(summary = "Post new payment")
    @PostMapping
    public ResponseEntity<Payment> doPayment(
//            @RequestBody(description = "Payment to add", required = true,
//                    content = @Content(schema = @Schema(implementation = Payment.class)))
            @RequestBody
            Payment payment) { //FIXME заменить entity на DTO
        return ResponseEntity.ok(service.savePayment(payment));
    }
}
