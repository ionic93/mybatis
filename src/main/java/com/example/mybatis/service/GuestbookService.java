package com.example.mybatis.service;

import com.example.mybatis.dto.GuestbookDTO;

import java.util.List;

public interface GuestbookService {

  Long register(GuestbookDTO dto);
  List<GuestbookDTO> getList();
  GuestbookDTO read(Long gno);
  void remove(Long gno);
  void modify(GuestbookDTO dto);
}
