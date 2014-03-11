/**
 * 
 */
package MarksKebbitHunter;

import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.wrappers.Tile;

/**
 * @author Anthony
 *
 */
@Manifest(name = "Hunter",authors = "Mark Lore",description = "Hunts Kebbits at Taverly")
public class MarksKebbits extends PollingScript {
	private List<Task> taskList = new ArrayList<>();
	Tile pile1 = new Tile(2875, 3480);
	
	@Override
    public void start() {
		findPath();
		taskList.add(new Banking(getContext()));
		taskList.add(new InspectHole(getContext()));
        taskList.add(new Tracking(getContext()));
    }

	@Override
	public int poll() {
		if(ctx.players.local().getLocation().distanceTo(Banking.bankTile) < 5 ) {
			Banking.atBank = true;
		}
		if(ctx.players.local().getLocation().distanceTo(pile1) < 10) {
			Banking.atBank = false;
		}
        for (Task task : taskList) {
            if (task.activate()) {
                task.execute();
                return 100;
            }
        }
        return 100;
    }
	
	static int object;
	public void findPath() {
		int setting = ctx.settings.get(1218);
		if(setting == 33) {
			object = 66467;
		} else if(setting == 12) {
			object = 66468;
		} else if(setting >= 1073740000 && setting <= 1073750000) {//1073741923
			object = 66469;
		/*} else if(setting == 1073741916) {
			object = 66469;*/
		} else if(setting == 1056) {
			object = 66470;
		} else if(setting == 1028) {
			object = 66470;
		} else if(setting == 1073754816) {
			object = 66470;
		} else if(setting == 1073840832) {
			object = 66470;
		} else if(setting == 4288) {
			object = 66471;
		} else if(setting == 1073752068) {
			object = 66471;
		} else if(setting == 1073848512) {
			object = 66471;
		} else if(setting >= 1073800000 && setting <= 1073840000) {//1073809440
			object = 66472;
		} else if(setting == 1073809412) {
			object = 66472;
		} else if(setting == 32960) {
			object = 66472;
		/*} else if(setting == 1073819840) {
			object = 66472;*/
		} else if(setting == 1476395235) {
			object = 66496;
		} else if(setting == 1476413472) {
			object = 66496;
		} else if(setting == 1476413444) {
			object = 66496;
		} else if(setting == 1476528132) {
			object = 66496;
		} else if(setting == 1476528160) {
			object = 66496;
		} else if(setting == 1476395228) {
			object = 66496;
		} else if(setting == 1476538560) {
			object = 66496;
		} else if(setting == 1476509888) {
			object = 66496;
		} else if(setting == 1476395235) {
			object = 66496;
		} else if(setting == 1342191296) {
			object = 66496;
		} else if(setting == 1342277312) {
			object = 66496;
		} else if(setting == 0) {
			object = 66473;
		}
		System.out.println(setting);
		System.out.println("OBJECTKebbit: "+object);
	}

}
