package com.steveh1uk.kalah.web;

import com.steveh1uk.kalah.application.Game;
import com.steveh1uk.kalah.application.GameDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 *  Controller for server side templating (Thymeleaf). The Game's state is kept in the user's Http Session
 */
@Controller
public class GameWebController {

    static final String GAME_SESSION = "GAME";
    private static final String GAME_DTO_MODEL = "gameDisplay";


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/newgame")
    public String newGame(HttpSession httpSession, Model model) {
        Game game = new Game();
        httpSession.setAttribute(GAME_SESSION, game);
        model.addAttribute(GAME_DTO_MODEL, game.newGameState());

        return "game";
    }

    @PostMapping(value ="/game", params = "restart")
    public String restartGame() {
        return "redirect:/newgame";
    }

    @PostMapping("/game")
    public String playGame(HttpSession httpSession, HttpServletRequest httpServletRequest, Model model) {
        Game game = (Game)httpSession.getAttribute(GAME_SESSION);
        if (game == null) {  // Timed out!
            return "redirect:/";
        }

        int houseNumber = parseHouseNumber(httpServletRequest);

        GameDto gameDto = game.play(houseNumber);

        model.addAttribute(GAME_DTO_MODEL, gameDto);

        return "game";
    }

    private int parseHouseNumber(HttpServletRequest httpServletRequest) {
        int houseNumber = -1;
        List<String> parameterNamesList =   Collections.list(httpServletRequest.getParameterNames());
        for (String name : parameterNamesList
             ) {
            if (name.startsWith("house-")) {
                int indexHyphen = name.indexOf("-");
                String house = name.substring(indexHyphen + 1);
                return Integer.parseInt(house);
            }
        }
        return houseNumber;
    }
}
