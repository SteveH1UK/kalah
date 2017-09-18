package com.steveh1uk.kalah.web;

import com.steveh1uk.kalah.application.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *  Use basic Spring MockMvc to test the Web Controller.
 *
 *  More detailed tests would require MockMvc and HtmlUnit Setup
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class GameWebControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void home() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("HOME_HTML_FORM_ID")));
    }

    @Test
    public void newGame() throws Exception {
        this.mockMvc.perform(get("/newgame")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("GAME_HTML_FORM_ID")));
    }

    @Test
    public void restartGame() throws Exception {
        // No session so will restart game
        this.mockMvc.perform(post("/game").param("restart", "dummy")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/newgame"));
    }
    @Test
    public void restartGameAfterTimeout() throws Exception {
        // No session so will restart game
        this.mockMvc.perform(post("/game").param("house-2", "dummy")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void playGame() throws Exception {
        MockHttpSession mockSession = new MockHttpSession();
        Game game = new Game();
        mockSession.setAttribute(GameWebController.GAME_SESSION, game);

        this.mockMvc.perform(post("/game").param("house-2", "dummy").session(mockSession)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("GAME_HTML_FORM_ID"))).andExpect(content().string(containsString("\"house-2\" value=\"0\"")));
    }


}