package com.jac444.task;

/**
 * @author Chen Huang
 * @version Assignment 2.0
 */

public class Main {

    private final static String newnham = "NewnhamLab";
    private final static String york    = "YorkLab";

    public static void main(String[] args) throws DateFormatException, RentPeriodException {

        /* TASK 1 - build labs from files - at least two labs */

        System.out.println("\n\n *" + " TASK 1 " + "*");
        Labs labs = new Labs(2);
        Lab lab1 = labs.addDevicesToLab(newnham, newnham + ".txt");
        Lab lab2 = labs.addDevicesToLab(york   , newnham + ".txt");
        System.out.println(lab1.toString() + "\n" + lab2.toString());

        /* TASK 2 - ask for a device that is not in any lab inventory */
        System.out.println("\n\n *" + " TASK 2 " + "*");
        MobileDevice Pixel = new MobileDevice("Google Pixel", 90);
        if(!lab2.isThereDevice(Pixel))
            System.out.println(Helper.printNonexistent(Pixel));

         /* TASK 3 - ask for a device that is in a lab inventory
         *  issue a rent request and print the device
         *  issue the same rent request and print the device
         *  return the device
         *  issue the rent request with new dates and print the device
         */
        System.out.println("\n\n *" + " TASK 3 " + "*");

        MobileDevice bb2 = new MobileDevice("Blackberry2", -95);
        if(bb2.rentDevice("11/21/2016", "12/25/2016", lab2)) {
            String tmp = bb2.availableDate(lab2);
            System.out.println(tmp);

        } else
            System.out.println(bb2.unavailableDate(lab2));

        if(bb2.rentDevice("11/21/2016", "12/25/2016", lab2)) {
            String tmp = bb2.availableDate(lab2);
            System.out.println("Wanted = " + bb2.getRequest());
            System.out.println(tmp);
        } else
            System.out.println(bb2.unavailableDate(lab2));

        if(bb2.rentDevice("11/21/2017", "12/25/2017", lab2)) {
            String tmp = bb2.availableDate(lab2);
            System.out.println("Wanted = " + bb2.getRequest());
            System.out.println(tmp);
        } else
            System.out.println(bb2.unavailableDate(lab2));



         /* TASK 4 - ask for the same device in all labs
          * if you can find a lab, rent the device from that lab
          */
        System.out.println("\n\n *" + " TASK 4 " + "*");
        labs.labs[0] = lab1;
        labs.labs[1] = lab2;
        Lab foundLab;
        MobileDevice tablet = new MobileDevice("Tablet", -20);
        foundLab = labs.isThereDeviceInLabs(tablet);
        if(foundLab != null) {
            if(tablet.rentDevice("11/21/2016", "12/25/2016", foundLab)) {
                String tmp = tablet.availableDate(foundLab);
                System.out.println(tmp);

            } else
                System.out.println(tablet.unavailableDate(foundLab));

            if(tablet.rentDevice("11/21/2016", "12/25/2016", foundLab)) {
                String tmp = tablet.availableDate(foundLab);
                System.out.println("Wanted = " + tablet.getRequest());
                System.out.println(tmp);
            } else
                System.out.println(tablet.unavailableDate(foundLab));

            if(tablet.rentDevice("11/21/2017", "12/25/2017", foundLab)) {
                String tmp = tablet.availableDate(foundLab);
                System.out.println("Wanted = " + tablet.getRequest());
                System.out.println(tmp);
            } else
                System.out.println(tablet.unavailableDate(foundLab));

        }


        /* TASK 5 - calculate maximum value tag for each lab */
        System.out.println("\n\n *" + " TASK 5 " + "*");
        int max_tag1, max_tag2;
        max_tag1 = lab1.findMaximumValueTag();
        max_tag2 = lab2.findMaximumValueTag();
        System.out.println("Max tag in YorkLab    is " + max_tag1);
        System.out.println("Max tag in NewnhamLab is " + max_tag2);
    }
}
