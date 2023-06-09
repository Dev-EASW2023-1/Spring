package com.example.demo.app.domain.controller;

import com.example.demo.app.domain.model.dto.contract.*;
import com.example.demo.app.domain.model.dto.item.ItemDto;
import com.example.demo.app.domain.model.dto.item.ItemListDto;
import com.example.demo.app.domain.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping("/complete")
    public ResponseEntity<ContractResponse> pushMember(
            @RequestBody ContractRequest contractRequest
    ) {
        return new ResponseEntity<>(
                contractService.registerContract(contractRequest),
                getJsonHeader(),
                HttpStatus.OK);
    }

    @PostMapping("/item")
    public ResponseEntity<ItemDto> findItem(
            @RequestBody ItemInContractDto itemInContractDto
    ) {
        return new ResponseEntity<>(
                contractService.findItemByContract(itemInContractDto),
                getJsonHeader(),
                HttpStatus.OK);
    }


    // 테스트용 API (Contract 테이블 JPQL @Query 사용)
    @GetMapping("/test1/{userId}/{realtorId}/{itemId}")
    public ResponseEntity<ItemListDto> test1(
            @PathVariable("userId") String userId,
            @PathVariable("realtorId") String realtorId,
            @PathVariable("itemId") String itemId
    ) {
        return new ResponseEntity<>(
                contractService.ContractTest1(userId, realtorId, itemId),
                getJsonHeader(),
                HttpStatus.OK);
    }

    // 테스트용 API (Contract 테이블 쿼리 메소드 사용)
    @GetMapping("/test2/{userId}/{realtorId}/{itemId}")
    public ResponseEntity<ItemDto> test2(
            @PathVariable("userId") String userId,
            @PathVariable("realtorId") String realtorId,
            @PathVariable("itemId") String itemId
    ) {
        return new ResponseEntity<>(
                contractService.ContractTest2(userId, realtorId, itemId),
                getJsonHeader(),
                HttpStatus.OK);
    }
    @PostMapping("/find-info")
    public ResponseEntity<ContractInfoResponse> findItemForPDF(
            @RequestBody ContractInfoRequest contractInfoRequest
    ){
        return new ResponseEntity<>(
                contractService.findContractInfo(contractInfoRequest),
                getJsonHeader(),
                HttpStatus.OK);
    }

    private HttpHeaders getJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return headers;
    }
}
