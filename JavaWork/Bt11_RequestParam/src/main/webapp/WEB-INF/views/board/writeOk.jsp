<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
작성자: ${dto.name}<br>
글제목: ${dto.subject}<br>
내용: ${dto.content}<br>
-->

작성자: ${DTO.name}<br>
글제목: ${DTO.subject}<br>
내용: ${DTO.content}<br>
uid: ${DTO.uid }<br>
조회수: ${DTO.viewCnt }<br>
등록일: ${DTO.regDate }<br>

<button onclick="history.back()">이전으로</button>