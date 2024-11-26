package Lezione5;

import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {
        Employee[] ae = new Employee[3];
        Object[] ao = new Object[3];
        Manager m = new Manager();
        m.setBonus(1000);
        ae[0] = new Employee();
        ae[1] = m;
        ae[2] = new Employee();
        ao[0] = ae[2];
        ao[1] = m;
        ao[2] = ae[0];
        double meanS = 0;
        for (int i = 0; i < 3; i++) {
            meanS += ae[i].getSalary();
        }
        meanS /= 3;

        System.out.println(meanS);

        SuperManager sm = new SuperManager();
        m = sm;
        Employee e = sm;
        Employee e2 = new Employee();
        boolean c = e2.getClass() == SuperManager.class; /*Facendo questa cosa, vedremo se la variabile sm
                                                            sarà esattamente della classe SuperManager */

        System.out.println(c);
    }
}