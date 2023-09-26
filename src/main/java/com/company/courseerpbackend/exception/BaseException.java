//package com.company.courseerpbackend.exception;
//
//
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Builder(access = AccessLevel.PROTECTED)
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class BaseException extends RuntimeException {
//
//    ResponseMessages responseMessage;
//    NotFoundExceptionType notFoundData;
//
//    // todo: fix. it doesn't return dynamic error message
//    @Override
//    public String getMessage() {
//        return responseMessage.message();
//    }
//
//    public static BaseException of(ResponseMessages responseMessage) {
//        return BaseException.builder().responseMessage(responseMessage).build();
//    }
//
//    public static BaseException unexpected() {
//        return of(UNEXPECTED);
//    }
//
//    public static BaseException notFound(String target, String field, String value) {
//        return BaseException.builder()
//                .responseMessage(NOT_FOUND)
//                .notFoundData(
//                        NotFoundExceptionType.of(target, Mgit config --global user.emailap.of(field, value))
//                )
//                .build();
//    }
//
//}
