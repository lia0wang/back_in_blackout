package unsw.blackout;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import unsw.utils.Angle;

import unsw.blackout.models.devices.*;
import unsw.blackout.models.superclasses.*;
import unsw.response.models.EntityInfoResponse;
import unsw.blackout.models.satellites.RelaySatellite;
import unsw.blackout.models.satellites.storage_satellite.*;

public class BlackoutController {
    
    // Entities is a HashMap of BaseObject objects - Device, Satellite
    private HashMap<String, BaseObject> baseObjects = new HashMap<String, BaseObject>();
    
    public void createDevice(String deviceId, String type, Angle position) {
        switch (type) {
            case "LaptopDevice":
                baseObjects.put(deviceId, new LaptopDevice(deviceId, position));
                break;
            case "HandheldDevice":
                baseObjects.put(deviceId, new HandheldDevice(deviceId, position));
                break;
            case "DesktopDevice":
                baseObjects.put(deviceId, new DesktopDevice(deviceId, position));
                break;
            default:
                break;
        }
    }

    public void removeDevice(String deviceId) {
        baseObjects.remove(deviceId);
    }

    public void createSatellite(String satelliteId, String type, double height, Angle position) {
        switch (type) {
            case "StandardSatellite":
                baseObjects.put(satelliteId, new StandardSatellite(satelliteId, position, height));
                break;
            case "RelaySatellite":
                baseObjects.put(satelliteId, new RelaySatellite(satelliteId, position, height));
                break;
            case "TeleportingSatellite":
                baseObjects.put(satelliteId, new TeleportingSatellite(satelliteId, position, height));
                break;
            default:
                break;
        }
    }

    public void removeSatellite(String satelliteId) {
        baseObjects.remove(satelliteId);
    }

    public List<String> listDeviceIds() {
        List<String> deviceIds = new ArrayList<String>();
        for (String deviceId : baseObjects.keySet()) {
            if (baseObjects.get(deviceId) instanceof Device) {
                deviceIds.add(deviceId);
            }
        }
        return deviceIds;
    }

    public List<String> listSatelliteIds() {
        List<String> satelliteIds = new ArrayList<String>();
        for (String satelliteId : baseObjects.keySet()) {
            if (baseObjects.get(satelliteId) instanceof Satellite) {
                satelliteIds.add(satelliteId);
            }
        }
        return satelliteIds;
    }

    public void addFileToDevice(String deviceId, String filename, String content) {
        Device device = (Device) baseObjects.get(deviceId);
        device.addFile(new File(deviceId, filename, content));
    }

    public EntityInfoResponse getInfo(String id) {
        BaseObject baseObject = baseObjects.get(id);
        if (baseObject == null) {
            return null;
        }
        return baseObject.getInfo();
    }

    public void simulate() {
        for (BaseObject object : baseObjects.values()) {
            if (object instanceof Satellite) {
                ((Satellite) object).moveSatellite(1);
            }
        }
    }

    /**
     * Simulate for the specified number of minutes.
     * You shouldn't need to modify this function.
     */
    public void simulate(int numberOfMinutes) {
        for (int i = 0; i < numberOfMinutes; i++) {
            simulate();
        }
    }

    public List<String> communicableEntitiesInRange(String id) {
        List<String> communicableEntities = new ArrayList<String>();
        BaseObject baseObject = baseObjects.get(id);
        if (baseObject == null) {
            return communicableEntities;
        }
        for (BaseObject otherBaseObject : baseObjects.values()) {
            if (baseObject.isCommunicable(otherBaseObject)) {
                communicableEntities.add(otherBaseObject.getUniqueId());
            }
        }
        return communicableEntities;
    }

    public void sendFile(String fileName, String fromId, String toId) throws FileTransferException {
    }

    public void createDevice(String deviceId, String type, Angle position, boolean isMoving) {
        createDevice(deviceId, type, position);
        // TODO: Task 3
    }

    public void createSlope(int startAngle, int endAngle, int gradient) {
        // TODO: Task 3
        // If you are not completing Task 3 you can leave this method blank :)
    }

}
