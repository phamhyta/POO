package game.states;

import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;

public class MenuState extends GameState {
    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    private int tileX = 48;
    private int tileY = 48;
    private int numberLine = 0;
    private int numberDif = 1;
    private boolean checkdificulty = false;

    public void Menu(Graphics2D g) {
        if (this.checkdificulty == false) {
            int width = 1280 - 10 * tileX;
            int height = tileX * 12;
            int x = 1280 / 2 - width / 2;
            int y = tileY * 2;
            Color c = new Color(0, 0, 0, 210);
            g.setColor(c);
            g.fillRoundRect(x, y, width + 5, height + 5, 35, 35);
            c = new Color(255, 255, 255);
            g.setColor(c);
            g.setStroke(new BasicStroke(5));
            g.drawRoundRect(x + 7, y + 8, width - 10, height - 10, 25, 25);
            g.setColor(Color.white);
            g.setFont(g.getFont().deriveFont(80F));
            String txt = "Menu";
            int txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
            g.drawString(txt, 1280 / 2 - txtLength / 2, tileY * 4);
            g.drawLine(1280 / 2 - tileX * 3, tileY * 5, 1280 / 2 + tileX * 3, tileY * 5);
            txt = "New Game";
            g.setFont(g.getFont().deriveFont(50F));
            txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
            g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 7));
            if (this.numberLine == 0) {
                g.drawString("->", 1280 / 2 - txtLength / 2 - tileX, (int) (tileY * 7));
            }
            txt = "Restart Level";
            g.setFont(g.getFont().deriveFont(50F));
            txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
            g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 8.5));
            if (this.numberLine == 1) {
                g.drawString("->", 1280 / 2 - txtLength / 2 - tileX, (int) (tileY * 8.5));
            }
            txt = "Difficulty";
            g.setFont(g.getFont().deriveFont(50F));
            txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
            g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 10));
            if (this.numberLine == 2) {
                g.drawString("->", 1280 / 2 - txtLength / 2 - tileX, (int) (tileY * 10));
            }
            txt = "Sound";
            g.setFont(g.getFont().deriveFont(50F));
            txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
            g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 11.5));
            if (this.numberLine == 3) {
                g.drawString("->", 1280 / 2 - txtLength / 2 - tileX, (int) (tileY * 11.5));
            }
            txt = "Exit to main menu";
            g.setFont(g.getFont().deriveFont(50F));
            txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
            g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 13));
            if (this.numberLine == 4) {
                g.drawString("->", 1280 / 2 - txtLength / 2 - tileX, (int) (tileY * 13));
            }
        } else {
            Difficulty(g);
        }

    }

    @Override
    public void update(double time) {

    }

    void Difficulty(Graphics2D g) {
        int width = this.tileX * 12;
        int height = this.tileY * 6;
        int x = 1280 / 2 - this.tileX * 6;
        int y = (int) (tileY * 2);
        Color c = new Color(0, 0, 0, 210);
        g.setColor(c);
        g.fillRoundRect(x, y, width, height, 35, 35);
        g.setColor(Color.white);
        String txt = "Difficulty";
        g.setFont(g.getFont().deriveFont(50F));
        int txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 3));
        txt = "Easy -- More heath and more damage";
        g.setFont(g.getFont().deriveFont(30F));
        txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 4.5));
        if (this.numberDif == 1) {
            g.drawString("->", 1280 / 2 - txtLength / 2 - this.tileX, (int) (tileY * 4.5));
        }
        txt = "Medium -- Less heath but  more damage";
        g.setFont(g.getFont().deriveFont(30F));
        txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 6));
        if (this.numberDif == 2) {
            g.drawString("->", 1280 / 2 - txtLength / 2 - this.tileX, (int) (tileY * 6));
        }
        txt = "Hard -- Less heath and less damage";
        g.setFont(g.getFont().deriveFont(30F));
        txtLength = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        g.drawString(txt, 1280 / 2 - txtLength / 2, (int) (tileY * 7.5));
        if (this.numberDif == 3) {
            g.drawString("->", 1280 / 2 - txtLength / 2 - this.tileX, (int) (tileY * 7.5));
        }
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.down.tick();
        key.up.tick();
        key.enter.tick();
        if (this.checkdificulty == false) {
            if (key.up.clicked) {
                numberLine--;
                if (numberLine < 0) {
                    numberLine = 4;
                }
            }
            if (key.down.clicked) {
                numberLine++;
                if (numberLine > 4) {
                    numberLine = 0;
                }
            }
            if (key.enter.clicked) {
                if (numberLine == 0) {
                    gsm.pop(GameStateManager.NEWGAME);
                    gsm.pop(GameStateManager.MENU);
                    gsm.pop(GameStateManager.PAUSE);
                    GameStateManager.sound.stopMusic();
                    gsm.add(GameStateManager.NEWGAME);
                }
                if (numberLine == 1) {
                    gsm.pop(GameStateManager.NEWGAME);
                    gsm.pop(GameStateManager.MENU);
                    gsm.pop(GameStateManager.PAUSE);
                    GameStateManager.sound.stopMusic();
                    gsm.add(GameStateManager.NEWGAME);
                }
                if (numberLine == 3) {
                    ((PlayState) this.gsm.getState(1)).chageMusic();
                }
                if (numberLine == 2) {
                    gsm.add(GameStateManager.PAUSE);
                    this.checkdificulty = true;
                }
                if (numberLine == 4) {
                    gsm.pop(GameStateManager.PLAY);
                    gsm.pop(GameStateManager.MENU);
                    gsm.pop(GameStateManager.PAUSE);
                    GameStateManager.sound.stopMusic();
                    gsm.add(GameStateManager.TITLE);
                }
            }
        } else {
            if (key.up.clicked) {
                this.numberDif--;
                if (this.numberDif == 0) {
                    this.numberDif = 3;
                }
            }
            if (key.down.clicked) {
                this.numberDif++;
                if (this.numberDif == 4) {
                    this.numberDif = 1;
                }
            }
            if (key.enter.clicked) {
                if (this.numberDif == 1) {
                    this.EasyMode();
                } else if (this.numberDif == 2) {
                    this.MediumMode();
                } else {
                    this.HardMode();
                }
                this.checkdificulty = false;
                gsm.pop(GameStateManager.PAUSE);
            }
        }
    }

    public void EasyMode() {
        ((PlayState) this.gsm.getState(GameStateManager.PLAY)).getPlayer().setHealth(200);
        ((PlayState) this.gsm.getState(GameStateManager.PLAY)).getPlayer().setDamage(75);
    }

    public void MediumMode() {
        ((PlayState) this.gsm.getState(GameStateManager.PLAY)).getPlayer().setHealth(150);
        ((PlayState) this.gsm.getState(GameStateManager.PLAY)).getPlayer().setDamage(50);
    }

    public void HardMode() {
        ((PlayState) this.gsm.getState(GameStateManager.PLAY)).getPlayer().setHealth(100);
        ((PlayState) this.gsm.getState(GameStateManager.PLAY)).getPlayer().setDamage(25);
    }

    @Override
    public void render(Graphics2D g) {
        this.Menu(g);
    }
}
