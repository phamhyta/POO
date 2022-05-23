package game.states;

import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.Graphics2D;

public class PauseState extends GameState {
    public PauseState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void update(double time) {
        System.out.println("PAUSED");
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {

    }
}
