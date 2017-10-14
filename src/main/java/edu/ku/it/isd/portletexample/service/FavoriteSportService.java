package edu.ku.it.isd.portletexample.service;

/**
 * Specifies behaviors an favorite sport service class must implement.
 *
 * @author bphillips
 */
public interface FavoriteSportService {

    /**
     * Get the favorite sport for the
     * provided KU Online ID.
     * @param kuOnlineId
     * @return 
     */
    String getFavoriteSport(String kuOnlineId);
    
    
    /**
     * Insert the favorite Sport
     * for the provided KU Online ID.
     * 
     * @param kuOnlineId 
     * @param favoriteSport 
     */
    void insertFavoriteSport(String kuOnlineId, String favoriteSport);
    
    /**
     * Remove record from data repository
     * user's favorite sport
     * @param kuOnlineId
     */
    void deleteFavoriteSport(String kuOnlineId);
}
