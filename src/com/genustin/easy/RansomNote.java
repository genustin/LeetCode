package com.genustin.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wayne on 16/8/18.
 * <p>
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,
 * write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;
 *  otherwise,  it  will  return  false.
 * <p>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> counts = new LinkedList<>();
        for (int i = 0; i < magazine.length(); i++) {
            counts.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (counts.contains(ransomNote.charAt(i)))
                counts.remove((Character) ransomNote.charAt(i));
            else
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        rn.canConstruct("aa", "ab");
    }
}
