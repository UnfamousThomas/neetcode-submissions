class TimeMap {
        private Map<String, List<Data>> values = new HashMap<>();
    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        List<Data> datas = values.getOrDefault(key, new ArrayList<Data>());
        datas.add(new Data(timestamp, value));
        values.put(key, datas);
    }
    
    public String get(String key, int timestamp) {
        List<Data> datas = values.get(key);
        if(datas.isEmpty()) return "";

        int lo = 0;
        int hi = datas.size() - 1;
        String result = "";
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            Data midElement = datas.get(mid);
            if(midElement.getTimestamp() <= timestamp) {
                //matches, but not neccessarily MOST RECENT. Most recent would probably be LARGER
                result = midElement.getValue();
                lo = mid + 1;
            }  else {
                //does not match
                hi = mid - 1;
            }
        }
        return result;
    }

    class Data {
        private int timestamp;
        private String value;

        Data(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int getTimestamp() {
            return timestamp;
        }
        private String getValue() {
            return value;
        }
    }
}
