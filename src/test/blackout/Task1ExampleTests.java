package blackout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import unsw.blackout.BlackoutController;
import unsw.response.models.EntityInfoResponse;
import unsw.response.models.FileInfoResponse;
import unsw.utils.Angle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static blackout.TestHelpers.assertListAreEqualIgnoringOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static unsw.utils.MathsHelper.RADIUS_OF_JUPITER;

@TestInstance(value = Lifecycle.PER_CLASS)
public class Task1ExampleTests {
    @Test
    public void testExample() {
        // Task 1
        // Example from the specification
        BlackoutController controller = new BlackoutController();

        // Creates 1 satellite and 3 devices
        // 2 devices are in view of the satellite
        // 1 device is out of view of the satellite
        controller.createSatellite("Satellite1", "StandardSatellite", 100 + RADIUS_OF_JUPITER, Angle.fromDegrees(340));
        controller.createDevice("DeviceA", "HandheldDevice", Angle.fromDegrees(30));
        controller.createDevice("DeviceB", "LaptopDevice", Angle.fromDegrees(180));
        controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));

        assertListAreEqualIgnoringOrder(Arrays.asList("Satellite1"), controller.listSatelliteIds());
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceA", "DeviceB", "DeviceC"), controller.listDeviceIds());

        assertEquals(new EntityInfoResponse("Satellite1", Angle.fromDegrees(340), 100 + RADIUS_OF_JUPITER, "StandardSatellite"), controller.getInfo("Satellite1"));

        assertEquals(new EntityInfoResponse("DeviceA", Angle.fromDegrees(30), RADIUS_OF_JUPITER, "HandheldDevice"), controller.getInfo("DeviceA"));
        assertEquals(new EntityInfoResponse("DeviceB", Angle.fromDegrees(180), RADIUS_OF_JUPITER, "LaptopDevice"), controller.getInfo("DeviceB"));
        assertEquals(new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice"), controller.getInfo("DeviceC"));
    }

    @Test
    public void testDelete() {
        // Task 1
        BlackoutController controller = new BlackoutController();

        // Creates 1 satellite and 3 devices and deletes them
        controller.createSatellite("Satellite1", "StandardSatellite", 100 + RADIUS_OF_JUPITER, Angle.fromDegrees(340));
        controller.createDevice("DeviceA", "HandheldDevice", Angle.fromDegrees(30));
        controller.createDevice("DeviceB", "LaptopDevice", Angle.fromDegrees(180));
        controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));

        assertListAreEqualIgnoringOrder(Arrays.asList("Satellite1"), controller.listSatelliteIds());
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceA", "DeviceB", "DeviceC"), controller.listDeviceIds());

        controller.removeDevice("DeviceA");
        controller.removeDevice("DeviceB");
        controller.removeDevice("DeviceC");
        controller.removeSatellite("Satellite1");
    }

    @Test
    public void basicFileSupport() {
        // Task 1
        BlackoutController controller = new BlackoutController();

        // Creates 1 device and add some files to it
        controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceC"), controller.listDeviceIds());
        assertEquals(new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice"), controller.getInfo("DeviceC"));

        controller.addFileToDevice("DeviceC", "Hello World", "My first file!");
        Map<String, FileInfoResponse> expected = new HashMap<>();
        expected.put("Hello World", new FileInfoResponse("Hello World", "My first file!", "My first file!".length(), true));
        assertEquals(new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice", expected), controller.getInfo("DeviceC"));
    }
    
    @Test
    public void testListDevices() {
        // Task 1
        BlackoutController controller = new BlackoutController();
        
        // Creates 3 Devices
        controller.createDevice("DeviceA", "HandheldDevice", Angle.fromDegrees(30));
        controller.createDevice("DeviceB", "LaptopDevice", Angle.fromDegrees(180));
        controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));
        
        // Checks that the list of devices is correct
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceA", "DeviceB", "DeviceC"), controller.listDeviceIds());
        
        // Checks that the list of devices is correct when a device is removed
        controller.removeDevice("DeviceA");
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceB", "DeviceC"), controller.listDeviceIds());
    }
    
    @Test
    public void testListEmpty() {
        // Task 1
        BlackoutController controller = new BlackoutController();
        
        // Checks that the list of devices is correct
        assertListAreEqualIgnoringOrder(Arrays.asList(), controller.listDeviceIds());
    }
    
    @Test
    public void testListSatellites() {
        // Task 1
        BlackoutController controller = new BlackoutController();
        
        // Creates 3 Satellites
        controller.createSatellite("SatelliteA", "StandardSatellite", 100 + RADIUS_OF_JUPITER, Angle.fromDegrees(340));
        controller.createSatellite("SatelliteB", "StandardSatellite", 100 + RADIUS_OF_JUPITER, Angle.fromDegrees(340));
        controller.createSatellite("SatelliteC", "StandardSatellite", 100 + RADIUS_OF_JUPITER, Angle.fromDegrees(340));
        
        // Checks that the list of satellites is correct
        assertListAreEqualIgnoringOrder(Arrays.asList("SatelliteA", "SatelliteB", "SatelliteC"), controller.listSatelliteIds());
        
        // Checks that the list of satellites is correct when a satellite is removed
        controller.removeSatellite("SatelliteA");
        assertListAreEqualIgnoringOrder(Arrays.asList("SatelliteB", "SatelliteC"), controller.listSatelliteIds());
    }
    
    @Test
    public void testListEmptySatellites() {
        // Task 1
        BlackoutController controller = new BlackoutController();
        
        // Checks that the list of satellites is correct
        assertListAreEqualIgnoringOrder(Arrays.asList(), controller.listSatelliteIds());
    }
    
    @Test
    public void testAddMultipleFilesToDevice() {
        // Task 1
        BlackoutController controller = new BlackoutController();
        
        // Creates 1 device and add some files to it
        controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceC"), controller.listDeviceIds());
        assertEquals(new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice"), controller.getInfo("DeviceC"));
        
        controller.addFileToDevice("DeviceC", "Hello World", "My first file!");
        controller.addFileToDevice("DeviceC", "Hello World 2", "My second file!");
        
        Map<String, FileInfoResponse> expected = new HashMap<>();
        expected.put("Hello World", new FileInfoResponse("Hello World", "My first file!", "My first file!".length(), true));
        expected.put("Hello World 2", new FileInfoResponse("Hello World 2", "My second file!", "My second file!".length(), true));
        assertEquals(new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice", expected), controller.getInfo("DeviceC"));
    }
    
    @Test
    public void testGetInfo() {
        // Task 1
        BlackoutController controller = new BlackoutController();
        
        // Creates 1 device and add some files to it
        controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));
        assertListAreEqualIgnoringOrder(Arrays.asList("DeviceC"), controller.listDeviceIds());
        assertEquals(new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice"), controller.getInfo("DeviceC"));
        
        controller.addFileToDevice("DeviceC", "Hello World", "My first file!");
        controller.addFileToDevice("DeviceC", "Hello World 2", "My second file!");
        
        EntityInfoResponse expected = new EntityInfoResponse("DeviceC", Angle.fromDegrees(330), RADIUS_OF_JUPITER, "DesktopDevice", new HashMap<String, FileInfoResponse>());
        
        EntityInfoResponse output = controller.getInfo("DeviceC");
        expected.getFiles().put("Hello World", new FileInfoResponse("Hello World", "My first file!", "My first file!".length(), true));
        expected.getFiles().put("Hello World 2", new FileInfoResponse("Hello World 2", "My second file!", "My second file!".length(), true));
        assertEquals(expected, output);
    }
}