package edu.ku.it.isd.portletexample.controller;

import edu.ku.it.isd.portletexample.service.FavoriteSportService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.xml.ws.WebServiceException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.ui.Model;

/**
 *
 * @author bphillips
 */
public class HomeControllerTest {
    
  @Test
  public void testGetStartView() throws WebServiceException, IOException {
      
      /*
        Need to create the userInfo object that will
        store the uid value.
        */
         Map<String, Object> userInfo = new HashMap<>();
         
         /*
          *Set a value for uid (used by KUL portal)
          *Set a value for cn (used by KUMC portal)
          */
         userInfo.put("uid", "brucephillips");
         userInfo.put("cn", "brucephillips");
         userInfo.put("kuPersonLHrId", "1343700");
         userInfo.put("EmplID", "2223434");
         userInfo.put("kuPersonPrimaryDepartment", "KU IT");
         userInfo.put("mail", "bphillips@ku.edu");
         userInfo.put("displayName", "Bruce Phillips");
         userInfo.put("departmentNumber", "1543000");
         
        
         final HomeController controller = new HomeController();

         final RenderRequest request = mock(RenderRequest.class);
        
         when(request.getAttribute(PortletRequest.USER_INFO)).thenReturn(userInfo);
         
         final FavoriteSportService favoriteSportService = mock(FavoriteSportService.class) ;
         
         when(favoriteSportService.getFavoriteSport("brucephillips")).thenReturn("football");
         
         controller.setFavoriteSportService(favoriteSportService);
         
         final Model model = mock(Model.class);
         
         final PortletSession session = mock(PortletSession.class);
         
         String controllerResult = controller.getStartView(model, session, request);
         
         assertEquals("Controller result does not equal home but should", "home", controllerResult) ;
         
  }
  
  
    
}
