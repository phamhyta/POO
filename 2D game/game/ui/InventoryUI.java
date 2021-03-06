package game.ui;

import game.util.KeyHandler;
import game.util.MouseHandler;
import java.awt.Graphics2D;
import game.game_object.Player;
import game.graphics.SpriteSheet;
import java.awt.*;

public class InventoryUI {
    private int slotCol = 0;
    private int slotRow = 0;
    private SpriteSheet spriteSheet;
    private Image image;
    private int size = 32;
    private int x = 850;
    private int y = 400;
    private int width = size * 11;
    private int height = size * 13;
    // Slot
    private final int slotXstart = x + 20;
    private final int slotYstart = y + 20;
    private int slotX;
    private int slotY;
    // Cursur
    private int cursurWight = size;
    private int cursurHeight = size;
    private Player p;

    public InventoryUI(Player p) {
        this.p = p;
        spriteSheet = new SpriteSheet("res/ui/slots.png");
    }

    public void drawSubWindow(Graphics2D g2, int x, int y, int width, int height) {
        g2.fillRoundRect(x, y, width, height, 35, 35);
        Color c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
        g2.setFont(new Font("NewellsHand", Font.PLAIN, 32));
    }

    public void drawInv(Graphics2D g2, int x, int y, int row, int col) {
        image = spriteSheet.getSubimage(3 * size + 8, 0 * size, size + 8, size + 8);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                g2.drawImage(image, 870 + j * size * 3 / 2, 420 + i * size * 3 / 2, size * 3 / 2, size * 3 / 2, null);
            }
        }
        Color c = new Color(218, 165, 32);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + size / 2, y + size / 2, col * size * 3 / 2 + size * 1 / 4,
                row * size * 3 / 2 + size * 1 / 4, 25, 25);
        g2.setFont(new Font("NewellsHand", Font.PLAIN, 32));
    }

    public void drawAttributes(Graphics2D g2, int slotX, int slotY) {
        if (slotX + slotY * 6 < p.getInventory().size() && slotX + slotY * 6 >= 0) {
            g2.setFont(new Font("NewellsHand", Font.PLAIN, size * 2 / 3));
            g2.drawString(p.getInventory().get(slotX + slotY * 6).getName(), x - size / 2 + 20,
                    y - height * 1 / 3 + 50);
            int cnt = 1;
            if (p.getInventory().get(slotCol + slotRow * 6).getHP() != 0) {
                g2.drawString("+" + String.valueOf(p.getInventory().get(slotCol + slotRow * 6).getHP()) + " HP",
                        x - size / 2 + 20, y - height * 1 / 3 + 50 + cnt * size);
                cnt++;
            }
            if (p.getInventory().get(slotCol + slotRow * 6).getMP() != 0) {
                g2.drawString("+" + String.valueOf(p.getInventory().get(slotCol + slotRow * 6).getMP()) + " MP",
                        x - size / 2 + 20, y - height * 1 / 3 + 50 + cnt * size);
                cnt++;
            }
            if (p.getInventory().get(slotCol + slotRow * 6).getAttackValue() != 0) {
                g2.drawString(
                        "+" + String.valueOf(p.getInventory().get(slotCol + slotRow * 6).getAttackValue()) + " attack",
                        x - size / 2 + 20, y - height * 1 / 3 + 50 + cnt * size);
                cnt++;
            }
            if (p.getInventory().get(slotCol + slotRow * 6).getDefense() != 0) {
                g2.drawString(
                        "+" + String.valueOf(p.getInventory().get(slotCol + slotRow * 6).getDefense()) + " defense",
                        x - size / 2 + 20, y - height * 1 / 3 + 50 + cnt * size);
                cnt++;
            }
            if (p.getInventory().get(slotCol + slotRow * 6).getSpeed() != 0) {
                g2.drawString("+" + String.valueOf(p.getInventory().get(slotCol + slotRow * 6).getSpeed()) + " Speed",
                        x - size / 2 + 20, y - height * 1 / 3 + 50 + cnt * size);
                cnt++;
            }
            if (p.getInventory().get(slotCol + slotRow * 6).getCoin() != 0) {
                g2.drawString(
                        "Gia: " + String.valueOf(p.getInventory().get(slotCol + slotRow * 6).getCoin()) + " Coins",
                        x - size / 2 + 20, y - height * 1 / 3 + 50 + cnt * size);
                cnt++;
            }
        }

    }

    public void drawInfo(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        drawSubWindow(g2, x - 820, y - height * 1 / 3, 350, 360);
        g2.drawString("+ Damage: " + String.valueOf(p.getDamage()), x - 800, y - height * 1 / 3 + 40);
        g2.drawString("+ Defense: " + String.valueOf(p.getDefense()), x - 800, y - height * 1 / 3 + 80);
        g2.drawString("+ EXP: " + String.valueOf(p.getEXP()), x - 800, y - height * 1 / 3 + 120);
        g2.drawString("+ Deacc: " + String.valueOf(p.getDeacc()), x - 800, y - height * 1 / 3 + 160);
        g2.drawString("+ Health: " + String.valueOf(p.getHealth()), x - 800, y - height * 1 / 3 + 200);
        g2.drawString("+ Mana: " + String.valueOf(p.getMana()), x - 800, y - height * 1 / 3 + 240);
    }

    public void render(Graphics2D g) {

        // // update

        int cursurX = slotXstart + size * slotCol * 3 / 2;
        int cursurY = slotYstart + size * slotRow * 3 / 2;
        drawInv(g, x, y, 4, 6);
        Color c = new Color(255, 255, 255);
        g.setColor(c);
        g.drawRoundRect(cursurX, cursurY, cursurWight * 3 / 2, cursurHeight * 3 / 2, 10, 10);

        // drawitems
        slotX = 0;
        slotY = 0;
        for (int i = 0; i < p.getInventory().size(); i++) {
            if (i <= 23) {
                g.drawImage(p.getInventory().get(i).getObjectRender().getImage(), slotXstart + slotX * size * 3 / 2,
                        slotYstart + slotY * size * 3 / 2, 48, 48, null);
                slotX++;
                if (slotX > 5) {
                    slotY++;
                    slotX = 0;
                }
            }
        }
        drawSubWindow(g, x - size / 2, y - height * 1 / 3, 350, 145);
        g.setColor(Color.BLACK);
        drawAttributes(g, slotCol, slotRow);
        slotX = 5;

        drawInfo(g);

    }

    public void input(MouseHandler mouse, KeyHandler key) {
        key.invDn.tick();
        key.invUp.tick();
        key.invLeft.tick();
        key.invRight.tick();
        key.invEnter.tick();
        if (key.invUp.clicked) {
            slotRow--;
            if (slotRow < 0)
                slotRow = 3;
        }
        if (key.invDn.clicked) {
            slotRow++;
            if (slotRow > 3)
                slotRow = 0;
        }
        if (key.invLeft.clicked) {
            slotCol--;
            if (slotCol < 0)
                slotCol = 5;
        }
        if (key.invRight.clicked) {
            slotCol++;
            if (slotCol > 5)
                slotCol = 0;
        }
        if (key.invEnter.clicked) {
            if (p.getInventory().size() != 0 && slotCol + slotRow * 6 < p.getInventory().size()) {
                p.getInventory().get(slotCol + slotRow * 6).use(p);
                p.getInventory().remove(slotCol + slotRow * 6);
            }
        }

    }

    public void update(double time) {
    }
}
