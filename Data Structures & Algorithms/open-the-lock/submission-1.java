class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visits = new HashSet<>(Arrays.asList(deadends));
        Deque<String> queue = new LinkedList<>();
        if (visits.contains("0000")) return -1;

        int turn = 0;
        
        visits.add("0000");
        queue.offer("0000");

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String lock = queue.poll();
                if (target.equals(lock)) return turn;

                for (String combination : children(lock)){
                    if (!visits.contains(combination)){
                        visits.add(combination);
                        queue.offer(combination);
                    }
                }
            }
            turn++;
        }
        return -1;
    }

    public List<String> children(String lock){
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            char[] arr = lock.toCharArray();
            arr[i] = Character.forDigit(((Character.getNumericValue(arr[i]) + 1) % 10), 10);
            res.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = Character.forDigit(((Character.getNumericValue(arr[i]) - 1 + 10) % 10), 10);
            res.add(new String(arr));
        }

        return res;
    }
}