/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Category;
import model.Game;
import model.GameCategory;
import model.Media;
import model.User;
import model.UserGameBuy;
import model.UserGameComment;

/**
 *
 * @author ACER
 */
public interface IGameDAO extends IDAO<Game> {

    Game get(int GameID);

    List<Game> getGame();

    List<Game> getGameByPage(List<Game> list, int start, int end);

    List<GameCategory> getGameByCategoryByPage(List<GameCategory> list, int start, int end);

    List<Game> sortGameList(List<Game> gameList, int sortType);

    List<Game> getFreeGames();

    List<Game> get10FreeGames();

    List<Game> getBestSeller();

    List<Game> get10BestSeller();

    List<Game> getNewRelease();

    List<Game> get10NewRelease();

    Game getGameById(int id);

    List<Media> getGameMediaByGameID(int id);

    List<UserGameComment> getGameCommentByGameID(int id);

    float getGameRateByID(int id);

    List<Game> getRecomendByCategory(Category category);

    List<GameCategory> getGameByCategory(int cate);

    List<Game> searchGamesByName(String name);

    List<Game> sortGameByName();

    List<Game> sortGameByPrice();

    List<UserGameBuy> getUserGameBuybyId(int userid);

    List<UserGameBuy> getUserGameBuy();

    List<Game> getDeals();

    List<Game> get10Deals();

    void insertDownloadToGame(Game game);

    int getLikesOrDislikes(Game game, int voteType);

    int getUserVoteOfAGame(User user, Game game);
    
    void deleteGameByID(int id);
}
