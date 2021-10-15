package com.example.mybatis.service;

import com.example.mybatis.dto.GuestbookDTO;
import com.example.mybatis.mapper.GuestbookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{

  private final GuestbookMapper guestbookMapper;

  @Override
  public Long register(GuestbookDTO dto) {
    log.info(dto);
    guestbookMapper.write(dto);
    return dto.getGno();
  }

  @Override
  public List<GuestbookDTO> getList() {
    List<GuestbookDTO> result = guestbookMapper.getList();
    return result;
  }

  @Override
  public GuestbookDTO read(Long gno) {
    return null;
  }

  @Override
  public void remove(Long gno) {
    guestbookMapper.delete(gno);
  }

  @Override
  public void modify(GuestbookDTO dto) {
    guestbookMapper.update(dto);
  }


}
