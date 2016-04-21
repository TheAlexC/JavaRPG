package models.Signal.SkillSignal.RadialSkill;

import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.ArrayList;

/**
 * Created by Matthew on 4/17/2016.
 */
public class RadialSphericalSkillSignal extends RadialSkill {

    public RadialSphericalSkillSignal(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
    }

    protected ArrayList<Location> getLocationArray2(ArrayList<Location> list, int n){
        ArrayList<Location> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); ++i) {
            Direction nextDirection = dir;
            Location currentLocation = list.get(i);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
        }

        for (int i = newList.size() - 1; i > -1; --i) {
            for (int j = 0; j < list.size(); ++j) {
                if (list.get(j).equals(newList.get(i))) {
                    newList.remove(i);
                    j = list.size();
                }
            }
        }

        for (int i = newList.size() - 1; i > -1; --i) {
            Location locationToAttack = newList.get(i);
            if (map.isOutOfBound(locationToAttack)) {
                newList.remove(i);
            }
        }

        if (n == 1) {
            int size = newList.size();
            for (int i = 0; i < size; ++i) {
                Location tmpLocation = newList.get(i);
                newList.add(tmpLocation.add(0,0,1));
                Location tmpLocation2 = newList.get(i);
                newList.add(tmpLocation2.add(0,0,-1));
            }
        }

        for (int i = newList.size() - 1; i > -1; --i) {
            Location locationToAttack = newList.get(i);
            if (map.isOutOfBound(locationToAttack)) {
                newList.remove(i);
            }
            else if (map.getTileAt(locationToAttack).isMountain()) {
                newList.remove(i);
            }
            else if (map.getTileAt(locationToAttack).isGround()) {
                newList.remove(i);
            }
        }

        return newList;
    }
}
