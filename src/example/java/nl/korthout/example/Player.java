package nl.korthout.example;

public class Player extends GameObject {

    private final Game game;
    private Health health;
    private Direction direction;

    public Player(Game game, int x, int y, int maxHealth) {
        super(new Location(x, y));
        this.game = game;
        this.health = new Health(maxHealth);
        this.direction = Direction.STANDSTILL;
    }

    public void decreaseHealth() {
        health.decreaseHealth();
        if (!health.alive()) {
            game.gameOver();
        }
    }

    public void eatPlant(Plant plant) {
        System.out.println("Player eats a plant. Health: " + health);
        health.increaseHealth(plant.getNutrition());
        game.removePlant(plant);
    }

    public void changeDirection(Direction direction) {
//        switch (direction) {
//            case NORTH:
//                System.out.println("Player changes direction NORTH");
//                break;
//            case EAST:
//                System.out.println("Player changes direction EAST");
//                break;
//            case SOUTH:
//                System.out.println("Player changes direction SOUTH");
//                break;
//            case WEST:
//                System.out.println("Player changes direction WEST");
//                break;
//            case STANDSTILL:
//                System.out.println("Player changes direction STAND STILL");
//                break;
//            default:
//                break;
//        }
        this.direction = direction;
    }

    public void walk() {
        switch (direction) {
            case NORTH:
                location.moveNorth();
                break;
            case EAST:
                location.moveEast();
                break;
            case SOUTH:
                location.moveSouth();
                break;
            case WEST:
                location.moveWest();
                break;
            case STANDSTILL:
                break;
            default:
                break;
        }
    }

}
