    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolsoap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.*;
import static lolsoap.LolSOAPImplTest.soapHandlerService;
/**
 *
 * @author Magnus
 */

@Path("lolsoapaccess")
public class LolSOAPImplTest {
    
    
     static LolSoapImplementation soapHandlerService;
     private Gson gsonConverter;
     
      @Context
    private UriInfo context;
      
         public LolSOAPImplTest() {
  
                soapHandlerService = new LolSoapImplementation();
                gsonConverter = new Gson();
                
               
    }
    
   @GET
   @Path("/creategame/{username}")
   @Produces(MediaType.TEXT_PLAIN)
    public String createNewGame(@PathParam("username") String username) {
        return soapHandlerService.soapHandler.createNewGame(username).toString();
    }

    @GET
    @Path("/findgames")
    @Produces(MediaType.APPLICATION_JSON)
    public String findGames() {
        UUID[] uuids = soapHandlerService.soapHandler.findGames(); 
        
       
        String jsonArray = gsonConverter.toJson(uuids);
   
        System.out.println("Array er : " + uuids.length + " langt");
         return jsonArray;
    }

   @GET
   @Path("/getplayers/{gameID}")
   @Produces(MediaType.APPLICATION_JSON)
    public String getUsernames(@PathParam("gameID") UUID gameId) {
        String[] names = soapHandlerService.soapHandler.getUsernames(gameId);
        
        String result = gsonConverter.toJson(names);
        return result;
    }

    @GET
    @Path("/joingame/{gameID}/{username}")
    public void joinGame(@PathParam("gameID") UUID gameId, @PathParam("username")  String username) {
         soapHandlerService.soapHandler.joinGame(gameId, username);
    }

    @GET
   @Path("/startgame/{username}")
    public void startGame(@PathParam("username") String username) {
        soapHandlerService.soapHandler.startGame(username);
    }

   @GET
   @Path("/isgamedone/{gameID}")
    public boolean isGameDone(@PathParam("gameID") UUID game) {
       
         return soapHandlerService.soapHandler.isGameDone(game);
    }

    @GET
    @Path("didiwin/{gameID}/{username}")
    public boolean didIWin(@PathParam("gameID") UUID gameId, @PathParam("username")  String username) {
         return soapHandlerService.soapHandler.didIWin(gameId, username);
    }

   @GET
   @Path("/getchamppic/{username}")
    public String getChampionImgUrl(@PathParam("username") String username) {
         return soapHandlerService.soapHandler.getChampionImgUrl(username);
    }

    
   @GET
   @Path("/getchamp/{username}")
    public String getChampionTitle(@PathParam("username") String username) {
         return soapHandlerService.soapHandler.getChampionTitle(username);
    }

   @GET
   @Path("/guesschamp/{guess}/{username}")
    public boolean guessChampion(@PathParam("username") String user,@PathParam("guess") String passedGuess) {
         return soapHandlerService.soapHandler.guessChampion(user, passedGuess);
    }

   @GET
   @Path("/skip/{username}")
    public void skipChampion(@PathParam("username") String username) {
          soapHandlerService.soapHandler.skipChampion(username);
    }
    
    @GET
    @Path("/hentbruger/{password}/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean hentBruger(@PathParam("username") String username, @PathParam("password") String pass) {
    String requestedUser = soapHandlerService.soapHandler.hentBruger(username, pass);
       if (requestedUser != null){
           
             return true;
        }
        else{
            
            return false;        }
        
    }

   @GET
   @Path("(/getplayersgames/{username}")
   @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public String getPlayersGames(@PathParam("username") String username) {
         UUID[] uuids = soapHandlerService.soapHandler.getPlayersGames(username); 
        
       
        String jsonArray = gsonConverter.toJson(uuids);
   
        System.out.println("Array er : " + uuids.length + " langt");
         return jsonArray;
    }
    

   @GET
   @Path("(/isgamestarted/{username}")
   @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public boolean isGameStarted(@PathParam("username") String username) {
        boolean bool = soapHandlerService.soapHandler.isGameStarted(username);
    return bool;
    }

   @GET
   @Path("(/getwinner/{gameid}")
   @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public String getWinner(@PathParam("gameid") UUID gameId) {
        
        String winner =  soapHandlerService.soapHandler.getWinner(gameId);
        return winner;
    }

    
    @GET
    @Path("/findallgames")
    @Produces(MediaType.APPLICATION_JSON)
    public String findAllGames() {
        UUID[] uuids = soapHandlerService.soapHandler.findAllGames(); 
        
       
        String jsonArray = gsonConverter.toJson(uuids);
   
        System.out.println("Array er : " + uuids.length + " langt");
         return jsonArray;
    }
    
    
    @GET
    @Path("/getScore/{gameID}/{username}")
    public int getScore(@PathParam("gameID")UUID gameId,@PathParam("username") String username) {
       return soapHandlerService.soapHandler.getScore(gameId, username); 
    }

    @GET
    @Path("/getScore/{gameID}/{username}")
    public long getTimeTaken(@PathParam("gameID")UUID gameId,@PathParam("username") String username) {
        return soapHandlerService.soapHandler.getTimeTaken(gameId, username); 
    }

    @GET
    @Path("/getScore/{gameID}/{number}")
    public void setNumberOfChamps(@PathParam("gameID")UUID gameId,@PathParam("number") int number) {
    soapHandlerService.soapHandler.setNumberOfChamps(gameId, number); 
    }

    @GET
    @Path("/getScore/{gameID}/{username}")
    public boolean playerDoneGuessing(@PathParam("gameID")UUID gameId,@PathParam("usrename") String username) {
      return soapHandlerService.soapHandler.playerDoneGuessing(gameId, username); 
    }

    
}

