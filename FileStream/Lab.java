package com.jac444.task;

import java.util.Vector;

@SuppressWarnings("all")
public class Lab implements MaxTagValue {


    String labName;
    Vector<MobileDevice> devices;


    public Lab(String labName) {
        if(this.labName != null)
            this.labName = "";
        this.labName = labName;
        devices = new Vector<>();
    }

    public void addDevice(MobileDevice md) {
        if(devices == null) {
            devices = new Vector<>();
        }
        if(md == null)
            return;
        devices.add(md);
    }

    @Override
    public String toString() {
        String r = "Lab = " + labName + "\n[\n";
        for(MobileDevice mobileDevice : devices)
            r += "(" + mobileDevice.deviceName + "," + mobileDevice.valueTag + ") => " + labName + "\n";
        r += "]";
        return r;
    }

    //
    public boolean isThereDevice(MobileDevice md) {
        boolean found = false;
        if(md == null) {
            System.out.println("You are accessing a null mobile device!");
            return false;
        }
        if(devices == null) {
            System.out.println("There are no devices for you to search!");
            return false;
        }
        for(MobileDevice mobileDevice : devices) {
            if(mobileDevice == null) {
                System.out.println("The process is stopping because a null MobileDevice pointer!");
                return false;
            }
            if(mobileDevice.deviceName.equals(md.deviceName)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public int findMaximumValueTag() {
        final int size = devices.size();
        int[] valueTags = new int[size];
        for(int i = 0; i < size; i++)
            valueTags[i] = devices.get(i).valueTag;
        return Finder.findMaximumValueTag(valueTags);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = labName != null ? labName.hashCode() : 0;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }


    /**
     * This is a function to implement if the device can be rented from the lab
     * @param wanted      The mobile device which is wanted from the lab
     * @param requestDate The date which the customer requests the device if available
     * @param dueDate     The date which the customer should return the device
     * @return            Returns if customer can successfully rent the device
     * @throws DateFormatException Throws if the date format is not correct
     */
    public boolean rentRequest(MobileDevice wanted, String requestDate, String dueDate) {
        if(!Helper.isValidDate(requestDate) || !Helper.isValidDate(dueDate)) {
            return false;
        }
        if(Helper.timeDifference(requestDate, dueDate) < 0)
            return false;
        if(!isThereDevice(wanted)) {
            return false;
        }
        return true;
    }
}
