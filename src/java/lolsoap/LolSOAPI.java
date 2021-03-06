/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolsoap;

/**
 *
 * @author Tobias and Mads Hornbeck
 */

import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface LolSOAPI {
    
		@WebMethod UUID createNewGame(String username);
		@WebMethod UUID[] findGames();
                
		@WebMethod UUID[] findAllGames();
                
		@WebMethod String[] getUsernames(UUID gameId);
		@WebMethod UUID[] getPlayersGames(String username);
                
		@WebMethod int getScore(UUID gameId, String username);
		@WebMethod long getTimeTaken(UUID gameId, String username);
                
		@WebMethod void joinGame(UUID gameId, String username);
		@WebMethod void startGame(String username);
                
            	@WebMethod void setNumberOfChamps(UUID gameId, int number);
                
                @WebMethod boolean isGameStarted(String username);
                @WebMethod boolean playerDoneGuessing(UUID gameId, String username);
		@WebMethod boolean isGameDone(UUID gameId);
		@WebMethod boolean didIWin(UUID gameId, String username);
                @WebMethod String getWinner(UUID gameId);
		@WebMethod String getChampionImgUrl(String username);
		@WebMethod String getChampionTitle(String username);    
		@WebMethod boolean guessChampion(String username, String guess);
		@WebMethod void skipChampion(String username);
                @WebMethod String hentBruger(String user, String pass);
}