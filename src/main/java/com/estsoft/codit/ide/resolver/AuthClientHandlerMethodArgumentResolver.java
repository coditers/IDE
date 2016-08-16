package com.estsoft.codit.ide.resolver;

import com.estsoft.codit.db.vo.ClientVo;
import com.estsoft.codit.ide.annotation.AuthClient;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AuthClientHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    AuthClient authClient = methodParameter.getParameterAnnotation(AuthClient.class);
    if(authClient == null){
      return false;
    }
    if (methodParameter.getParameterType().equals(ClientVo.class) == false ){
      return false;
    }
    return true;
  }

  @Override
  public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
    if(supportsParameter(methodParameter)==false){
      return WebArgumentResolver.UNRESOLVED;
    }
    HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
    HttpSession session = request.getSession();
    if(session == null){
      return WebArgumentResolver.UNRESOLVED;
    }
    return session.getAttribute("authClient");
  }
}
