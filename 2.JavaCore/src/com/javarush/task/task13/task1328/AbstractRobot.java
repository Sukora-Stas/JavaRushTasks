package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable {

    private static int hitCount;

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount += 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            attackedBodyPart = BodyPart.CHEST;
        }


        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defencedBodyPart = null;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            defencedBodyPart = BodyPart.CHEST;
            hitCount=0;
        }


        return defencedBodyPart;
    }

}
