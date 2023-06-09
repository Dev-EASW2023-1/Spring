package com.example.demo.app.domain.model.dto.item;

import com.example.demo.app.domain.model.entity.ItemEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class ItemDto {

    @NotBlank
    private String caseNumber;

    @NotBlank
    private String court;

    @NotBlank
    private String location;

    @NotBlank
    private String minimumBidPrice;

    @NotBlank
    private String photo;

    @NotBlank
    private String biddingPeriod;

    @NotBlank
    private String itemType;

    @NotBlank
    private String note;

    @NotBlank
    private String managementNumber;


    @Builder
    public ItemDto(String caseNumber, String court, String location, String minimumBidPrice, String photo, String biddingPeriod, String itemType, String note, String managementNumber) {
        this.caseNumber = caseNumber;
        this.court = court;
        this.location = location;
        this.minimumBidPrice = minimumBidPrice;
        this.photo = photo;
        this.biddingPeriod = biddingPeriod;
        this.itemType = itemType;
        this.note = note;
        this.managementNumber = managementNumber;
    }

    public ItemEntity toEntity() {
        return ItemEntity.builder()
                .caseNumber(caseNumber)
                .court(court)
                .location(location)
                .minimumBidPrice(minimumBidPrice)
                .photo(photo)
                .biddingPeriod(biddingPeriod)
                .itemType(itemType)
                .note(note)
                .managementNumber(managementNumber)
                .build();
    }
}


