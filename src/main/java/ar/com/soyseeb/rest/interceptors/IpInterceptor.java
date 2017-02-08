package ar.com.soyseeb.rest.interceptors;

import ar.com.soyseeb.core.model.RegistroHistoricoVotacion;
import ar.com.soyseeb.core.services.RegistroHistoricoVotacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by sbogado on 17/12/2016.
 */
@Component
public class IpInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(IpInterceptor.class);

    private static final String URL_ENCUESTA = "/api/encuesta/respuesta";

    @Autowired
    private RegistroHistoricoVotacionService registroHistoricoVotacionService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String address = httpServletRequest.getRemoteAddr();
        Optional<RegistroHistoricoVotacion> registro=registroHistoricoVotacionService.findByIpToday(address);
        if(httpServletRequest.getRequestURI().contains(URL_ENCUESTA)){
            if(registro.isPresent()){
                LOG.warn("El voto ya se encuentra registrado: " + address);
                httpServletResponse.sendError(403, messageSource.getMessage("ar.com.tssa.climalaboral.votoregistrado",null, Locale.getDefault()));
                return false;
            }else{
                RegistroHistoricoVotacion registroHistoricoVotacion = new RegistroHistoricoVotacion();
                registroHistoricoVotacion.setIp(address);
                registroHistoricoVotacionService.save(registroHistoricoVotacion);
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
