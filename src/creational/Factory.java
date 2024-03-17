package creational;

public class Factory {
    public static void main(String[] args) {
        Client client = new Client();
        client.BuildVehicle(VehicleType.VT_TwoWheeler);
        client.getVehicle().printVehicleInfo();

        client.BuildVehicle(VehicleType.VT_ThreeWheeler);
        client.getVehicle().printVehicleInfo();

        client.BuildVehicle(VehicleType.VT_FourWheeler);
        client.getVehicle().printVehicleInfo();
    }
}


enum VehicleType {
    VT_TwoWheeler,
    VT_ThreeWheeler,
    VT_FourWheeler
}

// Library Classes
abstract class Vehicle {
    abstract public void printVehicleInfo();
}

class TwoWheeler extends Vehicle {
    @Override
    public void printVehicleInfo()
    {
        System.out.println("I am two wheeler");
    }
}

class ThreeWheeler extends Vehicle {
    public void printVehicleInfo()
    {
        System.out.println("I am three wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicleInfo()
    {
        System.out.println("I am four wheeler");
    }
}

// Class Vehicle Factory with a single responsibility to
// construct Vehicles according to the clients requests.
// PS: This class can be extended to TwoWheelerFactory,
// ThreeWheelerFactory and so on.

// Class
class VehicleFactory {

    Vehicle build(VehicleType vehicleType)
    {
        if (VehicleType.VT_TwoWheeler.compareTo(vehicleType)
                == 0) {
            return new TwoWheeler();
        }
        else if (VehicleType.VT_ThreeWheeler.compareTo(
                vehicleType)
                == 0) {
            return new ThreeWheeler();
        }
        else if (VehicleType.VT_FourWheeler.compareTo(
                vehicleType)
                == 0) {
            return new FourWheeler();
        }
        return null;
    }
}

// Client class. The client object will ask the factory to
// build vehicles.
class Client {

    private Vehicle pVehicle;

    Client() { pVehicle = null; }

    void BuildVehicle(VehicleType vehicleType)
    {
        VehicleFactory vf = new VehicleFactory();
        pVehicle = vf.build(vehicleType);
    }

    Vehicle getVehicle() { return pVehicle; }
}




