package entity;

import java.util.HashSet;

/**
 * Created by ymcvalu on 2017/5/7.
 */
public class Main {
    public static void main(String[]args){
        Clerk c1=new Clerk();
        Clerk c2=new Clerk();
        c1.setId(1);
        c2.setId(1);
        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.hashCode()==c2.hashCode());
        HashSet<Clerk> s=new HashSet();
        s.add(c2);

        System.out.println(s.contains(c2));

    }

}
