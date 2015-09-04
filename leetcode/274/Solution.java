 public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < len / 2; i++) {
            citations[i] = citations[i] ^ citations[len - 1 - i];
            citations[len - 1 - i] = citations[i] ^ citations[len - 1 - i];
            citations[i] = citations[i] ^ citations[len - 1 - i];
        }
        for (int h = len - 1; h >= 0; h--) {
            if (citations[h] >= h + 1)
                return h + 1;
        }
        return 0;
    }