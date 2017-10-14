package edu.ku.it.isd.portletexample.controller;


import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


/**
 * Home controller class to get the initial portlet view.
 *
 *
 * @author bruce phillips
 */
@Controller
@RequestMapping("HELP")
public class HelpController {

    public static final Logger LOG = Logger.getLogger(HelpController.class);


    
    /**
     * Gets the starting portlet help page.
     *
     * @param request
     * @param model
     * @return
     */
    @RenderMapping
    public String getHelpView(PortletRequest request, Model model)  {

        LOG.info("In getHelpView");

        return "help";
        

    }

}
