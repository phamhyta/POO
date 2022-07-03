package game.tile;

import game.graphics.SpriteSheet;
import game.util.Camera;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<TileMap> tm;
    private Camera cam;
    private SpriteSheet spritesheet;
    private int width;
    private int height;
    private String file;
    private int columns;

    public TileManager() {
        tm = new ArrayList<TileMap>();
    }

    public TileManager(String path, Camera cam) {
        this();
        addTileMap(path, 64, 64, cam);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight, Camera cam) {
        this.cam = cam;
        cam.setTileSize(blockWidth);
        String imagePath;

        int tileWidth;
        int tileHeight;
        int tileColumns;
        int layers = 0;
        SpriteSheet sprite;

        String[] data = new String[10];

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("tileset");
            Node node = list.item(0);
            Element eElement = (Element) node;

            imagePath = eElement.getAttribute("name");
            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));
            tileColumns =  Integer.parseInt(eElement.getAttribute("columns"));

            this.columns = tileColumns;
            this.file = imagePath;
            sprite = new SpriteSheet("res/tile/" + imagePath +".png", tileWidth, tileHeight);

            list = doc.getElementsByTagName("layer");
            layers = list.getLength();

            for(int i = 0; i < layers; i++) {
                node = list.item(i);
                eElement = (Element) node;
                width = Integer.parseInt(eElement.getAttribute("width"));
                height = Integer.parseInt(eElement.getAttribute("height"));
                //System.out.println(width+ " "+height);
                data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();
                //System.out.println(data[i]);
                /*(i == 0) {
                    tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                } */
                if(i==0){
                    tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                }
                else if(i==1){
                    tm.add(new TileMapObj(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                    }
                    else{
                        tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                    }
                /*else{
                    tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));

                }*/
            }

            cam.setLimit(width * blockWidth, height * blockHeight);
        } catch(Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap:");
            e.printStackTrace();
            System.exit(0);
        }

        this.width = width;
        this.height = height;
    }



    public void render(Graphics2D g) {
        if(cam == null)
            return;
        for(int i = 0; i < tm.size(); i++) {
            tm.get(i).render(g, cam.getBounds());
        }
    }

    public int getWidth() {return width;}
    public int getHeight() {return height;}

}
