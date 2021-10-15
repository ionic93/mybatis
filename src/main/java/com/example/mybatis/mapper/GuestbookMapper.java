package com.example.mybatis.mapper;

import com.example.mybatis.dto.GuestbookDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuestbookMapper {

  public Long write(GuestbookDTO dto);

  //@Select("select * from guestbook where gno > 0 ")
  public List<GuestbookDTO> getList();

  public Long update(GuestbookDTO dto);

  public Long delete(Long gno);
}
