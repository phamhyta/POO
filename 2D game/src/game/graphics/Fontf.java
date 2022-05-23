package game.graphics;

import java.awt.Font;
import java.util.HashMap;

public class Fontf {
    private HashMap<String, Font> fonts = new HashMap();

    public Fontf() {
    }

    public void loadFont(String path, String name) {
        try {
            System.out.println("Loading: " + path + "...");
            Font font = Font.createFont(0, this.getClass().getClassLoader().getResourceAsStream(path));
            this.fonts.put(name, font);
        } catch (Exception var4) {
            System.out.println("ERROR: ttfFont - can't load font " + path + "...");
            var4.printStackTrace();
        }

    }

    public Font getFont(String name) {
        return (Font)this.fonts.get(name);
    }
}

