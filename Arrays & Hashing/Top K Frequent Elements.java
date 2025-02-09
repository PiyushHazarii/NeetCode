public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min-Heap (PriorityQueue) to keep the top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );

        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the element with the lowest frequency
            }
        }

        // Step 3: Extract the elements from the heap and return as an array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}



// Bucket sort algorithm used here 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a bucket where the index represents the frequency
        List<Integer>[] bucket = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(element);
        }

        
        // Step 3: Collect the top K frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 0 && k > 0; i--) {
            if (!bucket[i].isEmpty()) {
                for (int j = 0; j < bucket[i].size() && k > 0; j++) {
                    result.add(bucket[i].get(j));
                    k--;
                }
            }
        }

        // Convert the result list to an array and return
        int[] topK = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            topK[i] = result.get(i);
        }

        return topK;
    }
}
