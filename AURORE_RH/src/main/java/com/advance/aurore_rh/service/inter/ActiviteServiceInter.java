package com.advance.aurore_rh.service.inter;

import javax.servlet.http.HttpServletRequest;

public interface ActiviteServiceInter {


     void sauvegarde(HttpServletRequest request, String details, String parametres, String source);
}
