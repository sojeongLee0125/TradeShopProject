package com.nfteam.server.cart.controller;


import com.nfteam.server.cart.entity.Cart;
import com.nfteam.server.cart.service.CartService;
import com.nfteam.server.dto.response.cart.CartResponseDto;
import com.nfteam.server.security.userdetails.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity createCart(@AuthenticationPrincipal MemberDetails memberDetails) {
        Cart createdCart = cartService.createCart(memberDetails.getMemberId());
        return new ResponseEntity<>(CartResponseDto.of(createdCart), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity checkOutCart(@AuthenticationPrincipal MemberDetails memberDetails){
        Cart updatedCart = cartService.updateCart(memberDetails.getMemberId());
        return new ResponseEntity<>(CartResponseDto.of(updatedCart), HttpStatus.OK);
    }

}