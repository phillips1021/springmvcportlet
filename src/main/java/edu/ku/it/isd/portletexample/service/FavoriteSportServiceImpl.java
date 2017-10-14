package edu.ku.it.isd.portletexample.service;

import edu.ku.it.isd.portletexample.dao.FavoriteSportDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements favorite sport services.
 * @author bphillips
 */
@Service
public class FavoriteSportServiceImpl implements FavoriteSportService {
    
    public static final Logger LOG = Logger.getLogger(FavoriteSportServiceImpl.class.getName());

    @Autowired
    private FavoriteSportDao favoriteSportDao ;

    @Override
    public String getFavoriteSport(String kuOnlineId) {
        
        return favoriteSportDao.getFavoriteSport(kuOnlineId) ;

    }
    
        @Override
    public void insertFavoriteSport(String kuOnlineId, String favoriteSport) {
        
        favoriteSportDao.insertFavoriteSport(kuOnlineId, favoriteSport);
        
    }

    @Override
    public void deleteFavoriteSport(String kuOnlineId) {
        
        favoriteSportDao.deleteFavoriteSport(kuOnlineId);
        
    }
    
    

    public FavoriteSportDao getImageManagementDao() {
        return favoriteSportDao;
    }

    public void setImageManagementDao(FavoriteSportDao imageManagementDao) {
        this.favoriteSportDao = imageManagementDao;
    }

}
