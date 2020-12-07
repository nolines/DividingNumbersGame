package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.Game.GameExecutor;
import com.dividingnumbersgame.game.Player.Computer;
import com.dividingnumbersgame.game.Player.Human;
import com.dividingnumbersgame.game.Player.PlayerType;
import com.dividingnumbersgame.game.configuration.WebSocketClient;
import com.dividingnumbersgame.game.utils.UserCommands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

    private static GameExecutor gameExecutor;
    private static WebSocketClient webSocketClient;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameApplication.class, args);

        setupWebsocket();
        Scanner scanner = new Scanner(System.in);
        preSetupGame(scanner);
    }

    private static void preSetupGame(Scanner scanner) throws Exception {
        UserCommands cmd = userInput();
            switch (cmd){
                case PLAY_AGAINST_COMPUTER:
                    System.out.println("Enter player name");
                    String playerName = scanner.next();
                    Human human = new Human(playerName, PlayerType.HUMAN);
                    webSocketClient.SendMessage("User create message:" + human);
                    new GameExecutor().playAgainstComputer(human);
                    break;
                case PLAY_COMPUTERS:
                    Computer computer1 = new Computer("computer1", PlayerType.COMPUTER);
                    Computer computer2 = new Computer("computer2", PlayerType.COMPUTER);
                    webSocketClient.SendMessage("User create message:" + computer1);
                    webSocketClient.SendMessage("User create message:" + computer2);
                    new GameExecutor().playComputers(computer1, computer2);
                    break;
                default:
                    System.out.println("Waiting a valid input!");
            }
    }

    private static UserCommands userInput() {
        Scanner scanner = new Scanner(System.in);
        UserCommands cmd = null;

        while(cmd==null) {
            System.out.println("Enter your command: ");
            try {
                cmd = UserCommands.valueOf(scanner.next());
            } catch (Exception e) {
                System.out.println("Wrong input param");
            }
        }
        return cmd;
    }

    private static void setupWebsocket() {
        try {
            webSocketClient = new WebSocketClient();
            webSocketClient.Connect("ws://localhost:8080/operation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
