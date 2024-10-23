package com.esw.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class CollectionDTO {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BasicResponse {

        private int count;
        private List<?> contents;

        public static BasicResponse map(List<?> collection) {
            return BasicResponse.builder()
                    .count(collection.size())
                    .contents(collection)
                    .build();
        }

        public static BasicResponse map(int count, List<?> collection) {
            return BasicResponse.builder()
                    .count(count)
                    .contents(collection)
                    .build();
        }
    }
}
