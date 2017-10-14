package edu.ku.it.isd.portletexample.controller;


import java.util.Map;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.beans.factory.annotation.Autowired;
import edu.ku.it.isd.portletexample.service.FavoriteSportService ;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;


/**
 * Home controller class to get the initial portlet view.
 *
 *
 * @author bruce phillips
 */
@Controller
@RequestMapping("VIEW")
public class HomeController {

    public static final Logger LOG = Logger.getLogger(HomeController.class);
    
    private static final String COMMON_NAME = "commonName";
    
    private static final String SPORT_SELECTED = "selectedFavoriteSport" ;

    
    @Autowired
    private FavoriteSportService favoriteSportService ;

    
    /**
     * Gets the starting portlet view page.
     *
     * @param model
     * @param session
     * @param request
     * @return
     */
    @RenderMapping
    public String getStartView(Model model, PortletSession session, RenderRequest request)  {
        
        Map<String, Object> userInfo = (Map<String, Object>) request.getAttribute("uid");

        if (userInfo == null) {
            userInfo = (Map<String, Object>) request.getAttribute(PortletRequest.USER_INFO);
        }
        
        String commonName = (String) userInfo.get("uid") ;
        
        LOG.info("Common name found is " + commonName);
        
        session.setAttribute(COMMON_NAME, commonName);
        
        String selectedFavoriteSport = favoriteSportService.getFavoriteSport(commonName) ;
        
        model.addAttribute(SPORT_SELECTED, selectedFavoriteSport) ;
     
        LOG.info(commonName + " favorite sport is " + selectedFavoriteSport) ;

        return "home";

    }
    

    /**
     * Process user's form submission for favorite sport.
     * @param favoriteSport
     * @param request
     * @param response
     * @param session 
     */
    @ActionMapping(params = "action=processFavoriteSport")
    public void processFavoriteSport(@RequestParam("favoriteSport") String favoriteSport,
     ActionRequest request, ActionResponse response, PortletSession session) {
        
        String commonName = (String) session.getAttribute(COMMON_NAME);
        
        LOG.info("User with common name of " + commonName + " selected favorite sport of " + favoriteSport);
        
        session.setAttribute(SPORT_SELECTED, favoriteSport);
        
        favoriteSportService.deleteFavoriteSport(commonName);
        
        favoriteSportService.insertFavoriteSport(commonName, favoriteSport);
        
        response.setRenderParameter("action", "returnSuccess");
  
    }
    

    
    @RenderMapping(params = "action=returnSuccess")
    public String returnSuccess(Model model, PortletSession session ) {
        
        String sportSelected = (String) session.getAttribute(SPORT_SELECTED);
        
        model.addAttribute(SPORT_SELECTED, sportSelected);

        return "success" ;
        
    }

    public FavoriteSportService getFavoriteSportService() {
        return favoriteSportService;
    }

    public void setFavoriteSportService(FavoriteSportService favoriteSportService) {
        this.favoriteSportService = favoriteSportService;
    }


    
    
  
}
