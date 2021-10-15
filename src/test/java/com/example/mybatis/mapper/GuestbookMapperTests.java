package com.example.mybatis.mapper;

import jdk.nashorn.internal.objects.annotations.Setter;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookMapperTests {

  @Autowired
  private GuestbookMapper guestbookMapper;

  @Test
  void write() {
  }

  @Test
  void getList() {
    guestbookMapper.getList().forEach(guestbook ->{
      System.out.println(guestbook);
    });
  }

  @Test
  void update() {
  }

  @Test
  void delete() {
  }
}