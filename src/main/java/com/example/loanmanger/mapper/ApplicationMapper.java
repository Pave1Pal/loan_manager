package com.example.loanmanger.mapper;

import com.example.loanmanger.domain.dto.CreateApplicationDto;
import com.example.loanmanger.domain.entity.CreditApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accepted", ignore = true)
    @Mapping(target = "acceptedSum", ignore = true)
    @Mapping(target = "expirationDate", ignore = true)
    @Mapping(target = "days", ignore = true)
    @Mapping(target = "creditContract", ignore = true)
    CreditApplication fromCreateDto(CreateApplicationDto createDto);

    CreditApplication fromDto(CreditApplication applicationDto);

    CreditApplication toDto(CreditApplication application);
}
