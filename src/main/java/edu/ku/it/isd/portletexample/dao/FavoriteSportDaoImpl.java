package edu.ku.it.isd.portletexample.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Implements behaviors to interact with image management data repository.
 *
 * @author bphillips
 */
@Repository
public class FavoriteSportDaoImpl extends NamedParameterJdbcDaoSupport implements FavoriteSportDao {

    public static final Logger LOG = Logger.getLogger(FavoriteSportDaoImpl.class.getName());

    @Override
    public String getFavoriteSport(String kuOnlineId) {

        //Default favorite sport is football per business rule
        String favoriteSport = "football";
        
        String query = "select favoriteSport from favoriteSportTbl "
                + " where kuOnlineId = ? ";
        
        try {
            
        favoriteSport = (String) getJdbcTemplate().queryForObject(query, String.class, kuOnlineId);

        LOG.debug("Favorite Sport Found for " + kuOnlineId + " is " + favoriteSport);
        
        } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
            
            LOG.debug("No record found searching on " + kuOnlineId);
            
            favoriteSport = "football" ;
            
        }

        return favoriteSport;

    }

    @Override
    public void insertFavoriteSport(String kuOnlineId, String favoriteSport) {
        
        String query = "insert into favoriteSportTbl(kuOnlineId, favoriteSport) values(?,?)" ;
        
        getJdbcTemplate().update(query, kuOnlineId, favoriteSport);
        
    }

    @Override
    public void deleteFavoriteSport(String kuOnlineId) {
       
        String query = "delete from favoriteSportTbl where kuOnlineId = ?";
        
        getJdbcTemplate().update(query, kuOnlineId);
        
        
    }

}
