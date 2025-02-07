class Solution {
    public boolean isAnagram(String s, String t) {

        int charr[] = new int[26];
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

       
        boolean areAnagrams = Arrays.equals(ch1, ch2);
        return areAnagrams;

        // approach 2 
        
        for(int i=0;i<ch1.length;i++)
        {
            int index =  ch1[i] - 'a';
            charr[index]++;
        }

        for(int i=0;i<ch2.length;i++)
        {
            int index =  ch2[i] - 'a';
            charr[index]--;
        }
        for(int i =0;i<charr.length;i++)
        {
            if(charr[i] != 0)
            {
                return false;
            }
        }
        return true;
        
    }
}