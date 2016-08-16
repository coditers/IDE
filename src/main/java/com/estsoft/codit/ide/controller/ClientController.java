package com.estsoft.codit.ide.controller;

import com.estsoft.codit.db.vo.ClientVo;
import com.estsoft.codit.ide.annotation.Auth;
import com.estsoft.codit.ide.annotation.AuthClient;
import com.estsoft.codit.ide.service.ClientService;
import com.estsoft.codit.ide.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private MainService mainService;

  //TODO: client ticket 64bit
  @RequestMapping("/{clientId}")
  public String index(@PathVariable("clientId") int clientId, Model model) {
    boolean existsTicket = clientService.checkTicket(clientId, model);
    if(existsTicket){
      return "index-client";
    }
    return "index-error";
  }


  @RequestMapping("/instruction")
  public String instruction(@AuthClient ClientVo clientVo) {
    //ClientInterceptor에서 ticket과 email이 맞는지 체크해서 맞으면 세션을 부여하고 @AuthClient에 값을 넣어준다
    if(clientVo==null){
      return "instruction-error";
    }
    return "instruction";
  }

  @Auth
  @RequestMapping("/practice")
  public String practice(Model model) {
    mainService.setPracticeProblem(model);
    return "practice";
  }
}
