package com.estsoft.codit.ide.interceptor;


import com.estsoft.codit.db.repository.ClientRepository;
import com.estsoft.codit.db.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClientInterceptor  extends HandlerInterceptorAdapter {

  @Autowired
  private ClientRepository clientRepository;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    int ticket = Integer.parseInt(request.getParameter("ticket"));
    String email = request.getParameter("email");
    int clientIdByRecruitId = clientRepository.getByRecruitId(ticket);
    ClientVo clientVoByEmail = clientRepository.getByEmail(email);
    if(clientIdByRecruitId==0 || clientVoByEmail==null){
      return true;
    }
    if(clientIdByRecruitId==clientVoByEmail.getId()){
      HttpSession session = request.getSession(true);
      session.setAttribute("authClient", clientVoByEmail );
    }
    return true;
  }
}
