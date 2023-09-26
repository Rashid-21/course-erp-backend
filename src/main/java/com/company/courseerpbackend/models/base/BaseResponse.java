package com.company.courseerpbackend.models.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    HttpStatus status;
    Meta meta;
    T data;

    @Data
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static final class Meta {
        String key;
        String message;

        public static Meta of(String key, String message) {
            return Meta.builder()
                    .key(key)
                    .message(message)
                    .build();
        }
    }


    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.OK)
                .data(data)
                .meta(Meta.of("success","Successfully"))
                .build();
    }

    public static <T> BaseResponse<T> success() {

        return success(null);
    }
}
