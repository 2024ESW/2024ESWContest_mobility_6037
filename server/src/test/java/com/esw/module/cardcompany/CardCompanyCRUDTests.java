package com.esw.module.cardcompany;

import com.esw.module.cardcompany.entities.CardCompanyFindResponseDTO;
import com.esw.module.cardcompany.entities.CardCompanyRegisterRequestDTO;
import com.esw.module.cardcompany.service.CardCompanyFindService;
import com.esw.module.cardcompany.service.CardCompanyRegisterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class CardCompanyCRUDTests {

    @Autowired
    private CardCompanyFindService cardCompanyFindService;
    @Autowired
    private CardCompanyRegisterService cardCompanyRegisterService;


    @DisplayName("CardCompany 전체 조회 테스트")
    @Test
    void testFindAllCardCompanies(){

        Assertions.assertDoesNotThrow(
                () -> {
                    List<CardCompanyFindResponseDTO> cardCompanies = cardCompanyFindService.findAllCardCompanies();
                    cardCompanies.forEach(System.out::println);
                }
        );
    }

    private static Stream<Arguments> newCardCompany() {
        return Stream.of(
                Arguments.of(new CardCompanyRegisterRequestDTO("한신카드")),
                Arguments.of(new CardCompanyRegisterRequestDTO("민국카드"))
        );
    }

    @DisplayName("CardCompany 등록 테스트")
    @ParameterizedTest
    @MethodSource("newCardCompany")
    @Transactional
    void testRegisterCardCompany(CardCompanyRegisterRequestDTO newCardCompany){

        Assertions.assertDoesNotThrow(
                () -> cardCompanyRegisterService.registerCardCompany(newCardCompany)
        );

        cardCompanyFindService.findAllCardCompanies().forEach(System.out::println);

    }
}
