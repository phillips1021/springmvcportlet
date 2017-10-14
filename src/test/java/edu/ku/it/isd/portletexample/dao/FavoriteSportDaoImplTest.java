package edu.ku.it.isd.portletexample.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author bphillips
 */
@ContextConfiguration(locations={"/applicationContext_test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FavoriteSportDaoImplTest {
    
    @Autowired
    private FavoriteSportDao favoriteSportDao ;

    @Test
    public void getFavoriteSport() {
        
        String kuOnlineId = "brucephillips" ;
        
        String favoriteSport = favoriteSportDao.getFavoriteSport(kuOnlineId) ;
        
        assertEquals("Selected favorite sport is not football but should be.", "football", favoriteSport);
        
    }
    
    @Test
    public void testInsertFavoriteSport() {
        
        String kuOnlineId = "cbays" ;
        
        String favoriteSport = "baseball";
        
        favoriteSportDao.insertFavoriteSport(kuOnlineId, favoriteSport);
        
        String favoriteSportFromDao = favoriteSportDao.getFavoriteSport(kuOnlineId) ;
        
        assertEquals("Selected favorite sport is not baseball but should be.", favoriteSport, favoriteSportFromDao);
        
    }
    

    
}
