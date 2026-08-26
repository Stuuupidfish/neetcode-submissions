// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> steps = new ArrayList<>();
        if (pairs.size() == 0)
        {
            return steps;
        }
        else if (pairs.size() == 1)
        {
            steps.add(pairs);
            return steps;
        }
        else
        {
            int i = 0;
            int j;
            steps.add(deepCopy(pairs));
            while (i < pairs.size()-1)
            {
                //make a deep copy
                List<Pair> list; 
                if (i == 0)
                {
                    list = deepCopy(pairs);
                }
                else
                {
                    list = deepCopy(steps.get(steps.size()-1));
                }
                steps.add(list);
                j = i+1;
                while (j > 0 && list.get(j).key < list.get(j-1).key)
                {
                    Pair temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                    j--;
                }
                i++;
            }
        }
        return steps;
    }

    private List<Pair> deepCopy(List<Pair> pairs)
    {
        List<Pair> list = new ArrayList<>();
        for (Pair pair : pairs)
        {
            list.add(new Pair(pair.key, pair.value));
        }
        return list;
    }
}
