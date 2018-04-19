package com.jac444.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labs {

    public Lab[] labs;        // a collection of labs of type array
    public int numberOfLabs;  // number of labs in collection
    public static final String location = "G:/Seneca College/Java Space/Assignment2/";

    /**
     * Constructor with Integer value
     * @param numberOfLabs parameter to initialize the object of Labs
     */
    public Labs(int numberOfLabs) {
        if(numberOfLabs <= 0)
            return;
        this.numberOfLabs = numberOfLabs;
        labs = new Lab[numberOfLabs];
    }

    public Lab addDevicesToLab(String labName, String labFileName) {
        Lab lab = buildLabFromFile(labName, labFileName);
        return lab;
    }

    /**
     *
     * @param  labName    The name of the lab
     * @param  fileName   The name of the txt file
     * @return the lab object which we built from file
     */
    public Lab buildLabFromFile(String labName, String fileName) {

        Lab lab = new Lab(labName);
        MobileDevice md;
        String s;

        try (BufferedReader br = new BufferedReader(new FileReader(location + fileName))) {
            while ((s = br.readLine()) != null) {
                String deviceNameTmp = s.substring(0, s.indexOf(","));
                int    deviceTagTmp  = Integer.parseInt(s.substring(s.indexOf(",") + 1));
                md = new MobileDevice(deviceNameTmp, deviceTagTmp); // Create MobileDevice object
                md.setLab(lab); // Set lab object
                lab.addDevice(md);
            }
        } catch (IOException e) {
            System.out.println("Failed to read the file, maybe some permission issues?");
        }
        return lab;
    }

    public Lab isThereDeviceInLabs(MobileDevice md) {
        Lab foundLab = null;
        if(md == null) {
            System.out.println("MobileDevice object is null!");
            return null;
        }
        if(labs == null) {
            System.out.println("Labs object is null!");
            return null;
        }
        for(Lab lab : labs) {
            if(lab == null) {
                break;
            }
            if(lab.isThereDevice(md)) {
                foundLab = lab;
            }
        }
        return foundLab;
    }


    public Lab rentDeviceAvailable(MobileDevice md, String requestDate, String dueDate)
            throws DateFormatException {
        Lab foundLab = null;
        if(labs == null) {
            System.out.println("Null labs!");
            return null;
        } else {
            System.out.println(labs.length);
        }
        for(Lab lab : labs) {
            if(lab == null)
                break;
            if(lab.rentRequest(md, requestDate, dueDate)) {
                foundLab = lab;
            }
        }
        return foundLab;
    }
}

