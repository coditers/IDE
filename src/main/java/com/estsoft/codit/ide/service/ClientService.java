package com.estsoft.codit.ide.service;

import com.estsoft.codit.db.repository.ClientRepository;
import com.estsoft.codit.db.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public boolean checkTicket(int clientId, Model model) {
    ClientVo vo = clientRepository.get(clientId);
    if(vo==null){
      return false;
    }
    model.addAttribute("ticket", clientId);
    model.addAttribute("client", vo);
    return true;
  }
}
