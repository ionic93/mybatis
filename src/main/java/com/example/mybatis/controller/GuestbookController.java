package com.example.mybatis.controller;

import com.example.mybatis.dto.GuestbookDTO;
import com.example.mybatis.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

  private final GuestbookService service;

  @GetMapping({"/",""})
  public String index() {
    return "redirect:/guestbook/list";
  }

  @GetMapping({"/list"})
  public void list(Model model) {
    log.info("list.......");
    model.addAttribute("result", service.getList());
  }

  @GetMapping("/register")
  public void register() { }

  @PostMapping("/register")
  public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes) {
    log.info("registerPost...");
    Long gno = service.register(dto);
    redirectAttributes.addFlashAttribute("msg", gno);
    redirectAttributes.addFlashAttribute("noti", "등록");
    return "redirect:/guestbook/list";
  }

  @GetMapping({"/read", "/modify"})
  public void read(Long gno, Model model) {
    GuestbookDTO dto = service.read(gno);
    model.addAttribute("dto", dto);
  }
  @PostMapping("/modify")
  public String modify(GuestbookDTO dto,
                       RedirectAttributes redirectAttributes) {
    service.modify(dto);
    return "redirect:/guestbook/read";
  }

  @PostMapping("/remove")
  public String remove(Long gno, RedirectAttributes redirectAttributes) {
    service.remove(gno);
    redirectAttributes.addFlashAttribute("msg", gno);
    redirectAttributes.addFlashAttribute("noti", "삭제");
    return "redirect:/guestbook/list";
  }

}
