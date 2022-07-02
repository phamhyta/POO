
package game.data;

public abstract class MapAsset {
    protected GameControl gc;
    public MapAsset(GameControl gc) {
        this.gc = gc;
        this.setMonsterPosition();
        this.setMaterialPosition();
        this.setNPC();
    }

    protected abstract void setMonsterPosition();

    public abstract void setMaterialPosition();

    public abstract void resetEnemy(int var1);

    public abstract void setNPC();
}
