package game.gameObject;


import game.math.BoundingBox;
import game.math.Vector2f;
import game.render.EnemySkillRender;


public class EnemySkill extends Entity{
    private int direction;
    private Entity entity;
    private EnemySkillRender enemySkillRender;
    private int r_attack;
    private Vector2f defaultVector;
    protected BoundingBox sense;
    protected int r_sense;
    public EnemySkill(Entity entity, int size) {
        super(new Vector2f(entity.getPos()), size);
        this.entity = entity;
        this.direction = entity.currentDirection;
        enemySkillRender = new EnemySkillRender(this);
        checkCurrentDirection();
        damage = entity.getDamage()*2;

        defaultVector = new Vector2f(entity.getPos());
        r_attack =300;
        maxSpeed = 8;
        acc = 2;
        deacc=3;
    }

    private void checkCurrentDirection() {
        if(direction == UP) up =true;
        if(direction == DOWN) down =true;
        if(direction == LEFT) left =true;
        if(direction == RIGHT) right =true;
    }
    public void update(Player player) {
        if(!die){
            this.chase(player);
            if(pos.x > defaultVector.x + r_attack || pos.x < defaultVector.x - r_attack||
                    pos.y >defaultVector.y + r_attack || pos.y < defaultVector.y - r_attack){
                die = true;
            }
            if(this.getBounds().collides(player.getBounds())){
                die = true;
                player.setHealth( player.getHealth()- damageCaculate( player), force*getDirection(), currentDirection == UP || currentDirection == DOWN);
                if(player.getHealth() <= 0) player.setDeath(true);
            }
            if(tc.collisionTile(dx, 0) || tc.collisionTile(0, dy)) die = true;
        }
    }

    private void chase(Player player) {
        BoundingBox playerBounds = player.getBounds();
        if (!player.getDeath()) {
            autoDirecting(this.pos, player.getPos());
        } else {
            stopDirecting();
        }
    }
    private void autoDirecting(Vector2f posA, Vector2f posB){
        if (posA.y > posB.y + 1) {
            up = true;
        } else {
            up = false;
        }
        if (posA.y < posB.y - 1) {
            down = true;
        } else {
            down = false;
        }

        if (posA.x > posB.x + 1) {
            left = true;
        } else {
            left = false;
        }
        if (posA.x < posB.x - 1) {
            right = true;
        } else {
            right = false;
        }
    }
    private void stopDirecting(){
        up = false;
        down = false;
        left = false;
        right = false;
    }
    public EnemySkillRender getSkillRender() {return enemySkillRender;}
}
