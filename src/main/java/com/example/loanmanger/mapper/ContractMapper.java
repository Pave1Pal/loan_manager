package com.example.loanmanger.mapper;

import com.example.loanmanger.domain.dto.CreditContractDto;
import com.example.loanmanger.domain.entity.CreditContract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    CreditContract formDto(CreditContractDto contractDto);

    CreditContractDto toDto(CreditContract creditContract);
}
